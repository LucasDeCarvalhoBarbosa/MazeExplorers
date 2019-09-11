package Biblioteca.Direcoes;

/**
 *
 * @author Lucas Barbosa
 */
public class DirecaoBaixoDireita extends Direcao{
    
    @Override
    public String toString(){
        return "[Baixo e Direita]";
    }
    
    @Override
    public boolean direcaoOposta(Direcao direcao) {
        return (direcao instanceof DirecaoCimaEsquerda);
    }

    @Override
    public boolean direcaoQuaseOposta(Direcao direcao) {
        return ((direcao instanceof DirecaoCimaEsquerda) ||
                (direcao instanceof DirecaoCima)) ||
                (direcao instanceof DirecaoEsquerda);
    }
    
}
