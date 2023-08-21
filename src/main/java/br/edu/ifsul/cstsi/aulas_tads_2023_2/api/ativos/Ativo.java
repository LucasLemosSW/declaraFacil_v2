package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos;

import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.notacorretagems.Notacorretagem;
import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.operacoes.Operacao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
public class Ativo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long ticker;

    private Integer quantidadeEmCarteira;

    private Double precoMedio;

    private Timestamp mesEntradaNaCarteira;

    @OneToMany(mappedBy = "ativoByTicker")
    private Collection<Operacao> operacaosByTicker;

    @ManyToMany(mappedBy = "ativos")
    List<Notacorretagem> notascorretagem;

}