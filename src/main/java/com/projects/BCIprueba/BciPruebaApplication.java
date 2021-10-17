package com.projects.BCIprueba;

import com.projects.BCIprueba.services.db.DataBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BciPruebaApplication {

	public static void main(String[] args) {
		DataBase.createData();
		SpringApplication.run(BciPruebaApplication.class, args);
	}
}
