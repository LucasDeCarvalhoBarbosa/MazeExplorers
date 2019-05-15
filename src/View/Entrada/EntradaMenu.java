package View.Entrada;

import org.newdawn.slick.Input;

/**
 *
 * @author Lucas Barbosa
 */
public class EntradaMenu extends ContextoDeEntrada{

    public EntradaMenu(Input input, View.LabirintoVisual LabirintoVisual) {
        super(input, LabirintoVisual);
    }

    @Override
    public void verificarEntrada() {
        if(input.isKeyDown(Input.KEY_ESCAPE)){
            voltar();
        }
    }
    
    //ações
    private void voltar(){
        System.exit(0);//temporariamente
    }
    
}
