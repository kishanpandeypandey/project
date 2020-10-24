package com.erp.store.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.erp.store.entity.Unit;


public interface UnitService {
	
	
	  
void saveExcelData(MultipartFile file);	  
List<Unit> getUnitList();
List<Unit> getUnitByname(String name);
	  

}
