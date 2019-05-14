package Biblioteca.Excecoes;

/**
 *
 * @author Lucas Barbosa
 */
public class ObjetivoInvalidoException extends RuntimeException {
    
    @Override
    public String getMessage(){
        return "O nó especificado para ser o objetivo, não é valido, "
                + "pois não está dentro do intervalo do labirinto.";
    }
    
}
