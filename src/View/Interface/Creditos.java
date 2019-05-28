package View.Interface;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import de.lessvoid.nifty.slick2d.NiftyBasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas Barbosa
 */
public class Creditos extends NiftyBasicGameState implements ScreenController{
    
    private Nifty nifty;
    private Screen screen;
    
//    public Creditos(Nifty nifty){
//        this.nifty = nifty;
//    }
    
    @Override
    protected void prepareNifty(Nifty nifty, StateBasedGame sbg) {
        Constantes.carregarNifty(nifty);
    }
    
    @Override
    public int getID() {
        return Constantes.idCreditos;
    }

    @Override
    public void bind(Nifty nifty, Screen screen) {
        this.nifty = nifty;
        this.screen = screen;
    }

    @Override
    public void onStartScreen() {
    }

    @Override
    public void onEndScreen() {
    }
    
    //Métodos de interação
    public void voltar(){
        nifty.gotoScreen("start");
    }
    
}
