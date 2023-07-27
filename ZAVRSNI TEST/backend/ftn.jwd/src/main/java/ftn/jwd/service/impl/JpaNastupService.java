package ftn.jwd.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ftn.jwd.model.Nastup;
import ftn.jwd.model.Izvodjac;
import ftn.jwd.model.Festival;
import ftn.jwd.repository.FestivalRepository;
import ftn.jwd.repository.IzvodjacRepository;
import ftn.jwd.repository.NastupRepository;
import ftn.jwd.service.NastupService;

@Service
public class JpaNastupService implements NastupService {
	
	@Autowired
	private NastupRepository nastupRepository;
	
	@Autowired
	private IzvodjacRepository izvodjacRepository;
	
	@Autowired
	private FestivalRepository festivalRepository;
	
	
	@Override
	public List<Nastup> findAll() {
		return nastupRepository.findAll();
	}

	@Override
	public Page<Nastup> findAll(Long izvodjacId, Long festivalId, Integer pageNo) {
		if(izvodjacId == null && festivalId == null) {
			return nastupRepository.findAll(PageRequest.of(pageNo, 3));
		} else if(izvodjacId == null) {
			return nastupRepository.findByFestivalId(festivalId, PageRequest.of(pageNo, 3));
		} else if(festivalId == null) {
			return nastupRepository.findByIzvodjacId(izvodjacId, PageRequest.of(pageNo, 3));
		}
		return nastupRepository.findByFestivalIdAndIzvodjacId(festivalId, izvodjacId, PageRequest.of(pageNo, 3));
	}

	@Override
	public Nastup findOne(Long id) {
		return nastupRepository.findOneById(id);
	}

	@Override
	public Nastup save(Nastup nastup) {
		return nastupRepository.save(nastup);
	}

	@Override
	public Nastup create(Nastup nastup) {
		Izvodjac izvodjac = nastup.getIzvodjac();		
		Festival festival = nastup.getFestival();
		
		List<Nastup> sviNastupiFestivala = festival.getNastupi();
		
		for(Nastup nastupFestivala: sviNastupiFestivala) {
			if(nastupFestivala.getIzvodjac().getDrzavaPorekla().equals(izvodjac.getDrzavaPorekla())) {
				System.out.println("Na festivalu ne mogu biti 2 izvodjaca iz iste drzave!");
				return null;
			}
		}
		
		return nastupRepository.save(nastup);
	}

	@Override
	public Nastup update(Nastup nastup) {
		return nastupRepository.save(nastup);
	}

	@Override
	@Transactional
	public Nastup delete(Long id) {
		Nastup nastup = findOne(id);
		
		Izvodjac izvodjac = nastup.getIzvodjac();
		izvodjac.getNastupi().remove(nastup);
		izvodjacRepository.save(izvodjac);
		
		Festival festival = nastup.getFestival();
		festival.getNastupi().remove(nastup);
		festivalRepository.save(festival);
		
		nastupRepository.deleteById(id);
		return nastup;
	}

}
