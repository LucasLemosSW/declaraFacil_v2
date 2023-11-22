package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT p FROM Usuario p where p.codUsuario=:codUser")
    Usuario findByCodUsuario(@Param("codUser") Integer codUser);

    UserDetails findByNome(String nome);

//    UserDetails findByEmail(String email);

    UserDetails findByLogin(String email);

}
