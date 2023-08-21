package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.operacoes;

import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos.Ativo;
import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.darfs.Darf;
import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.darfs.DarfDTO;
import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.notacorretagems.Notacorretagem;
import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios.Usuario;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Operacao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cod_operacao")
    private Integer codOperacao;
    @Basic
    @Column(name = "quantidade")
    private Long quantidade;
    @Basic
    @Column(name = "preco")
    private Double preco;
    @Basic
    @Column(name = "data_da_operacao")
    private Timestamp dataDaOperacao;
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
    @ManyToOne
    @JoinColumn(name = "numero_nota", referencedColumnName = "numero_nota")
    private Notacorretagem notacorretagemByNumeroNota;
    @ManyToOne
    @JoinColumn(name = "cod_darf", referencedColumnName = "cod_darf")
    private Darf darfByCodDarf;
    @ManyToOne
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario")
    private Usuario usuarioByCodUsuario;
    @ManyToOne
    @JoinColumn(name = "ticker", referencedColumnName = "ticker")
    private Ativo ativoByTicker;

}
