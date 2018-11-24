package com.project.service;

import java.util.List;

import com.project.entity.Tarea;

public interface TareaService {
	
	public List<Tarea> getAll();
	public Tarea getById(Long id);
	public Tarea save(Tarea tarea);
	public Tarea delete (Long id);

}
