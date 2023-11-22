package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.ativos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AtivoService {

    @Autowired
    private AtivoRepository rep;

    public List<AtivoDTO> getAtivos() {
        return rep.findAll().stream().map(AtivoDTO::create).collect(Collectors.toList());
    }

    public List<AtivoDTO> getAtivosByUsuario(Integer codUsuario) {
        return rep.findByCodUsuario(codUsuario).stream().map(AtivoDTO::create).collect(Collectors.toList());
//        return rep.findByCodUsuario(codUsuario).stream().map(AtivoDTO::create).collect(Collectors.toList());
    }

    public List<AtivoDTO> getAtivosByTicker(String ticker) {
        return rep.findByTicker(ticker).stream().map(AtivoDTO::create).collect(Collectors.toList());
    }

    public List<CarteiraDTO> getCarteiraByUser(Integer codUser) {
        List<CarteiraDTO> carteira = new ArrayList<>();
        int[] quantidade = new int[2];
        Double[] precoMedio= new Double[1];

        List<AtivoDTO> ativos = getAtivosByUsuario(codUser);
        Map<String, List<AtivoDTO>> ativosPorTicker = ativos.stream()
                .collect(Collectors.groupingBy(AtivoDTO::getTicker));

        ativosPorTicker.forEach((tickers, listaTickers) -> {

            quantidade[0]=0;
            precoMedio[0]=0.0;
            listaTickers.forEach(ativo->{
                if(ativo.getTipoOperacao().equals("D")){
                    precoMedio[0]=((precoMedio[0]*quantidade[0])+(ativo.getQuantidade()*ativo.getPrecoMedio()))/(quantidade[0]+ativo.getQuantidade());
                    quantidade[0]=quantidade[0]+ativo.getQuantidade();
                } else if (ativo.getTipoOperacao().equals("C")) {
                    quantidade[0]=quantidade[0]-ativo.getQuantidade();
                }
            });

            if(quantidade[0]!=0)
                carteira.add(new CarteiraDTO(tickers,precoMedio[0],quantidade[0]));

        });
        return carteira;
    }
}
