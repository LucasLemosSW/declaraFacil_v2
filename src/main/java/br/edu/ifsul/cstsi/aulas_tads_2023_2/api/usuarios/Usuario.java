package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios;

import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.operacoes.Operacao;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cod_usuario")
    private Integer codUsuario;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "sobrenome")
    private String sobrenome;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "usuarioByCodUsuario")
    private Collection<Operacao> operacaosByCodUsuario;

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (codUsuario != null ? !codUsuario.equals(usuario.codUsuario) : usuario.codUsuario != null) return false;
        if (nome != null ? !nome.equals(usuario.nome) : usuario.nome != null) return false;
        if (sobrenome != null ? !sobrenome.equals(usuario.sobrenome) : usuario.sobrenome != null) return false;
        if (email != null ? !email.equals(usuario.email) : usuario.email != null) return false;
        if (password != null ? !password.equals(usuario.password) : usuario.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codUsuario != null ? codUsuario.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (sobrenome != null ? sobrenome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Collection<Operacao> getOperacaosByCodUsuario() {
        return operacaosByCodUsuario;
    }

    public void setOperacaosByCodUsuario(Collection<Operacao> operacaosByCodUsuario) {
        this.operacaosByCodUsuario = operacaosByCodUsuario;
    }
}
