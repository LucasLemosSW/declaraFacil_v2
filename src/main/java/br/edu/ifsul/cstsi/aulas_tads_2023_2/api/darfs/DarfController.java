package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.darfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/darfs")
//@Api(value = "Produtos")
public class DarfController {

    @Autowired
    private DarfService service;

    @GetMapping
    public ResponseEntity selectAll() {
        List<DarfDTO> darfs = service.getDarfs();
        return ResponseEntity.ok(darfs);
    }

    @GetMapping("/{codDarf}")
    public ResponseEntity<Darf> selectDarfsByCodDarf(@PathVariable("codDarf") Integer codDarf) {
//        List<DarfDTO> darfs = service.getDarfsByUser(codUser);
        System.out.println("CODIGOO: "+codDarf);
        return ResponseEntity.ok(service.getDarfsByCodDarf(codDarf));
    }

    @GetMapping("/user/{codUser}")
    public ResponseEntity<List<DarfDTO>> selectDarfsByUser(@PathVariable("codUser") Integer codUser) {
        List<DarfDTO> darfs = service.getDarfsByUser(codUser);
        System.out.println("DarFSSS: "+darfs);
        return ResponseEntity.ok(darfs);
    }

//    @GetMapping("/usuario/{codUser}")
//    public ResponseEntity<List<AtivoDTO>> selectAtivosByUser(@PathVariable("codUser") Integer codUser) {
//        List<AtivoDTO> ativos = service.getAtivosByUsuario(codUser);
//        return ResponseEntity.ok(ativos);
//    }
}
