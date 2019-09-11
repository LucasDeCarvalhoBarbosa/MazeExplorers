package Biblioteca.Direcoes;

/**
 *
 * @author Lucas Barbosa
 */
public class DirecaoBaixoEsquerda extends Direcao{
    
    @Override
    public String toString(){
        return "[Baixo e Esquerda]";
    }
    
    @Override
    public boolean direcaoOposta(Direcao direcao) {
        return (direcao instanceof DirecaoCimaDireita);
    }

    @Override
    public boolean direcaoQuaseOposta(Direcao direcao) {
        return ((direcao instanceof DirecaoCimaDireita) ||
                (direcao instanceof DirecaoCima) ||
                (direcao instanceof DirecaoDireita));
    }
    
}
