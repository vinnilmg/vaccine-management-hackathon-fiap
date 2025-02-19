package com.fiap.hackathon.ms_postos_vacina.repository;

import com.fiap.hackathon.ms_postos_vacina.repository.entity.LoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoteRepository extends JpaRepository<LoteEntity, Long> {
    LoteEntity findByPostoVacinacaoIdAndNumero(Long postoVacinacaoId, String numero);

    List<LoteEntity> findByNumero(String numero);
}
