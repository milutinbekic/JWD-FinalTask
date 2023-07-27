package ftn.jwd.service;

import java.util.List;

import org.springframework.data.domain.Page;

import ftn.jwd.model.Nastup;

public interface NastupService {
	
	List<Nastup> findAll();
	
	Page<Nastup> findAll(Long izvodjacId, Long festivalId, Integer pageNo);
	
	Nastup findOne(Long id);
	
	Nastup save(Nastup nastup);
	
	Nastup create(Nastup nastup);
	
	Nastup update(Nastup nastup);
	
	Nastup delete(Long id);

}
