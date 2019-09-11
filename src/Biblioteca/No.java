package Biblioteca;

import Biblioteca.Direcoes.DirecaoEsquerda;
import Biblioteca.Direcoes.DirecaoDireita;
import Biblioteca.Direcoes.DirecaoCima;
import Biblioteca.Direcoes.DirecaoBaixo;
import Biblioteca.Direcoes.Direcao;
import Biblioteca.Direcoes.DirecaoBaixoDireita;
import Biblioteca.Direcoes.DirecaoBaixoEsquerda;
import Biblioteca.Direcoes.DirecaoCimaDireita;
import Biblioteca.Direcoes.DirecaoCimaEsquerda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Barbosa
 */
public class No {
    
    private boolean livre;
    
    private int linha;
    private int coluna;
    
    private double heuristica;
    private double custoCaminho;
    
    /**
     * Gera um nó com apenas linha e coluna, portanto seu atributo livre fica 
     * vazio.
     * Ideal para informar o início ou o objetivo, por exeplo.
     * 
     * @param linha a linha que o nó pertence
     * @param coluna a coluna que o nó pertence
     */
    public No(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
        this.heuristica = -1;
    }
    
    /**
     * Gera um nó com linha, coluna e com a informação se está ou não livre.
     * 
     * @param linha a linha que o nó pertence
     * @param coluna a coluna que o nó pertence
     * @param livre se o nó pode está livre para ser atravessado
     */
    public No(int linha, int coluna, boolean livre){
        this.linha = linha;
        this.coluna = coluna;
        this.livre = livre;
        this.heuristica = -1;
    }
    
    /**
     * Retorna uma lista de nós que são vizinhos (adjacentes) a este nó, 
     * mas apenas os que estão livres.
     * 
     * @param espaco o espaco do labirinto
     * @param caminho o caminho feito até aqui.
     * @return uma lista de nós que são adjacentes e estão livres.
     */
    public List<No> getVizinhos(No[][] espaco, Caminho caminho){//por enquanto é igual ao vizinhosCima
        List<No> vizinhos = new ArrayList<>();
        
        boolean temEspacoCima = linha-1 >= 0;
        boolean temEspacoDireita = coluna+1 < espaco[coluna].length;
        boolean temEspacoBaixo = linha+1 < espaco.length;
        boolean temEspacoEsquerda = coluna-1 >= 0;
        
        if(temEspacoCima){
            No no = espaco[linha-1][coluna];
            if(isValido(no, caminho))
                vizinhos.add(no);
        }
        
        if((temEspacoCima)&&(temEspacoDireita)){
            No no = espaco[linha-1][coluna+1];
            if(isValido(no, caminho))
                vizinhos.add(no);
        }
        
        if(temEspacoDireita){
            No no = espaco[linha][coluna+1];
            if(isValido(no, caminho))
                vizinhos.add(no);
        }
        
        if((temEspacoBaixo)&&(temEspacoDireita)){
            No no = espaco[linha+1][coluna+1];
            if(isValido(no, caminho))
                vizinhos.add(no);
        }
        
        if(temEspacoBaixo){
            No no = espaco[linha+1][coluna];
            if(isValido(no, caminho))
                vizinhos.add(no);
        }
        
        if((temEspacoBaixo)&&(temEspacoEsquerda)){
            No no = espaco[linha+1][coluna-1];
            if(isValido(no, caminho))
                vizinhos.add(no);
        }
        
        if(temEspacoEsquerda){
            No no = espaco[linha][coluna-1];
            if(isValido(no, caminho))
                vizinhos.add(no);
        }
        
        if((temEspacoCima)&&(temEspacoEsquerda)){
            No no = espaco[linha-1][coluna-1];
            if(isValido(no, caminho))
                vizinhos.add(no);
        }
        
        return vizinhos;
    }
    
    private boolean isValido(No no, Caminho caminho){
//        System.out.println("\n"+no);
//        System.out.println("no.isLivre() == "+(no.isLivre()));
//        System.out.println("!caminho.jaPassou(no) == "+(!caminho.possui(no)));
//        System.out.println("(!caminho.isNoExcluido(no)) == "+(!caminho.isNoExcluido(no)));
//        System.out.println("Conclusão: ");
//        if((no.isLivre()) && (!caminho.possui(no)) && (!caminho.isNoExcluido(no))){
//            System.out.println("Válido");
//        }else System.out.println("Inválido");
        
        return ((no.isLivre()) && (!caminho.possui(no)) && (!caminho.isNoExcluido(no)));
    }
    
