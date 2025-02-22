package com.br.fiap.core.repository;

import com.br.fiap.core.entity.EnderecoData;
import com.br.fiap.core.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoDataRepository extends JpaRepository<EnderecoData, Long> {

}
