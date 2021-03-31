package com.foramacionbdi.microservicios.app.cursos.models.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.foramacionbdi.microservicios.commons.alumnos.models.entity.Alumnno;
import com.foramacionbdi.microservicios.commons.examenes.models.entity.Examen;

@Entity
@Table(name="cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotEmpty
	private String nombre;
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<Alumnno> alumnos;
	
	@ManyToMany(fetch= FetchType.LAZY)
	private List<Examen> examenes;
	
	
	public List<Alumnno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumnno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public void addAlumnos(Alumnno alumno) {
		this.alumnos.add(alumno);
	}

	public void removeAlumnos(Alumnno alumno) {
		this.alumnos.remove(alumno);
	}

	
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
		
		
	}
	
	

	public Curso() {
		this.alumnos  = new ArrayList<>();
		this.examenes = new ArrayList<>();
		
		
	} // Constructor 

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

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public List<Examen> getExamenes() {
		return examenes;
	}

	public void setExamenes(List<Examen> examenes) {
		this.examenes = examenes;
	}
	
	public void addExamen(Examen examen) {
		this.examenes.add(examen); // no posee relacion inversa mismo que alumnos 
		
	}
	
	public void removeExamen(Examen examen) {
		this.examenes.remove(examen);  
		
	}
	
	
	
	

}
