package ftn.jwd.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.jwd.model.Performance;
import ftn.jwd.model.Artist;
import ftn.jwd.model.Festival;
import ftn.jwd.service.FestivalService;
import ftn.jwd.service.ArtistService;
import ftn.jwd.service.PerformanceService;
import ftn.jwd.web.dto.PerformanceDto;

@Component
public class PerformanceDtoToPerformance implements Converter<PerformanceDto, Performance> {

	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private FestivalService festivalService;
	
	@Autowired
	private PerformanceService performanceService;
	
	
	@Override
	public Performance convert(PerformanceDto performanceDto) {
		Performance performance;
		
		if(performanceDto.getId() == null) {
			performance = new Performance();
		} else {
			performance = performanceService.findOne(performanceDto.getId());
		}
		
		if(performance != null) {
			performance.setId(performanceDto.getId());
			
			Artist artist = artistService.findOne(performanceDto.getArtistId());
			if(artist != null) {
				performance.setArtist(artist);
			}
			
			Festival festival = festivalService.findOne(performanceDto.getFestivalId());
			if(festival != null) {
				performance.setFestival(festival);
			}
		}
		
		return performance;
	}

}
