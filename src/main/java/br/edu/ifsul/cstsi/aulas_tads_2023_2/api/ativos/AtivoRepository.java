package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtivoRepository extends JpaRepository<Ativo,Long> {

    List<Ativo> findByTicker(Long ticker);
}
