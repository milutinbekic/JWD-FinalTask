package ftn.jwd.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.jwd.model.Nastup;
import ftn.jwd.model.Izvodjac;
import ftn.jwd.model.Festival;
import ftn.jwd.service.FestivalService;
import ftn.jwd.service.IzvodjacService;
import ftn.jwd.service.NastupService;
import ftn.jwd.web.dto.NastupDto;

@Component
public class NastupDtoToNastup implements Converter<NastupDto, Nastup> {

	@Autowired
	private IzvodjacService izvodjacService;
	
	@Autowired
	private FestivalService festivalService;
	
	@Autowired
	private NastupService nastupService;
	
	
	@Override
	public Nastup convert(NastupDto nastupDto) {
		Nastup nastup;
		
		if(nastupDto.getId() == null) {
			nastup = new Nastup();
		} else {
			nastup = nastupService.findOne(nastupDto.getId());
		}
		
		if(nastup != null) {
			nastup.setId(nastupDto.getId());
			
			Izvodjac izvodjac = izvodjacService.findOne(nastupDto.getIzvodjacId());
			if(izvodjac != null) {
				nastup.setIzvodjac(izvodjac);
			}
			
			Festival festival = festivalService.findOne(nastupDto.getFestivalId());
			if(festival != null) {
				nastup.setFestival(festival);
			}
		}
		
		return nastup;
	}

}
