package ftn.jwd.web.dto;

public class PerformanceDto {
	
	private Long id;
	
	private Long festivalId;
	private String festivalName;
	
	private Long artistId;
	private String artistName;
	public PerformanceDto(Long id, Long festivalId, String festivalName, Long artistId, String artistName) {
		super();
		this.id = id;
		this.festivalId = festivalId;
		this.festivalName = festivalName;
		this.artistId = artistId;
		this.artistName = artistName;
	}
	public PerformanceDto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFestivalId() {
		return festivalId;
	}
	public void setFestivalId(Long festivalId) {
		this.festivalId = festivalId;
	}
	public String getFestivalName() {
		return festivalName;
	}
	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}
	public Long getArtistId() {
		return artistId;
	}
	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	

}
