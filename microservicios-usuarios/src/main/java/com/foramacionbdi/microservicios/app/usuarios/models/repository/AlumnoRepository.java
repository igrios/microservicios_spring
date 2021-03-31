package com.foramacionbdi.microservicios.app.usuarios.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.foramacionbdi.microservicios.commons.alumnos.models.entity.Alumnno;

public interface AlumnoRepository extends PagingAndSortingRepository<Alumnno,Long> {
	
	@Query("select a from  Alumnno a where a.nombre  like %?1% or a.apellido  like %?1%")

	public List<Alumnno> findByNombreOrApellido(String term);
	
}
