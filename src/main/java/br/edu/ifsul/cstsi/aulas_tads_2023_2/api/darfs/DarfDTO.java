package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.darfs;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class DarfDTO {

    private Integer codDarf;

    private Long codDoImposto;

    private Double valor;

    public static DarfDTO create(Darf darf){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(darf, DarfDTO.class);
    }
}
