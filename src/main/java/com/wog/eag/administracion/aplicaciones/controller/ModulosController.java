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
import com.wog.eag.administracion.aplicaciones.dto.ModulosDTO;
import com.wog.eag.administracion.aplicaciones.model.ModulosEntity;
import com.wog.eag.administracion.aplicaciones.service.ModulosChildService;

@RestController
public class ModulosController {

	@Autowired
	private ModulosChildService modulosService;
	
	@GetMapping("/modulos/list/{id}")
	public ResponseEntity<List<ModulosDTO>> list( @PathVariable("id") long parentId  ){
		List<ModulosEntity> list = modulosService.list( new BigDecimal(parentId) );
		
		List<ModulosDTO> listResult = new ArrayList<ModulosDTO>();
		ModulosDTO modulosDto = null;
		for (ModulosEntity entity : list) {
			modulosDto = convertoEntityToDTO(entity);
			listResult.add(modulosDto);
		}
		
		return ResponseEntity.ok().body( listResult );
	}

	@PostMapping( "/modulos" ) 
	public ResponseEntity<?> save(@RequestBody ModulosDTO modulosDTO){
		Gson gson = new Gson();
		
		ModulosEntity entity = convertoDTOToEntity(modulosDTO);
		
		BigDecimal id = modulosService.save(entity);
		JsonObject json = new JsonObject();
		json.addProperty("id", id);
		json.addProperty("message", "Registro Creado Satisfactoriamente.");
		return ResponseEntity.ok().body( gson.toJson( json ) );
	}

	@GetMapping("/modulos/{id}")
	public ResponseEntity<ModulosDTO> get(@PathVariable("id") long id ){
		ModulosEntity entity = modulosService.get( new BigDecimal(id) );
		
		ModulosDTO dto = convertoEntityToDTO(entity);
		
		return ResponseEntity.ok().body( dto );
	}

	@PutMapping( "/modulos/{id}" ) 
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody ModulosDTO modulosDTO ){
		Gson gson = new Gson();
		
		ModulosEntity entity = convertoDTOToEntity(modulosDTO);
		
		modulosService.update(new BigDecimal(id), entity);
		return ResponseEntity.ok().body( gson.toJson("Registro Actualizado Satisfactoriamente.") );
	}

	@DeleteMapping ( "/modulos/{id}" ) 
	public ResponseEntity<?> delete(@PathVariable("id") long id ){
		Gson gson = new Gson();
		modulosService.delete( new BigDecimal(id) );
		return ResponseEntity.ok().body( gson.toJson("El registro ha sido eliminado.") );
	}

	private ModulosDTO convertoEntityToDTO(ModulosEntity entity) {
		ModulosDTO dto = new ModulosDTO();
		if (entity != null) {
			dto.setAdApplicationId(entity.getAdApplicationId());
			dto.setName(entity.getName());
			dto.setPackageRoot(entity.getPackageRoot());
			dto.setAddtables(entity.getAddtables());
			dto.setAdModuleId(entity.getAdModuleId());
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
	
	private ModulosEntity convertoDTOToEntity(ModulosDTO dto) {
		ModulosEntity entity = new ModulosEntity();
		
			entity.setAdApplicationId(dto.getAdApplicationId());
			entity.setName(dto.getName());
			entity.setPackageRoot(dto.getPackageRoot());
			entity.setAddtables(dto.getAddtables());
			entity.setAdModuleId(dto.getAdModuleId());
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