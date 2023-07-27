package ftn.jwd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.jwd.model.Nastup;

@Repository
public interface NastupRepository extends JpaRepository<Nastup, Long> {
	
	Nastup findOneById(Long id);
	Page<Nastup> findByFestivalIdAndIzvodjacId(Long festivalId, Long izvodjaId, Pageable pageble);
	Page<Nastup> findByIzvodjacId(Long izvodjacId, Pageable pageble);
	Page<Nastup> findByFestivalId(Long festivalId, Pageable pageble);

}
