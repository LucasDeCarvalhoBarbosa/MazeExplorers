package Biblioteca.Direcoes;

/**
 *
 * @author Lucas Barbosa
 */
public abstract class Direcao {
    
    public Direcao direcaoInversa(){
        if(this instanceof DirecaoCima)
            return new DirecaoBaixo();
        
        if(this instanceof DirecaoCimaDireita)
            return new DirecaoBaixoEsquerda();
        
        if(this instanceof DirecaoDireita)
            return new DirecaoEsquerda();
        
        if(this instanceof DirecaoBaixoDireita)
            return new DirecaoCimaEsquerda();
        
        if(this instanceof DirecaoBaixo)
            return new DirecaoCima();
        
        if(this instanceof DirecaoBaixoEsquerda)
            return new DirecaoCimaDireita();
        
        if(this instanceof DirecaoEsquerda)
            return new DirecaoDireita();
        
        //só pode ser então uma DirecaoCimaEsquerda e a sua inversa é:
       return new DirecaoBaixoDireita();
    }
    
    public abstract boolean direcaoOposta(Direcao direcao);
    
    public abstract boolean direcaoQuaseOposta(Direcao direcao);
    
}
