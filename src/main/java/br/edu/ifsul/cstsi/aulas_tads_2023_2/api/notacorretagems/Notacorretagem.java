package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.notacorretagems;

import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos.Ativo;
import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.operacoes.Operacao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

@Entity
public class Notacorretagem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numero_nota")
    private Long numeroNota;
    @Basic
    @Column(name = "nome_arquivo")
    private String nomeArquivo;
    @Basic
    @Column(name = "quantidade")
    private Double quantidade;
    @Basic
    @Column(name = "preco")
    private Double preco;
    @Basic
    @Column(name = "data_da_nota")
    private Timestamp dataDaNota;
    @Basic
    @Column(name = "valor_da_operacao")
    private Double valorDaOperacao;
    @Basic
    @Column(name = "total_da_operacao")
    private Double totalDaOperacao;
    @Basic
    @Column(name = "taxa_de_liquidacao")
    private Double taxaDeLiquidacao;
    @Basic
    @Column(name = "emolumentos")
    private Double emolumentos;
    @Basic
    @Column(name = "corretagem")
    private Double corretagem;
    @Basic
    @Column(name = "dedo_duro")
    private Double dedoDuro;

    @OneToMany(mappedBy = "notacorretagemByNumeroNota")
    private Collection<Operacao> operacaosByNumeroNota;

    @ManyToMany
    @JoinTable(
            name = "notacorretagemativo",
            joinColumns = @JoinColumn(name = "notacorretagem_numero_nota"),
            inverseJoinColumns = @JoinColumn(name = "ativo_ticker"))
    Set<Ativo> ativos;

}