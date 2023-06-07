package co.edu.unbosque.proyecto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.proyecto.model.Animal;
import co.edu.unbosque.proyecto.model.Vet;
import co.edu.unbosque.proyecto.repository.AnimalRepository;
import co.edu.unbosque.proyecto.repository.VetRepository;
import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Veterinaria")
@Transactional
public class ControllerVet {

	@Autowired
	private VetRepository vetRepo;

	@Autowired
	private AnimalRepository animRepo;
	
	
	@PostMapping(path = "/AgregarVeterinario")
	public ResponseEntity<String> addCAT(@RequestParam String name, @RequestParam Long document,
			@RequestParam String birthdate, @RequestParam String specialty, @RequestParam Integer star) {

		Vet fill = vetRepo.findByDocument(document);		
		
		if (fill != null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The document number is already registered (CODE 406) \n");

		} else if (star < 0 || star > 5) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Failed to create because the number of stars is invalid (CODE 406) \n");

		} else {
			Vet vet = new Vet(null, name, document, birthdate, specialty, star);

			vetRepo.save(vet);
			return ResponseEntity.status(HttpStatus.CREATED).body("Created (CODE 201) \n");

		}
	}

	@GetMapping("/BuscarVeterinarioCedula/{document}")
	public ResponseEntity<String> getOne(@PathVariable Long document) {

		Vet fill = vetRepo.findByDocument(document);

		if (fill != null) {

			return ResponseEntity.status(HttpStatus.FOUND).body(fill.toString() + " (CODE 302) \n");

		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No match with any veterinarian (CODE 204) \n");

		}

	}

	@GetMapping("/VerTodosLosVeterinarios")
	public ResponseEntity<String> getAll() {
		ArrayList<Vet> fill = vetRepo.findAll();
		if (fill.size() != 0) {
			return ResponseEntity.status(HttpStatus.FOUND).body(fill.toString() + " (CODE 302) \n");
		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("No veterinarians have been created yet. (CODE 204) \n");

		}

	}

	@DeleteMapping("/EliminarVeterinarioPorCedula/{document}")
	public ResponseEntity<String> delete(@PathVariable Long document, @RequestParam Long new_document) {

		Vet fill = vetRepo.findByDocument(document);

		if (fill == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Cannot be deleted because the document does not match any veterinarian. (CODE 204) \n");
		} else {
			if (vetRepo.findByDocument(new_document) != null) {

				ArrayList<Animal> lista = animRepo.findByVetDocument(document);

				for (int i = 0; i < lista.size(); i++) {
					lista.get(i).setVetDocument(new_document);
					animRepo.save(lista.get(i));
				}
				vetRepo.deleteByDocument(document);
				
				return ResponseEntity.status(HttpStatus.FOUND).body("Deleted. (CODE 202)");

			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("The new veterinarian's document is not registered. (CODE 204) \n");
			}
		}
	}

}
