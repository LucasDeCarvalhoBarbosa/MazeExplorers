package Biblioteca.Direcoes;

/**
 *
 * @author Lucas Barbosa
 */
public class DirecaoEsquerda extends Direcao{
    
    @Override
    public String toString(){
        return "[Esquerda]";
    }
    
    @Override
    public boolean direcaoOposta(Direcao direcao) {
        return (direcao instanceof DirecaoDireita);
    }

    @Override
    public boolean direcaoQuaseOposta(Direcao direcao) {
        return ((direcao instanceof DirecaoDireita) || 
                (direcao instanceof DirecaoCimaDireita) ||
                (direcao instanceof DirecaoBaixoDireita));
    }
    
}
