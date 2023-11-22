package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.notacorretagems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class NotacorretagemService {

    @Autowired
    private NotacorretagemRepository rep;

    public List<NotacorretagemDTO> getNotaCorretagem() {
        return rep.findAll().stream().map(NotacorretagemDTO::create).collect(Collectors.toList());
    }

    public Notacorretagem saveNotaCorretagem(Notacorretagem notacorretagem) {
        return rep.save(notacorretagem);
    }

    public void getData(String textoNota) {

        String[] palavras = textoNota.split("\\s+");
        int posicao = IntStream.range(0, palavras.length)
                .filter(i -> palavras[i].equals("Nr."))
                .findFirst()
                .orElse(-1);

        for (String palavra : palavras) {
            System.out.println(palavra);
        }

        System.out.println("NumeroNota: "+findNumeroNota(textoNota));
        System.out.println("NomeDoDoc: "+findNomeDoDoc(textoNota));
        System.out.println("DataDaNota: "+findDataDaNota(textoNota));
        System.out.println("ValorDaOperacao: "+findTotalDaOperacao(textoNota));
        System.out.println("TaxaDeLiquidacao: "+findTaxaDeLiquidacao(textoNota));
        System.out.println("Emolumentos: "+findEmolumentos(textoNota));
        System.out.println("Ativos: "+findAtivos(textoNota));
    }

    public Long findNumeroNota(String textoNota){
        String[] palavras = textoNota.split("\\s+");
        int posicao = IntStream.range(0, palavras.length)
                .filter(i -> palavras[i].equals("Nr."))
                .findFirst()
                .orElse(-1);
        return Long.parseLong(palavras[posicao+2]);
    }

    public String findNomeDoDoc(String textoNota){
        return "Nota Clear";
    }

    public Timestamp findDataDaNota(String textoNota) {
        String[] palavras = textoNota.split("\\s+");
        int posicao = IntStream.range(0, palavras.length)
                .filter(i -> palavras[i].equals("pregão"))
                .findFirst()
                .orElse(-1);

        String[] partes = palavras[posicao+1].split("/");
        Timestamp timestamp = Timestamp.valueOf(partes[2]+"-"+partes[1]+"-"+partes[0]+" 00:00:00");
        return timestamp;
    }

    public String findValorDaOperacao(String textoNota){
        return "Nota Clear";
    }

    public String findTotalDaOperacao(String textoNota){
        String[] palavras = textoNota.split("\\s+");
        int posicao = IntStream.range(0, palavras.length)
                .filter(i -> palavras[i].equals("CBLC"))
                .findFirst()
                .orElse(-1);
        palavras[posicao-1]=palavras[posicao-1].replaceAll("[^\\d,]", "");
        return palavras[posicao-1];
    }

    public String findTaxaDeLiquidacao(String textoNota){
        String linhaEncontrada = null;
        String[] linhas = textoNota.split("\n");
        for (String linha : linhas) {
            if (linha.contains("Taxa de liquidação")) {
                linhaEncontrada = linha;
                break; // Saia do loop assim que encontrar a primeira linha
            }
        }
        return linhaEncontrada.replaceAll("[^\\d,]", "");
    }

    public String findEmolumentos(String textoNota){
        String linhaEncontrada = null;
        String[] linhas = textoNota.split("\n");
        for (String linha : linhas) {
            if (linha.contains("Emolumentos")) {
                linhaEncontrada = linha;
                break; // Saia do loop assim que encontrar a primeira linha
            }
        }
        return linhaEncontrada.replaceAll("[^\\d,]", "");
    }

    public String findCorretagem(String textoNota){
        return "Nota Clear";
    }

    public String findTipoOperacao(String textoNota){
        return "Nota Clear";
    }

    public String finddedoDuro(String textoNota){
        return "Nota Clear";
    }

    public String findUsuario(String textoNota){
        return "Nota Clear";
    }

    public String findAtivos(String textoNota){
        int posicaoInicio=0;
        int posicaoFim=0;
        String[] linhas = textoNota.split("\n");
        for (int i = 0; i < linhas.length; i++) {
            String linha = linhas[i];
            if (linha.contains("Negócios realizados")){
                posicaoInicio= i;
                System.out.println("Achou Inicio: "+posicaoInicio);
            }

            if (linha.contains("NOTA DE NEGOCIAÇÃO")){
                posicaoFim=i;
                System.out.println("Achou Fim: "+posicaoFim);
            }

            System.out.println(i);
        }

        System.out.println("Inicio: "+posicaoInicio+" Fim: "+posicaoFim);
        System.out.println(linhas[(posicaoInicio+2)]+"\n"+linhas[(posicaoInicio+3)]);
        return linhas[(posicaoInicio+2)]+"\n"+linhas[(posicaoInicio+3)];
    }
}


