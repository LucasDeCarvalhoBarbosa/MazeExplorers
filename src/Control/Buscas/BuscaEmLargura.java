package Control.Buscas;

import Biblioteca.Caminho;
import Biblioteca.Excecoes.CaminhoInexistenteException;
import Biblioteca.Labirinto;
import Biblioteca.No;
import Control.Acao;
import Control.ExecutaAcao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Barbosa
 */
public class BuscaEmLargura extends Busca {

    public BuscaEmLargura(Labirinto labirinto) {
        super(labirinto);
    }

    @Override
    public Caminho buscar(Acao acao) throws CaminhoInexistenteException {
        executa = new ExecutaAcao(acao);
        
        Caminho caminho = new Caminho();
        caminho.adiciona(inicio);
        
        //O No que eu estou usando no momento é sempre caminho.olhaTopo()
        while(!caminho.olhaTopo().equals(objetivo)){
            
            
            try{
                executa.executa(caminho.olhaTopo(), caminho.olhaTopo().direcaoEmRelacao(caminho.penultimo()));
            }catch(IndexOutOfBoundsException e){
                throw new CaminhoInexistenteException();
            }
        }
        
        return caminho;
    }
    
    
    
    public class Nivel {
        
        private List<No> nos;
        
        public Nivel(List<No> nos){
            this.nos = nos;
        }
        
        public Nivel geraProximoNivel(Caminho caminho){
            List<No> lista = new ArrayList<>();
            
            for(int i=0;i<nos.size();i++){
                
                List<No> vizinhos = nos.get(i).getVizinhos(labirinto.getEspaco(), caminho);
                for(int j=0;j<vizinhos.size();j++){
                    lista.add(vizinhos.get(i));
                }
                
            }
            
            return new Nivel(lista);
        }
        
        public No get(int i){
            return nos.get(i);
        }
        
        public int tamanho(){
            return nos.size();
        }
        
    }
    
}
