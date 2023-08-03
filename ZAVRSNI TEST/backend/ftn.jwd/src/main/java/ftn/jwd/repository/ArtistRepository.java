package ftn.jwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.jwd.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
	
	Artist findOneById(Long id);

}
