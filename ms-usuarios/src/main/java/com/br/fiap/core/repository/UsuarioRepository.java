package com.br.fiap.core.repository;

import com.br.fiap.core.entity.UsuarioData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioData, Long> {

}
