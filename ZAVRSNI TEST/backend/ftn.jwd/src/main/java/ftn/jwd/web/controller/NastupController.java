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

import ftn.jwd.model.Nastup;
import ftn.jwd.service.NastupService;
import ftn.jwd.support.NastupDtoToNastup;
import ftn.jwd.support.NastupToNastupDto;
import ftn.jwd.web.dto.NastupDto;

@RestController
@RequestMapping(value = "/api/nastupi", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class NastupController {
	
	@Autowired
	private NastupService nastupService;
	
	@Autowired
	private NastupToNastupDto nastupToNastupDto;
	
	@Autowired
	private NastupDtoToNastup nastupDtoToNastup;
	
	
	
    @GetMapping
    public ResponseEntity<List<NastupDto>> getAll(
    		
    		@RequestParam(required = false) Long izvodjacId,
    		@RequestParam(required = false) Long festivalId,
            @RequestParam(value = "pageNo", defaultValue = "-1") int pageNo){

        Page<Nastup> page;
        
        if(pageNo != -1) {
        	page = nastupService.findAll(izvodjacId, festivalId, pageNo);
            
            HttpHeaders headers = new HttpHeaders();
            headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
            
            return new ResponseEntity<>(nastupToNastupDto.convert(page.getContent()), headers, HttpStatus.OK);
        }
        
        List<Nastup> list = nastupService.findAll();
        return new ResponseEntity<>(nastupToNastupDto.convert(list), HttpStatus.OK);
        
    }
	
    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NastupDto> create(@Valid @RequestBody NastupDto nastupDto){
		Nastup nastup = nastupDtoToNastup.convert(nastupDto);

        if(nastup.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Nastup sacuvanNastup = nastupService.create(nastup);

        return new ResponseEntity<>(nastupToNastupDto.convert(sacuvanNastup), HttpStatus.CREATED);
    }
	
    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NastupDto> update(@PathVariable Long id, @Valid @RequestBody NastupDto nastupDto){

        if(!id.equals(nastupDto.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Nastup nastup = nastupDtoToNastup.convert(nastupDto);

        if(nastup.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Nastup sacuvanNastup = nastupService.update(nastup);

        return new ResponseEntity<>(nastupToNastupDto.convert(sacuvanNastup),HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<NastupDto> delete(@PathVariable Long id) {
		Nastup nastup = nastupService.delete(id);

		if (nastup == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(nastupToNastupDto.convert(nastup), HttpStatus.OK);
	}

}
