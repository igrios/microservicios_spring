package com.foramacionbdi.microservicios.app.cursos.models.repository;



import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.foramacionbdi.microservicios.app.cursos.models.entity.Curso;

public interface CursoRepository extends PagingAndSortingRepository<Curso,Long>{
	
	@Query("select c from Curso c join fetch c.alumnos a where a.id = ?1")
	public Curso findCursobyAlumno(Long id);
	
}