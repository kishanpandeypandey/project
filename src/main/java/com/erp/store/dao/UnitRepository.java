package com.erp.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erp.store.entity.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
	
	@Query(value = "SELECT * FROM unit WHERE name = :firstName", nativeQuery = true)
    List<Unit> findByName(@Param("firstName") String firstName);

}
