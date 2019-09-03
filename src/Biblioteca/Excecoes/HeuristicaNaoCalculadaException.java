package Biblioteca.Excecoes;

/**
 *
 * @author Lucas Barbosa
 */
public class HeuristicaNaoCalculadaException extends RuntimeException {
    
    @Override
    public String getMessage(){
        return "A Heurística Não foi calculada para este No!";
    }
    
}
