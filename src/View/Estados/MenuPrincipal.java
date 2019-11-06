package View.Estados;

import Components.Button;
import Components.CheckBox;
import Components.Container;
import Components.Label;
import SimpleGUI.SimpleGUI;
import Util.Action;
import Util.Dimension;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import Control.Constantes;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Lucas Barbosa
 */
public class MenuPrincipal extends BasicGameState {
    
    private StateBasedGame sbg;
    
    //private TiledMap mapa;//[e para ser um LabirirntoVisual e é para terem personagens andando no fundo
    
    private SimpleGUI gui;
    private Label lbTitulo;
    private Container painel;
    private Button btExplorar;
    private Button btConfiguracoes;
    private Button btCreditos;
    private Button btSair;

    @Override
    public int getID() {
        return Constantes.ID_MENU_PRINCIPAL;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.sbg = game;
        
        //mapa = new TiledMap("assets/labirintos/modelo0.tmx");
        
        gui = new SimpleGUI(container, Constantes.textoFont());
        
        lbTitulo = new Label("Maze Explorers");
        lbTitulo.setFont(Constantes.tituloFont());
        lbTitulo.setBackgroundColor(new Color(255, 255, 255, 0));
        lbTitulo.setForegroundColor(Color.orange);
        lbTitulo.setLocation(450, 150);
        gui.add(lbTitulo);
        
        painel = new Container(new Dimension(200, 400));
        painel.centralize(container);
        painel.setLocation(painel.getX(), 250);
        painel.setBackgroundColor(new Color(135, 206, 235, 180));
        painel.setBorderColor(new Color(135, 206, 235, 255));
        gui.add(painel);
        
        btExplorar = new Button(Constantes.substituir("mp.explorar"));
        btExplorar.setFont(Constantes.textoFont());
        //btExplorar.setBackgroundColor(Color.white);
        btExplorar.addAction(new Action(){
            @Override
            public void action() {
                sbg.enterState(Constantes.ID_ESCOLHER_TECNICA);
            }
        });
        painel.add(btExplorar);
        
        btConfiguracoes = new Button(Constantes.substituir("mp.configuracoes"));
        btConfiguracoes.setFont(Constantes.textoFont());
        //btConfiguracoes.setBackgroundColor(Color.white);
        btConfiguracoes.addAction(new Action(){
            @Override
            public void action() {
                sbg.enterState(Constantes.ID_CONFIGURACOES);
            }
        });
        painel.add(btConfiguracoes);
        
        btCreditos = new Button(Constantes.substituir("mp.creditos"));
        btCreditos.setFont(Constantes.textoFont());
        //btCreditos.setBackgroundColor(Color.white);
        btCreditos.addAction(new Action(){
            @Override
            public void action() {
                sbg.enterState(Constantes.ID_CREDITOS);
            }
        });
        painel.add(btCreditos);
        
        btSair = new Button(Constantes.substituir("mp.sair"));
        btSair.setFont(Constantes.textoFont());
        //btSair.setBackgroundColor(Color.white);
        btSair.addAction(new Action(){
            @Override
            public void action() {
                System.exit(0);
            }
        });
        painel.add(btSair);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        //mapa.render(0, 0);
        gui.renderGUI(g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        gui.checkEvents(container.getInput());
        atualizaTexto();
    }
    
    private void atualizaTexto(){//para que a alteração de idioma apareça
        btExplorar.setText(Constantes.substituir("mp.explorar"));
        btConfiguracoes.setText(Constantes.substituir("mp.configuracoes"));
        btCreditos.setText(Constantes.substituir("mp.creditos"));
        btSair.setText(Constantes.substituir("mp.sair"));
    }
    
}
