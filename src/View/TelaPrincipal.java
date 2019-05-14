package View;

import Biblioteca.Direcoes.DirecaoDireita;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Lucas Barbosa
 */
public class TelaPrincipal extends BasicGame{
    
    private LabirintoVisual labirintoVisual;
    private Sprite sprite;

    public TelaPrincipal(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        labirintoVisual = Modelos.geraLabirinto(3);
        sprite = new Sprite(new DirecaoDireita());
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    }
    
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        labirintoVisual.mapa.render(0, 0);
        //sprite.desenha(32, 32);
    }
    
}
