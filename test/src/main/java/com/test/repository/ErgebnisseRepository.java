package com.test.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.model.Ergebnisse;

@Repository
public interface ErgebnisseRepository extends JpaRepository<Ergebnisse,Integer> {

List<Ergebnisse> findBymaterial(String material);


}
