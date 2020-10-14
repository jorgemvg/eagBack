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
import com.wog.eag.administracion.aplicaciones.dto.TabDTO;
import com.wog.eag.administracion.aplicaciones.model.TabEntity;
import com.wog.eag.administracion.aplicaciones.service.TabChildService;

@RestController
public class TabController {

	@Autowired
	private TabChildService tabService;
	
	@GetMapping("/tab/list/{id}")
	public ResponseEntity<List<TabDTO>> list( @PathVariable("id") long parentId  ){
		List<TabEntity> list = tabService.list( new BigDecimal(parentId) );
		
		List<TabDTO> listResult = new ArrayList<TabDTO>();
		TabDTO tabDto = null;
		for (TabEntity entity : list) {
			tabDto = convertoEntityToDTO(entity);
			listResult.add(tabDto);
		}
		
		return ResponseEntity.ok().body( listResult );
	}

	@PostMapping( "/tab" ) 
	public ResponseEntity<?> save(@RequestBody TabDTO tabDTO){
		Gson gson = new Gson();
		
		TabEntity entity = convertoDTOToEntity(tabDTO);
		
		BigDecimal id = tabService.save(entity);
		JsonObject json = new JsonObject();
		json.addProperty("id", id);
		json.addProperty("message", "Registro Creado Satisfactoriamente.");
		return ResponseEntity.ok().body( gson.toJson( json ) );
	}

	@GetMapping("/tab/{id}")
	public ResponseEntity<TabDTO> get(@PathVariable("id") long id ){
		TabEntity entity = tabService.get( new BigDecimal(id) );
		
		TabDTO dto = convertoEntityToDTO(entity);
		
		return ResponseEntity.ok().body( dto );
	}

