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
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	private String genre;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private int members;
	
	@OneToMany(mappedBy = "artist", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Performance> performances;

	public Artist(Long id, String name, String genre, String country, int members, List<Performance> performances) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.country = country;
		this.members = members;
		this.performances = performances;
	}

	public Artist() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	public List<Performance> getPerformances() {
		return performances;
	}

	public void setPerformances(List<Performance> performances) {
		this.performances = performances;
	}
	
	

}
