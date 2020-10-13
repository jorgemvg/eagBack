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
import com.wog.eag.administracion.aplicaciones.dto.ToolbarDTO;
import com.wog.eag.administracion.aplicaciones.model.ToolbarEntity;
import com.wog.eag.administracion.aplicaciones.service.ToolbarChildService;
import com.wog.eag.administracion.aplicaciones.service.ToolbarService;

@RestController
public class ToolbarController {

	@Autowired
	private ToolbarChildService toolbarService;
	
	@GetMapping("/toolbar/list/{id}")
	public ResponseEntity<List<ToolbarDTO>> list( @PathVariable("id") long parentId  ){
		List<ToolbarEntity> list = toolbarService.list( new BigDecimal(parentId) );
		
		List<ToolbarDTO> listResult = new ArrayList<ToolbarDTO>();
		ToolbarDTO toolbarDto = null;
		for (ToolbarEntity entity : list) {
			toolbarDto = convertoEntityToDTO(entity);
			listResult.add(toolbarDto);
		}
		
		return ResponseEntity.ok().body( listResult );
	}

	@PostMapping( "/toolbar" ) 
	public ResponseEntity<?> save(@RequestBody ToolbarDTO toolbarDTO){
		Gson gson = new Gson();
		
		ToolbarEntity entity = convertoDTOToEntity(toolbarDTO);
		
		toolbarService.save(entity);
		return ResponseEntity.ok().body( gson.toJson("Registro Creado Satisfactoriamente.") );
	}

	@GetMapping("/toolbar/{id}")
	public ResponseEntity<ToolbarDTO> get(@PathVariable("id") String compositePk ){
		ToolbarEntity entity = toolbarService.get( compositePk );
		
		ToolbarDTO dto = convertoEntityToDTO(entity);
		
		return ResponseEntity.ok().body( dto );
	}

	@PutMapping( "/toolbar/{id}" ) 
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody ToolbarDTO toolbarDTO ){
		Gson gson = new Gson();
		
		ToolbarEntity entity = convertoDTOToEntity(toolbarDTO);
		
		toolbarService.update(new BigDecimal(id), entity);
		return ResponseEntity.ok().body( gson.toJson("Registro Actualizado Satisfactoriamente.") );
	}

	@DeleteMapping ( "/toolbar/{id}" ) 
	public ResponseEntity<?> delete(@PathVariable("id") String compositePk ){
		Gson gson = new Gson();
		toolbarService.delete( compositePk );
		return ResponseEntity.ok().body( gson.toJson("El registro ha sido eliminado.") );
	}

	private ToolbarDTO convertoEntityToDTO(ToolbarEntity entity) {
		ToolbarDTO dto = new ToolbarDTO();
		if (entity != null) {
			dto.setSequence(entity.getSequence());
			dto.setName(entity.getName());
			dto.setScreenType(entity.getScreenType());
			dto.setAdToolbarbuttonId(entity.getAdToolbarbuttonId());
			dto.setDescription(entity.getDescription());
			dto.setAction(entity.getAction());
			dto.setDisplayLogic(entity.getDisplayLogic());
			dto.setIsactive(entity.getIsactive());
			dto.setAdTabToolbarId(entity.getAdTabToolbarId());
			dto.setAdTabId(entity.getAdTabId());
			dto.setAdClientId(entity.getAdClientId());
			dto.setAdOrgId(entity.getAdOrgId());
		}
		return dto;
	}
	
	private ToolbarEntity convertoDTOToEntity(ToolbarDTO dto) {
		ToolbarEntity entity = new ToolbarEntity();
		
			entity.setSequence(dto.getSequence());
			entity.setName(dto.getName());
			entity.setScreenType(dto.getScreenType());
			entity.setAdToolbarbuttonId(dto.getAdToolbarbuttonId());
			entity.setDescription(dto.getDescription());
			entity.setAction(dto.getAction());
			entity.setDisplayLogic(dto.getDisplayLogic());
			entity.setIsactive(dto.getIsactive());
			entity.setAdTabToolbarId(dto.getAdTabToolbarId());
			entity.setAdTabId(dto.getAdTabId());
			entity.setAdClientId(dto.getAdClientId());
			entity.setAdOrgId(dto.getAdOrgId());
		
		return entity;
	}
}