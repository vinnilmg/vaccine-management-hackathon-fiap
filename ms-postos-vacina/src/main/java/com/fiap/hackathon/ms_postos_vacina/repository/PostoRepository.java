package com.fiap.hackathon.ms_postos_vacina.repository;

import com.fiap.hackathon.ms_postos_vacina.repository.entity.PostoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PostoRepository extends JpaRepository<PostoEntity, Long> {
    Collection<PostoEntity> findByEnderecoBairro(String bairro);
}