	@PutMapping( "/tab/{id}" ) 
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody TabDTO tabDTO ){
		Gson gson = new Gson();
		
		TabEntity entity = convertoDTOToEntity(tabDTO);
		
		tabService.update(new BigDecimal(id), entity);
		return ResponseEntity.ok().body( gson.toJson("Registro Actualizado Satisfactoriamente.") );
	}

	@DeleteMapping ( "/tab/{id}" ) 
	public ResponseEntity<?> delete(@PathVariable("id") long id ){
		Gson gson = new Gson();
		tabService.delete( new BigDecimal(id) );
		return ResponseEntity.ok().body( gson.toJson("El registro ha sido eliminado.") );
	}

	private TabDTO convertoEntityToDTO(TabEntity entity) {
		TabDTO dto = new TabDTO();
		if (entity != null) {
			dto.setName(entity.getName());
			dto.setLabel(entity.getLabel());
			dto.setDescription(entity.getDescription());
			dto.setHelp(entity.getHelp());
			dto.setAdTableId(entity.getAdTableId());
			dto.setEntitytype(entity.getEntitytype());
			dto.setSeqno(entity.getSeqno());
			dto.setTablevel(entity.getTablevel());
			dto.setIssinglerow(entity.getIssinglerow());
			dto.setIsreadonly(entity.getIsreadonly());
			dto.setHastree(entity.getHastree());
			dto.setWhereclause(entity.getWhereclause());
			dto.setOrderbyclause(entity.getOrderbyclause());
			dto.setDisplayLogic(entity.getDisplayLogic());
			dto.setCanCopyEntity(entity.getCanCopyEntity());
			dto.setHasfile(entity.getHasfile());
			dto.setHasDynamicFields(entity.getHasDynamicFields());
			dto.setAdDynEntityType(entity.getAdDynEntityType());
			dto.setAdDynEntityRef(entity.getAdDynEntityRef());
			dto.setAdDinamicTabId(entity.getAdDinamicTabId());
			dto.setImportfields(entity.getImportfields());
			dto.setIsactive(entity.getIsactive());
			dto.setShowpagelist(entity.getShowpagelist());
			dto.setShowpageview(entity.getShowpageview());
			dto.setAdWindowId(entity.getAdWindowId());
			dto.setAdClientId(entity.getAdClientId());
			dto.setIstranslationtab(entity.getIstranslationtab());
			dto.setAdOrgId(entity.getAdOrgId());
			dto.setAdColumnId(entity.getAdColumnId());
			dto.setCommitwarning(entity.getCommitwarning());
			dto.setAdProcessId(entity.getAdProcessId());
			dto.setProcessing(entity.getProcessing());
			dto.setIssorttab(entity.getIssorttab());
			dto.setAdColumnsortorderId(entity.getAdColumnsortorderId());
			dto.setAdImageId(entity.getAdImageId());
			dto.setIncludedTabId(entity.getIncludedTabId());
			dto.setFilterclause(entity.getFilterclause());
			dto.setEditreference(entity.getEditreference());
			dto.setHasAuditory(entity.getHasAuditory());
			dto.setIsinfotab(entity.getIsinfotab());
			dto.setShowpageedit(entity.getShowpageedit());
			dto.setAdTabId(entity.getAdTabId());
			dto.setAdColumnsortyesnoId(entity.getAdColumnsortyesnoId());
			dto.setConfSaveMobile(entity.getConfSaveMobile());
			dto.setDinamicTable(entity.getDinamicTable());
			dto.setFileTable(entity.getFileTable());
		
			dto.setCreated(entity.getCreated());
			dto.setCreatedby(entity.getCreatedby());
			dto.setUpdated(entity.getUpdated());
			dto.setUpdatedby(entity.getUpdatedby());
		}
		return dto;
	}
	
	private TabEntity convertoDTOToEntity(TabDTO dto) {
		TabEntity entity = new TabEntity();
		
			entity.setName(dto.getName());
			entity.setLabel(dto.getLabel());
			entity.setDescription(dto.getDescription());
			entity.setHelp(dto.getHelp());
			entity.setAdTableId(dto.getAdTableId());
			entity.setEntitytype(dto.getEntitytype());
			entity.setSeqno(dto.getSeqno());
			entity.setTablevel(dto.getTablevel());
			entity.setIssinglerow(dto.getIssinglerow());
			entity.setIsreadonly(dto.getIsreadonly());
			entity.setHastree(dto.getHastree());
			entity.setWhereclause(dto.getWhereclause());
			entity.setOrderbyclause(dto.getOrderbyclause());
			entity.setDisplayLogic(dto.getDisplayLogic());
			entity.setCanCopyEntity(dto.getCanCopyEntity());
			entity.setHasfile(dto.getHasfile());
			entity.setHasDynamicFields(dto.getHasDynamicFields());
			entity.setAdDynEntityType(dto.getAdDynEntityType());
			entity.setAdDynEntityRef(dto.getAdDynEntityRef());
			entity.setAdDinamicTabId(dto.getAdDinamicTabId());
			entity.setImportfields(dto.getImportfields());
			entity.setIsactive(dto.getIsactive());
			entity.setShowpagelist(dto.getShowpagelist());
			entity.setShowpageview(dto.getShowpageview());
			entity.setAdWindowId(dto.getAdWindowId());
			entity.setAdClientId(dto.getAdClientId());
			entity.setIstranslationtab(dto.getIstranslationtab());
			entity.setAdOrgId(dto.getAdOrgId());
			entity.setAdColumnId(dto.getAdColumnId());
			entity.setCommitwarning(dto.getCommitwarning());
			entity.setAdProcessId(dto.getAdProcessId());
			entity.setProcessing(dto.getProcessing());
			entity.setIssorttab(dto.getIssorttab());
			entity.setAdColumnsortorderId(dto.getAdColumnsortorderId());
			entity.setAdImageId(dto.getAdImageId());
			entity.setIncludedTabId(dto.getIncludedTabId());
			entity.setFilterclause(dto.getFilterclause());
			entity.setEditreference(dto.getEditreference());
			entity.setHasAuditory(dto.getHasAuditory());
			entity.setIsinfotab(dto.getIsinfotab());
			entity.setShowpageedit(dto.getShowpageedit());
			entity.setAdTabId(dto.getAdTabId());
			entity.setAdColumnsortyesnoId(dto.getAdColumnsortyesnoId());
			entity.setConfSaveMobile(dto.getConfSaveMobile());
			entity.setDinamicTable(dto.getDinamicTable());
			entity.setFileTable(dto.getFileTable());
		
			entity.setCreated(dto.getCreated());
			entity.setCreatedby(dto.getCreatedby());
			entity.setUpdated(dto.getUpdated());
			entity.setUpdatedby(dto.getUpdatedby());
		
		return entity;
	}
}