package Biblioteca.Direcoes;

/**
 *
 * @author Lucas Barbosa
 */
public class DirecaoCima extends Direcao{
    
    @Override
    public String toString(){
        return "[Cima]";
    }
    
    @Override
    public boolean direcaoOposta(Direcao direcao) {
        return (direcao instanceof DirecaoBaixo);
    }

    @Override
    public boolean direcaoQuaseOposta(Direcao direcao) {
        return ((direcao instanceof DirecaoBaixo) || 
                (direcao instanceof DirecaoBaixoEsquerda) ||
                (direcao instanceof DirecaoBaixoDireita));
    }
    
}
