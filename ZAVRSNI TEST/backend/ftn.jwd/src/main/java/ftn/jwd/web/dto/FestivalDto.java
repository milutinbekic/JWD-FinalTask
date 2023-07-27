package ftn.jwd.web.dto;

public class FestivalDto {
	
	private Long id;
	
	private String naziv;

	public FestivalDto(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public FestivalDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	

}
