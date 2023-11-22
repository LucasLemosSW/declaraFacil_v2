package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.notacorretagems;

import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos.Ativo;
import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notacorretagem {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long numeroNota;
    private String nomeArquivo;
    private Timestamp dataDaNota;
    private Double valorDaOperacao;
    private Double totalDaOperacao;
    private Double taxaDeLiquidacao;
    private Double emolumentos;
    private Double corretagem;
    private String tipo_operacao;
    private Double dedoDuro;

    @ManyToOne
    @JoinColumn(name = "codUsuario", referencedColumnName = "codUsuario")
    private Usuario usuarioByCodUsuario;

    @ManyToMany
    @JoinTable(
            name = "notacorretagemativo",
            joinColumns = @JoinColumn(name = "notacorretagem_numero_nota"),
            inverseJoinColumns = @JoinColumn(name = "ativo_codAtivo"))
    Set<Ativo> ativos;

}