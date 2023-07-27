package ftn.jwd.service;

import java.util.List;

import ftn.jwd.model.Festival;

public interface FestivalService {
	
	List<Festival> findAll();
	Festival findOne(Long id);
	Festival save(Festival festival);

}
