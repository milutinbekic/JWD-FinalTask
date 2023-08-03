package ftn.jwd.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ftn.jwd.model.Performance;
import ftn.jwd.model.Artist;
import ftn.jwd.model.Festival;
import ftn.jwd.repository.FestivalRepository;
import ftn.jwd.repository.ArtistRepository;
import ftn.jwd.repository.PerformanceRepository;
import ftn.jwd.service.PerformanceService;

@Service
public class JpaPerformanceService implements PerformanceService {
	
	@Autowired
	private PerformanceRepository performanceRepository;
	
	@Autowired
	private ArtistRepository artistRepository;
	
	@Autowired
	private FestivalRepository festivalRepository;
	
	
	@Override
	public List<Performance> findAll() {
		return performanceRepository.findAll();
	}

	@Override
	public Page<Performance> findAll(Long artistId, Long festivalId, Integer pageNo) {
		if(artistId == null && festivalId == null) {
			return performanceRepository.findAll(PageRequest.of(pageNo, 3));
		} else if(artistId == null) {
			return performanceRepository.findByFestivalId(festivalId, PageRequest.of(pageNo, 3));
		} else if(festivalId == null) {
			return performanceRepository.findByArtistId(artistId, PageRequest.of(pageNo, 3));
		}
		return performanceRepository.findByFestivalIdAndArtistId(festivalId, artistId, PageRequest.of(pageNo, 3));
	}

	@Override
	public Performance findOne(Long id) {
		return performanceRepository.findOneById(id);
	}

	@Override
	public Performance save(Performance performance) {
		return performanceRepository.save(performance);
	}

	@Override
	public Performance create(Performance performance) {
		Artist artist = performance.getArtist();		
		Festival festival = performance.getFestival();
		
		List<Performance> AllPerformancesOnFestival = festival.getPerformances();
		
		for(Performance performanceOnFestival: AllPerformancesOnFestival) {
			if(performanceOnFestival.getArtist().getCountry().equals(artist.getCountry())) {
				System.out.println("Na festivalu ne mogu biti 2 artista iz iste drzave!");
				return null;
			}
		}
		
		return performanceRepository.save(performance);
	}

	@Override
	public Performance update(Performance performance) {
		return performanceRepository.save(performance);
	}

	@Override
	@Transactional
	public Performance delete(Long id) {
		Performance performance = findOne(id);
		
		Artist artist = performance.getArtist();
		artist.getPerformances().remove(performance);
		artistRepository.save(artist);
		
		Festival festival = performance.getFestival();
		festival.getPerformances().remove(performance);
		festivalRepository.save(festival);
		
		performanceRepository.deleteById(id);
		return performance;
	}

}
