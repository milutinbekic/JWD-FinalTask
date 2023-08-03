package ftn.jwd.service;

import java.util.List;

import ftn.jwd.model.Artist;

public interface ArtistService {
	
	List<Artist> findAll();
	Artist findOne(Long id);
	Artist save(Artist artist);
	Artist create(Artist artist);

}
