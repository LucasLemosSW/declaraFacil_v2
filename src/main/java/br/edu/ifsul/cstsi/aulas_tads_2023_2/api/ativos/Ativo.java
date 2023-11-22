package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos;

import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.notacorretagems.Notacorretagem;
import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios.Usuario;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
public class Ativo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long codAtivo;
    private String ticker;
    private Double precoMedio;
    private Integer quantidade;
    private String tipoOperacao;
    private Timestamp dataOperacao;

    @ManyToOne
    @JoinColumn(name = "codUsuario", referencedColumnName = "codUsuario")
    private Usuario usuarioByCodUsuario;

    @ManyToMany(mappedBy = "ativos")
    List<Notacorretagem> notascorretagem;

}