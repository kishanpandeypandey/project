package com.erp.store.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.erp.store.config.GetExcelData;
import com.erp.store.config.StoreExcelData;
import com.erp.store.dao.UnitRepository;
import com.erp.store.dao.UnitTypeRepository;
import com.erp.store.entity.Unit;
import com.erp.store.entity.UnitType;
import com.erp.store.service.UnitService;

@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	UnitTypeRepository unitTypeRepository;

	@Autowired
	UnitRepository unitRepository;

	@Override
	public void saveExcelData(MultipartFile file) {

		try {
			
	//Getting list of all unit.
	//remove dublicate type		
	//add unique type to unitType database
			
		Set<StoreExcelData> listOfNewExcelSheet = GetExcelData.excelToUnit(file.getInputStream());
		if(listOfNewExcelSheet == null) {
  			System.out.println("your excel sheet is empty");
  		}
		
    //check unit_type table is null or not
	//if null so add hole data remove dublicate one	

        List<UnitType> listofUnitTypeFormDatabase= unitTypeRepository.findAll();
			UnitType unitType4 = new UnitType();

      if(listofUnitTypeFormDatabase == null) {

  		for(StoreExcelData storeExcelData : listOfNewExcelSheet) {

System.out.println("this is first run");
unitType4.setName(storeExcelData.getType());
unitType4.setCreatedOn(LocalDate.now());
unitTypeRepository.save(unitType4);
}}
  		
  		 List<String> listOfType = new ArrayList<>();
  		 for(UnitType unitType2 : listofUnitTypeFormDatabase) {
  			 
  			 listOfType.add(unitType2.getName());
  		 }
  		 
  		 
  		for(StoreExcelData storeExcelData2 : listOfNewExcelSheet) {


  			if( listOfType.contains(storeExcelData2.getType())) {
  				System.out.println("this data is already exist in unitType table");
  			}else
  			{

  			unitType4.setName(storeExcelData2.getType());
  			unitType4.setCreatedOn(LocalDate.now());
  			unitTypeRepository.save(unitType4);
  			unitType4=null;
  			}

  		}
  		
  		// save data to unit table
  		
  		List<Unit> listOfUnit = unitRepository.findAll();
  		List<String> listOfName = new ArrayList<>();
  		for(Unit unit: listOfUnit) {
  			listOfName.add(unit.getName());
  		}
  		
  		
  		if(listofUnitTypeFormDatabase == null) {
  			System.out.println("unitType table is empty");
  		}
  		else {
  		Unit unit = new Unit();
  		
  		
  		for(UnitType unitType2: listofUnitTypeFormDatabase) {
  			for(StoreExcelData storeExcelData : listOfNewExcelSheet) {

  				
  			if(unitType2.getName().equals(storeExcelData.getType())) {
  				

  				unit.setName(storeExcelData.getUnitname());
  				unit.setStatus(storeExcelData.getStatus());
  				unit.setDescription(storeExcelData.getDiscription());
  				unit.setUnitType(unitType2.getId());
  				unit.setCreatedOn(LocalDate.now());
  				unit.setUpdatedOn(LocalDate.now());
  				unit.setCreatedBy(542);
  				unit.setType(unitType2.getName());

  				unitRepository.save(unit);
  	  			System.out.println("i am enter here");
  				}
  				unit = null;
  			}
  		}
  		}	
  		
  		
  		
      }		
	
		catch (Exception e) {
e.printStackTrace();
throw new RuntimeException("fail to store excel data: " + e.getMessage());		

		}
		
		
		
		
		
	}

	@Override
	public List<Unit> getUnitList() {
		
		return unitRepository.findAll();
	}

	@Override
	public List<Unit> getUnitByname(String name) {
		List<Unit> listOfUnitByName = unitRepository.findByName(name);
		return null;
	}

	
}
