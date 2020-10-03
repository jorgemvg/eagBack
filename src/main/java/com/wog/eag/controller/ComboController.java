package com.wog.eag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/combosRefList/{referenceId}")
	public ResponseEntity<List<Combo>> getRefList( @PathVariable("referenceId") long id ){
		List<Combo> list = combosService.getRefList( id );
		return ResponseEntity.ok().body( list );
	}
	
}
