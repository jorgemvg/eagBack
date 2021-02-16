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

import com.wog.eag.administracion.aplicaciones.dao.ModulosDAO;
import com.wog.eag.administracion.aplicaciones.model.ModulosEntity;
import com.wog.eag.model.UsuarioPrincipal;
import com.wog.eag.service.SequenceGeneratorService;
import com.wog.eag.administracion.aplicaciones.model.AplicacionEntity;

@Transactional
@Service
public class ModulosServiceImpl implements ModulosService{

	@Autowired
	private ModulosDAO modulosDao;
	
	@Autowired
	protected SequenceGeneratorService sequenceGenerator;
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public ModulosEntity get(BigDecimal id) {
		return modulosDao.get(id);
	}

	@Override
	@Transactional
	public BigDecimal save(ModulosEntity entity) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		entity.setCreated( new Timestamp(new Date().getTime()) );
		entity.setUpdated( new Timestamp(new Date().getTime()) );
		entity.setCreatedby(principal.getAdUserId());
		entity.setUpdatedby(principal.getAdUserId());
		entity.setAdClientId(principal.getDefaultAdClientId());
		entity.setAdOrgId(principal.getDefaultAdOrgId());
		entity.setIsactive("Y");
		
		BigDecimal adModuleId = sequenceGenerator.getSequence("AD_MODULE", principal.getDefaultAdClientId());
		entity.setAdModuleId(adModuleId);
		
		return modulosDao.save(entity);
	}

	@Override
	@Transactional
	public void update(BigDecimal id, ModulosEntity entity) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		entity.setUpdated( new Timestamp(new Date().getTime()) );
		entity.setUpdatedby(principal.getAdUserId());
		
		modulosDao.update(entity);
	}

	@Override
	@Transactional
	public void delete(BigDecimal id) {
		modulosDao.delete(id);
	}
	
	@Override
	@Transactional
	public List<ModulosEntity> list( BigDecimal parentId ) {
		return modulosDao.list(parentId);
	}

	public ModulosEntity setDefaultValue( BigDecimal adApplicationId ) {

		ModulosEntity entity = new ModulosEntity();

		AplicacionEntity aplicacionEntity = sessionFactory.getCurrentSession().load(AplicacionEntity.class, adApplicationId);
		entity.setAdApplicationId( aplicacionEntity.getAdApplicationId() );

		entity.setAdModuleId( new BigDecimal("1") );
		entity.setIsactive( "Y" );
	
		return entity;
	
	}		
}