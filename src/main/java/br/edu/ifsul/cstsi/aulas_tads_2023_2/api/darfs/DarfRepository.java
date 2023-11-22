package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.darfs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DarfRepository extends JpaRepository<Darf,Integer> {

    Darf findByCodDarf(Integer codDarf);

    @Query(value = "SELECT p FROM Darf p where p.usuarioByCodUsuario.codUsuario=:codUser")
    List<Darf> findByCodUsuario(@Param("codUser") Integer codUser);
}
