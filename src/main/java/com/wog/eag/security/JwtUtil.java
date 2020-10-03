package com.wog.eag.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Service
public class JwtUtil {

	@Autowired
	private Environment env;
	
	public String extractUsername( String token ) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public Date extractExpiration( String token ) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
		
	}
	
	private Claims extractAllClaims(String token) {
		
		try {
			Claims claims = Jwts.parser().setSigningKey(env.getProperty("security.jwt.key")).parseClaimsJws(token).getBody();
			return claims;
		} catch (UnsupportedJwtException| MalformedJwtException | IllegalArgumentException | SignatureException ex) {
		    System.out.println("Invalid JWT Token");
//		    ex.printStackTrace();
		    throw new BadCredentialsException("Invalid JWT token: ", ex);
		} catch (ExpiredJwtException expiredEx) {
		    System.out.println("JWT Token is expired");
//		    expiredEx.printStackTrace();
		    throw expiredEx;
		} catch (Exception e) {
		    System.out.println("Error");
//		    expiredEx.printStackTrace();
		    throw e;
		}
	}
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public String generateToken( UserDetails userDetails ) {
		Map<String, Object> claims = new HashMap<>();
		return createToken( claims, userDetails.getUsername() );
	}
	
	private String createToken( Map<String, Object> claims, String subject ) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))//10 horas
				.signWith(SignatureAlgorithm.HS256, env.getProperty("security.jwt.key")).compact();
	}
	
	public Boolean validateToken( String token, UserDetails userDetails ) {
		final String username = extractUsername(token);
		return ( username.equals(userDetails.getUsername()) && !isTokenExpired(token) );
	}
}
