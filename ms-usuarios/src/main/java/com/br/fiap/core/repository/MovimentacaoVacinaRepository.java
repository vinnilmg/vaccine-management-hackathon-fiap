package com.br.fiap.core.repository;

import com.br.fiap.core.entity.DependenteData;
import com.br.fiap.core.entity.MovimentacaoVacinaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoVacinaRepository extends JpaRepository<MovimentacaoVacinaData, Long> {
}
