package mazeexplorers;

import View.Interface.Creditos;
import View.Interface.EscolherTecnicas;
import View.Interface.MenuPrincipal;
import de.lessvoid.nifty.slick2d.NiftyStateBasedGame;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Lucas Barbosa
 */
public class Main extends NiftyStateBasedGame{
    
    public Main(String titulo){
        super(titulo);
    }

    public static void main(String[] args) throws SlickException {
        try{
            AppGameContainer janela = new AppGameContainer(new Main("Maze Explorers"));
            janela.setDisplayMode(800, 600, false);//true
            janela.setShowFPS(false);//false
            janela.start();
        } catch (SlickException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new MenuPrincipal());
        this.addState(new Creditos());
        this.addState(new EscolherTecnicas());
        //this.addState(new TelaLabirinto());
    }
    
}
