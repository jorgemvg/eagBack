package com.wog.eag.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wog.eag.dao.AplicacionDAO;
import com.wog.eag.model.Aplicacion;
import com.wog.eag.model.UsuarioPrincipal;

@Service
public class AplicacionServiceImpl implements AplicacionService{

	@Autowired
	private AplicacionDAO aplicacionDao;
	
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	
	@Override
	@Transactional
	public List<Aplicacion> list() {
		return aplicacionDao.list();
	}
//	
	@Override
	@Transactional
	public BigDecimal save(Aplicacion aplicacion) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		aplicacion.setCreated( new Timestamp(new Date().getTime()) );
		aplicacion.setUpdated( new Timestamp(new Date().getTime()) );
		aplicacion.setCreatedby(principal.getAdUserId());
		aplicacion.setUpdatedby(principal.getAdUserId());
		aplicacion.setAdClientId(principal.getDefaultAdClientId());
		aplicacion.setAdOrgId(principal.getDefaultAdOrgId());
		aplicacion.setIsactive("Y");
		
		BigDecimal adApplicationId = sequenceGenerator.getSequence("AD_APPLICATION", principal.getDefaultAdClientId());
		aplicacion.setAdApplicationId(adApplicationId);
		
		return aplicacionDao.save(aplicacion);
	}
//
	@Override
	@Transactional
	public Aplicacion get(BigDecimal id) {
		return aplicacionDao.get(id);
	}
//

//
	@Override
	@Transactional
	public void update(BigDecimal id, Aplicacion aplicacion) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		aplicacion.setUpdated( new Timestamp(new Date().getTime()) );
		aplicacion.setUpdatedby(principal.getAdUserId());
		
		aplicacionDao.update(aplicacion);
	}
//
	@Override
	@Transactional
	public void delete(BigDecimal id) {
		aplicacionDao.delete(id);
	}
//	
//	@Override
//	@Transactional
//	public boolean exists(long id) {
//		return authorDao.exists(id);
//	}

}
