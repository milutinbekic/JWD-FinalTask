package ftn.jwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.jwd.model.Artist;
import ftn.jwd.repository.ArtistRepository;
import ftn.jwd.service.ArtistService;

@Service
public class JpaArtistService implements ArtistService {
	
	@Autowired
	private ArtistRepository artistRepository;

	@Override
	public List<Artist> findAll() {
		return artistRepository.findAll();
	}

	@Override
	public Artist findOne(Long id) {
		return artistRepository.findOneById(id);
	}

	@Override
	public Artist save(Artist artist) {
		return artistRepository.save(artist);
	}

	@Override
	public Artist create(Artist artist) {
		return artistRepository.save(artist);
	}

}
