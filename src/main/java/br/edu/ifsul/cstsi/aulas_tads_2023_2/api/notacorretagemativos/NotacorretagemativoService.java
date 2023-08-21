//package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.notacorretagemativos;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class NotacorretagemativoService {
//
//    @Autowired
//    private NotacorretagemativoRepository rep;
//
//    public List<NotacorretagemativoDTO> getNotaCorretagemAtivo() {
//        return rep.findAll().stream().map(NotacorretagemativoDTO::create).collect(Collectors.toList());
//    }
//}
