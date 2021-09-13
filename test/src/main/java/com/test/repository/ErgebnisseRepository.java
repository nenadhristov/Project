package com.test.repository;




import java.sql.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.model.Ergebnisse;

@Repository
public interface ErgebnisseRepository extends JpaRepository<Ergebnisse,Integer> {

	@Query(value = "SELECT * FROM Ergebnisse where Material=:Material and Laboreingangsdatum=:Laboreingangsdatum", nativeQuery = true)
	List<Ergebnisse> findMaterial(@Param("Material") String Material, @Param("Laboreingangsdatum") Date Laboreingangsdatum );
	
	@Query(value = "SELECT * FROM Ergebnisse where Material=:Material", nativeQuery = true)
	List<Ergebnisse> findOnlyByMaterial(@Param("Material") String Material);

}
