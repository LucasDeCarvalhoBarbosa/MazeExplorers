package Control.Buscas;

import Biblioteca.Caminho;
import Biblioteca.Excecoes.CaminhoInexistenteException;
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
    public Caminho buscar(Acao acao) throws CaminhoInexistenteException{
        executa = new ExecutaAcao(acao);
        Caminho caminho = new Caminho();
        caminho.adiciona(inicio);
        
        //O No que eu estou usando no momento é sempre caminho.olhaTopo()
        while(!caminho.olhaTopo().equals(this.objetivo)){
            No proximoPasso = proximoPasso(caminho.olhaTopo(), caminho);
            
            //verifica se o caminho retornou o próprio nó porque não encontrou nenhum vizinho para explorar
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
    //arrumar
    private No proximoPasso(No noAtual, Caminho caminho){
        List<No> vizinhos = noAtual.getVizinhos(labirinto.getEspaco(), caminho);
        this.atribuiHeuristica(vizinhos);
        
        if(vizinhos.size()>0){//se tiver pelo menos um vizinho válido para explorar
            return melhorNo(vizinhos);
        }
        
        //se não tiver nenhum vizinho eu devo voltar um nível (voltar para o nó anterior, porque este não tem a solução)
        if(caminho.tamanho()>0){
            caminho.adicionaNoExcluido(noAtual);
            caminho.removeTopo();
            return null;
        }else
            throw new CaminhoInexistenteException();
        
    }
    
}
