package Biblioteca.Buscas;

import Biblioteca.Caminho;
import Biblioteca.Labirinto;
import Biblioteca.No;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Barbosa
 */
public class Nivel {
        
    private List<No> nos;
    private Labirinto labirinto;
    
    private int contador;

    public Nivel(List<No> nos, Labirinto labirinto){
        this.nos = nos;
        this.labirinto = labirinto;
        this.contador = 0;
    }

    /**
     * Gera o próximo Nivel a partir deste.
     * 
     * @param caminho o caminho que está percorrendo.
     * @param origem oNo que é a origem do Labirinto, ou seja, o início
     * @return o próximo nível.
     */
    public Nivel geraProximoNivel(Caminho caminho){
        //apagar
        System.out.println("\n\n"+this+"\n");
        No origem = labirinto.getInicio();

        List<No> lista = new ArrayList<>();

        for(int i=0;i<nos.size();i++){

            List<No> vizinhos = nos.get(i).getVizinhosOpostos(labirinto.getEspaco(),
                    caminho, nos.get(i), origem.direcaoEmRelacao(nos.get(i)));
            
            for(int j=0;j<vizinhos.size();j++){
                //System.out.println("vizinho #"+i+" "+vizinhos.get(j));
                if((!lista.contains(vizinhos.get(j))) && (!nos.contains(vizinhos.get(j))))
                    lista.add(vizinhos.get(j));
            }

        }

        Nivel proximoNivel = new Nivel(lista, labirinto);
        //proximoNivel.labirinto = labirinto;
        return proximoNivel;
    }

    /**
     * Retorna No que está na posição informada.
     * 
     * @param i a posição que deseja obter o No.
     * @return o No que está na possição informada.
     */
    public No get(int i){
        return nos.get(i);
    }

    /**
     * Retorna o próximo No do Nivel, o No escolhido é que tiver o índice do contador.<br>
     * Obs: retorna null, se não houver um próximo.
     * 
     * @return o próximo No.
     */
    public No proximo(){
        if(contador<nos.size()){
            No no = nos.get(contador);
            contador++;
            return no;
        }
        
        return null;
    }
    
    /**
     * Retorna se o nivel já foi verificado completamente usando o método próximo.
     * 
     * @return true se já foram verificados todos os nós e, do contrário, retorna false.
     */
    public boolean completamenteVerificado(){
        //return contador == nos.size();
        if(contador==nos.size())
            return true;
        
        return nos.get(contador) == null;
    }

    /**
     * A quantidade de nós (No) que o Nivel possui.
     * 
     * @return o tamanho do nível.
     */
    public int size(){
        return nos.size();
    }

    /**
     * Retorna se o Nivel está vazio, ou seja, com nenhum No.
     * 
     * @return true se o size for 0 e, do contrário, false
     */
    public boolean isEmpty(){
        return nos.isEmpty();
    }

    /**
     * Representação do nível em X e O, onde:<br>
     * X: um No que pertence ao Nivel.<br>
     * O: um No que <b>não</b> pertence ao Nivel.
     * 
     * @return 
     */
    @Override
    public String toString(){
        String s = "";
        for(int i=0;i<labirinto.getEspaco().length;i++){
            for(int j=0;j<labirinto.getEspaco()[i].length;j++){

                if(nos.contains(labirinto.getEspaco()[i][j]))
                    s += "X  ";
                else
                    s += "O  ";

            }
            s += "\n";
        }

        return s;
    }
        
}
