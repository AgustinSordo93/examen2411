package com.project.service;

import java.util.List;

import com.project.entity.Usuario;

public interface UsuarioService {
	
	public List<Usuario> getAll();
	public Usuario getById(Long id);
	public Usuario save(Usuario usuario);
	public Usuario delete (Long id);

}
