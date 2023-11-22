package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios;

import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos.Ativo;
import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.darfs.Darf;
import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.notacorretagems.Notacorretagem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Usuario implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer codUsuario;
    private String nome;
    private String sobrenome;
    private String login;
    private String password;
    private UserRole role;

    @OneToMany(mappedBy = "usuarioByCodUsuario")
    private Collection<Notacorretagem> notacorretagemsByCodUsuario;

    @OneToMany(mappedBy = "usuarioByCodUsuario")
    private Collection<Ativo> ativosByCodUsuario;

    @OneToMany(mappedBy = "usuarioByCodUsuario")
    private Collection<Darf> darfssByCodUsuario;

    public Usuario(String login,String nome,String sobrenome, String password,UserRole role){
        this.login= login;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.password = password;
        this.role = role;
    }

    public Usuario() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
