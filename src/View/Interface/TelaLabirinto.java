package View.Interface;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import de.lessvoid.nifty.slick2d.NiftyBasicGameState;
import de.lessvoid.nifty.slick2d.NiftyOverlayGameState;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas Barbosa
 */
public class TelaLabirinto extends NiftyOverlayGameState implements ScreenController{
    
    private Nifty nifty;
    private Screen screen;
    
    private boolean rodando;
    
    public TelaLabirinto(){
        rodando = true;
    }
    

    @Override
    protected void enterState(GameContainer gc, StateBasedGame sbg) {
    }

    @Override
    protected void initGameAndGUI(GameContainer gc, StateBasedGame sbg) {
    }

    @Override
    protected void leaveState(GameContainer gc, StateBasedGame sbg) {
    }

    @Override
    protected void renderGame(GameContainer gc, StateBasedGame sbg, Graphics grphcs) {
    }

    @Override
    protected void updateGame(GameContainer gc, StateBasedGame sbg, int i) {
    }

    @Override
    protected void prepareNifty(Nifty nifty, StateBasedGame sbg) {
    }

    @Override
    public int getID() {
        return Constantes.idTelaLabirinto;
    }

    @Override
    public void mouseWheelMoved(int change) {
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
    }

    @Override
    public void mousePressed(int button, int x, int y) {
    }

    @Override
    public void mouseReleased(int button, int x, int y) {
    }

    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
    }

    @Override
    public void mouseDragged(int oldx, int oldy, int newx, int newy) {
    }

    @Override
    public void setInput(Input input) {
    }

    @Override
    public boolean isAcceptingInput() {
        return rodando;
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }

    @Override
    public void keyPressed(int key, char c) {
    }

    @Override
    public void keyReleased(int key, char c) {
    }

    @Override
    public void controllerLeftPressed(int controller) {
    }

    @Override
    public void controllerLeftReleased(int controller) {
    }

    @Override
    public void controllerRightPressed(int controller) {
    }

    @Override
    public void controllerRightReleased(int controller) {
    }

    @Override
    public void controllerUpPressed(int controller) {
    }

    @Override
    public void controllerUpReleased(int controller) {
    }

    @Override
    public void controllerDownPressed(int controller) {
    }

    @Override
    public void controllerDownReleased(int controller) {
    }

    @Override
    public void controllerButtonPressed(int controller, int button) {
    }

    @Override
    public void controllerButtonReleased(int controller, int button) {
    }

    @Override
    public void bind(Nifty nifty, Screen screen) {
    }

    @Override
    public void onStartScreen() {
    }

    @Override
    public void onEndScreen() {
    }
    
    //Métodos de interação
    public void voltar(){//temporário
        nifty.gotoScreen("start");
    }
    
}
