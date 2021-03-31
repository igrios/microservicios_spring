package com.foramacionbdi.microservicios.app.cursos.services;



import com.foramacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.foramacionbdi.microservicios.commons.services.CommonServices;


public interface CursoService extends CommonServices<Curso> {
	
	public Curso findCursobyAlumno(Long id);
	

}
