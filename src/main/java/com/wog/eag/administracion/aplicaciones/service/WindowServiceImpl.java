package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wog.eag.administracion.aplicaciones.dao.WindowDAO;
import com.wog.eag.administracion.aplicaciones.model.WindowEntity;
import com.wog.eag.model.UsuarioPrincipal;
import com.wog.eag.service.SequenceGeneratorService;

@Service
public class WindowServiceImpl implements WindowService{

	@Autowired
	private WindowDAO windowDao;
	
	@Autowired
	protected SequenceGeneratorService sequenceGenerator;
	
	@Override
	@Transactional
	public WindowEntity get(BigDecimal id) {
		return windowDao.get(id);
	}

	@Override
	@Transactional
	public BigDecimal save(WindowEntity entity) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		entity.setCreated( new Timestamp(new Date().getTime()) );
		entity.setUpdated( new Timestamp(new Date().getTime()) );
		entity.setCreatedby(principal.getAdUserId());
		entity.setUpdatedby(principal.getAdUserId());
		entity.setAdClientId(principal.getDefaultAdClientId());
		entity.setAdOrgId(principal.getDefaultAdOrgId());
		entity.setIsactive("Y");
		
		BigDecimal adWindowId = sequenceGenerator.getSequence("AD_WINDOW", principal.getDefaultAdClientId());
		entity.setAdWindowId(adWindowId);
		
		return windowDao.save(entity);
	}

	@Override
	@Transactional
	public void update(BigDecimal id, WindowEntity entity) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		entity.setUpdated( new Timestamp(new Date().getTime()) );
		entity.setUpdatedby(principal.getAdUserId());
		
		windowDao.update(entity);
	}

	@Override
	@Transactional
	public void delete(BigDecimal id) {
		windowDao.delete(id);
	}
	
	@Override
	@Transactional
	public List<WindowEntity> list( BigDecimal parentId ) {
		return windowDao.list(parentId);
	}
	
}