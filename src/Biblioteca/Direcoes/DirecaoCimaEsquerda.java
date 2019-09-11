package Biblioteca.Direcoes;

/**
 *
 * @author Lucas Barbosa
 */
public class DirecaoCimaEsquerda extends Direcao{
    
    @Override
    public String toString(){
        return "[Cima e Esquerda]";
    }
    
    @Override
    public boolean direcaoOposta(Direcao direcao) {
        return (direcao instanceof DirecaoBaixoDireita);
    }

    @Override
    public boolean direcaoQuaseOposta(Direcao direcao) {
        return ((direcao instanceof DirecaoBaixoDireita) || 
                (direcao instanceof DirecaoBaixo) ||
                (direcao instanceof DirecaoDireita));
    }
    
}
