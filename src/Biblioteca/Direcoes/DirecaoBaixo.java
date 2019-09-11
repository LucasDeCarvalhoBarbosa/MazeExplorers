package Biblioteca.Direcoes;

/**
 *
 * @author Lucas Barbosa
 */
public class DirecaoBaixo extends Direcao{
    
    @Override
    public String toString(){
        return "[Baixo]";
    }

    @Override
    public boolean direcaoOposta(Direcao direcao) {
        return (direcao instanceof DirecaoCima);
    }

    @Override
    public boolean direcaoQuaseOposta(Direcao direcao) {
        return ((direcao instanceof DirecaoCima) || 
                (direcao instanceof DirecaoCimaEsquerda) ||
                (direcao instanceof DirecaoCimaDireita));
    }
    
}
