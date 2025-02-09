package com.fiap.hackathon.agendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsAgendamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAgendamentoApplication.class, args);
    }

}
