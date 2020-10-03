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
import com.wog.eag.administracion.aplicaciones.model.Window;
import com.wog.eag.model.UsuarioPrincipal;
import com.wog.eag.service.SequenceGeneratorService;

@Service
public class WindowServiceImpl implements WindowService{

	@Autowired
	private WindowDAO windowDao;
	
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	
	@Override
	@Transactional
	public Window get(BigDecimal id) {
		return windowDao.get(id);
	}

	@Override
	@Transactional
	public BigDecimal save(Window window) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		window.setCreated( new Timestamp(new Date().getTime()) );
		window.setUpdated( new Timestamp(new Date().getTime()) );
		window.setCreatedby(principal.getAdUserId());
		window.setUpdatedby(principal.getAdUserId());
		window.setAdClientId(principal.getDefaultAdClientId());
		window.setAdOrgId(principal.getDefaultAdOrgId());
		window.setIsactive("Y");
		
		BigDecimal adWindowId = sequenceGenerator.getSequence("AD_WINDOW", principal.getDefaultAdClientId());
		window.setAdWindowId(adWindowId);
		
		return windowDao.save(window);
	}

	@Override
	@Transactional
	public void update(BigDecimal id, Window window) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		window.setUpdated( new Timestamp(new Date().getTime()) );
		window.setUpdatedby(principal.getAdUserId());
		
		windowDao.update(window);
	}

	@Override
	@Transactional
	public void delete(BigDecimal id) {
		windowDao.delete(id);
	}
	
	@Override
	@Transactional
	public List<Window> list( BigDecimal adModuleId ) {
		return windowDao.list(adModuleId);
	}

}