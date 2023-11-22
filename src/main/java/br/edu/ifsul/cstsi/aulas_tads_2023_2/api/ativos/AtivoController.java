package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/ativos")
public class AtivoController {

    @Autowired
    private AtivoService service;

    @GetMapping
    public ResponseEntity<List<AtivoDTO>> selectAll() {
        List<AtivoDTO> ativos = service.getAtivos();
        return ResponseEntity.ok(ativos);
    }

    @GetMapping("/usuario/{codUser}")
    public ResponseEntity<List<AtivoDTO>> selectAtivosByUser(@PathVariable("codUser") Integer codUser) {
        List<AtivoDTO> ativos = service.getAtivosByUsuario(codUser);
        return ResponseEntity.ok(ativos);
    }

    @GetMapping("/ticker/{ticker}")
    public ResponseEntity<List<AtivoDTO>> selectAtivosByUser(@PathVariable("ticker") String ticker) {
        List<AtivoDTO> ativos = service.getAtivosByTicker(ticker);
        return ResponseEntity.ok(ativos);
    }

    @GetMapping("/carteira/{codUser}")
    public ResponseEntity<List<CarteiraDTO>> selectCarteiraByUser(@PathVariable("codUser") Integer codUser) {

        return ResponseEntity.ok(service.getCarteiraByUser(codUser));
    }
}
