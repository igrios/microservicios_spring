package com.foramacionbdi.microservicios.app.cursos.services;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foramacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.foramacionbdi.microservicios.app.cursos.models.repository.CursoRepository;
import com.foramacionbdi.microservicios.commons.services.CommonServiceImpl;


@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Override
	@Transactional(readOnly=true) 
	public Curso findCursobyAlumno(Long id) {		
		return repository.findCursobyAlumno(id);
	}


	
	
}
