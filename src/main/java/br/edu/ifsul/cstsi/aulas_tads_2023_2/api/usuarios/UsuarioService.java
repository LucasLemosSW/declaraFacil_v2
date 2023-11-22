package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository rep;

    public List<UsuarioDTO> getUsuarios() {
        return rep.findAll().stream().map(UsuarioDTO::create).collect(Collectors.toList());
    }

    public UsuarioDTO getUsuarioByID(Integer UserID) {
        System.out.println(UserID);
        return UsuarioDTO.create(rep.findByCodUsuario(UserID));
    }
}
