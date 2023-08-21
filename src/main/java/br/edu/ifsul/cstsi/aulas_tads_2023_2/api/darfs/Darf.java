package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.darfs;

import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.operacoes.Operacao;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
@Data
@Entity
public class Darf {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cod_darf")
    private Integer codDarf;
    @Basic
    @Column(name = "cod_do_imposto")
    private Long codDoImposto;
    @Basic
    @Column(name = "valor")
    private Double valor;
    @OneToMany(mappedBy = "darfByCodDarf")
    private Collection<Operacao> operacaosByCodDarf;

    public Integer getCodDarf() {
        return codDarf;
    }

    public void setCodDarf(Integer codDarf) {
        this.codDarf = codDarf;
    }

    public Long getCodDoImposto() {
        return codDoImposto;
    }

    public void setCodDoImposto(Long codDoImposto) {
        this.codDoImposto = codDoImposto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Darf darf = (Darf) o;

        if (codDarf != null ? !codDarf.equals(darf.codDarf) : darf.codDarf != null) return false;
        if (codDoImposto != null ? !codDoImposto.equals(darf.codDoImposto) : darf.codDoImposto != null) return false;
        if (valor != null ? !valor.equals(darf.valor) : darf.valor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codDarf != null ? codDarf.hashCode() : 0;
        result = 31 * result + (codDoImposto != null ? codDoImposto.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        return result;
    }

    public Collection<Operacao> getOperacaosByCodDarf() {
        return operacaosByCodDarf;
    }

    public void setOperacaosByCodDarf(Collection<Operacao> operacaosByCodDarf) {
        this.operacaosByCodDarf = operacaosByCodDarf;
    }
}

