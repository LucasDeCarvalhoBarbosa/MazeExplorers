package View.Estados;

import Components.Button;
import Components.Container;
import Components.Label;
import Components.RadioButton;
import SimpleGUI.SimpleGUI;
import Util.Action;
import Util.ButtonGroup;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import Control.Constantes;
import static Control.Constantes.idiomaAtual;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Lucas Barbosa
 */
public class Configuracoes extends BasicGameState {
    
    private StateBasedGame sbg;
    
    private TiledMap tiledMap;
    
    private SimpleGUI gui;
    
    private Label lbConfiguracoes;
    private Container pnIdiomas;
    private ButtonGroup grupoIdioma;
    private RadioButton rbPortugues;
    private RadioButton rbIngles;
    private RadioButton rbEspanhol;
    private Button btVoltar;

    @Override
    public int getID() {
        return Constantes.ID_CONFIGURACOES;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.sbg = game;
        
        tiledMap = ((MenuPrincipal) sbg.getState(Constantes.ID_MENU_PRINCIPAL)).getTiledMap();
        
        gui = new SimpleGUI(container, Constantes.textoFont());
        
        lbConfiguracoes = new Label(Constantes.substituir("conf.titulo"));
        lbConfiguracoes.setFont(Constantes.tituloFont());
        lbConfiguracoes.setLocation(480, 150);
        gui.add(lbConfiguracoes);
        
        pnIdiomas = new Container(500, 230, 0, 0);
        pnIdiomas.setBackgroundColor(new Color(135, 206, 235, 180));
        gui.add(pnIdiomas);
        
        rbPortugues = new RadioButton(0, 0, 50, 30, Constantes.substituir("conf.portugues"));
        rbPortugues.setFont(Constantes.textoFont());
        if(Constantes.idiomaAtual.equals("pt")){
            rbPortugues.setSelected(true);
        }
        pnIdiomas.add(rbPortugues);
        
        rbIngles = new RadioButton(0, 0, 50, 30, Constantes.substituir("conf.ingles"));
        rbIngles.setFont(Constantes.textoFont());
        if(Constantes.idiomaAtual.equals("en")){
            rbIngles.setSelected(true);
        }
        pnIdiomas.add(rbIngles);
        
        rbEspanhol = new RadioButton(0, 0, 50, 30, Constantes.substituir("conf.espanhol"));
        rbEspanhol.setFont(Constantes.textoFont());
        if(!rbPortugues.isSelected() && !rbIngles.isSelected()){
            rbEspanhol.setSelected(true);
        }
        pnIdiomas.add(rbEspanhol);
        
        grupoIdioma = new ButtonGroup();
        grupoIdioma.addRadioButton(rbPortugues);
        grupoIdioma.addRadioButton(rbIngles);
        grupoIdioma.addRadioButton(rbEspanhol);
        
        btVoltar = new Button(Constantes.substituir("conf.voltar"));
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
        tiledMap.render(0, 0);
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
        lbConfiguracoes.setText(Constantes.substituir("conf.titulo"));
        rbPortugues.setText(Constantes.substituir("conf.portugues"));
        rbIngles.setText(Constantes.substituir("conf.ingles"));
        rbEspanhol.setText(Constantes.substituir("conf.espanhol"));
        btVoltar.setText(Constantes.substituir("conf.voltar"));
    }
    
    private void voltar(){
        if(rbPortugues.isSelected()){
            Constantes.idiomaAtual = "pt";
            
        }else if(rbIngles.isSelected()){
            Constantes.idiomaAtual = "en";
        }else
            Constantes.idiomaAtual = "es";
        
        salvarIdioma();
        sbg.enterState(Constantes.ID_MENU_PRINCIPAL);
    }
    
    private void salvarIdioma(){
        Properties propriedades = new Properties();
        try {
            FileInputStream file = new FileInputStream("assets/interface/configuracoes/config.properties");
            propriedades.load(file);
            propriedades.setProperty("idioma", idiomaAtual);
            
            FileOutputStream output = new FileOutputStream("assets/interface/configuracoes/config.properties");
            propriedades.store(output, "");
        } catch (IOException ex) {
            //Logger.getLogger(Configuracoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
