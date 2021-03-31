package com.foramacionbdi.microservicios.app.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.foramacionbdi.microservicios.commons.alumnos.models.entity",
	         "com.foramacionbdi.microservicios.app.cursos.models.entity",
	         "com.foramacionbdi.microservicios.commons.examenes.models.entity"
})




public class MicroserviciosCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosCursosApplication.class, args);
	}

}
