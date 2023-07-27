package ftn.jwd.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.jwd.model.Festival;
import ftn.jwd.service.FestivalService;
import ftn.jwd.support.FestivalToFestivalDto;
import ftn.jwd.web.dto.FestivalDto;

@RestController
@RequestMapping(value = "/api/festivali", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class FestivalController {
	
	@Autowired
	private FestivalService festivalService;
	
	@Autowired
	private FestivalToFestivalDto festivalToFestivalDto;
	

	@GetMapping
	public ResponseEntity<List<FestivalDto>> getAll(){
		List<Festival> festivali = festivalService.findAll();
		List<FestivalDto> festivaliDto = new ArrayList<>();
		for(Festival s: festivali) {
			festivaliDto.add(festivalToFestivalDto.convert(s));
		}
		return new ResponseEntity<>(festivaliDto, HttpStatus.OK);
	}

}
