package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.darfs;

import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DarfRepository extends JpaRepository<Ativo,String> {

//    List<Ativo> findByTicker(String ticker);
}
