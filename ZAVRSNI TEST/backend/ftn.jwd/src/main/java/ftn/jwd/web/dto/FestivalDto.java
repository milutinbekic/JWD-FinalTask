package ftn.jwd.web.dto;

public class FestivalDto {
	
	private Long id;
	
	private String name;

	public FestivalDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
