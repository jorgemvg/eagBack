package com.wog.eag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.wog.eag.model.Combo;
import com.wog.eag.service.CombosServiceImpl;

@RestController
public class ComboController {

	@Autowired
	private CombosServiceImpl combosService;
	
	@GetMapping("/")
	public String welcome() {
		return "welcome!!";
	}
	
	@GetMapping("/combos")
	public ResponseEntity<List<Combo>> getCombo( @RequestParam("params") String parameters  ){
		List<Combo> list = combosService.getCombo( parameters );
		return ResponseEntity.ok().body( list );
	}
	
	@GetMapping("/combos/adRefList/{referenceId}")
	public ResponseEntity<List<Combo>> getRefList( @PathVariable("referenceId") long id ){
		List<Combo> list = combosService.getRefList( id );
		return ResponseEntity.ok().body( list );
	}
	
	@PostMapping("/combos/adTableId/{adValruleId}")
	public ResponseEntity<List<Combo>> getAtTableLid( @PathVariable("adValruleId") long adValruleId, @RequestBody String parameters ){
		List<Combo> list = combosService.getAtTableLid( adValruleId, parameters );
		return ResponseEntity.ok().body( list );
	}
	
}
