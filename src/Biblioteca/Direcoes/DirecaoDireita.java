package Biblioteca.Direcoes;

/**
 *
 * @author Lucas Barbosa
 */
public class DirecaoDireita extends Direcao{
    
    @Override
    public String toString(){
        return "[Direita]";
    }
    
    @Override
    public boolean direcaoOposta(Direcao direcao) {
        return (direcao instanceof DirecaoEsquerda);
    }

    @Override
    public boolean direcaoQuaseOposta(Direcao direcao) {
        return ((direcao instanceof DirecaoEsquerda) || 
                (direcao instanceof DirecaoCimaEsquerda) ||
                (direcao instanceof DirecaoBaixoEsquerda));
    }
    
}
