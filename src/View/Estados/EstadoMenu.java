package View.Estados;

import Control.Constantes;
import Control.Traducao;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import de.lessvoid.nifty.slick2d.NiftyBasicGameState;
import de.lessvoid.nifty.slick2d.NiftyStateBasedGame;
import javax.swing.JOptionPane;
import mazeexplorers.Main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas Barbosa
 */
public class EstadoMenu extends NiftyBasicGameState implements ScreenController{

    private Main aplicacao;
    private Traducao traducao;
    
    private Nifty nifty;
    private Screen screen;
    
    private StateBasedGame sbg;
    

    @Override
    protected void prepareNifty(Nifty nifty, StateBasedGame sbg) {
        Constantes.carregarNifty(nifty);
    }
    
    //De BasicGameState
    @Override
    public int getID() {
        return Constantes.ID_MENU;
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
    
    @Override
    protected void updateGame(GameContainer gc, StateBasedGame sbg, int delta){
        this.sbg = sbg;
        System.out.println("sbg: "+sbg);
    }
    
    //Métodos de interação
    public void sair(){
       System.exit(0);
    }
    
    public void proximaTela(String proximaTela){
        JOptionPane.showMessageDialog(null, "sbg: "+sbg);
        JOptionPane.showMessageDialog(null, "nifty: "+nifty);
        if(proximaTela.equals("TelaLabirinto")){
            
            //Main.getInstance().mudaEstado(2);
            sbg.enterState(2);
        }else
            nifty.gotoScreen(proximaTela);
    }
    
    public String traduz(String key){
        return Traducao.traduz(key);
    }
    
    //gets e sets
    public Main getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(Main aplicacao) {
        this.aplicacao = aplicacao;
    }

    public Traducao getTraducao() {
        return traducao;
    }

    public void setTraducao(Traducao traducao) {
        this.traducao = traducao;
    }
    
}
