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
import com.wog.eag.administracion.aplicaciones.dto.WindowDTO;
import com.wog.eag.administracion.aplicaciones.model.WindowEntity;
import com.wog.eag.administracion.aplicaciones.service.WindowChildService;

@RestController
public class WindowController {

	@Autowired
	private WindowChildService windowService;
	
	@GetMapping("/window/list/{id}")
	public ResponseEntity<List<WindowDTO>> list( @PathVariable("id") long parentId  ){
		List<WindowEntity> list = windowService.list( new BigDecimal(parentId) );
		
		List<WindowDTO> listResult = new ArrayList<WindowDTO>();
		WindowDTO windowDto = null;
		for (WindowEntity entity : list) {
			windowDto = convertoEntityToDTO(entity);
			listResult.add(windowDto);
		}
		
		return ResponseEntity.ok().body( listResult );
	}

	@PostMapping( "/window" ) 
	public ResponseEntity<?> save(@RequestBody WindowDTO windowDTO){
		Gson gson = new Gson();
		
		WindowEntity entity = convertoDTOToEntity(windowDTO);
		
		BigDecimal id = windowService.save(entity);
		JsonObject json = new JsonObject();
		json.addProperty("id", id);
		json.addProperty("message", "Registro Creado Satisfactoriamente.");
		return ResponseEntity.ok().body( gson.toJson( json ) );
	}

	@GetMapping("/window/{id}")
	public ResponseEntity<WindowDTO> get(@PathVariable("id") long id ){
		WindowEntity entity = windowService.get( new BigDecimal(id) );
		
		WindowDTO dto = convertoEntityToDTO(entity);
		
		return ResponseEntity.ok().body( dto );
	}

	@PutMapping( "/window/{id}" ) 
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody WindowDTO windowDTO ){
		Gson gson = new Gson();
		
		WindowEntity entity = convertoDTOToEntity(windowDTO);
		
		windowService.update(new BigDecimal(id), entity);
		return ResponseEntity.ok().body( gson.toJson("Registro Actualizado Satisfactoriamente.") );
	}

	@DeleteMapping ( "/window/{id}" ) 
	public ResponseEntity<?> delete(@PathVariable("id") long id ){
		Gson gson = new Gson();
		windowService.delete( new BigDecimal(id) );
		return ResponseEntity.ok().body( gson.toJson("El registro ha sido eliminado.") );
	}

	private WindowDTO convertoEntityToDTO(WindowEntity entity) {
		WindowDTO dto = new WindowDTO();
		if (entity != null) {
			dto.setName(entity.getName());
			dto.setDescription(entity.getDescription());
			dto.setHelp(entity.getHelp());
			dto.setNumtabs(entity.getNumtabs());
			dto.setIsactive(entity.getIsactive());
			dto.setAdWindowId(entity.getAdWindowId());
			dto.setWindowtype(entity.getWindowtype());
			dto.setAdClientId(entity.getAdClientId());
			dto.setAdOrgId(entity.getAdOrgId());
			dto.setProcessing(entity.getProcessing());
			dto.setAdColorId(entity.getAdColorId());
			dto.setAdImageId(entity.getAdImageId());
			dto.setIssotrx(entity.getIssotrx());
			dto.setIsdefault(entity.getIsdefault());
			dto.setAdModuleId(entity.getAdModuleId());
			dto.setEntitytype(entity.getEntitytype());
		
			dto.setCreated(entity.getCreated());
			dto.setCreatedby(entity.getCreatedby());
			dto.setUpdated(entity.getUpdated());
			dto.setUpdatedby(entity.getUpdatedby());
		}
		return dto;
	}
	
	private WindowEntity convertoDTOToEntity(WindowDTO dto) {
		WindowEntity entity = new WindowEntity();
		
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			entity.setHelp(dto.getHelp());
			entity.setNumtabs(dto.getNumtabs());
			entity.setIsactive(dto.getIsactive());
			entity.setAdWindowId(dto.getAdWindowId());
			entity.setWindowtype(dto.getWindowtype());
			entity.setAdClientId(dto.getAdClientId());
			entity.setAdOrgId(dto.getAdOrgId());
			entity.setProcessing(dto.getProcessing());
			entity.setAdColorId(dto.getAdColorId());
			entity.setAdImageId(dto.getAdImageId());
			entity.setIssotrx(dto.getIssotrx());
			entity.setIsdefault(dto.getIsdefault());
			entity.setAdModuleId(dto.getAdModuleId());
			entity.setEntitytype(dto.getEntitytype());
		
			entity.setCreated(dto.getCreated());
			entity.setCreatedby(dto.getCreatedby());
			entity.setUpdated(dto.getUpdated());
			entity.setUpdatedby(dto.getUpdatedby());
		
		return entity;
	}
}