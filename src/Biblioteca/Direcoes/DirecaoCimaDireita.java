package Biblioteca.Direcoes;

/**
 *
 * @author Lucas Barbosa
 */
public class DirecaoCimaDireita extends Direcao{
    
    @Override
    public String toString(){
        return "[Cima e Direita]";
    }
    
    @Override
    public boolean direcaoOposta(Direcao direcao) {
        return (direcao instanceof DirecaoBaixoEsquerda);
    }

    @Override
    public boolean direcaoQuaseOposta(Direcao direcao) {
        return ((direcao instanceof DirecaoBaixoEsquerda) || 
                (direcao instanceof DirecaoBaixo) ||
                (direcao instanceof DirecaoEsquerda));
    }
    
}
