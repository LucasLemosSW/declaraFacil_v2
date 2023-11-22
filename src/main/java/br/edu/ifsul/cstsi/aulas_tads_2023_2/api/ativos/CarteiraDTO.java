package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarteiraDTO {

    private String ticker;
    private Double precoMedio;
    private Integer quantidade;

}
