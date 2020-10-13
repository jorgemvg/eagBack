package com.wog.eag.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.wog.eag.config.exception.BadApiCredentialsException;
import com.wog.eag.config.exception.JDBCConnectionException;
import com.wog.eag.model.AuthenticationRequest;
import com.wog.eag.model.AuthenticationResponse;
import com.wog.eag.model.ErrorResponse;
import com.wog.eag.security.JwtUtil;
import com.wog.eag.security.MyUserDetailsService;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationController;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@RequestMapping(value="/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationController.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
			final String jwt = jwtTokenUtil.generateToken(userDetails);
		
			return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
		
		}catch (BadCredentialsException e) {
			throw new BadApiCredentialsException("Incorrect username and password");
		}catch ( InternalAuthenticationServiceException e ) {
			//TODO: validar que tipo de excepcion/implementacion llega
			throw new JDBCConnectionException("Error de Conexión con la base de datos.");
		}
		catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		
	}
	
	@RequestMapping(value="/logoutUser", method=RequestMethod.GET)  
    public ResponseEntity<?> logoutPage(HttpServletRequest request, HttpServletResponse response) {  
		System.out.println("Entro al logout");
		Gson gson = new Gson();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout( request, response, auth);  
        }  
        return ResponseEntity.ok(  gson.toJson("Logueo Exitoso")  );
     }  
	
}
