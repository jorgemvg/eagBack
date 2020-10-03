package com.wog.eag.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wog.eag.dao.CombosDAOImpl;
import com.wog.eag.model.Combo;

@Service
public class CombosServiceImpl {

	@Autowired
	private CombosDAOImpl combosDao;
	
	@Transactional
	public List<Combo> getRefList( Long adReferenceId ) {
		
		return combosDao.getRefList(adReferenceId, "es_CO");
		
	}
	
	
}
