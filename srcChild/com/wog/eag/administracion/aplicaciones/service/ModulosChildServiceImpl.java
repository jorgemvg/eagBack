package com.wog.eag.administracion.aplicaciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wog.eag.administracion.aplicaciones.dao.ModulosChildDAOImpl;

@Service
public class ModulosChildServiceImpl extends ModulosServiceImpl {

	@Autowired
	private ModulosChildDAOImpl modulosDao;
	

}