package com.wog.eag.administracion.aplicaciones.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.google.gson.JsonObject;
import com.wog.eag.administracion.aplicaciones.dto.AplicacionDTO;
import com.wog.eag.administracion.aplicaciones.model.AplicacionEntity;
import com.wog.eag.administracion.aplicaciones.service.AplicacionChildService;

@RestController
public class AplicacionController {

	@Autowired
	private AplicacionChildService aplicacionService;
	
	@GetMapping("/aplicacion/list")
	public ResponseEntity<List<AplicacionDTO>> list(   ){
		List<AplicacionEntity> list = aplicacionService.list(  );
		
		List<AplicacionDTO> listResult = new ArrayList<AplicacionDTO>();
		AplicacionDTO aplicacionDto = null;
		for (AplicacionEntity entity : list) {
			aplicacionDto = convertoEntityToDTO(entity);
			listResult.add(aplicacionDto);
		}
		
		return ResponseEntity.ok().body( listResult );
	}

	@PostMapping( "/aplicacion" ) 
	public ResponseEntity<?> save(@RequestBody AplicacionDTO aplicacionDTO){
		Gson gson = new Gson();
		
		AplicacionEntity entity = convertoDTOToEntity(aplicacionDTO);
		
		BigDecimal id = aplicacionService.save(entity);
		JsonObject json = new JsonObject();
		json.addProperty("id", id);
		json.addProperty("message", "Registro Creado Satisfactoriamente.");
		return ResponseEntity.ok().body( gson.toJson( json ) );
	}

	@GetMapping("/aplicacion/{id}")
	public ResponseEntity<AplicacionDTO> get(@PathVariable("id") long id ){
		AplicacionEntity entity = aplicacionService.get( new BigDecimal(id) );
		
		AplicacionDTO dto = convertoEntityToDTO(entity);
		
		return ResponseEntity.ok().body( dto );
	}

	@PutMapping( "/aplicacion/{id}" ) 
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody AplicacionDTO aplicacionDTO ){
		Gson gson = new Gson();
		
		AplicacionEntity entity = convertoDTOToEntity(aplicacionDTO);
		
		aplicacionService.update(new BigDecimal(id), entity);
		return ResponseEntity.ok().body( gson.toJson("Registro Actualizado Satisfactoriamente.") );
	}

	@DeleteMapping ( "/aplicacion/{id}" ) 
	public ResponseEntity<?> delete(@PathVariable("id") long id ){
		Gson gson = new Gson();
		aplicacionService.delete( new BigDecimal(id) );
		return ResponseEntity.ok().body( gson.toJson("El registro ha sido eliminado.") );
	}

	@GetMapping("/aplicacion/defaultValues")
	public ResponseEntity<AplicacionDTO> setDefaultValue (  ) {
		
		AplicacionEntity entity = aplicacionService.setDefaultValue(  );
		
		AplicacionDTO dto = convertoEntityToDTO(entity);
		
		return ResponseEntity.ok().body( dto );
		
	}

	private AplicacionDTO convertoEntityToDTO(AplicacionEntity entity) {
		AplicacionDTO dto = new AplicacionDTO();
		if (entity != null) {
			dto.setCodeApplication(entity.getCodeApplication());
			dto.setName(entity.getName());
			dto.setDescription(entity.getDescription());
			dto.setUrl(entity.getUrl());
			dto.setDriverclass(entity.getDriverclass());
			dto.setUsuario(entity.getUsuario());
			dto.setPassword(entity.getPassword());
			dto.setDatabasename(entity.getDatabasename());
			dto.setPackageRoot(entity.getPackageRoot());
			dto.setContextRoot(entity.getContextRoot());
			dto.setDatabaseType(entity.getDatabaseType());
			dto.setAdApplicationId(entity.getAdApplicationId());
			dto.setAdClientId(entity.getAdClientId());
			dto.setAdOrgId(entity.getAdOrgId());
			dto.setIsactive(entity.getIsactive());
		
			dto.setCreated(entity.getCreated());
			dto.setCreatedby(entity.getCreatedby());
			dto.setUpdated(entity.getUpdated());
			dto.setUpdatedby(entity.getUpdatedby());
		}
		return dto;
	}
	
	private AplicacionEntity convertoDTOToEntity(AplicacionDTO dto) {
		AplicacionEntity entity = new AplicacionEntity();
		
			entity.setCodeApplication(dto.getCodeApplication());
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			entity.setUrl(dto.getUrl());
			entity.setDriverclass(dto.getDriverclass());
			entity.setUsuario(dto.getUsuario());
			entity.setPassword(dto.getPassword());
			entity.setDatabasename(dto.getDatabasename());
			entity.setPackageRoot(dto.getPackageRoot());
			entity.setContextRoot(dto.getContextRoot());
			entity.setDatabaseType(dto.getDatabaseType());
			entity.setAdApplicationId(dto.getAdApplicationId());
			entity.setAdClientId(dto.getAdClientId());
			entity.setAdOrgId(dto.getAdOrgId());
			entity.setIsactive(dto.getIsactive());
		
			entity.setCreated(dto.getCreated());
			entity.setCreatedby(dto.getCreatedby());
			entity.setUpdated(dto.getUpdated());
			entity.setUpdatedby(dto.getUpdatedby());
		
		return entity;
	}
}