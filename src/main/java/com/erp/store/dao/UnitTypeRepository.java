package com.erp.store.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erp.store.entity.UnitType;

@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType, Long>{

	
	//@Query("SELECT u.unit_type_id FROM unit_type u where u.name = :names")
   // int findIdByName(@Param("name") String names);
    
    //@Query("SELECT a.unit_type_id FROM unit_type a WHERE name = ?1")
    //int findIdByName(String firstName);
    
    @Query(value = "SELECT unit_type_id FROM unit_type WHERE name = :firstName", nativeQuery = true)
    int findIdByName(@Param("firstName") String firstName);

 
}
