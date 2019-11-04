package Biblioteca.Buscas;

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
        
        Nivel nivelAtual = new Nivel(caminho.olhaTopo().getVizinhos(labirinto.getEspaco(), caminho), labirinto);
        
        //O No que eu estou usando no momento é sempre caminho.olhaTopo()
        while(!caminho.olhaTopo().equals(objetivo)){
            
            
            if(nivelAtual.completamenteVerificado())
                nivelAtual = nivelAtual.geraProximoNivel(caminho);
            
            No proximo = nivelAtual.proximo();//resolver, aqui nunca pode dar null
            No proximoPasso = proximoPasso(proximo, caminho);//este pode ser null
            
            if(proximoPasso!=null){//se ele é adjacente, executa normalmente
                caminho.adiciona(proximoPasso);
                
                try{
                    executa.executa(caminho.olhaTopo(), caminho.olhaTopo().direcaoEmRelacao(caminho.penultimo()));
                }catch(IndexOutOfBoundsException e){
                    throw new CaminhoInexistenteException();
                }
                
            }else{//se ele não é adjacente, deve executar, mas não adicionar no caminho
                //executa...
            }
            
        }
        
        return caminho;
    }
    
    @Override
    protected No proximoPasso(No noAtual, Caminho caminho){
        if(caminho.tamanho()>0){
            System.out.println("caminho: "+caminho);
            System.out.println("noAtual: "+noAtual);
            System.out.println("caminho.olhaTopo(): "+caminho.olhaTopo());
//            if(!noAtual.isAdjacente(caminho.olhaTopo())){
//                return null;//se os nós não forem adjacentes, deve retornar.
//            }else
                return noAtual;
        }else
            throw new CaminhoInexistenteException();
        
    }
    
}
