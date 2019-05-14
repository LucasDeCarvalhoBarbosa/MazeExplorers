package Biblioteca.Excecoes;

/**
 *
 * @author Lucas Barbosa
 */
public class InicioInvalidoException extends RuntimeException {
    
    @Override
    public String getMessage(){
        return "O nó especificado para ser o início, não é valido, "
                + "pois não está dentro do intervalo do labirinto.";
    }
    
}
