package co.edu.unbosque.proyecto.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.proyecto.model.Vet;


public interface VetRepository extends CrudRepository<Vet, Integer> {

	
	public Vet findByDocument(Long document);
	
	public ArrayList<Vet> findAll();
	
	public void deleteByDocument(Long document);
	
}
