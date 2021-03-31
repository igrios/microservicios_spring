package com.foramacionbdi.microservicios.app.examenes.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foramacionbdi.microservicios.commons.services.CommonServiceImpl;
import com.foramacionbdi.microservicios.commons.examenes.models.entity.Asignatura;
import com.foramacionbdi.microservicios.commons.examenes.models.entity.Examen;
import com.foramacionbdi.microservicios.app.examenes.modeles.repository.AsignaturaRepository;
import com.foramacionbdi.microservicios.app.examenes.modeles.repository.ExamenRepository;


@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen,ExamenRepository> implements ExamenService{

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findBynombre(String term) {
		return repository.findBynombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> findAllAsignaturas() {
		return (List<Asignatura>) asignaturaRepository.findAll();
	}
	
	
	
	
	
	

}
