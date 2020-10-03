package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wog.eag.administracion.aplicaciones.dao.TableDAO;
import com.wog.eag.administracion.aplicaciones.model.TableEntity;
import com.wog.eag.model.UsuarioPrincipal;
import com.wog.eag.service.SequenceGeneratorService;

@Service
public class TableServiceImpl implements TableService{

	@Autowired
	private TableDAO tableDao;
	
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	
	@Override
	@Transactional
	public TableEntity get(BigDecimal id) {
		return tableDao.get(id);
	}

	@Override
	@Transactional
	public BigDecimal save(TableEntity entity) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		entity.setCreated( new Timestamp(new Date().getTime()) );
		entity.setUpdated( new Timestamp(new Date().getTime()) );
		entity.setCreatedby(principal.getAdUserId());
		entity.setUpdatedby(principal.getAdUserId());
		entity.setAdClientId(principal.getDefaultAdClientId());
		entity.setAdOrgId(principal.getDefaultAdOrgId());
		entity.setIsactive("Y");
		
		BigDecimal adTableId = sequenceGenerator.getSequence("AD_TABLE", principal.getDefaultAdClientId());
		entity.setAdWindowId(adTableId);
		
		return tableDao.save(entity);
	}

	@Override
	@Transactional
	public void update(BigDecimal id, TableEntity entity) {
		
		UsuarioPrincipal principal = (UsuarioPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		entity.setUpdated( new Timestamp(new Date().getTime()) );
		entity.setUpdatedby(principal.getAdUserId());
		
		tableDao.update(entity);
	}

	@Override
	@Transactional
	public void delete(BigDecimal id) {
		tableDao.delete(id);
	}
	
	@Override
	@Transactional
	public List<TableEntity> list( BigDecimal adModuleId ) {
		return tableDao.list(adModuleId);
	}

}