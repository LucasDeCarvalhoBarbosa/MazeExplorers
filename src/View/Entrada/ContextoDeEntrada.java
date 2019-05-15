package View.Entrada;

import View.LabirintoVisual;
import org.newdawn.slick.Input;

/**
 *
 * @author Lucas Barbosa
 */
public abstract class ContextoDeEntrada {
    
    protected Input input;
    protected LabirintoVisual LabirintoVisual;
    
    public ContextoDeEntrada(Input input, LabirintoVisual LabirintoVisual){
        this.input = input;
        this.LabirintoVisual = LabirintoVisual;
    }
    
    public abstract void verificarEntrada();
    
}
