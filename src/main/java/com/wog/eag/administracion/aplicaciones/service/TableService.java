package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.TableEntity;

public interface TableService {

	TableEntity get(BigDecimal id);
	
	BigDecimal save(TableEntity entity);
	
	void update(BigDecimal id, TableEntity entity);
	
	void delete(BigDecimal id);
	
	List<TableEntity> list(BigDecimal adModuleId);

}