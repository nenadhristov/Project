package com.test.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.load.ErgebnisseRequest;
import com.test.load.PageableRequest;
import com.test.model.Ergebnisse;
import com.test.repository.ErgebnisseCrudRepository;
import com.test.repository.ErgebnisseRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ErgebnisseController {
	
	@Autowired
	ErgebnisseRepository repository;
	
	@Autowired
	ErgebnisseCrudRepository crudRepository;

	@RequestMapping(value="/ergebnisse", method=RequestMethod.POST)
	public Page<Ergebnisse> getData(@RequestBody PageableRequest request){
		
		
		Page<Ergebnisse> data = repository.findAll(PageRequest.of(request.getFrom(), request.getTo()));
		
		return data;
		
		
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public List<Ergebnisse> Search(@RequestBody ErgebnisseRequest request){
		
		
		List<Ergebnisse> ergebnisseList = repository.findMaterial(request.getMaterial(), request.getLaboreingangsdatum());
		
		return ergebnisseList;
		
		
	}
	
	@RequestMapping(value="/searchMaterial", method=RequestMethod.POST)
	public List<Ergebnisse> SearchByMaterial(@RequestBody ErgebnisseRequest request){
		
		
		List<Ergebnisse> ergebnisseList = repository.findOnlyByMaterial(request.getMaterial());
		
		return ergebnisseList;
		
		
	}
	
	
	
	

}
