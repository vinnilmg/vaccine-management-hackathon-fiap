package com.fiap.hackathon.ms_postos_vacina.repository;

import com.fiap.hackathon.ms_postos_vacina.repository.entity.Posto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PostoRepository extends JpaRepository<Posto, Long> {
    Collection<Posto> findByEnderecoBairro(String bairro);
}
