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
import com.wog.eag.administracion.aplicaciones.dto.TableDTO;
import com.wog.eag.administracion.aplicaciones.model.TableEntity;
import com.wog.eag.administracion.aplicaciones.service.TableService;

@RestController
public class TableController {

	@Autowired
	private TableService tableService;
	
	@GetMapping("/table/list/{id}")
	public ResponseEntity<List<TableDTO>> list( @PathVariable("id") long adModuleId  ){
		List<TableEntity> list = tableService.list( new BigDecimal(adModuleId) );
		
		List<TableDTO> listResult = new ArrayList<TableDTO>();
		TableDTO windowDTO = null;
		for (TableEntity entity : list) {
			windowDTO = convertoEntityToDTO(entity);
			listResult.add(windowDTO);
		}
		
		return ResponseEntity.ok().body( listResult );
	}

	@PostMapping( "/table" ) 
	public ResponseEntity<?> save(@RequestBody TableDTO tableDTO){
		Gson gson = new Gson();
		
		TableEntity entity = convertoDTOToEntity(tableDTO);
		
		tableService.save(entity);
		return ResponseEntity.ok().body( gson.toJson("Registro Creado Satisfactoriamente.") );
	}

	@GetMapping("/table/{id}")
	public ResponseEntity<TableDTO> get(@PathVariable("id") long id ){
		TableEntity window = tableService.get( new BigDecimal(id) );
		
		TableDTO dto = convertoEntityToDTO(window);
		
		return ResponseEntity.ok().body( dto );
	}

	@PutMapping( "/table/{id}" ) 
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody TableDTO tableDTO ){
		Gson gson = new Gson();
		
		TableEntity entity = convertoDTOToEntity(tableDTO);
		
		tableService.update(new BigDecimal(id), entity);
		return ResponseEntity.ok().body( gson.toJson("Registro Actualizado Satisfactoriamente.") );
	}

	@DeleteMapping ( "/table/{id}" ) 
	public ResponseEntity<?> delete(@PathVariable("id") long id ){
		Gson gson = new Gson();
		tableService.delete( new BigDecimal(id) );
		return ResponseEntity.ok().body( gson.toJson("El registro ha sido eliminado.") );
	}
	
	private TableDTO convertoEntityToDTO(TableEntity entity) {
		TableDTO dto = new TableDTO();
		
		dto.setAdTableId(entity.getAdTableId());
		dto.setAdModuleId(entity.getAdModuleId());
		dto.setAdClientId(entity.getAdClientId());
		dto.setAdOrgId(entity.getAdOrgId());
		dto.setIsactive(entity.getIsactive());
		dto.setCreated(entity.getCreated());
		dto.setCreatedby(entity.getCreatedby());
		dto.setUpdated(entity.getUpdated());
		dto.setUpdatedby(entity.getUpdatedby());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setHelp(entity.getHelp());
		dto.setTablename(entity.getTablename());
		dto.setIsrelationtable(entity.getIsrelationtable());
		
		return dto;
	}
	
	private TableEntity convertoDTOToEntity(TableDTO dto) {
		TableEntity entity = new TableEntity();
		
		entity.setAdTableId(dto.getAdTableId());
		entity.setAdModuleId(dto.getAdModuleId());
		entity.setAdClientId(dto.getAdClientId());
		entity.setAdOrgId(dto.getAdOrgId());
		entity.setIsactive(dto.getIsactive());
		entity.setCreated(dto.getCreated());
		entity.setCreatedby(dto.getCreatedby());
		entity.setUpdated(dto.getUpdated());
		entity.setUpdatedby(dto.getUpdatedby());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setHelp(dto.getHelp());
		entity.setTablename(dto.getTablename());
		entity.setIsrelationtable(dto.getIsrelationtable());
		
		return entity;
	}

}