package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtivoService {

    @Autowired
    private AtivoRepository rep;

    public List<AtivoDTO> getAtivos() {
        return rep.findAll().stream().map(AtivoDTO::create).collect(Collectors.toList());
    }
}
