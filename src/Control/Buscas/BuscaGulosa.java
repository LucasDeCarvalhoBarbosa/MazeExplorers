package Control.Buscas;

import Biblioteca.Caminho;
import Biblioteca.Labirinto;
import Biblioteca.No;
import Control.Acao;
import Control.ExecutaAcao;
import java.util.List;

/**
 *
 * @author Lucas Barbosa
 */
public class BuscaGulosa extends BuscaHeuristica{

    public BuscaGulosa(Labirinto labirinto) {
        super(labirinto);
    }
    
    @Override
    public Caminho buscar(Acao acao) {
        executa = new ExecutaAcao(acao);
        Caminho caminho = new Caminho();
        caminho.adiciona(inicio);
        
        while(!caminho.olhaTopo().equals(this.objetivo)){
            executa.executa(caminho.olhaTopo(), caminho.olhaTopo().direcaoEmRelacao(caminho.penultimo()));
            
            caminho.adiciona(proximoPasso(caminho.olhaTopo(), caminho));
        }
        
        return caminho;
    }
    
    private No proximoPasso(No noAtual, Caminho caminho){
        List<No> vizinhos = noAtual.getVizinhos(labirinto.getEspaco(), caminho);
        this.atribuiHeuristica(vizinhos);
        
        return melhorNo(vizinhos);
    }
    
}
