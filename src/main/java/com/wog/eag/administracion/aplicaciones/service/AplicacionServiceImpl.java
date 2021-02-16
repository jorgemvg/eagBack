package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wog.eag.administracion.aplicaciones.dao.AplicacionDAO;
import com.wog.eag.administracion.aplicaciones.model.AplicacionEntity;
import com.wog.eag.model.UsuarioPrincipal;
import com.wog.eag.service.SequenceGeneratorService;

@Service
public class AplicacionServiceImpl implements AplicacionService{

	@Autowired
	private AplicacionDAO aplicacionDao;
	
	@Autowired
	protected SequenceGeneratorService sequenceGenerator;
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public AplicacionEntity get(BigDecimal id) {
		return aplicacionDao.get(id);
	}

	@Override
	@Transactional
	public BigDecimal save(AplicacionEntity entity) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		entity.setCreated( new Timestamp(new Date().getTime()) );
		entity.setUpdated( new Timestamp(new Date().getTime()) );
		entity.setCreatedby(principal.getAdUserId());
		entity.setUpdatedby(principal.getAdUserId());
		entity.setAdClientId(principal.getDefaultAdClientId());
		entity.setAdOrgId(principal.getDefaultAdOrgId());
		entity.setIsactive("Y");
		
		BigDecimal adApplicationId = sequenceGenerator.getSequence("AD_APPLICATION", principal.getDefaultAdClientId());
		entity.setAdApplicationId(adApplicationId);
		
		return aplicacionDao.save(entity);
	}

	@Override
	@Transactional
	public void update(BigDecimal id, AplicacionEntity entity) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		entity.setUpdated( new Timestamp(new Date().getTime()) );
		entity.setUpdatedby(principal.getAdUserId());
		
		aplicacionDao.update(entity);
	}

	@Override
	@Transactional
	public void delete(BigDecimal id) {
		aplicacionDao.delete(id);
	}
	
	@Override
	@Transactional
	public List<AplicacionEntity> list(  ) {
		return aplicacionDao.list();
	}

	public AplicacionEntity setDefaultValue(  ) {

		AplicacionEntity entity = new AplicacionEntity();


		entity.setIsactive( "Y" );
	
		return entity;
	
	}		
}