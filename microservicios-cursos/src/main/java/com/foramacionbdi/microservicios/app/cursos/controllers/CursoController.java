package com.foramacionbdi.microservicios.app.cursos.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foramacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.foramacionbdi.microservicios.app.cursos.services.CursoService;
import com.foramacionbdi.microservicios.commons.alumnos.models.entity.Alumnno;
import com.foramacionbdi.microservicios.commons.controllers.CommonController;
import com.foramacionbdi.microservicios.commons.examenes.models.entity.Examen;

@RestController
public class CursoController extends CommonController<Curso,CursoService>
{
	@PutMapping("/{id}")	
	public ResponseEntity<?> editar(@Valid @RequestBody Curso curso,BindingResult result,@PathVariable Long id){
	   
		
		if(result.hasErrors()) {
			
				return this.validar(result);
				
			}
		
		
		Optional<Curso> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
						
		}
		
		Curso dbCurso = o.get();
		
		dbCurso.setNombre(curso.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
				
	}
	
	@PutMapping("/{id}/asignar-alumno")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumnno> alumnos, @PathVariable Long id) {
		
		Optional<Curso> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
						
		}
		
		Curso dbCurso = o.get();
		alumnos.forEach(a ->{ dbCurso.addAlumnos(a);} );
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumnno alumno, @PathVariable Long id) {
		
		Optional<Curso> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
						
		}
		
		Curso dbCurso = o.get();
		dbCurso.removeAlumnos(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	
	      
	@PutMapping("/{id}/asignar-examenes")
	public ResponseEntity<?> asignarExamenes(@RequestBody List<Examen> examenes, @PathVariable Long id) {
		
		Optional<Curso> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
						
		}
		
		Curso dbCurso = o.get();
		examenes.forEach(e ->{ dbCurso.addExamen(e);} );
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	
	@PutMapping("/{id}/eliminar-examenes")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Examen examen, @PathVariable Long id) {
		
		Optional<Curso> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
						
		}
		
		Curso dbCurso = o.get();
		dbCurso.removeExamen(examen);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	
	
	
@GetMapping("/alumno/{id}")
public ResponseEntity<?> buscarPorAlumno(@PathVariable Long id){
	Curso curso = service.findCursobyAlumno(id);
	return ResponseEntity.ok(curso);
	
	
	
}

	
	
	
}
