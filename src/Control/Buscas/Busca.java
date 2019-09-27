package Control.Buscas;

import Biblioteca.Caminho;
import Biblioteca.Excecoes.CaminhoInexistenteException;
import Biblioteca.Labirinto;
import Biblioteca.No;
import Control.Acao;
import Control.ExecutaAcao;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Lucas Barbosa
 */
public abstract class Busca {
    
    protected Labirinto labirinto;
    protected No inicio;
    protected No objetivo;
    
    protected ExecutaAcao executa;
    
    public Busca(Labirinto labirinto){
        this.labirinto = labirinto;
        inicio = labirinto.getInicio();
        objetivo = labirinto.getObjetivo();
    }
    
    public abstract Caminho buscar(Acao acao) throws CaminhoInexistenteException;
    
    protected abstract No proximoPasso(No noAtual, Caminho caminho);
    
    public boolean possui(Collection<No> colecao, No no){
        Iterator iterator = colecao.iterator();
        while(iterator.hasNext()){
            if(((No) iterator.next()).equals(no))
                return true;
        }
        return false;
    }
    
    //gets e sets
    public Labirinto getLabirinto() {
        return labirinto;
    }

    public void setLabirinto(Labirinto labirinto) {
        this.labirinto = labirinto;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(No objetivo) {
        this.objetivo = objetivo;
    }
    
}
