package com.wog.eag.administracion.aplicaciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wog.eag.administracion.aplicaciones.dao.ModulosChildDAOImpl;

@Transactional
@Service
public class ModulosChildServiceImpl extends ModulosServiceImpl implements ModulosChildService {

	@Autowired
	private ModulosChildDAOImpl modulosDao;
	

}