    public List<No> getVizinhosOpostos(No[][] espaco, Caminho caminho,No no, Direcao direcao){
        List<No> opostos = new ArrayList<>();
        List<No> vizinhos = getVizinhos(espaco, caminho);
        for(int i=0;i<vizinhos.size();i++){
            if((vizinhos.get(i).direcaoEmRelacao(no).direcaoOposta(direcao)) || 
               (vizinhos.get(i).direcaoEmRelacao(no).direcaoQuaseOposta(direcao))){
                opostos.add(vizinhos.get(i));
            }
        }
        
        return opostos;
    }
    
    public Direcao direcaoEmRelacao(No no){
        if((linha<no.getLinha())&&(coluna==no.getColuna()))
            return new DirecaoCima();
        
        if((linha<no.getLinha())&&(coluna>no.getColuna()))
            return new DirecaoCimaDireita();

        if((linha==no.getLinha())&&(coluna>no.getColuna()))
            return new DirecaoDireita();
        
        if((linha>no.getLinha())&&(coluna>no.getColuna()))
            return new DirecaoBaixoDireita();

        if((linha>no.getLinha())&&(coluna==no.getColuna()))
            return new DirecaoBaixo();
        
        if((linha>no.getLinha())&&(coluna<no.getColuna()))
            return new DirecaoBaixoEsquerda();

        if((linha==no.getLinha())&&(coluna<no.getColuna()))
            return new DirecaoEsquerda();
        
        if((linha<no.getLinha())&&(coluna<no.getColuna()))
            return new DirecaoCimaEsquerda();
        
        return new DirecaoCima();
    }
    
    public boolean temVizinhos(No[][] espaco, Caminho caminho){
        return getVizinhos(espaco, caminho).isEmpty();
    }
    
    public boolean equals(No no){
        return (this.linha==no.getLinha())&&(this.coluna==no.getColuna());
    }
    
    /**
     * Usado somente para verificações, como por exemplo, se um labirinto
     * é possível de ser solucionado com o método da mao.
     * 
     * <b>ATENÇÃO! Não use para obter os vizinhos em buscas!</b>
     * 
     * @param espaco
     * @return 
     */
    public List<No> todosOsVizinhos(No[][] espaco){
        boolean temEspacoCima = linha-1 >= 0;
        boolean temEspacoDireita = coluna+1 < espaco[coluna].length;
        boolean temEspacoBaixo = linha+1 < espaco.length;
        boolean temEspacoEsquerda = coluna-1 >= 0;
        
        List<No> todosOsVizinhos = new ArrayList<>();
        if(temEspacoCima){
            todosOsVizinhos.add(espaco[linha-1][coluna]);
        }
        if(temEspacoDireita){
            todosOsVizinhos.add(espaco[linha][coluna+1]);
        }
        if(temEspacoBaixo){
            todosOsVizinhos.add(espaco[linha+1][coluna]);
        }
        if(temEspacoEsquerda){
            todosOsVizinhos.add(espaco[linha][coluna-1]);
        }
        return todosOsVizinhos;
    }
    
    /**
     * Retorna a distância euclidiana entre este No e o No passado no parâmtro.
     * 
     * @param outro o outro No
     * @return a distância entre este No e o informado
     */
    public double distanciaEuclidiana(No outro){
        double a = outro.getLinha() - this.getLinha();
        double b = outro.getColuna() - this.getColuna();
     
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
    
    /**
     * Reporesentação customizada do No em uma String substituindo o 
     * método de java.lang.Object.
     * 
     * @return a String que erpresenta o No
     */
    @Override
    public String toString(){
        return "(linha="+linha+", coluna="+coluna+")";
    }
    
    //gets e stes
    public boolean isLivre() {
        return livre;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }
    
    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public double getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(double heuristica) {
        this.heuristica = heuristica;
    }

    public double getCustoCaminho() {
        return custoCaminho;
    }

    public void setCustoCaminho(double custoCaminho) {
        this.custoCaminho = custoCaminho;
    }
    
}
