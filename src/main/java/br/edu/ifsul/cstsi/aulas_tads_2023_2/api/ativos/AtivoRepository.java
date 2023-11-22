package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtivoRepository extends JpaRepository<Ativo,Long> {

    List<Ativo> findByCodAtivo(Long codAtivo);
    @Query(value="SELECT p FROM Ativo p where p.usuarioByCodUsuario.codUsuario=:codUsuario")
    List<Ativo> findByCodUsuario(@Param("codUsuario") Integer codUsuario);

    List<Ativo> findByTicker(String ticker);

//    @Query(value = "SELECT * FROM ativo where cod_usuario=codAtivo")
//    List<Ativo> findByCodUsuario(Integer codAtivo);
}
