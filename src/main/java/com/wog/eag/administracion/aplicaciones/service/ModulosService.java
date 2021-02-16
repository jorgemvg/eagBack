package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.ModulosEntity;

public interface ModulosService {

	ModulosEntity get(	BigDecimal id);
	
	BigDecimal save( ModulosEntity modulos );

	void update( BigDecimal id, ModulosEntity modulos );
	
	void delete(	BigDecimal id);
	
	List<ModulosEntity> list(BigDecimal parentId);

	public ModulosEntity setDefaultValue( BigDecimal parentId );
}