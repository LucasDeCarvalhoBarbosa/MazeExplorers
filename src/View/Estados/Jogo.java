package View.Estados;

import Control.Constantes;
import javax.swing.JOptionPane;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas Barbosa
 */
public class Jogo extends BasicGameState {

    @Override
    public int getID() {
        return Constantes.ID_LABIRINTO;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.green);
        g.drawString("Labirinto!", container.getWidth()/2, container.getHeight()/2);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        JOptionPane.showMessageDialog(null, "entrou!", "Jogo", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
