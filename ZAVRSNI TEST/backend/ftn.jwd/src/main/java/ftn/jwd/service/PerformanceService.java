package ftn.jwd.service;

import java.util.List;

import org.springframework.data.domain.Page;

import ftn.jwd.model.Performance;

public interface PerformanceService {
	
	List<Performance> findAll();
	
	Page<Performance> findAll(Long artistId, Long festivalId, Integer pageNo);
	
	Performance findOne(Long id);
	
	Performance save(Performance performance);
	
	Performance create(Performance performance);
	
	Performance update(Performance performance);
	
	Performance delete(Long id);

}
