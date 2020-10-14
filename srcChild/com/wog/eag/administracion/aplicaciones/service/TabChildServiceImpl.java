package com.wog.eag.administracion.aplicaciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wog.eag.administracion.aplicaciones.dao.TabChildDAOImpl;

@Service
public class TabChildServiceImpl extends TabServiceImpl implements TabChildService {

	@Autowired
	private TabChildDAOImpl tabDao;
	

}