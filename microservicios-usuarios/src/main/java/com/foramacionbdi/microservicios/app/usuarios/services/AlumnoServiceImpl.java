package com.foramacionbdi.microservicios.app.usuarios.services;


import com.foramacionbdi.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.foramacionbdi.microservicios.commons.alumnos.models.entity.Alumnno;
import com.foramacionbdi.microservicios.commons.services.CommonServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;  

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumnno, AlumnoRepository> implements AlumnoServices {

	@Override
	@Transactional(readOnly=true)
	public List<Alumnno> findByNombreOrApellido(String term) {
		
		return repository.findByNombreOrApellido(term);
	}
	

	

}
