package ftn.jwd.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.jwd.model.Performance;
import ftn.jwd.model.Festival;
import ftn.jwd.model.Artist;
import ftn.jwd.web.dto.PerformanceDto;

@Component
public class PerformanceToPerformanceDto implements Converter<Performance, PerformanceDto> {

	@Override
	public PerformanceDto convert(Performance performance) {
		PerformanceDto performanceDto = new PerformanceDto();
		
		performanceDto.setId(performance.getId());

		Festival festival = performance.getFestival();
		if (festival != null) {
			performanceDto.setFestivalId(festival.getId());
			performanceDto.setFestivalName(festival.getName());
		}
		
		Artist artist = performance.getArtist();
		if (artist != null) {
			performanceDto.setArtistId(artist.getId());
			performanceDto.setArtistName(artist.getName());
		}
		
		return performanceDto;
	}
	
	public List<PerformanceDto> convert(List<Performance> performances){
		List<PerformanceDto> performancesDto = new ArrayList<>();
		
		for(Performance z: performances) {
			performancesDto.add(convert(z));
		}
		
		return performancesDto;
	}

}
