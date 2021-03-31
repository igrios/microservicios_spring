package com.foramacionbdi.microservicios.app.usuarios.services;



import java.util.List;

import com.foramacionbdi.microservicios.commons.alumnos.models.entity.Alumnno;
import com.foramacionbdi.microservicios.commons.services.CommonServices;

public interface AlumnoServices  extends CommonServices<Alumnno>{
	
	public List<Alumnno> findByNombreOrApellido(String term);

}
