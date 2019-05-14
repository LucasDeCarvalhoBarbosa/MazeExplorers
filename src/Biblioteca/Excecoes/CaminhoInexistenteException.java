package Biblioteca.Excecoes;

/**
 *
 * @author Lucas Barbosa
 */
public class CaminhoInexistenteException extends RuntimeException {
    
    @Override
    public String getMessage(){
        return "Não existe um caminho do nó início até o nó objetivo";
    }
    
}
