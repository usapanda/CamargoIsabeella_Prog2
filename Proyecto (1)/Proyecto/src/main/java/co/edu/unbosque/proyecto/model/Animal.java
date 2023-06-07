package co.edu.unbosque.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Animal{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String species;
	
	@Column(unique = true)
	private Long animalDocument;
	
	private String name;
	
	private String breed;
	
	private Long ownerDocument;
	
	private String ownerName;
	
	private Long vetDocument;
	
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}


	public Animal(Integer id, String species, Long animalDocument, String name, String breed, Long ownerDocument,
			String ownerName, Long vetDocument) {
		super();
		this.id = id;
		this.species = species;
		this.animalDocument = animalDocument;
		this.name = name;
		this.breed = breed;
		this.ownerDocument = ownerDocument;
		this.ownerName = ownerName;
		this.vetDocument = vetDocument;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public Long getAnimalDocument() {
		return animalDocument;
	}


	public void setAnimalDocument(Long animalDocument) {
		this.animalDocument = animalDocument;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public Long getOwnerDocument() {
		return ownerDocument;
	}


	public void setOwnerDocument(Long ownerDocument) {
		this.ownerDocument = ownerDocument;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public Long getVetDocument() {
		return vetDocument;
	}


	public void setVetDocument(Long vetDocument) {
		this.vetDocument = vetDocument;
	}


	@Override
	public String toString() {
		return "Id = " + id + ", species = " + species + ", animalDocument = " + animalDocument + ", name = " + name
				+ ", breed = " + breed + ", ownerDocument = " + ownerDocument + ", ownerName = " + ownerName
				+ ", vetDocument = " + vetDocument + "\n";
	}
	
}
