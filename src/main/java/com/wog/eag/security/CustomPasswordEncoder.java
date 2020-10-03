package com.wog.eag.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder  {

	@Override
	public String encode(CharSequence rawPassword) {
		try {
			System.out.println(rawPassword.toString());
			return Crypto.sha1Base64( rawPassword.toString() );
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		try {
		
			String rawPasswordEncoded = Crypto.sha1Base64( rawPassword.toString() );
		
			if ( rawPasswordEncoded.equals(encodedPassword) ) {
				return true;
			} else {
				return false;
			}

		}catch (Exception e) {
			return false;
		}
	}
}
