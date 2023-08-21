//package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.notacorretagems;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class NotacorretagemService {
//
//    @Autowired
//    private NotacorretagemRepository rep;
//
//    public List<NotacorretagemDTO> getNotaCorretagem() {
//        return rep.findAll().stream().map(NotacorretagemDTO::create).collect(Collectors.toList());
//    }
//}
