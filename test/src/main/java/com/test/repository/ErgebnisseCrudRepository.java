package com.test.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.test.model.Ergebnisse;

public interface ErgebnisseCrudRepository extends CrudRepository<Ergebnisse,Integer> {
	
	Page<Ergebnisse> findAll(Pageable pageable);
	

}
