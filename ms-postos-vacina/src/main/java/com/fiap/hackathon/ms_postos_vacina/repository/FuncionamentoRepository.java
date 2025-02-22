package com.fiap.hackathon.ms_postos_vacina.repository;

import com.fiap.hackathon.ms_postos_vacina.repository.entity.FuncionamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionamentoRepository extends JpaRepository<FuncionamentoEntity, Long> {
}
