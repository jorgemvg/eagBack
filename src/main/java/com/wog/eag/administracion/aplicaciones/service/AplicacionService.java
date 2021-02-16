package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.AplicacionEntity;

public interface AplicacionService {

	AplicacionEntity get(	BigDecimal id);
	
	BigDecimal save( AplicacionEntity aplicacion );

	void update( BigDecimal id, AplicacionEntity aplicacion );
	
	void delete(	BigDecimal id);
	
	List<AplicacionEntity> list();

	public AplicacionEntity setDefaultValue(  );
}