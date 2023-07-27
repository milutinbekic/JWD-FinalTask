package ftn.jwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.jwd.model.Izvodjac;

@Repository
public interface IzvodjacRepository extends JpaRepository<Izvodjac, Long> {
	
	Izvodjac findOneById(Long id);

}
