package com.wog.eag.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wog.eag.dao.CombosDAOImpl;
import com.wog.eag.model.Combo;
import com.wog.eag.model.UsuarioPrincipal;

@Service
public class CombosServiceImpl {

	@Autowired
	private CombosDAOImpl combosDao;
	
	@Transactional
	public List<Combo> getCombo( String parameters ) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		JsonParser parser = new JsonParser();
		JsonObject json = (JsonObject) parser.parse(parameters); 
		
		String comboName = json.get("comboName").getAsString();
		String adValRuleId = json.get("adValRuleId") != null ? (json.get("adValRuleId").getAsBigDecimal()).toString() : "";

		String combo = comboName + adValRuleId;
		
		switch ( combo ) {
		case "adToolbarbuttonId":
			return combosDao.getAdToolbarbuttonId( principal.getDefaultAdClientId(), principal.getDefaultAdOrgId() );
		default:
			return new ArrayList<Combo>();
		}
		
	}
	
	@Transactional
	public List<Combo> getRefList( Long adReferenceId ) {
		return combosDao.getRefList(adReferenceId, "es_CO");
	}
	
	@Transactional
	public List<Combo> getAtTableLid( Long adValruleId, String parameters ) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		switch (adValruleId.intValue()) {
		case 100277:
			JsonParser parser = new JsonParser();  
			JsonObject json = (JsonObject) parser.parse(parameters);   
			JsonElement element = json.get("adApplicationId");
			return combosDao.getAdTableId100277( principal.getDefaultAdClientId(), principal.getDefaultAdOrgId(), element.getAsString());
		default:
			return new ArrayList<Combo>();
		}
		
		
		
	}
	
	
}
