package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.ModulosEntity;

public interface ModulosDAO {

	ModulosEntity get(BigDecimal id);
	
	BigDecimal save( ModulosEntity modulos );

	void update( ModulosEntity modulos );
	
	void delete( BigDecimal id);
	
	List<ModulosEntity> list(BigDecimal parentId);

}