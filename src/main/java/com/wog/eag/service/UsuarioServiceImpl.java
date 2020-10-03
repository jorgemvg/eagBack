package com.wog.eag.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wog.eag.dao.UsuarioDAO;
import com.wog.eag.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Override
	@Transactional
	public List<Usuario> list() {
		return usuarioDao.list();
	}

	@Override
	@Transactional
	public BigDecimal save(Usuario aplicacion) {
		return usuarioDao.save(aplicacion);
	}

	@Override
	@Transactional
	public Usuario get(BigDecimal id) {
		return usuarioDao.get(id);
	}

	@Override
	@Transactional
	public void update(BigDecimal id, Usuario aplicacion) {
		usuarioDao.update(id, aplicacion);
	}

	@Override
	@Transactional
	public void delete(BigDecimal id) {
		usuarioDao.delete(id);
	}
	
	@Override
	@Transactional
	public boolean exists(long id) {
		return usuarioDao.exists( new BigDecimal(id));
	}
	
	@Override
	@Transactional
	public Usuario getUsuarioByUsername(String username) {
		return usuarioDao.getUsuarioByUsername( username );
	}

}