package ftn.jwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.jwd.model.Festival;
import ftn.jwd.repository.FestivalRepository;
import ftn.jwd.service.FestivalService;

@Service
public class JpaFestivalService implements FestivalService {
	
	@Autowired
	private FestivalRepository festivalRepository;

	@Override
	public List<Festival> findAll() {
		return festivalRepository.findAll();
	}

	@Override
	public Festival findOne(Long id) {
		return festivalRepository.findOneById(id);
	}

	@Override
	public Festival save(Festival festival) {
		return festivalRepository.save(festival);
	}

}
