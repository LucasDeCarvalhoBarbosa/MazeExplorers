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
    
    public boolean MetodoDaMaoPodeResolver(){
        for(int i=0;i<espaco.length;i++){
            for(int j=0;j<espaco[i].length;j++){
                
                if(noSeparado(espaco[i][j], espaco[i][j].todosOsVizinhos(espaco))){
                    System.out.println("return no if");
                    return false;
                }
                
            }
        }
        System.out.println("return no final");
        return true;
    }
    
    private boolean noSeparado(No no, List<No> nos){
        if(no.isLivre()){
            return false;
        }
        
        for(int i=0;i<nos.size();i++){
            if(!nos.get(i).isLivre()){
                return true;//se pelo menos um dos nós não estiver livre, este nó não está separado.
            }
        }
        return false;
    }
    
    public double distanciaEntreNos(No no1, No no2){
        double a = no2.getLinha() - no1.getLinha();
        double b = no2.getColuna() - no1.getColuna();
     
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
    
    public int quantidadeNos(){
        return espaco.length * espaco[0].length;
    }
    
    public void liberarTudo(){
        for(int i=0;i<espaco.length;i++){
            for(int j=0;j<espaco[i].length;j++){
                espaco[i][j].setLivre(true);
            }
        }
    }
    
    public void bloquearTudo(){
        for(int i=0;i<espaco.length;i++){
            for(int j=0;j<espaco[i].length;j++){
                //if((!espaco[i][j].equals(inicio))&&(!espaco[i][j].equals(objetivo))){
                    espaco[i][j].setLivre(false);
                //}
            }
        }
    }
    
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
