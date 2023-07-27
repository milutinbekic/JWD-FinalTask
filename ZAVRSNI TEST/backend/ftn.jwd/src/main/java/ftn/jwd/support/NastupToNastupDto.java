package ftn.jwd.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.jwd.model.Nastup;
import ftn.jwd.model.Festival;
import ftn.jwd.model.Izvodjac;
import ftn.jwd.web.dto.NastupDto;

@Component
public class NastupToNastupDto implements Converter<Nastup, NastupDto> {

	@Override
	public NastupDto convert(Nastup nastup) {
		NastupDto nastupDto = new NastupDto();
		
		nastupDto.setId(nastup.getId());

		Festival festival = nastup.getFestival();
		if (festival != null) {
			nastupDto.setFestivalId(festival.getId());
			nastupDto.setFestivalNaziv(festival.getNaziv());
		}
		
		Izvodjac izvodjac = nastup.getIzvodjac();
		if (izvodjac != null) {
			nastupDto.setIzvodjacId(izvodjac.getId());
			nastupDto.setIzvodjacIme(izvodjac.getIme());
		}
		
		return nastupDto;
	}
	
	public List<NastupDto> convert(List<Nastup> nastupi){
		List<NastupDto> nastupiDto = new ArrayList<>();
		
		for(Nastup z: nastupi) {
			nastupiDto.add(convert(z));
		}
		
		return nastupiDto;
	}

}
