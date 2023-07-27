package ftn.jwd.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.jwd.model.Festival;
import ftn.jwd.web.dto.FestivalDto;

@Component
public class FestivalToFestivalDto implements Converter<Festival, FestivalDto> {

	@Override
	public FestivalDto convert(Festival festival) {
		FestivalDto festivalDto = new FestivalDto();
		
		festivalDto.setId(festival.getId());
		festivalDto.setNaziv(festival.getNaziv());
		
		return festivalDto;
	}
	
	public List<FestivalDto> convert(List<Festival> festivali){
		List<FestivalDto> festivaliDto = new ArrayList<>();
		
		for(Festival z: festivali) {
			festivaliDto.add(convert(z));
		}
		
		return festivaliDto;
	}

}
