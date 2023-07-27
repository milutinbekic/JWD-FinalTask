package ftn.jwd.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.jwd.model.Izvodjac;
import ftn.jwd.service.IzvodjacService;
import ftn.jwd.web.dto.IzvodjacDto;

@Component
public class IzvodjacDtoToIzvodjac implements Converter<IzvodjacDto, Izvodjac> {

	@Autowired
	private IzvodjacService izvodjacService;
	
	
	@Override
	public Izvodjac convert(IzvodjacDto izvodjacDto) {
		Izvodjac izvodjac;
		
		if(izvodjacDto.getId() == null) {
			izvodjac = new Izvodjac();
		} else {
			izvodjac = izvodjacService.findOne(izvodjacDto.getId());
		}
		
		if(izvodjac != null) {
			izvodjac.setId(izvodjacDto.getId());
			izvodjac.setBrojClanova(izvodjacDto.getBrojClanova());
			izvodjac.setDrzavaPorekla(izvodjacDto.getDrzavaPorekla());
			izvodjac.setIme(izvodjacDto.getIme());
			izvodjac.setZanr(izvodjacDto.getZanr());
		}
		
		return izvodjac;
	}

}
