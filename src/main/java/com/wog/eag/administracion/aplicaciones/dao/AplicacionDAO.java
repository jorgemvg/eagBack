package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.AplicacionEntity;

public interface AplicacionDAO {

	AplicacionEntity get(BigDecimal id);
	
	BigDecimal save( AplicacionEntity aplicacion );

	void update( AplicacionEntity aplicacion );
	
	void delete( BigDecimal id);
	
	List<AplicacionEntity> list();

}