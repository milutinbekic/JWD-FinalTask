package ftn.jwd.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.jwd.model.Performance;
import ftn.jwd.service.PerformanceService;
import ftn.jwd.support.PerformanceDtoToPerformance;
import ftn.jwd.support.PerformanceToPerformanceDto;
import ftn.jwd.web.dto.PerformanceDto;

@RestController
@RequestMapping(value = "/api/performances", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class PerformanceController {
	
	@Autowired
	private PerformanceService performanceService;
	
	@Autowired
	private PerformanceToPerformanceDto performanceToPerformanceDto;
	
	@Autowired
	private PerformanceDtoToPerformance performanceDtoToPerformance;
	
	
	
    @GetMapping
    public ResponseEntity<List<PerformanceDto>> getAll(
    		
    		@RequestParam(required = false) Long artistId,
    		@RequestParam(required = false) Long festivalId,
            @RequestParam(value = "pageNo", defaultValue = "-1") int pageNo){

        Page<Performance> page;
        
        if(pageNo != -1) {
        	page = performanceService.findAll(artistId, festivalId, pageNo);
            
            HttpHeaders headers = new HttpHeaders();
            headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
            
            return new ResponseEntity<>(performanceToPerformanceDto.convert(page.getContent()), headers, HttpStatus.OK);
        }
        
        List<Performance> list = performanceService.findAll();
        return new ResponseEntity<>(performanceToPerformanceDto.convert(list), HttpStatus.OK);
        
    }
	
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PerformanceDto> create(@Valid @RequestBody PerformanceDto performanceDto){
		Performance performance = performanceDtoToPerformance.convert(performanceDto);

        if(performance.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Performance sacuvanPerformance = performanceService.create(performance);

        return new ResponseEntity<>(performanceToPerformanceDto.convert(sacuvanPerformance), HttpStatus.CREATED);
    }
	
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PerformanceDto> update(@PathVariable Long id, @Valid @RequestBody PerformanceDto performanceDto){

        if(!id.equals(performanceDto.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Performance performance = performanceDtoToPerformance.convert(performanceDto);

        if(performance.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Performance sacuvanPerformance = performanceService.update(performance);

        return new ResponseEntity<>(performanceToPerformanceDto.convert(sacuvanPerformance),HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PerformanceDto> delete(@PathVariable Long id) {
		Performance performance = performanceService.delete(id);

		if (performance == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(performanceToPerformanceDto.convert(performance), HttpStatus.OK);
	}

}
