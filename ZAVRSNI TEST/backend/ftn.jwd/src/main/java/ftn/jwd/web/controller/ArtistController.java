package ftn.jwd.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.jwd.model.Artist;
import ftn.jwd.service.ArtistService;
import ftn.jwd.support.ArtistDtoToArtist;
import ftn.jwd.support.ArtistToArtistDto;
import ftn.jwd.web.dto.ArtistDto;

@RestController
@RequestMapping(value = "/api/artists", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private ArtistToArtistDto artistToArtistDto;
	
	@Autowired
	private ArtistDtoToArtist artistDtoToArtist;
	
	
	@GetMapping
	public ResponseEntity<List<ArtistDto>> getAll(){
		List<Artist> artists = artistService.findAll();
		List<ArtistDto> artistsDto = new ArrayList<>();
		for(Artist s: artists) {
			artistsDto.add(artistToArtistDto.convert(s));
		}
		return new ResponseEntity<>(artistsDto, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArtistDto> create(@Valid @RequestBody ArtistDto artistDto){
		Artist artist = artistDtoToArtist.convert(artistDto);

        if(artist.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Artist savedArtist = artistService.create(artist);

        return new ResponseEntity<>(artistToArtistDto.convert(savedArtist), HttpStatus.CREATED);
    }

}
