package co.edu.unbosque.proyecto.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	@Column(unique = true)
	private Long document;

	private String birthdate;

	private String specialty;

	private Integer star;

	public Vet() {
		// TODO Auto-generated constructor stub
	}

	public Vet(Integer id, String name, Long document, String birthdate, String specialty, Integer star) {
		super();
		this.id = id;
		this.name = name;
		this.document = document;
		this.birthdate = birthdate;
		this.specialty = specialty;
		this.star = star;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDocument() {
		return document;
	}

	public void setDocument(Long document) {
		this.document = document;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	@Override
	public String toString() {
		return "Id = " + getId() + "\n Name = " + getName() + "\n Document = " + getDocument() + "\n Birthdate = "
				+ getBirthdate().toString() + "\n Specialty = " + getSpecialty() + "\n Star = " + getStar();
	}

}