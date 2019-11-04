package View.Estados;

import Components.Button;
import Components.Container;
import Components.Label;
import SimpleGUI.SimpleGUI;
import Util.Action;
import Util.Dimension;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
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
public class Creditos extends BasicGameState {
    
    private StateBasedGame sbg;
    
    private SimpleGUI gui;
    
    private Label lbCreditos;
    private Label lbDesenvolvedores;
    private Container painel;
    private Label lbDesenvolvedor1;
    private Label lbDesenvolvedor2;
    private Button btVoltar;

    @Override
    public int getID() {
        return Constantes.ID_CREDITOS;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.sbg = game;
        
        gui = new SimpleGUI(container, Constantes.textoFont());
        
        lbCreditos = new Label(Constantes.substituir("cre.creditos"));
        lbCreditos.setFont(Constantes.tituloFont());
        lbCreditos.setLocation(500, 150);
        gui.add(lbCreditos);
        
        painel = new Container(500, 230, 0, 0);
        gui.add(painel);
        
        lbDesenvolvedores = new Label(Constantes.substituir("cre.desenvolvedores"));
        lbDesenvolvedores.setFont(Constantes.tituloFont());
        painel.add(lbDesenvolvedores);
        
        lbDesenvolvedor1 = new Label("Lucas de Carvalho Barbosa");
        lbDesenvolvedor1.setFont(Constantes.textoFont());
        painel.add(lbDesenvolvedor1);
        
        lbDesenvolvedor2 = new Label("Allysson Urias Ribeiro");
        lbDesenvolvedor2.setFont(Constantes.textoFont());
        painel.add(lbDesenvolvedor2);
        
        btVoltar = new Button(Constantes.substituir("cre.voltar"));
        btVoltar.setFont(Constantes.textoFont());
        btVoltar.setLocation(50, 650);
        btVoltar.addAction(new Action(){
            @Override
            public void action() {
                voltar();
            } 
        });
        gui.add(btVoltar);
        
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        gui.renderGUI(g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        gui.checkEvents(container.getInput());
        atualizaTexto();
        
        if(container.getInput().isKeyDown(Input.KEY_ESCAPE)){
            voltar();
        }
    }
    
    private void atualizaTexto(){
        lbCreditos.setText(Constantes.substituir("cre.creditos"));
        lbDesenvolvedores.setText(Constantes.substituir("cre.desenvolvedores"));
        btVoltar.setText(Constantes.substituir("cre.voltar"));
    }
    
    private void voltar(){
        sbg.enterState(Constantes.ID_MENU_PRINCIPAL);
    }
    
}
