package com.fiap.hackathon.ms_postos_vacina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.fiap.hackathon.ms_postos_vacina",
		"com.fiap.hackathon.ms_postos_vacina.controller.mapper"
})
public class MsPostosVacinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPostosVacinaApplication.class, args);
	}

}
