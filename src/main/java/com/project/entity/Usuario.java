package com.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name ="USUARIOS")
public class Usuario {
	
	private int id;
	private String usuario;
	private String password;
	
	@JsonManagedReference
	@OneToMany(mappedBy="usuario", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	private List <PermisosUsuario> permisosUsuarios;
	
	@ManyToOne
	@JoinColumn(name = "PAIS_ID")
	private Pais pais;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
