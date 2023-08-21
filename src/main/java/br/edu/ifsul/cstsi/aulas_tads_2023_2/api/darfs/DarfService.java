package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.darfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DarfService {

    @Autowired
    private DarfRepository rep;

    public List<DarfDTO> getAtivos() {
        return rep.findAll().stream().map(DarfDTO::create).collect(Collectors.toList());
    }
}
