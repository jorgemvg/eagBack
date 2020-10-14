package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wog.eag.administracion.aplicaciones.dao.TabDAO;
import com.wog.eag.administracion.aplicaciones.model.TabEntity;
import com.wog.eag.model.UsuarioPrincipal;
import com.wog.eag.service.SequenceGeneratorService;

@Service
public class TabServiceImpl implements TabService{

	@Autowired
	private TabDAO tabDao;
	
	@Autowired
	protected SequenceGeneratorService sequenceGenerator;
	
	@Override
	@Transactional
	public TabEntity get(BigDecimal id) {
		return tabDao.get(id);
	}

	@Override
	@Transactional
	public BigDecimal save(TabEntity entity) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		entity.setCreated( new Timestamp(new Date().getTime()) );
		entity.setUpdated( new Timestamp(new Date().getTime()) );
		entity.setCreatedby(principal.getAdUserId());
		entity.setUpdatedby(principal.getAdUserId());
		entity.setAdClientId(principal.getDefaultAdClientId());
		entity.setAdOrgId(principal.getDefaultAdOrgId());
		entity.setIsactive("Y");
		
		BigDecimal adTabId = sequenceGenerator.getSequence("AD_TAB", principal.getDefaultAdClientId());
		entity.setAdTabId(adTabId);
		
		return tabDao.save(entity);
	}

	@Override
	@Transactional
	public void update(BigDecimal id, TabEntity entity) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		entity.setUpdated( new Timestamp(new Date().getTime()) );
		entity.setUpdatedby(principal.getAdUserId());
		
		tabDao.update(entity);
	}

	@Override
	@Transactional
	public void delete(BigDecimal id) {
		tabDao.delete(id);
	}
	
	@Override
	@Transactional
	public List<TabEntity> list( BigDecimal parentId ) {
		return tabDao.list(parentId);
	}
	
}