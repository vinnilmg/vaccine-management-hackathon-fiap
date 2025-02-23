package com.fiap.hackaton.msvacina.config;

import com.fiap.hackaton.msvacina.application.gateway.VacinaGateway;
import com.fiap.hackaton.msvacina.application.usecases.*;
import com.fiap.hackaton.msvacina.application.usecases.impl.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateVacinaUseCase createVacinaUseCase(VacinaGateway vacinaGateway) {
        return new CreateVacinaUseCaseImpl(vacinaGateway);
    }

    @Bean
    public FindAllVacinaUseCase findAllVacinaUseCase(VacinaGateway vacinaGateway) {
        return new FindAllVacinaUseCaseImpl(vacinaGateway);
    }

    @Bean
    public FindVacinaByIdUseCase findVacinaByIdUseCase(VacinaGateway vacinaGateway) {
        return new FindVacinaByIdUseCaseImpl(vacinaGateway);
    }

    @Bean
    public DeleteVacinaUseCase deleteVacinaUseCase(VacinaGateway vacinaGateway, FindVacinaByIdUseCase findVacinaByIdUseCase) {
        return new DeleteVacinaUseCaseImpl(vacinaGateway, findVacinaByIdUseCase);
    }

    @Bean
    public UpdateVacinaUseCase updateVacinaUseCase(VacinaGateway vacinaGateway, FindVacinaByIdUseCase findVacinaByIdUseCase) {
        return new UpdateVacinaUseCaseImpl(vacinaGateway, findVacinaByIdUseCase);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
