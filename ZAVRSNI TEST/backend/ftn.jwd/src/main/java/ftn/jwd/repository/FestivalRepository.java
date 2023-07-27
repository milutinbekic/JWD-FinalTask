package ftn.jwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.jwd.model.Festival;

@Repository
public interface FestivalRepository extends JpaRepository<Festival, Long> {
	
	Festival findOneById(Long id);

}
