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
import com.wog.eag.administracion.aplicaciones.dto.ModulosDTO;
import com.wog.eag.administracion.aplicaciones.model.Modulos;
import com.wog.eag.administracion.aplicaciones.service.ModulosService;

@RestController
public class ModulosController {

	@Autowired
	private ModulosService modulosService;
	
	@GetMapping("/modulos/list/{id}")
	public ResponseEntity<List<ModulosDTO>> list( @PathVariable("id") long adApplicationId  ){
		List<Modulos> list = modulosService.list( new BigDecimal(adApplicationId) );
		
		List<ModulosDTO> listResult = new ArrayList<ModulosDTO>();
		ModulosDTO modulosDTO = null;
		for (Modulos modulos : list) {
			modulosDTO = convertoEntityToDTO(modulos);
			listResult.add(modulosDTO);
		}
		
		return ResponseEntity.ok().body( listResult );
	}

	@PostMapping( "/modulos" ) 
	public ResponseEntity<?> save(@RequestBody ModulosDTO modulosDTO){
		Gson gson = new Gson();
		
		Modulos modulos = convertoDTOToEntity(modulosDTO);
		
		modulosService.save(modulos);
		return ResponseEntity.ok().body( gson.toJson("Registro Creado Satisfactoriamente.") );
	}

	@GetMapping("/modulos/{id}")
	public ResponseEntity<ModulosDTO> get(@PathVariable("id") long id ){
		Modulos modulos = modulosService.get( new BigDecimal(id) );
		
		ModulosDTO modulosDTO = convertoEntityToDTO(modulos);
		
		return ResponseEntity.ok().body( modulosDTO );
	}

	@PutMapping( "/modulos/{id}" ) 
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody ModulosDTO modulosDTO ){
		Gson gson = new Gson();
		
		Modulos modulos = convertoDTOToEntity(modulosDTO);
		
		modulosService.update(new BigDecimal(id), modulos);
		return ResponseEntity.ok().body( gson.toJson("Registro Actualizado Satisfactoriamente.") );
	}

	@DeleteMapping ( "/modulos/{id}" ) 
	public ResponseEntity<?> delete(@PathVariable("id") long id ){
		Gson gson = new Gson();
		modulosService.delete( new BigDecimal(id) );
		return ResponseEntity.ok().body( gson.toJson("El registro ha sido eliminado.") );
	}
	
	private ModulosDTO convertoEntityToDTO(Modulos modulos) {
		ModulosDTO modulosDTO = new ModulosDTO();
		
		modulosDTO.setAdModuleId(modulos.getAdModuleId());
		modulosDTO.setAdApplicationId(modulos.getAdApplicationId());
		modulosDTO.setAdClientId(modulos.getAdClientId());
		modulosDTO.setAdOrgId(modulos.getAdOrgId());
		modulosDTO.setIsactive(modulos.getIsactive());
		modulosDTO.setCreated(modulos.getCreated());
		modulosDTO.setCreatedby(modulos.getCreatedby());
		modulosDTO.setUpdated(modulos.getUpdated());
		modulosDTO.setUpdatedby(modulos.getUpdatedby());
		modulosDTO.setName(modulos.getName());
		modulosDTO.setAddtables(modulos.getAddtables());
		modulosDTO.setPackageRoot(modulos.getPackageRoot());
		
		return modulosDTO;
	}
	
	private Modulos convertoDTOToEntity(ModulosDTO modulosDTO) {
		Modulos modulos = new Modulos();
		
		modulos.setAdModuleId(modulosDTO.getAdModuleId());
		modulos.setAdApplicationId(modulosDTO.getAdApplicationId());
		modulos.setAdClientId(modulosDTO.getAdClientId());
		modulos.setAdOrgId(modulosDTO.getAdOrgId());
		modulos.setIsactive(modulosDTO.getIsactive());
		modulos.setCreated(modulosDTO.getCreated());
		modulos.setCreatedby(modulosDTO.getCreatedby());
		modulos.setUpdated(modulosDTO.getUpdated());
		modulos.setUpdatedby(modulosDTO.getUpdatedby());
		modulos.setName(modulosDTO.getName());
		modulos.setAddtables(modulosDTO.getAddtables());
		modulos.setPackageRoot(modulosDTO.getPackageRoot());
		
		return modulos;
	}

}