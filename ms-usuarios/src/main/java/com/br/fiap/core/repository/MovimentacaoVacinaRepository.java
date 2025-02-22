package com.br.fiap.core.repository;

import com.br.fiap.core.entity.MovimentacaoVacinaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovimentacaoVacinaRepository extends JpaRepository<MovimentacaoVacinaData, Long> {

    public List<MovimentacaoVacinaData> findAllByUsuarioId(Long id);

    @Query("SELECT m FROM MovimentacaoVacinaData m WHERE m.usuario.id IN :ids")
    public List<MovimentacaoVacinaData> findAllByUsuarioId(@Param("ids") List<Long> id);
}
