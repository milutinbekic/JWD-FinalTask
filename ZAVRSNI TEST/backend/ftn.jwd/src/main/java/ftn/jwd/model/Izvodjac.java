package ftn.jwd.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Izvodjac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String ime;
	
	@Column(nullable = false)
	private String zanr;
	
	@Column(nullable = false)
	private String drzavaPorekla;
	
	@Column(nullable = false)
	private int brojClanova;
	
	@OneToMany(mappedBy = "izvodjac", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Nastup> nastupi;

	public Izvodjac(Long id, String ime, String zanr, String drzavaPorekla, int brojClanova, List<Nastup> nastupi) {
		super();
		this.id = id;
		this.ime = ime;
		this.zanr = zanr;
		this.drzavaPorekla = drzavaPorekla;
		this.brojClanova = brojClanova;
		this.nastupi = nastupi;
	}

	public Izvodjac() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public String getDrzavaPorekla() {
		return drzavaPorekla;
	}

	public void setDrzavaPorekla(String drzavaPorekla) {
		this.drzavaPorekla = drzavaPorekla;
	}

	public int getBrojClanova() {
		return brojClanova;
	}

	public void setBrojClanova(int brojClanova) {
		this.brojClanova = brojClanova;
	}

	public List<Nastup> getNastupi() {
		return nastupi;
	}

	public void setNastupi(List<Nastup> nastupi) {
		this.nastupi = nastupi;
	}
	
	

}
