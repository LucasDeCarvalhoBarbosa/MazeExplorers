package View.Interface;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.Menu;
import de.lessvoid.nifty.controls.MenuItemActivatedEvent;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import de.lessvoid.nifty.slick2d.NiftyBasicGameState;
import de.lessvoid.nifty.tools.SizeValue;
import org.bushe.swing.event.EventTopicSubscriber;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas Barbosa
 */
public class MenuPrincipal extends NiftyBasicGameState implements ScreenController{

    private Nifty nifty;
    private Screen screen;
    

    @Override
    protected void prepareNifty(Nifty nifty, StateBasedGame sbg) {
        Constantes.carregarNifty(nifty);
    }
    
    @Override
    public int getID() {
        return Constantes.idMenuPrincipal;
    }
    
    @Override
    public void renderGame(GameContainer gc, StateBasedGame sbg, Graphics g){
        
    }
    
    @Override
    protected void updateGame(GameContainer gc, StateBasedGame sbg, int i) {
        
    }
    
    @Override
    public void enterState(GameContainer gc, StateBasedGame sbg){
        
    }
    
    @Override
    public void leaveState(GameContainer gc, StateBasedGame sbg){
        
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
    public void sair(){
       System.exit(0);
    }
    
    public void proximaTela(String proximaTela){
        nifty.gotoScreen(proximaTela);
    }
    
}
