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
        nosPorLinha = 12;
    }
    
    /**
     * Retorna true se o no informado já foi percorrido no Caminho, e do 
     * contrário, retorna false.
     * 
     * @param no o nó que será testado
     * @return true se o caminho tiver este nó e do contrário, retorna false.
     */
    public boolean possui(No no){
        /*if(no.equals(caminho.get(caminho.size()-1))){
            return false;//se for o último elemento, não conta 
        }*/
        for(int i=0;i<caminho.size();i++){
            if(caminho.get(i).equals(no))
                return true;
        }
        
        return false;
    }
    
    public int getCusto() {
        int custo = 0;
        for(int i=0;i<caminho.size();i++){
            custo += caminho.get(i).getCustoCaminho();
        }
        
        return custo;
    }
    
    /**
     * Adiciona o No passado por parâmtro no Caminho.
     * 
     * @param no o nó que será adicionado ao Caminho.
     */
    public void adiciona(No no){
        this.caminho.push(no);
    }
    
    /**
     * Remove o No que está no topo da pilha do Caminho, ou seja, o último No 
     * que foi adiciona ao Caminho.
     * 
     * @return o No removido do Caminho.
     * @throws EmptyStackException Se o Caminho estiver vazio será lançada uma 
     * exceção
     */
    public No removeTopo()throws EmptyStackException{
        return caminho.pop();
    }
    
    /**
     * Retorna o No que está no topo do da pilha do Caminho, ou seja o último No
     * que foi adiicionado.
     * 
     * @return o No do topo
     * @throws EmptyStackException 
     */
    public No olhaTopo()throws EmptyStackException{
        return caminho.peek();
    }
    
    /**
     * Retorna o penúltimo No do caminho, ou seja, o No que foi adicionao antes 
     * do último No que foi adionado.
     * 
     * @return o penúltimo No do caminho.
     */
    public No penultimo(){
        return caminho.get(tamanho()-2);
    }
    
    /**
     * Retorna true se o caminho estiver vaizio, ou seja, não tiver nenhum No.
     * 
     * @return true se estiver vazio e do contrário, retorna false.
     */
    public boolean isVazio(){
        return caminho.isEmpty();
    }
    
    /**
     * Retorna o tamanho do caminho, ou seja, quantos Nos o caminho possui.
     * 
     * @return o tamanho do Caminho.
     */
    public int tamanho(){
        return caminho.size();
    }
    
    /**
     * Retorna true se um No já foi excluído do Caminho e do caontrário, 
     * retorna false.
     * 
     * @param no o No que deverá ser verificado se foi excluído.
     * @return true se o No já foi excluido pelo caminho e, do contrário, 
     * retorna false
     */
    public boolean isNoExcluido(No no){
        boolean noExcluido = false;
        for(int i=0;i<nosExcluidos.size();i++){
            if(no.equals(nosExcluidos.get(i)))
                return true;
        }
        
        return noExcluido;
    }
    
    /**
     * Adiciona um nó para a lista de Nos que foram excluídos do Caminho.
     * 
     * @param no o No que será adicionado a lista de Nos excluídos.
     */
    public void adicionaNoExcluido(No no){
        if(!nosExcluidos.contains(no))
            nosExcluidos.add(no);
    }
    
    /**
     * Retorna a quantidaed de Nos excluídos, ou seja, quantos Nos possui a 
     * lista de Nos excluídos.
     * 
     * @return a quantidade de Nos excluídos
     */
    public int quantidadeNosExcluidos(){
        return nosExcluidos.size();
    }
    
    /**
     * Retorna o No da lista de nós excluídos na posição informada.
     * 
     * @param i a posição do No que se deseja obter.
     * @return o No na posição informada.
     */
    public No getNoExcluido(int i){
        return nosExcluidos.get(i);
    }
    
    /**
     * Coloca o No passado na posição infirmada na lista de nós excluídos.
     * @param i a posição que o nó deve ser colocado
     * @param no o nó que se deseja colocar na lista de nós excluídos.
     */
    public void setNoExcluido(int i, No no){
        nosExcluidos.set(i, no);
    }
    
    /**
     * Reporesentação customizada do Caminho em uma String substituindo o 
     * método de java.lang.Object.
     * 
     * @return a String que erpresenta Caminho
     */
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
            if(nosLinhaAtual>=nosPorLinha){//se for o último
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
