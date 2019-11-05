package View.Estados;

import Biblioteca.Direcoes.DirecaoDireita;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import Control.Constantes;
import Control.Ponto;
import View.LabirintoVisual;
import View.Sprite;

/**
 *
 * @author Lucas Barbosa
 */
public class TelaLabirinto extends BasicGameState {
        
    private StateBasedGame sbg;
    
//    private LabirintoVisual labirintoVisual;
    private Sprite sprite;
    
    private TiledMap mapa;

    @Override
    public int getID() {
        return Constantes.ID_TELA_LABIRINTO;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.sbg = game;
        
        mapa = new TiledMap("assets/labirintos/modelo1.tmx");
        sprite = new Sprite(new Ponto(10, 10), new DirecaoDireita(), Sprite.BUSCA_A_STAR);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        mapa.render(0, 0);
        sprite.desenha(sprite.getLocalizacao().getX(), sprite.getLocalizacao().getY());
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if(container.getInput().isKeyDown(Input.KEY_ESCAPE)){
            sbg.enterState(Constantes.ID_PAUSA);
        }
        
        //por enquanto, depois apagar
        if(container.getInput().isKeyDown(Input.KEY_SPACE)){
            ExploracaoAcabou acabou = (ExploracaoAcabou) sbg.getState(Constantes.ID_EXPLORACAO_ACABOU);
            acabou.setNosBuscaLargura(15);
            acabou.setNosBuscaProfundidade(17);
            acabou.setNosBuscaGulosa(10);
            acabou.setNosBuscaAStar(9);
            
            sbg.enterState(Constantes.ID_EXPLORACAO_ACABOU);
        }
        
    }
    
}
