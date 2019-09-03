package View.Interface;

import Control.Constantes;
import Control.Traducao;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import de.lessvoid.nifty.slick2d.NiftyBasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas Barbosa
 */
public class TelaConfiguracoes extends NiftyBasicGameState implements ScreenController{
    
    private Nifty nifty;
    private Screen screen;
    
    private Traducao traducao;
    
    
    @Override
    protected void prepareNifty(Nifty nifty, StateBasedGame sbg) {
        
    }

    //De BasicGameState
    @Override
    public int getID() {
        return Constantes.ID_CONFIGURACOES;
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
    
    //Métodos internos

    
    //Métodos de interação
//    public void proximaTela(String proximaTela){//deve salvar as alterações e resetar as outras telas
//        nifty.gotoScreen(proximaTela);
//    }
    
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
