package com.br.fiap.core.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "MOVIMENTACAO_VACINA")
public class MovimentacaoVacinaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "identificador_vacina")
    private String identificadorVacina;

    @Column(name = "data_aplicacao")
    private LocalDate dataAplicacao;

    @Column(name = "identificador_local")
    private String identificadorLocal;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioData usuario;

    @ManyToOne
    @JoinColumn(name = "dependente_id")
    private DependenteData dependente;


    @PrePersist
    public void gerarSequence() {
        if (this.sequence == null) {
            List<MovimentacaoVacinaData> movimentacoesVacina = usuario.getMovimentacaoVacinal()
                    .stream()
                    .filter(mv -> mv.getIdentificadorVacina().equals(this.identificadorVacina))
                    .toList();

            Integer ultimaSequence = movimentacoesVacina.stream()
                    .mapToInt(MovimentacaoVacinaData::getSequence)
                    .max()
                    .orElse(0);

            this.sequence = ultimaSequence + 1;
        }
    }
}
