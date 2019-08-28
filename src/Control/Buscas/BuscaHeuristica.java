package Control.Buscas;

import Biblioteca.Labirinto;
import Biblioteca.No;
import java.util.List;

/**
 *
 * @author Lucas Barbosa
 */
public abstract class BuscaHeuristica extends Busca {
    
    public BuscaHeuristica(Labirinto labirinto) {
        super(labirinto);
    }
    
    protected double calculaHeuristica(No no){
        return no.distanciaEuclidiana(this.objetivo);
    }
    
    protected void atribuiHeuristica(List<No> nos){
        for(int i=0;i<nos.size();i++){
            nos.get(i).setHeuristica(calculaHeuristica(nos.get(i)));
        }
    }
    
    protected No melhorNo(List<No> nos){
        No melhor = nos.get(0);
        for(int i=0;i<nos.size();i++){
            if(nos.get(i).compareTo(melhor)>0)
                melhor = nos.get(i);
        }
        
        return melhor;
    }
    
}
