package co.edu.unbosque.proyecto.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.proyecto.model.Animal;
import co.edu.unbosque.proyecto.repository.AnimalRepository;
import co.edu.unbosque.proyecto.repository.VetRepository;
import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Veterinaria")
@Transactional
public class ControllerAnimal {

	@Autowired
	private AnimalRepository animRepo;

	@Autowired
	private VetRepository vetRepo;

	@PostMapping(path = "/AgregarGato")
	public ResponseEntity<String> addCat(@RequestParam Long animal_document, @RequestParam String name,
			@RequestParam String breed, @RequestParam Long owner_document, @RequestParam String owner_name,
			@RequestParam Long vet_document) {

		if (vetRepo.findByDocument(vet_document) == null) {

			return ResponseEntity.status(HttpStatus.CREATED)
					.body("The veterinarian's document is not in our database. (CODE 204)");

		} else if (animRepo.findByAnimalDocument(animal_document) != null) {

			return ResponseEntity.status(HttpStatus.CREATED)
					.body("The cat document already exists in the database. (CODE 400)");

		} else {
			String species = "CAT";

			Animal nuevo = new Animal(null, species, animal_document, name, breed, owner_document, owner_name,
					vet_document);

			animRepo.save(nuevo);

			return ResponseEntity.status(HttpStatus.CREATED).body("Created (CODE 201)");
		}
	}

	@PostMapping(path = "/AgregarPerro")
	public ResponseEntity<String> addDog(@RequestParam Long animal_document, @RequestParam String name,
			@RequestParam String breed, @RequestParam Long owner_document, @RequestParam String owner_name,
			@RequestParam Long vet_document) {

		if (vetRepo.findByDocument(vet_document) == null) {

			return ResponseEntity.status(HttpStatus.CREATED)
					.body("The veterinarian's document is not in our database. (CODE 204)");

		} else if (animRepo.findByAnimalDocument(animal_document) != null) {

			return ResponseEntity.status(HttpStatus.CREATED)
					.body("The dog document already exists in the database. (CODE 400)");

		} else {
			String species = "DOG";

			Animal nuevo = new Animal(null, species, animal_document, name, breed, owner_document, owner_name,
					vet_document);

			animRepo.save(nuevo);

			return ResponseEntity.status(HttpStatus.CREATED).body("Created (CODE 201)");
		}

	}

	@PostMapping(path = "/AgregarConejo")
	public ResponseEntity<String> addRabbit(@RequestParam Long animal_document, @RequestParam String name,
			@RequestParam String breed, @RequestParam Long owner_document, @RequestParam String owner_name,
			@RequestParam Long vet_document) {

		if (vetRepo.findByDocument(vet_document) == null) {

			return ResponseEntity.status(HttpStatus.CREATED)
					.body("The veterinarian's document is not in our database. (CODE 204)");

		} else if (animRepo.findByAnimalDocument(animal_document) != null) {

			return ResponseEntity.status(HttpStatus.CREATED)
					.body("The rabbit document already exists in the database. (CODE 400)");

		} else {
			String species = "RABBIT";

			Animal nuevo = new Animal(null, species, animal_document, name, breed, owner_document, owner_name,
					vet_document);

			animRepo.save(nuevo);

			return ResponseEntity.status(HttpStatus.CREATED).body("Created (CODE 201)");
		}
	}

	@PostMapping(path = "/AgregarCaballo")
	public ResponseEntity<String> addHorse(@RequestParam Long animal_document, @RequestParam String name,
			@RequestParam String breed, @RequestParam Long owner_document, @RequestParam String owner_name,
			@RequestParam Long vet_document) {

		if (vetRepo.findByDocument(vet_document) == null) {

			return ResponseEntity.status(HttpStatus.CREATED)
					.body("The veterinarian's document is not in our database. (CODE 204)");
			
		} else if (animRepo.findByAnimalDocument(animal_document) != null) {

			return ResponseEntity.status(HttpStatus.CREATED)
					.body("The horse document already exists in the database. (CODE 400)");

		} else {
			String species = "HORSE";

			Animal nuevo = new Animal(null, species, animal_document, name, breed, owner_document, owner_name,
					vet_document);

			animRepo.save(nuevo);

			return ResponseEntity.status(HttpStatus.CREATED).body("Created (CODE 201)");
		}

	}
	
	@GetMapping("/TodosLosAnimales")
	public ResponseEntity<String> seeAnimals(){
		ArrayList<Animal> lista = animRepo.findAll();
		if (lista.size() != 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(lista.toString() + " (CODE 302)");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body("No animals in the database to display. (CODE 204)");
		}
	}

	@GetMapping("/TodosLosPerros")
	public ResponseEntity<String> seeDogs(){
		ArrayList<Animal> lista = animRepo.findBySpecies("DOG");
		if (lista.size() != 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(lista.toString() + " (CODE 302)");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body("No dogs in the database to display. (CODE 204)");
		}
	}
	
	@GetMapping("/TodosLosGatos")
	public ResponseEntity<String> seeCats(){
		ArrayList<Animal> lista = animRepo.findBySpecies("CAT");
		if (lista.size() != 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(lista.toString() + " (CODE 302)");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body("No cats in the database to display. (CODE 204)");
		}
	}
	
	@GetMapping("/TodosLosConejos")
	public ResponseEntity<String> seeRabbits(){
		ArrayList<Animal> lista = animRepo.findBySpecies("RABBIT");
		
		if (lista.size() != 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(lista.toString() + " (CODE 302)");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body("No rabbits in the database to display. (CODE 204)");
		}
	}
	
	@GetMapping("/TodosLosCaballos")
	public ResponseEntity<String> seeHorses(){
		ArrayList<Animal> lista = animRepo.findBySpecies("HORSE");
		if (lista.size() != 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(lista.toString() + " (CODE 302)");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body("No horses in the database to display. (CODE 204)");
		}
	}
	
	@GetMapping("/BuscarAnimalDocumento/{animalDocument}")
	public ResponseEntity<String> getOne(@PathVariable Long animalDocument) {
		Animal fill = animRepo.findByAnimalDocument(animalDocument);
		if (fill != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(fill.toString() + " (CODE 204)");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body("No animal associated with the document. (CODE 204)");
		}
		
	}
}
