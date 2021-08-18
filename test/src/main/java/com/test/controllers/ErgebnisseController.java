package com.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.load.ErgebnisseRequest;
import com.test.model.Ergebnisse;
import com.test.repository.ErgebnisseRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ErgebnisseController {
	
	ErgebnisseRepository repository;
	
	@Autowired
	ErgebnisseController(ErgebnisseRepository repository){
		this.repository=repository;
	}
	
	@RequestMapping(value="/ergebnisse", method=RequestMethod.GET)
	public List<Ergebnisse> getData(ErgebnisseRequest request){
		
		
		List<Ergebnisse> ergebnisseList = repository.findAll();
		
		return ergebnisseList;
		
		
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public List<Ergebnisse> Search(ErgebnisseRequest request){
		
		
		List<Ergebnisse> ergebnisseList = repository.findBymaterial(request.getMaterial());
		
		return ergebnisseList;
		
		
	}
	
	
	
	

}
