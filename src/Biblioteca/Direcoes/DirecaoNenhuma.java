package Biblioteca.Direcoes;

/**
 *
 * @author Lucas Barbosa
 */
public class DirecaoNenhuma extends Direcao{
    
    @Override
    public String toString(){
        return "[Nenhuma]";
    }
    
    @Override
    public boolean direcaoOposta(Direcao direcao) {
        return false;
    }

    @Override
    public boolean direcaoQuaseOposta(Direcao direcao) {
        return false;
    }
    
}
