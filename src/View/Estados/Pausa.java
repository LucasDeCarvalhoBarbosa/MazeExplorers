package View.Estados;

import Components.Button;
import Components.Container;
import Components.Label;
import SimpleGUI.SimpleGUI;
import Util.Action;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import Control.Constantes;

/**
 *
 * @author Lucas Barbosa
 */
public class Pausa extends BasicGameState {
    
    private StateBasedGame sbg;
    
    private SimpleGUI gui;
    
    private Label lbTitulo;
    private Container painel;
    private Button btMenuPrincipal;
    private Button btRetomar;

    @Override
    public int getID() {
        return Constantes.ID_PAUSA;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.sbg = game;
        
        gui = new SimpleGUI(container, Constantes.textoFont());
        
        lbTitulo = new Label(Constantes.substituir("pausa.exploracaoPausada"));
        lbTitulo.setFont(Constantes.textoFont());
        lbTitulo.setLocation(500, 170);
        gui.add(lbTitulo);
        
        painel = new Container(500, 230, 0, 0);
        gui.add(painel);
        
        btRetomar = new Button(Constantes.substituir("pausa.retornar"));
        btRetomar.setFont(Constantes.textoFont());
        btRetomar.addAction(new Action(){
            @Override
            public void action() {
                retomar();
            }
        });
        painel.add(btRetomar);
        
        btMenuPrincipal = new Button(Constantes.substituir("pausa.menuPrincipal"));
        btMenuPrincipal.setFont(Constantes.textoFont());
        btMenuPrincipal.addAction(new Action(){
            @Override
            public void action() {
                voltarMenuPrincipal();
            }
        });
        painel.add(btMenuPrincipal);
   }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        gui.renderGUI(g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        gui.checkEvents(container.getInput());
        atualizaTexto();
        
//        if(container.getInput().isKeyDown(Input.KEY_ESCAPE)){
//            retomar();
//        }
    }
    
    private void atualizaTexto(){
        lbTitulo.setText(Constantes.substituir("pausa.exploracaoPausada"));
        btMenuPrincipal.setText(Constantes.substituir("pausa.menuPrincipal"));
        btRetomar.setText(Constantes.substituir("pausa.retornar"));
    }
    
    private void retomar(){
        sbg.enterState(Constantes.ID_TELA_LABIRINTO);
    }
    
    private void voltarMenuPrincipal(){
        ((TelaLabirinto) sbg.getState(Constantes.ID_TELA_LABIRINTO)).fecharSessao();
        sbg.enterState(Constantes.ID_MENU_PRINCIPAL);
    }
    
}
