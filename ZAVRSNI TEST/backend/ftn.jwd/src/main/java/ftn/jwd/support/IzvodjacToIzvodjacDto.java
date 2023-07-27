package ftn.jwd.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.jwd.model.Izvodjac;
import ftn.jwd.web.dto.IzvodjacDto;

@Component
public class IzvodjacToIzvodjacDto implements Converter<Izvodjac, IzvodjacDto> {

	@Override
	public IzvodjacDto convert(Izvodjac izvodjac) {
		IzvodjacDto izvodjacDto = new IzvodjacDto();
		
		izvodjacDto.setId(izvodjac.getId());
		izvodjacDto.setBrojClanova(izvodjac.getBrojClanova());
		izvodjacDto.setDrzavaPorekla(izvodjac.getDrzavaPorekla());
		izvodjacDto.setIme(izvodjac.getIme());
		izvodjacDto.setZanr(izvodjac.getZanr());
		
		return izvodjacDto;
	}
	
	public List<IzvodjacDto> convert(List<Izvodjac> izvodjaci){
		List<IzvodjacDto> izvodjaciDto = new ArrayList<>();
		
		for(Izvodjac z: izvodjaci) {
			izvodjaciDto.add(convert(z));
		}
		
		return izvodjaciDto;
	}

}
