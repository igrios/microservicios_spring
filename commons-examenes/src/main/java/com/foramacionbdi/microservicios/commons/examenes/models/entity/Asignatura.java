package com.foramacionbdi.microservicios.commons.examenes.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="asignaturas")
public class Asignatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	public Asignatura() {
		
		this.Child = new ArrayList<>();
	}

	@JsonIgnoreProperties(value = {"Child"})
	@ManyToOne(fetch = FetchType.LAZY)
	private Asignatura Dad;
	
	@JsonIgnoreProperties(value = {"Dad"},allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "Dad", cascade = CascadeType.ALL)
	private List<Asignatura> Child;
	
	
	
	public Asignatura getDad() {
		return Dad;
	}

	public void setDad(Asignatura dad) {
		Dad = dad;
	}

	public List<Asignatura> getChild() {
		return Child;
	}

	public void setChild(List<Asignatura> child) {
		Child = child;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	

}
