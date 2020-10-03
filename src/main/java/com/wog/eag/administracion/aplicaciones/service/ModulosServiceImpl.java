package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wog.eag.administracion.aplicaciones.dao.ModulosDAO;
import com.wog.eag.administracion.aplicaciones.model.Modulos;
import com.wog.eag.model.UsuarioPrincipal;
import com.wog.eag.service.SequenceGeneratorService;

@Service
public class ModulosServiceImpl implements ModulosService{

	@Autowired
	private ModulosDAO modulosDao;
	
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	
	@Override
	@Transactional
	public Modulos get(BigDecimal id) {
		return modulosDao.get(id);
	}

	@Override
	@Transactional
	public BigDecimal save(Modulos modulos) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		modulos.setCreated( new Timestamp(new Date().getTime()) );
		modulos.setUpdated( new Timestamp(new Date().getTime()) );
		modulos.setCreatedby(principal.getAdUserId());
		modulos.setUpdatedby(principal.getAdUserId());
		modulos.setAdClientId(principal.getDefaultAdClientId());
		modulos.setAdOrgId(principal.getDefaultAdOrgId());
		modulos.setIsactive("Y");
		
		BigDecimal adApplicationId = sequenceGenerator.getSequence("AD_MODULE", principal.getDefaultAdClientId());
		modulos.setAdModuleId(adApplicationId);
		
		return modulosDao.save(modulos);
	}

	@Override
	@Transactional
	public void update(BigDecimal id, Modulos modulos) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		modulos.setUpdated( new Timestamp(new Date().getTime()) );
		modulos.setUpdatedby(principal.getAdUserId());
		
		modulosDao.update(modulos);
	}

	@Override
	@Transactional
	public void delete(BigDecimal id) {
		modulosDao.delete(id);
	}
	
	@Override
	@Transactional
	public List<Modulos> list( BigDecimal adApplicationId ) {
		return modulosDao.list(adApplicationId);
	}

}