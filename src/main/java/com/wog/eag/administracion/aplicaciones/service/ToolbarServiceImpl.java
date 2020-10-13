package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wog.eag.administracion.aplicaciones.dao.ToolbarDAO;
import com.wog.eag.administracion.aplicaciones.model.ToolbarEntity;
import com.wog.eag.model.UsuarioPrincipal;
import com.wog.eag.service.SequenceGeneratorService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wog.eag.administracion.aplicaciones.model.ToolbarPk;
import com.wog.eag.administracion.aplicaciones.model.ToolbarEntity;

@Service
public class ToolbarServiceImpl implements ToolbarService{

	@Autowired
	private ToolbarDAO toolbarDao;
	
	@Autowired
	protected SequenceGeneratorService sequenceGenerator;
	
	@Override
	@Transactional
	public ToolbarEntity get(String parameters) {

		JsonParser parser = new JsonParser();  
		JsonObject json = (JsonObject) parser.parse(parameters);   
		JsonElement eAdToolbarbuttonId = json.get("adToolbarbuttonId");
		JsonElement eAdTabToolbarId = json.get("adTabToolbarId");
		BigDecimal adToolbarbuttonId = eAdToolbarbuttonId.getAsBigDecimal();
		BigDecimal adTabToolbarId = eAdTabToolbarId.getAsBigDecimal();
		
		ToolbarPk pk = new ToolbarPk();
		pk.setAdToolbarbuttonId(adToolbarbuttonId);
		pk.setAdTabToolbarId(adTabToolbarId);
		return toolbarDao.get(pk);
	}

	@Override
	@Transactional
	public BigDecimal save(ToolbarEntity entity) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		entity.setCreated( new Timestamp(new Date().getTime()) );
		entity.setUpdated( new Timestamp(new Date().getTime()) );
		entity.setCreatedby(principal.getAdUserId());
		entity.setUpdatedby(principal.getAdUserId());
		entity.setAdClientId(principal.getDefaultAdClientId());
		entity.setAdOrgId(principal.getDefaultAdOrgId());
		entity.setIsactive("Y");
		
		BigDecimal adTabToolbarId = sequenceGenerator.getSequence("AD_TAB_TOOLBAR", principal.getDefaultAdClientId());
		entity.setAdTabToolbarId(adTabToolbarId);
		
		return toolbarDao.save(entity);
	}

	@Override
	@Transactional
	public void update(BigDecimal id, ToolbarEntity entity) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		entity.setUpdated( new Timestamp(new Date().getTime()) );
		entity.setUpdatedby(principal.getAdUserId());
		
		toolbarDao.update(entity);
	}

	@Override
	@Transactional
	public void delete(String parameters) {

		JsonParser parser = new JsonParser();  
		JsonObject json = (JsonObject) parser.parse(parameters);   
		JsonElement eAdToolbarbuttonId = json.get("adToolbarbuttonId");
		JsonElement eAdTabToolbarId = json.get("adTabToolbarId");
		BigDecimal adToolbarbuttonId = eAdToolbarbuttonId.getAsBigDecimal();
		BigDecimal adTabToolbarId = eAdTabToolbarId.getAsBigDecimal();
		
		ToolbarPk pk = new ToolbarPk();
		pk.setAdToolbarbuttonId(adToolbarbuttonId);
		pk.setAdTabToolbarId(adTabToolbarId);
		toolbarDao.delete(pk);
	}
	
	@Override
	@Transactional
	public List<ToolbarEntity> list( BigDecimal parentId ) {
		return toolbarDao.list(parentId);
	}
	
}