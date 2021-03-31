package com.foramacionbdi.microservicios.app.examenes.services;

import java.util.List;
import com.foramacionbdi.microservicios.commons.examenes.models.entity.Asignatura;
import com.foramacionbdi.microservicios.commons.examenes.models.entity.Examen;
import com.foramacionbdi.microservicios.commons.services.CommonServices;

public interface ExamenService extends CommonServices<Examen>{
	
	public List<Examen> findBynombre(String term);
	
	public List<Asignatura> findAllAsignaturas();
	

}
