package ftn.jwd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.jwd.model.Performance;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {
	
	Performance findOneById(Long id);
	Page<Performance> findByFestivalIdAndArtistId(Long festivalId, Long artistId, Pageable pageble);
	Page<Performance> findByArtistId(Long artistId, Pageable pageble);
	Page<Performance> findByFestivalId(Long festivalId, Pageable pageble);

}
