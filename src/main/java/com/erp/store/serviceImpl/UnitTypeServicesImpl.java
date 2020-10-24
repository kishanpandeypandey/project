package com.erp.store.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.store.dao.UnitTypeRepository;
import com.erp.store.entity.UnitType;
import com.erp.store.service.UnitTypeServices;

@Service
public class UnitTypeServicesImpl implements UnitTypeServices{
	
	@Autowired
	UnitTypeRepository unitTypeRepository;

	@Override
	public List<UnitType> getUnitTypeList() {
		List<UnitType> listofUnitTypeData = unitTypeRepository.findAll();
		return listofUnitTypeData;
	}

		
}
