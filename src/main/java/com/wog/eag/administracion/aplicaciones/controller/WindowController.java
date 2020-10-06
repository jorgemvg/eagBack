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
import com.wog.eag.administracion.aplicaciones.dto.WindowDTO;
import com.wog.eag.administracion.aplicaciones.model.Window;
import com.wog.eag.administracion.aplicaciones.service.WindowService;

@RestController
public class WindowController {

	@Autowired
	private WindowService windowService;
	
	@GetMapping("/window/list/{id}")
	public ResponseEntity<List<WindowDTO>> list( @PathVariable("id") long adModuleId  ){
		List<Window> list = windowService.list( new BigDecimal(adModuleId) );
		
		List<WindowDTO> listResult = new ArrayList<WindowDTO>();
		WindowDTO windowDTO = null;
		for (Window window : list) {
			windowDTO = convertoEntityToDTO(window);
			listResult.add(windowDTO);
		}
		
		return ResponseEntity.ok().body( listResult );
	}

	@PostMapping( "/window" ) 
	public ResponseEntity<?> save(@RequestBody WindowDTO windowDTO){
		Gson gson = new Gson();
		
		Window window = convertoDTOToEntity(windowDTO);
		
		windowService.save(window);
		return ResponseEntity.ok().body( gson.toJson("Registro Creado Satisfactoriamente.") );
	}

	@GetMapping("/window/{id}")
	public ResponseEntity<WindowDTO> get(@PathVariable("id") long id ){
		Window window = windowService.get( new BigDecimal(id) );
		
		WindowDTO windowDTO = convertoEntityToDTO(window);
		
		return ResponseEntity.ok().body( windowDTO );
	}

	@PutMapping( "/window/{id}" ) 
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody WindowDTO windowDTO ){
		Gson gson = new Gson();
		
		Window window = convertoDTOToEntity(windowDTO);
		
		windowService.update(new BigDecimal(id), window);
		return ResponseEntity.ok().body( gson.toJson("Registro Actualizado Satisfactoriamente.") );
	}

	@DeleteMapping ( "/window/{id}" ) 
	public ResponseEntity<?> delete(@PathVariable("id") long id ){
		Gson gson = new Gson();
		windowService.delete( new BigDecimal(id) );
		return ResponseEntity.ok().body( gson.toJson("El registro ha sido eliminado.") );
	}
	
	private WindowDTO convertoEntityToDTO(Window window) {
		WindowDTO windowDTO = new WindowDTO();
		
		windowDTO.setAdWindowId(window.getAdWindowId());
		windowDTO.setAdModuleId(window.getAdModuleId());
		windowDTO.setAdClientId(window.getAdClientId());
		windowDTO.setAdOrgId(window.getAdOrgId());
		windowDTO.setIsactive(window.getIsactive());
		windowDTO.setCreated(window.getCreated());
		windowDTO.setCreatedby(window.getCreatedby());
		windowDTO.setUpdated(window.getUpdated());
		windowDTO.setUpdatedby(window.getUpdatedby());
		windowDTO.setName(window.getName());
		windowDTO.setDescription(window.getDescription());
		windowDTO.setHelp(window.getHelp());
		windowDTO.setWindowtype(window.getWindowtype());
		windowDTO.setIssotrx(window.getIssotrx());
		windowDTO.setEntitytype(window.getEntitytype());
		windowDTO.setProcessing(window.getProcessing());
		windowDTO.setAdImageId(window.getAdImageId());
		windowDTO.setAdColorId(window.getAdColorId());
		windowDTO.setIsdefault(window.getIsdefault());
		windowDTO.setNumtabs(window.getNumtabs());
		
		return windowDTO;
	}
	
	private Window convertoDTOToEntity(WindowDTO windowDTO) {
		Window window = new Window();
		
		window.setAdWindowId(windowDTO.getAdWindowId());
		window.setAdModuleId(windowDTO.getAdModuleId());
		window.setAdClientId(windowDTO.getAdClientId());
		window.setAdOrgId(windowDTO.getAdOrgId());
		window.setIsactive(windowDTO.getIsactive());
		window.setCreated(windowDTO.getCreated());
		window.setCreatedby(windowDTO.getCreatedby());
		window.setUpdated(windowDTO.getUpdated());
		window.setUpdatedby(windowDTO.getUpdatedby());
		window.setName(windowDTO.getName());
		window.setDescription(windowDTO.getDescription());
		window.setHelp(windowDTO.getHelp());
		window.setWindowtype(windowDTO.getWindowtype());
		window.setIssotrx(windowDTO.getIssotrx());
		window.setEntitytype(windowDTO.getEntitytype());
		window.setProcessing(windowDTO.getProcessing());
		window.setAdImageId(windowDTO.getAdImageId());
		window.setAdColorId(windowDTO.getAdColorId());
		window.setIsdefault(windowDTO.getIsdefault());
		window.setNumtabs(windowDTO.getNumtabs());
		
		return window;
	}

}