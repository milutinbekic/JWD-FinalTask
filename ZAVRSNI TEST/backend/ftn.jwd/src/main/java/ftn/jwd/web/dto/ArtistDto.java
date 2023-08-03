package ftn.jwd.web.dto;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class ArtistDto {
	
	private Long id;
	
	private String name;
	
	private String genre;
	
	@Length(min = 4)
	private String country;
	
	@Positive
	private int members;

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

	public ArtistDto() {
		super();
	}

	public ArtistDto(Long id, String name, String genre, String country, int members) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.country = country;
		this.members = members;
	}

}
