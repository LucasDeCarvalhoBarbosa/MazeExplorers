package Biblioteca;

import Biblioteca.Excecoes.InicioInvalidoException;
import Biblioteca.Excecoes.ObjetivoInvalidoException;
import Biblioteca.No;
import java.util.List;

/**
 *
 * @author Lucas Barbosa
 */
public class Labirinto {
    
    private No[][] espaco;
    private No inicio;
    private No objetivo;
    
    public Labirinto(No[][] espaco, No inicio, No objetivo) throws InicioInvalidoException, ObjetivoInvalidoException{
        this.espaco = espaco;
        this.inicio = inicio;
        this.objetivo = objetivo;
        
        if((inicio.getLinha()<0)||(inicio.getLinha()>espaco.length)||
            (inicio.getColuna()<0)||(inicio.getColuna()>espaco[0].length)){
            throw new InicioInvalidoException();
        }
        if((objetivo.getLinha()<0)||(objetivo.getLinha()>espaco.length)||
            (objetivo.getColuna()<0)||(objetivo.getColuna()>espaco[0].length)){
            throw new ObjetivoInvalidoException();
        }
    }
    
    /**
     * Com este Construtor, se pode usar uma matriz de int com <b>0s</b> e <b>1s</b> no lugar 
     * de uma matriz de nó.<br>
     * Sendo:<br>
     * 0: No bloqueado<br>
     * 1: No livre<br>
     * Exemplo de utilização:<br>
     * <hr>
     * int[][] matriz = new int[][]{<br>
     * new int[]{0, 1, 0},<br>
     * new int[]{0, 1, 1},<br>
     * new int[]{1, 0, 1}<br>
     * }
     * Labirinto labirinto = new Labirinto(matriz, new No(0, 1), new No(2, 2));<hr>
     * 
     * @param matriz a matriz de int com 0 e 1s (int[][])
     * @param inicio o No que será usado como início
     * @param objetivo o No que será usado como objetivo(saída do labirinto)
     * @throws InicioInvalidoException
     * @throws ObjetivoInvalidoException 
     */
    public Labirinto(int[][] matriz, No inicio, No objetivo) throws InicioInvalidoException, ObjetivoInvalidoException{
        this.espaco = geraEspaco(matriz);
        this.inicio = inicio;
        this.objetivo = objetivo;
        
        if((inicio.getLinha()<0)||(inicio.getLinha()>espaco.length)||
            (inicio.getColuna()<0)||(inicio.getColuna()>espaco[0].length)){
            throw new InicioInvalidoException();
        }
        if((objetivo.getLinha()<0)||(objetivo.getLinha()>espaco.length)||
            (objetivo.getColuna()<0)||(objetivo.getColuna()>espaco[0].length)){
            throw new ObjetivoInvalidoException();
        }
    }
    
    /**
     * Este método faz a tradução de uma matriz de 0s e 1s (onde 0 é bloqueado 
     * e 1 é livre) para uma matriz de No que poderá ser usada pelo Labirinto.
     * 
     * @param matriz a matriz de 0s e 1s que será traduzida
     * @return uma matriz de No.
     */
    private No[][] geraEspaco(int[][] matriz){
        No[][] espaco = new No[matriz.length][matriz[0].length];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                espaco[i][j] = new No(i, j, (matriz[i][j]==1));//se for igual a 1 é true, senão é false
            }
        }
        
        return espaco;
    }
    
    /**
     * Retora a quantidade de nós o labirinto possui.
     * 
     * @return a quantidade de nós
     */
    public int quantidadeNos(){
        return espaco.length * espaco[0].length;
    }
    
    /**
     * Deixa todos os nós do labirinto como livres, ou seja, com livre igual 
     * a true.
     */
    public void liberarTudo(){
        for(int i=0;i<espaco.length;i++){
            for(int j=0;j<espaco[i].length;j++){
                espaco[i][j].setLivre(true);
            }
        }
    }
    
    /**
     * Deixa todos os nós do labirinto como bloqueados, ou seja, com livre igual
     * a false.
     * 
     */
    public void bloquearTudo(){
        for(int i=0;i<espaco.length;i++){
            for(int j=0;j<espaco[i].length;j++){
                //if((!espaco[i][j].equals(inicio))&&(!espaco[i][j].equals(objetivo))){
                    espaco[i][j].setLivre(false);
                //}
            }
        }
    }
    
    /**
     * Reporesentação customizada do labirinto em uma string substituindo o 
     * método de java.lang.Object.
     * O B é begin, ou início.
     * O E é end, ou fim.
     * O 0 é um No bloqueado.
     * O 1 é um No livre.
     * 
     * @return a String que representa o labirinto
     */
    @Override
    public String toString(){
        String labirinto = "";
        for(int i=0;i<espaco.length;i++){
            for(int j=0;j<espaco[i].length;j++){
                boolean jaEscreveu = false;
                if(espaco[i][j].equals(inicio)){
                    labirinto += "B ";//Begin
                    jaEscreveu = true;
                }
                if(espaco[i][j].equals(objetivo)){
                    labirinto += "E ";//End
                    jaEscreveu = true;
                }
                
                if(jaEscreveu==false)
                if(espaco[i][j].isLivre()){
                    labirinto += "1 ";
                }else labirinto += "0 ";
            }
            labirinto += "\n";
        }
        return labirinto;
    }
    
    //gets e sets
    public No[][] getEspaco() {
        return espaco;
    }

    public void setEspaco(No[][] espaco) {
        this.espaco = espaco;
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
