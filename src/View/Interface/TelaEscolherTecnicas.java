package View.Interface;

import Control.Constantes;
import Control.Traducao;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import de.lessvoid.nifty.slick2d.NiftyBasicGameState;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas Barbosa
 */
public class TelaEscolherTecnicas extends NiftyBasicGameState implements ScreenController{
    
    private Nifty nifty;
    private Screen screen;
    
    private Traducao traducao;
    
    
    @Override
    protected void prepareNifty(Nifty nifty, StateBasedGame sbg) {
        
    }
    
    @Override
    public int getID() {
        return Constantes.ID_ESCOLHER_TECNICAS;
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
    public void proximaTela(String proximaTela){
        nifty.gotoScreen(proximaTela);
    }
    
    public String traduz(String key){
        return Traducao.traduz(key);
    }
    
    //gets e sets
    public Traducao getTraducao() {
        return traducao;
    }

    public void setTraducao(Traducao traducao) {
        this.traducao = traducao;
    }
    
}