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
 * Ele consegue encontrar o o
 * bjetivo,mas ele está teleportando(visitando nós que estão no nível,
 * mas não são vizinhos.
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
        
        //boolean nivelTodoVerificado = false;
        Nivel nivelAtual = new Nivel(caminho.olhaTopo().getVizinhos(labirinto.getEspaco(), caminho), labirinto);
        System.out.println("nivel.size() == "+nivelAtual.size()+"---------------------------");
        //O No que eu estou usando no momento é sempre caminho.olhaTopo()
        while(!caminho.olhaTopo().equals(objetivo)){
            
            if(nivelAtual.completamenteVerificado())
                nivelAtual = nivelAtual.geraProximoNivel(caminho);
            
            caminho.adiciona(nivelAtual.proximo());
            
            try{
                executa.executa(caminho.olhaTopo(), caminho.olhaTopo().direcaoEmRelacao(caminho.penultimo()));
            }catch(IndexOutOfBoundsException e){
                throw new CaminhoInexistenteException();
            }
        }
        
        return caminho;
    }
    
}
