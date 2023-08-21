//package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.notacorretagems;
//
//import lombok.Data;
//import org.modelmapper.ModelMapper;
//
//import java.sql.Timestamp;
//
//@Data
//public class NotacorretagemDTO {
//
//    private Long numeroNota;
//    private String nomeArquivo;
//    private double quantidade;
//    private double preco;
//    private Timestamp dataDaNota;
//    private double valorDaOperacao;
//    private double totalDaOperacao;
//    private double taxaDeLiquidacao;
//    private double emolumentos;
//    private double corretagem;
//    private double dedoDuro;
//    private long codigoNotaCorretagemAtivo;
//
//    public static NotacorretagemDTO create(Notacorretagem notaCorretagem){
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(notaCorretagem, NotacorretagemDTO.class);
//    }
//}
