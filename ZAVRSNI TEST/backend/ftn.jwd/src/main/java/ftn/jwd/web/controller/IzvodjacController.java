package ftn.jwd.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.jwd.model.Izvodjac;
import ftn.jwd.service.IzvodjacService;
import ftn.jwd.support.IzvodjacDtoToIzvodjac;
import ftn.jwd.support.IzvodjacToIzvodjacDto;
import ftn.jwd.web.dto.IzvodjacDto;

@RestController
@RequestMapping(value = "/api/izvodjaci", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class IzvodjacController {
	
	@Autowired
	private IzvodjacService izvodjacService;
	
	@Autowired
	private IzvodjacToIzvodjacDto izvodjacToIzvodjacDto;
	
	@Autowired
	private IzvodjacDtoToIzvodjac izvodjacDtoToIzvodjac;
	
	
	@GetMapping
	public ResponseEntity<List<IzvodjacDto>> getAll(){
		List<Izvodjac> izvodjaci = izvodjacService.findAll();
		List<IzvodjacDto> izvodjaciDto = new ArrayList<>();
		for(Izvodjac s: izvodjaci) {
			izvodjaciDto.add(izvodjacToIzvodjacDto.convert(s));
		}
		return new ResponseEntity<>(izvodjaciDto, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IzvodjacDto> create(@Valid @RequestBody IzvodjacDto izvodjacDto){
		Izvodjac izvodjac = izvodjacDtoToIzvodjac.convert(izvodjacDto);

        if(izvodjac.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Izvodjac sacuvanIzvodjac = izvodjacService.create(izvodjac);

        return new ResponseEntity<>(izvodjacToIzvodjacDto.convert(sacuvanIzvodjac), HttpStatus.CREATED);
    }

}
