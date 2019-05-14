package Control.Buscas;

import Biblioteca.Caminho;
import Biblioteca.Direcoes.DirecaoCima;
import Biblioteca.Labirinto;
import Biblioteca.No;
import Control.Acao;
import Control.ExecutaAcao;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @author Lucas Barbosa
 */

public class BuscaEmLargura extends Busca{
    
    public BuscaEmLargura(Labirinto labirinto){
        super(labirinto);
    }
    
    @Override
    public Caminho buscar(Acao acao){
        executa = new ExecutaAcao(acao);
        
        Caminho caminho = new Caminho();
        caminho.adiciona(inicio);
        List<No> nosAbertos = new ArrayList<>();
        nosAbertos.add(labirinto.getInicio());
      
        while(caminho.tamanho()<=labirinto.quantidadeNos()){
            if(nosAbertos.contains(labirinto.getObjetivo())){
                caminho = adicionaAteObjetivo(caminho, nosAbertos, labirinto.getObjetivo());
                return caminho;
            }
            nosAbertos = novosVizinhos(nosAbertos, labirinto, caminho);
            
            List<No> lista = pilhaParaLista(caminho.getCaminho());
            lista = juncaoDeListas(lista, nosAbertos);
            caminho.setCaminho(listaParaPilha(lista));
            
            //Ação
            for(int i=0;i<nosAbertos.size();i++){           //talvez nãp sejam todos em relação ao penúltimo
                executa.executa(nosAbertos.get(i), nosAbertos.get(i).direcaoEmRelacao(caminho.penultimo()));
            }
            
      }
      return null;
    }
    
    /**
     * Adiciona todos os nós da lista até o objetivo. Não adiciona nenhum nó 
     * depois do objetivo ser adicionado. Se não houver o objetivo na lista, 
     * retorna nulo(null).
     * 
     * @param caminho o caminho.
     * @param nos a lista de nós.
     * @param objetivo o nó objetivo.
     * @return o caminho feito de onde ele já estava antes deste método até o 
     * nó objetivo
     */
    private Caminho adicionaAteObjetivo(Caminho caminho, List<No> nos, No objetivo){//certo
        for(int i=0;i<nos.size();i++){
            caminho.adiciona(nos.get(i));
            if(nos.get(i).equals(objetivo))
                return caminho;
        }
        return null;
    }
    
    /**
     * Retorna todos os vizinhos da lista de vizinhos.
     * @param nos a lista de nós que serão retirados os vizinhos
     * @param labirinto o labirinto
     * @param caminho o caminho para assegurar que não adicione nós duplicados.
     * @return a lista de nós que são os vizinhos dos nós passados.
     */
    private List<No> novosVizinhos(List<No> nos, Labirinto labirinto, Caminho caminho){//certo
        System.out.println("nos.size() == "+nos.size());
        List<No> novosVizinhos = new ArrayList<>();
        for(int i=0;i<nos.size();i++){
            novosVizinhos = juncaoDeListas(novosVizinhos, nos.get(i).getVizinhos(labirinto.getEspaco(), caminho));
        }
        return novosVizinhos;
    }
    
    /**
     * Junta duas listas de No em uma única lista na ordem:
     * - Todos os elementos da primeira lista.
     * - Depois todos os elementos da segunda lista.
     * 
     * Não adiciona elementos repetidos.
     * 
     * @param lista1 a primeira lista.
     * @param lista2 a segunda lista.
     * @return a lista formada pela junção.
     */
    private List<No> juncaoDeListas(List<No> lista1, List<No> lista2){//certo
        List<No> juncao = new ArrayList<>();

        for(int i=0;i<lista1.size();i++){
            if(!possui(juncao, lista1.get(i))){
                juncao.add(lista1.get(i));
            }
        }
        
        for(int i=0;i<lista2.size();i++){
            if(!possui(juncao, lista2.get(i))){
                juncao.add(lista2.get(i));
            }
        }
        return juncao;
    }
    
    private List<No> pilhaParaLista(Stack<No> pilha){
        List<No> lista = new ArrayList<>();
        for(int i=0;i<pilha.size();i++){
            lista.add(pilha.get(i));
        }
        return lista;
    }
    
    private Stack<No> listaParaPilha(List<No> lista){
        Stack<No> pilha = new Stack<>();
        for(int i=0;i<lista.size();i++){
            pilha.push(lista.get(i));
        }
        return pilha;
    }
    
}