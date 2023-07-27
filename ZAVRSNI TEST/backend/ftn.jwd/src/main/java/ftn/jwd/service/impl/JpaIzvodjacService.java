package ftn.jwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.jwd.model.Izvodjac;
import ftn.jwd.repository.IzvodjacRepository;
import ftn.jwd.service.IzvodjacService;

@Service
public class JpaIzvodjacService implements IzvodjacService {
	
	@Autowired
	private IzvodjacRepository izvodjacRepository;

	@Override
	public List<Izvodjac> findAll() {
		return izvodjacRepository.findAll();
	}

	@Override
	public Izvodjac findOne(Long id) {
		return izvodjacRepository.findOneById(id);
	}

	@Override
	public Izvodjac save(Izvodjac izvodjac) {
		return izvodjacRepository.save(izvodjac);
	}

	@Override
	public Izvodjac create(Izvodjac izvodjac) {
		return izvodjacRepository.save(izvodjac);
	}

}
