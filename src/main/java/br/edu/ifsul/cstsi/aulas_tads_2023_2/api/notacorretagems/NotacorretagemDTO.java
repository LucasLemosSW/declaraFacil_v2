package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.notacorretagems;

import lombok.Data;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;

@Data
public class NotacorretagemDTO {

    private Long numeroNota;
    private String nomeArquivo;
    private Timestamp dataDaNota;
    private Double valorDaOperacao;
    private Double totalDaOperacao;
    private Double taxaDeLiquidacao;
    private Double emolumentos;
    private Double corretagem;
    private String tipo_operacao;
    private Double dedoDuro;

    public static NotacorretagemDTO create(Notacorretagem notaCorretagem){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(notaCorretagem, NotacorretagemDTO.class);
    }

    public static Notacorretagem converterDtoParaObjeto(NotacorretagemDTO notacorretagemDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Notacorretagem notacorretagem = modelMapper.map(notacorretagemDTO, Notacorretagem.class);
        return notacorretagem;
    }
}
