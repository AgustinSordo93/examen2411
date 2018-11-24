package com.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="TAREAS")
public class Tarea {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descripcion;
	
	@JsonManagedReference
	@OneToMany(mappedBy="usuario", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	private List <Usuario> Usuario;
	
	@ManyToOne
	@JoinColumn(name = "TIPO_TAREA_ID")
	private TiposTarea tiposTarea;
	
	
	public List<Usuario> getUsuario() {
		return Usuario;
	}
	public void setUsuario(List<Usuario> usuario) {
		Usuario = usuario;
	}
	public TiposTarea getTiposTarea() {
		return tiposTarea;
	}
	public void setTiposTarea(TiposTarea tiposTarea) {
		this.tiposTarea = tiposTarea;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
