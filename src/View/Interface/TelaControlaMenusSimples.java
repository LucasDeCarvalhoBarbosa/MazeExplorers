package View.Interface;

import Control.Constantes;
import Control.Traducao;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import de.lessvoid.nifty.slick2d.NiftyBasicGameState;
import static mazeexplorers.Main.configuracoes;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas Barbosa
 */
public class TelaControlaMenusSimples extends NiftyBasicGameState implements ScreenController{

    private Nifty nifty;
    private Screen screen;
    
    private Traducao traducao;
    

    @Override
    protected void prepareNifty(Nifty nifty, StateBasedGame sbg) {
        Constantes.carregarNifty(nifty);
    }
    
    //De BasicGameState
    @Override
    public int getID() {
        return Constantes.ID_CONTROLA_MENUS_SIMPLES;
    }
    
    //De ScreenController
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
