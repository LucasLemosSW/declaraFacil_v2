package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.darfs;

import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos.Ativo;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;

@Data
public class DarfDTO {

    private Long ticker;
    private int quantidadeEmCarteira;
    private float precoMedio;
    private Timestamp mesEntradaNaCarteira;
    private int codigoNotaCorretagemAtivo;

    public static DarfDTO create(Ativo ativo){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(ativo, DarfDTO.class);
    }
}
