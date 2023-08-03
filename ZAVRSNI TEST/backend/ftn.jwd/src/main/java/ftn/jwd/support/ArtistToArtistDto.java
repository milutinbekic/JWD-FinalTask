package ftn.jwd.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.jwd.model.Artist;
import ftn.jwd.web.dto.ArtistDto;

@Component
public class ArtistToArtistDto implements Converter<Artist, ArtistDto> {

	@Override
	public ArtistDto convert(Artist artist) {
		ArtistDto artistDto = new ArtistDto();
		
		artistDto.setId(artist.getId());
		artistDto.setMembers(artist.getMembers());
		artistDto.setCountry(artist.getCountry());
		artistDto.setName(artist.getName());
		artistDto.setGenre(artist.getGenre());
		
		return artistDto;
	}
	
	public List<ArtistDto> convert(List<Artist> artisti){
		List<ArtistDto> artistiDto = new ArrayList<>();
		
		for(Artist z: artisti) {
			artistiDto.add(convert(z));
		}
		
		return artistiDto;
	}

}
