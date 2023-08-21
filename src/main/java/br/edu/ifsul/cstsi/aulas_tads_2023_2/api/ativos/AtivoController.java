package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/ativos")
//@Api(value = "Produtos")
public class AtivoController {

    @Autowired
    private AtivoService service;

    @GetMapping
//    @ApiOperation(value = "Retorna todos os produtos cadastrados.")
    public ResponseEntity<List<AtivoDTO>> selectAll() {
        List<AtivoDTO> ativos = service.getAtivos();
        return ResponseEntity.ok(ativos);
    }
}
