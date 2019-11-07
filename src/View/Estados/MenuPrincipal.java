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
import java.util.Random;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Lucas Barbosa
 */
public class MenuPrincipal extends BasicGameState {
    
    private StateBasedGame sbg;
    
    private TiledMap tiledMap;
    
    private SimpleGUI gui;
    private Label lbTitulo;
    private Container painel;
    private Button btExplorar;
    private Button btConfiguracoes;
    private Button btCreditos;
    private Button btSair;
    
    private TiledMap escolheMapaAleatorio() throws SlickException{
        Random r = new Random();
        switch(r.nextInt(4)){
            case 0:
                return new TiledMap("assets/labirintos/modelo0.tmx");
                
            case 1:
                return new TiledMap("assets/labirintos/modelo2.tmx");
                
            case 2:
                return new TiledMap("assets/labirintos/modelo2.tmx");
                
            default:
                return new TiledMap("assets/labirintos/modelo3.tmx");
        }
    }

    @Override
    public int getID() {
        return Constantes.ID_MENU_PRINCIPAL;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.sbg = game;
        
        tiledMap = escolheMapaAleatorio();
        
        gui = new SimpleGUI(container, Constantes.textoFont());
        
        lbTitulo = new Label("Maze Explorers");
        lbTitulo.setFont(Constantes.mazeExplorersFont());
        lbTitulo.setBackgroundColor(new Color(255, 255, 255, 0));
        lbTitulo.setForegroundColor(Color.orange);
        lbTitulo.setLocation(470, 150);
        gui.add(lbTitulo);
        
        painel = new Container(new Dimension(200, 400));
        painel.centralize(container);
        painel.setLocation(painel.getX(), 250);
        painel.setBackgroundColor(new Color(135, 206, 235, 180));
        painel.setBorderColor(new Color(135, 206, 235, 255));
        gui.add(painel);
        
        btExplorar = new Button(Constantes.substituir("mp.explorar"));
        btExplorar.setFont(Constantes.textoFont());
        btExplorar.setBackgroundColor(new Color(200, 200, 200));
        btExplorar.addAction(new Action(){
            @Override
            public void action() {
                sbg.enterState(Constantes.ID_ESCOLHER_TECNICA);
            }
        });
        painel.add(btExplorar);
        
        btConfiguracoes = new Button(Constantes.substituir("mp.configuracoes"));
        btConfiguracoes.setFont(Constantes.textoFont());
        btConfiguracoes.setBackgroundColor(new Color(200, 200, 200));
        btConfiguracoes.addAction(new Action(){
            @Override
            public void action() {
                sbg.enterState(Constantes.ID_CONFIGURACOES);
            }
        });
        painel.add(btConfiguracoes);
        
        btCreditos = new Button(Constantes.substituir("mp.creditos"));
        btCreditos.setFont(Constantes.textoFont());
        btCreditos.setBackgroundColor(new Color(200, 200, 200));
        btCreditos.addAction(new Action(){
            @Override
            public void action() {
                sbg.enterState(Constantes.ID_CREDITOS);
            }
        });
        painel.add(btCreditos);
        
        btSair = new Button(Constantes.substituir("mp.sair"));
        btSair.setFont(Constantes.textoFont());
        btSair.setBackgroundColor(new Color(200, 200, 200));
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
        tiledMap.render(0, 0);
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
    
    //gets e sets
    public TiledMap getTiledMap() {
        return tiledMap;
    }

    public void setTiledMap(TiledMap tiledMap) {
        this.tiledMap = tiledMap;
    }
    
}
