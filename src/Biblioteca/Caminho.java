package Biblioteca;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Lucas Barbosa
 */
public class Caminho {
    
    private Stack<No> caminho;
    
    private List<No> nosExcluidos;
    
    private int nosPorLinha;
    
    public Caminho(){
        this.caminho = new Stack<>();
        nosExcluidos = new ArrayList<>();
        nosPorLinha = 10;
    }
    
    public Caminho(int nosPorLinha){
        this.caminho = new Stack<>();
        nosExcluidos = new ArrayList<>();
        this.nosPorLinha = nosPorLinha;
    }
    
    public boolean jaPassou(No no){
        /*if(no.equals(caminho.get(caminho.size()-1))){
            return false;//se for o último elemento, não conta 
        }*/
        for(int i=0;i<caminho.size();i++){
            if(caminho.get(i).equals(no))
                return true;
        }
        return false;
    }
    
    public void adiciona(No no){
        this.caminho.push(no);
    }
    
    public No removeTopo()throws EmptyStackException{
        return caminho.pop();
    }
    
    public No olhaTopo()throws EmptyStackException{
        return caminho.peek();
    }
    
    public No penultimo(){
        return caminho.get(tamanho()-2);
    }
    
    public boolean isVazio(){
        return caminho.isEmpty();
    }
    
    public int tamanho(){
        return caminho.size();
    }
    
    public boolean isNoExcluido(No no){
        boolean noExcluido = false;
        for(int i=0;i<nosExcluidos.size();i++){
            noExcluido = no.equals(nosExcluidos.get(i));
        }
        return noExcluido;
    }
    
    public void adicionaNoExcluido(No no){
        if(!nosExcluidos.contains(no))
            nosExcluidos.add(no);
    }
    
    public int quantidadeNosExcluidos(){
        return nosExcluidos.size();
    }
    
    @Override
    public String toString(){
        String s = "";
        int nosLinhaAtual = 0;
        for(int i=0;i<caminho.size();i++){
            s += "("+caminho.get(i).getLinha()+", "+caminho.get(i).getColuna()+")";
            nosLinhaAtual++;
            
            if(!(i==caminho.size()-1)){//se não for o último
                s += " -> ";
            }
            if(nosLinhaAtual>=nosPorLinha){
                s += "\n";
                nosLinhaAtual = 0;
            }
        }
        return s;
    }
    
    //gets e sets
    public Stack<No> getCaminho() {
        return caminho;
    }

    public void setCaminho(Stack<No> caminho) {
        this.caminho = caminho;
    }

    public List<No> getNosExcluidos() {
        return nosExcluidos;
    }

    public void setNosExcluidos(List<No> nosExcluidos) {
        this.nosExcluidos = nosExcluidos;
    }

    public int getNosPorLinha() {
        return nosPorLinha;
    }

    public void setNosPorLinha(int nosPorLinha) {
        this.nosPorLinha = nosPorLinha;
    }
    
}
