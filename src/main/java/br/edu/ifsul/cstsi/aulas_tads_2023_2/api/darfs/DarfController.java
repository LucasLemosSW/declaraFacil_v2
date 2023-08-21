package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.darfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/darfs")
//@Api(value = "Produtos")
public class DarfController {

//    @Autowired
//    private DarfService service;

    @GetMapping
//    @ApiOperation(value = "Retorna todos os produtos cadastrados.")
    public ResponseEntity selectAll() {
//        List<DarfDTO> ativos = service.getAtivos();
        return ResponseEntity.ok("ativo");
    }
}
