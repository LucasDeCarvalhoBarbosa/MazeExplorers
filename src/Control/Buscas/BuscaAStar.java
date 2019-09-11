package Control.Buscas;

import Biblioteca.Caminho;
import Biblioteca.Excecoes.CaminhoInexistenteException;
import Biblioteca.Excecoes.HeuristicaNaoCalculadaException;
import Biblioteca.Labirinto;
import Biblioteca.No;
import Control.Acao;
import Control.ExecutaAcao;
import java.util.List;

/**
 *
 * @author Lucas Barbosa
 */
public class BuscaAStar extends BuscaHeuristica {

    public BuscaAStar(Labirinto labirinto) {
        super(labirinto);
    }

    @Override
    public Caminho buscar(Acao acao) throws CaminhoInexistenteException {
        executa = new ExecutaAcao(acao);
        Caminho caminho = new Caminho();
        caminho.adiciona(inicio);
        
        //O No que eu estou usando no momento é sempre caminho.olhaTopo()
        while(!caminho.olhaTopo().equals(this.objetivo)){
            No proximoPasso = proximoPasso(caminho.olhaTopo(), caminho);
            
            //verifica se o caminho retornou null porque não encontrou nenhum vizinho para explorar
            if(proximoPasso!=null)
                caminho.adiciona(proximoPasso);
            
            try{
                executa.executa(caminho.olhaTopo(), caminho.olhaTopo().direcaoEmRelacao(caminho.penultimo()));
            }catch(IndexOutOfBoundsException e){
                throw new CaminhoInexistenteException();
            }
        }
        
        return caminho;
    }
    
    private No proximoPasso(No noAtual, Caminho caminho){
        List<No> vizinhos = noAtual.getVizinhos(labirinto.getEspaco(), caminho);
        this.atribuiHeuristica(vizinhos);
        
        return noAtual;//mudar
    }
    
    @Override
    public No melhorNo(List<No> nos){
        return nos.get(0);//mudar
    }
    
    public int comparacao(No no1, No no2) throws HeuristicaNaoCalculadaException{
        return 0;//mudar
    }
    
}
