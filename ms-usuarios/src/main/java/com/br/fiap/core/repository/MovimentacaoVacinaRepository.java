package com.br.fiap.core.repository;

import com.br.fiap.core.entity.MovimentacaoVacinaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentacaoVacinaRepository extends JpaRepository<MovimentacaoVacinaData, Long> {

    public List<MovimentacaoVacinaData> findAllByUsuarioId(Long id);
}
