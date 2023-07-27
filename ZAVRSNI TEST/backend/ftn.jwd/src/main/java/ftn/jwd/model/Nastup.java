package ftn.jwd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nastup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Festival festival;
	
	@ManyToOne
	private Izvodjac izvodjac;

	public Nastup(Long id, Festival festival, Izvodjac izvodjac) {
		super();
		this.id = id;
		this.festival = festival;
		this.izvodjac = izvodjac;
	}

	public Nastup() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public Izvodjac getIzvodjac() {
		return izvodjac;
	}

	public void setIzvodjac(Izvodjac izvodjac) {
		this.izvodjac = izvodjac;
	}
	
	

}
