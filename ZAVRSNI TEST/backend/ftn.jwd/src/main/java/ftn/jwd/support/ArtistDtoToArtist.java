package ftn.jwd.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.jwd.model.Artist;
import ftn.jwd.service.ArtistService;
import ftn.jwd.web.dto.ArtistDto;

@Component
public class ArtistDtoToArtist implements Converter<ArtistDto, Artist> {

	@Autowired
	private ArtistService artistService;
	
	
	@Override
	public Artist convert(ArtistDto artistDto) {
		Artist artist;
		
		if(artistDto.getId() == null) {
			artist = new Artist();
		} else {
			artist = artistService.findOne(artistDto.getId());
		}
		
		if(artist != null) {
			artist.setId(artistDto.getId());
			artist.setMembers(artistDto.getMembers());
			artist.setCountry(artistDto.getCountry());
			artist.setName(artistDto.getName());
			artist.setGenre(artistDto.getGenre());
		}
		
		return artist;
	}

}
