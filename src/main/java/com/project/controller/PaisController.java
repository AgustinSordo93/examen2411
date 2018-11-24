package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Pais;
import com.project.service.PaisService;

@RestController
@RequestMapping("/paises")
public class PaisController {
	
	@Autowired
	private PaisService paisService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> response = null;
		
		try {
			List<Pais> pais = this.paisService.getAll();
			response = ResponseEntity.ok(pais);
		}	catch (Exception e) {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		
		return response;
	}
	
	@PostMapping

	public ResponseEntity<?> save(@RequestBody Pais pais) {
		
		ResponseEntity<?> response =null;
		try {
			Pais result = this.paisService.save(pais);
			response = ResponseEntity.status(HttpStatus.OK).body(result);
		}	catch(Exception e){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}
		return response;
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id")long id) {
		ResponseEntity<?> response =null;
		try {
			Pais pais = this.paisService.getById(id);
			
			if(pais !=null) {
				response = ResponseEntity.status(HttpStatus.OK).body(pais);
			} else {
				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro inexistente");
			}
		}	catch(Exception e){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()); 
	}
			
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")Long id){
		
		ResponseEntity<?> response =null;
		
		try {
			Pais pais = this.paisService.delete(id);
			if(pais !=null) {
				response = ResponseEntity.status(HttpStatus.OK).body(pais);
			} else {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("404 Error");
			}
		}	catch(Exception e){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()); 
	}
		return response;
	}


	
	

	

}
