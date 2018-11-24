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

import com.project.entity.Tarea;
import com.project.service.TareaService;

@RestController
@RequestMapping("/tareas")
public class TareaController {
	
	@Autowired
	private TareaService tareaService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> response = null;
		
		try {
			List<Tarea> tarea = this.tareaService.getAll();
			response = ResponseEntity.ok(tarea);
		}	catch (Exception e) {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		
		return response;
	}
	
	@PostMapping

	public ResponseEntity<?> save(@RequestBody Tarea tarea) {
		
		ResponseEntity<?> response =null;
		try {
			Tarea result = this.tareaService.save(tarea);
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
			Tarea tarea = this.tareaService.getById(id);
			
			if(tarea !=null) {
				response = ResponseEntity.status(HttpStatus.OK).body(tarea);
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
			Tarea tarea = this.tareaService.delete(id);
			if(tarea !=null) {
				response = ResponseEntity.status(HttpStatus.OK).body(tarea);
			} else {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("404 Error");
			}
		}	catch(Exception e){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()); 
	}
		return response;
	}


	

}
