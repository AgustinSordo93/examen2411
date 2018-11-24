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

import com.project.entity.Usuario;
import com.project.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> response = null;
		
		try {
			List<Usuario> usuario = this.usuarioService.getAll();
			response = ResponseEntity.ok(usuario);
		}	catch (Exception e) {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		
		return response;
	}
	
	@PostMapping

	public ResponseEntity<?> save(@RequestBody Usuario usuario) {
		
		ResponseEntity<?> response =null;
		try {
			Usuario result = this.usuarioService.save(usuario);
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
			Usuario usuario = this.usuarioService.getById(id);
			
			if(usuario !=null) {
				response = ResponseEntity.status(HttpStatus.OK).body(usuario);
			} else {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("404 Error");
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
			Usuario usuario = this.usuarioService.delete(id);
			if(usuario !=null) {
				response = ResponseEntity.status(HttpStatus.OK).body(usuario);
			} else {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("404 Error");
			}
		}	catch(Exception e){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()); 
	}
		return response;
	}


	
	

}
