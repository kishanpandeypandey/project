package com.erp.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.erp.store.entity.Unit;
import com.erp.store.entity.UnitType;
import com.erp.store.service.UnitService;
import com.erp.store.service.UnitTypeServices;
import com.google.gson.annotations.Until;

@Controller
public class UnitController {
	
	
	
	@Autowired
	UnitService unitservice;
	
	@Autowired
	UnitTypeServices unitTypeServices;
	
  
	  
	//upload new excel sheet to database
	@PostMapping("/upload")
	public void saveUnitData(@RequestParam("file")MultipartFile file) {
		unitservice.saveExcelData(file);
		
	}
	
	//get list of unit table in json
	@GetMapping("/getUnitList")
	@ResponseBody
	public List<Unit> getUnitList(){
		List<Unit> ListOfUnit = unitservice.getUnitList();
		return ListOfUnit;
		
	}
	//get list of unittype table 
	@GetMapping("/getUnitTypeList")
	@ResponseBody
	public List<UnitType> getUnitTypeList(){
		List<UnitType> ListOfUnit = unitTypeServices.getUnitTypeList();
		return ListOfUnit;
		
	}
	
	//filter unit table by name
	@GetMapping(value="/data/{name}")
	@ResponseBody
	public List<Unit> getUnitByName(@PathVariable("name") String name) {   
		List<Unit> listOfUnitByName = unitservice.getUnitByname(name);
	   System.out.println("every thing work");
	    return listOfUnitByName;
	}
		
	}
	



