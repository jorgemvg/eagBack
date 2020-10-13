package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wog.eag.model.UsuarioPrincipal;

import com.wog.eag.administracion.aplicaciones.dao.ToolbarChildDAOImpl;
import com.wog.eag.administracion.aplicaciones.model.ToolbarEntity;

@Service
public class ToolbarChildServiceImpl extends ToolbarServiceImpl implements ToolbarChildService {

	@Autowired
	private ToolbarChildDAOImpl toolbarDao;
	
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
		
		BigDecimal adTabToolbarId = toolbarDao.getAdTabToolbarId(entity.getAdTabId(), entity.getScreenType());
		
		if (adTabToolbarId == null  ) {
			adTabToolbarId = sequenceGenerator.getSequence("AD_TAB_TOOLBAR", principal.getDefaultAdClientId());
		}
		
		entity.setAdTabToolbarId(adTabToolbarId);
		
		return toolbarDao.save(entity);
	}
}