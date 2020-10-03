package com.wog.eag.security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {

	public static void main(String[] args) {
		try {
		String encoded =  sha1Base64( "puntomlm" );
		System.out.println(encoded);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    static String mensajeEncriptar = "msjEnc";

    public static String sha1Base64( String text ) throws Exception {
	if ( text == null || text.trim().equals( "" ) ) {
	    return "";
	}

	String result = text;
	result = hash( text );
	return result;
    }

    public static String hash( String plaintext ) throws Exception {
	MessageDigest md = null;

	try {
	    md = MessageDigest.getInstance( "SHA" ); // SHA-1 generator instance
	}
	catch ( NoSuchAlgorithmException e ) {
	    throw new Exception( e.getMessage() );
	}

	try {
	    md.update( plaintext.getBytes( "UTF-8" ) ); // Message summary
	    // generation
	}
	catch ( UnsupportedEncodingException e ) {
	    throw new Exception( e.getMessage() );
	}

	byte raw[] = md.digest(); // Message summary reception
	try {
	    String hash = new String( org.apache.commons.codec.binary.Base64.encodeBase64( raw ), "UTF-8" );
	    return hash;
	}
	catch ( UnsupportedEncodingException use ) {
	    throw new Exception( use );
	}
    }

    public static String encriptar( String cleartext ) throws Exception {
	return crypt( cleartext, mensajeEncriptar, Cipher.ENCRYPT_MODE );
    }

    public static String desEncriptar( String ciphertext ) throws Exception {
	return crypt( ciphertext, mensajeEncriptar, Cipher.DECRYPT_MODE );
    }

    public static String encriptar( String cleartext, String key ) throws Exception {
	return crypt( cleartext, key, Cipher.ENCRYPT_MODE );
    }

    public static String desEncriptar( String ciphertext, String key ) throws Exception {
	return crypt( ciphertext, key, Cipher.DECRYPT_MODE );
    }

    private static String crypt( String input, String key, int mode ) throws Exception {

	if ( input != null ) {

	    // Install SunJCE provider
	    Provider sunJce = new com.sun.crypto.provider.SunJCE();
	    Security.addProvider( sunJce );

	    byte[ ] raw = key.getBytes();
	    SecretKeySpec skeySpec = new SecretKeySpec( raw, "Blowfish" );

	    Cipher cipher = Cipher.getInstance( "Blowfish/ECB/PKCS5Padding" );
	    cipher.init( mode, skeySpec );

	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    ByteArrayInputStream bis = new ByteArrayInputStream( input.getBytes() );
	    CipherOutputStream cos = new CipherOutputStream( bos, cipher );

	    int length = 0;
	    byte[ ] buffer = new byte[ 8192 ];

	    while ( ( length = bis.read( buffer ) ) != -1 ) {
		cos.write( buffer, 0, length );
	    }

	    bis.close();
	    cos.close();

	    return bos.toString();
	}
	else {
	    return null;
	}
    }

}