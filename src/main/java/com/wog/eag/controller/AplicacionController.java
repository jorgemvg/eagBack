package com.wog.eag.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.wog.eag.model.Aplicacion;
import com.wog.eag.service.AplicacionService;

@RestController
public class AplicacionController {

	@Autowired
	private AplicacionService aplicacionService;
	
	@GetMapping("/aplicacion")
	public ResponseEntity<List<Aplicacion>> list(){
		List<Aplicacion> list = aplicacionService.list();
		return ResponseEntity.ok().body( list );
	}

	@PostMapping( "/aplicacion" ) 
	public ResponseEntity<?> save(@RequestBody Aplicacion empleado){
		Gson gson = new Gson();
		aplicacionService.save(empleado);
		return ResponseEntity.ok().body( gson.toJson("Registro Creado Satisfactoriamente.") );
	}

	@GetMapping("/aplicacion/{id}")
	public ResponseEntity<Aplicacion> get(@PathVariable("id") long id ){
		Aplicacion empleado = aplicacionService.get( new BigDecimal(id));
		return ResponseEntity.ok().body( empleado );
	}

	@PutMapping( "/aplicacion/{id}" ) 
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Aplicacion empleado ){
		Gson gson = new Gson();
		aplicacionService.update(new BigDecimal(id), empleado);
		return ResponseEntity.ok().body( gson.toJson("Registro Actualizado Satisfactoriamente.") );
	}

	@DeleteMapping ( "/aplicacion/{id}" ) 
	public ResponseEntity<?> delete(@PathVariable("id") long id ){
		Gson gson = new Gson();
		boolean exists = true;//empleadokService.exists(id);
		
		if ( exists ) {
			aplicacionService.delete(new BigDecimal(id));
			return ResponseEntity.ok().body( gson.toJson("El registro ha sido eliminado.") );
		} else {
			return ResponseEntity.badRequest().body( gson.toJson("El registro no existe.") );
		}
	}

}
