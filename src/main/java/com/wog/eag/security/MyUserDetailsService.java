package com.wog.eag.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wog.eag.dao.SecurityDAO;
import com.wog.eag.model.Usuario;
import com.wog.eag.model.UsuarioPrincipal;
import com.wog.eag.service.UsuarioService;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private SecurityDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioPrincipal usuario = dao.getUserInfoByUsernameByCodeApp(username, "EAG");
		return  usuario;
	}
	
}