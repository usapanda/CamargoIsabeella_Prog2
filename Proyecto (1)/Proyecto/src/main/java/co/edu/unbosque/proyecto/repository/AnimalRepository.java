package co.edu.unbosque.proyecto.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.proyecto.model.Animal;

import java.util.ArrayList;
import java.util.List;


public interface AnimalRepository extends CrudRepository<Animal, Integer>{

	public Animal findByAnimalDocument(Long animalDocument);
	
	public ArrayList<Animal> findByBreed(String breed);
	
	public ArrayList<Animal> findBySpecies(String species);
	
	public ArrayList<Animal> findByVetDocument(Long vetDocument);
	
	public ArrayList<Animal> findAll();
	
}
