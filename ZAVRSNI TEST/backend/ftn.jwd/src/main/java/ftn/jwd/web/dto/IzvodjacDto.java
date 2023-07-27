package ftn.jwd.web.dto;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class IzvodjacDto {
	
	private Long id;
	
	private String ime;
	
	private String zanr;
	
	@Length(min = 4)
	private String drzavaPorekla;
	
	@Positive
	private int brojClanova;

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

	public IzvodjacDto() {
		super();
	}

	public IzvodjacDto(Long id, String ime, String zanr, String drzavaPorekla, int brojClanova) {
		super();
		this.id = id;
		this.ime = ime;
		this.zanr = zanr;
		this.drzavaPorekla = drzavaPorekla;
		this.brojClanova = brojClanova;
	}

}
