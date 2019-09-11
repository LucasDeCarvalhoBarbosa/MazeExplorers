package Control.Buscas;

import Biblioteca.Excecoes.HeuristicaNaoCalculadaException;
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
    
    public abstract No melhorNo(List<No> nos);
    
    public abstract int comparacao(No no1, No no2) throws HeuristicaNaoCalculadaException;
    
}
