package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos;

import lombok.Data;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;

@Data
public class AtivoDTO {

    private Long codAtivo;
    private String ticker;
    private Double precoMedio;
    private Integer quantidade;
    private String tipoOperacao;
    private Timestamp dataOperacao;
    private Integer codUsuario;

    public static AtivoDTO create(Ativo ativo){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(ativo, AtivoDTO.class);
    }
}
