package ftn.jwd.service;

import java.util.List;

import ftn.jwd.model.Izvodjac;

public interface IzvodjacService {
	
	List<Izvodjac> findAll();
	Izvodjac findOne(Long id);
	Izvodjac save(Izvodjac izvodjac);
	Izvodjac create(Izvodjac izvodjac);

}
