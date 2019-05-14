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
public class BuscaEmProfundidade extends Busca{
    
    public BuscaEmProfundidade(Labirinto labirinto){
        super(labirinto);
    }
    
    
    @Override
    public Caminho buscar(Acao acao){
        executa = new ExecutaAcao(acao);
        
        Caminho caminho = new Caminho();
        caminho.adiciona(inicio);
        No noAtual = inicio;
        
        /*&&(!(caminho.quantidadeNosExcluidos()==labirinto.quantidadeNos()))*/
        while((!noAtual.equals(objetivo))&&(!caminho.getCaminho().empty())){
            //!possui(caminho.getCaminho(), proximoPasso)
            System.out.println("no atual : "+noAtual);
            System.out.println("caminho:");
            for(int i=0;i<caminho.getCaminho().size();i++){
                System.out.println("\t"+caminho.getCaminho().get(i));
            }
            
            No proximoPasso = proximoPasso(noAtual, caminho);
            if(proximoPasso!=null){
                caminho.adiciona(proximoPasso);
            }else{
                if(caminho.getCaminho().size()>0)
                    caminho.removeTopo();
            }
            
            if((caminho.getCaminho().size()>0))
                noAtual = caminho.olhaTopo();
            
            //System.out.println("proximo passo: ("+noAtual.getLinha()+", "+noAtual.getColuna()+")");
            
            //Ação
            executa.executa(caminho.olhaTopo(), caminho.olhaTopo().direcaoEmRelacao(caminho.penultimo()));
        }
        return caminho;
    }
    
    private No proximoPasso(No noAtual, Caminho caminho){
        List<No> vizinhos = noAtual.todosOsVizinhos(labirinto.getEspaco());
        for(int i=0;i<vizinhos.size();i++){
            if((!caminho.isNoExcluido(vizinhos.get(i)))&&(!caminho.jaPassou(vizinhos.get(i)))){
                if(vizinhos.get(i).isLivre())
                    return vizinhos.get(i);
            }
        }
        caminho.adicionaNoExcluido(noAtual);
        return null;//caminho.removeTopo();//se eu não tenho mais nenhum vizinho válido, eu volto
    }
    
}
