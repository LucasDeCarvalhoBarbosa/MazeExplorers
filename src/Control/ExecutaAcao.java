package Control;

import Biblioteca.Direcoes.Direcao;
import Control.Acao;
import Biblioteca.No;

/**
 * 
 * @author Lucas Barbosa
 */

public class ExecutaAcao {
    
    Acao acao;
    
    public ExecutaAcao(Acao acao){
        this.acao = acao;
    }
    
    public void executa(No no, Direcao direcao){
        acao.acao(no, direcao);
    }
}
