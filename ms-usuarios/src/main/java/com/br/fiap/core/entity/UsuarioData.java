package com.br.fiap.core.entity;

import com.br.fiap.core.enums.TipoPacienteEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "USUARIOS")
public class UsuarioData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String email;

    @Column
    private String telefone;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id")
    private EnderecoData endereco;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "numero_carteirinha_sus")
    private String numeroCarteirinhaSUS;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoPacienteEnum tipo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dependente_de_id")
    private UsuarioData dependenteDe;

    @OneToMany(mappedBy = "dependenteDe", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private List<UsuarioData> dependentesList;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<MovimentacaoVacinaData> movimentacaoVacinal;
}
