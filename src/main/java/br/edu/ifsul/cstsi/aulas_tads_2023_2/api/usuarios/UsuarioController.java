package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity selectAll() {
        List<UsuarioDTO> usuarios = service.getUsuarios();
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/{userID}")
    public ResponseEntity<UsuarioDTO> selectUserByID(@PathVariable("userID") Integer userID ) {
        return ResponseEntity.ok(service.getUsuarioByID(userID));
    }
}
