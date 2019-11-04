package View.Estados;

import Components.Button;
import Components.CheckBox;
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
public class EscolherTecnicas extends BasicGameState {
    
    private StateBasedGame sbg;
    
    private SimpleGUI gui;
    
    private Label lbTitulo;
    private Container pnBuscas;
    
    private CheckBox cbBuscaLargura;
    private CheckBox cbBuscaProfundidade;
    private CheckBox cbBuscaGulosa;
    private CheckBox cbBuscaAStar;
    
    private Button btVoltar;
    private Button btConfirmar;

    @Override
    public int getID() {
        return Constantes.ID_ESCOLHER_TECNICA;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.sbg = game;
        
        gui = new SimpleGUI(container, Constantes.textoFont());
        
        lbTitulo = new Label(Constantes.substituir("tec.escolha"));
        lbTitulo.setFont(Constantes.tituloFont());
        lbTitulo.setLocation(450, 150);
        gui.add(lbTitulo);
        
        pnBuscas = new Container(500, 230, 0, 0);
        gui.add(pnBuscas);
        
        cbBuscaLargura = new CheckBox(0, 0, 50, 30, Constantes.substituir("tec.buscaLargura"));
        cbBuscaLargura.setFont(Constantes.textoFont());
        pnBuscas.add(cbBuscaLargura);
        
        cbBuscaProfundidade = new CheckBox(0, 0, 50, 30, Constantes.substituir("tec.buscaProfundidade"));
        cbBuscaProfundidade.setFont(Constantes.textoFont());
        pnBuscas.add(cbBuscaProfundidade);
        
        cbBuscaGulosa = new CheckBox(0, 0, 50, 30, Constantes.substituir("tec.buscaGulosa"));
        cbBuscaGulosa.setFont(Constantes.textoFont());
        pnBuscas.add(cbBuscaGulosa);
        
        cbBuscaAStar = new CheckBox(0, 0, 50, 30, Constantes.substituir("tec.buscaAStar"));
        cbBuscaAStar.setFont(Constantes.textoFont());
        pnBuscas.add(cbBuscaAStar);
        
        btVoltar = new Button(Constantes.substituir("tec.voltar"));
        btVoltar.setFont(Constantes.textoFont());
        btVoltar.setLocation(50, 650);
        btVoltar.addAction(new Action(){
            @Override
            public void action() {
                voltar();
            } 
        });
        gui.add(btVoltar);
        
        btConfirmar = new Button(Constantes.substituir("tec.confirmar"));
        btConfirmar.setFont(Constantes.textoFont());
        btConfirmar.setLocation(1000, 650);
        btConfirmar.addAction(new Action(){
            @Override
            public void action() {
                explorar();
            }
        });
        gui.add(btConfirmar);
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
        if(container.getInput().isKeyDown(Input.KEY_ENTER)){
            explorar();
        }
    }
    
    private void atualizaTexto(){
        lbTitulo.setText(Constantes.substituir("tec.escolha"));
        cbBuscaLargura.setText(Constantes.substituir("tec.buscaLargura"));
        cbBuscaProfundidade.setText(Constantes.substituir("tec.buscaProfundidade"));
        cbBuscaGulosa.setText(Constantes.substituir("tec.buscaGulosa"));
        cbBuscaAStar.setText(Constantes.substituir("tec.buscaAStar"));
        btVoltar.setText(Constantes.substituir("tec.voltar"));
        btConfirmar.setText(Constantes.substituir("tec.confirmar"));
    }
    
    private void voltar(){
        sbg.enterState(Constantes.ID_MENU_PRINCIPAL);
    }
    
    private void explorar(){
        if((cbBuscaLargura.isSelected())||(cbBuscaProfundidade.isSelected())||
                        (cbBuscaGulosa.isSelected())||(cbBuscaAStar.isSelected())){
            sbg.enterState(Constantes.ID_TELA_LABIRINTO);
        }
    }
    
}
