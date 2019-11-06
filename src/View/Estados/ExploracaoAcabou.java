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
public class ExploracaoAcabou extends BasicGameState {
    
    private int nosBuscaLargura = 0;
    private int nosBuscaProfundidade = 0;
    private int nosBuscaGulosa = 0;
    private int nosBuscaAStar = 0;
    
    private StateBasedGame sbg;
    
    private SimpleGUI gui;
    
    private Label lbTitulo;
    private Container pnBuscas;
    
    private Container pnBuscaLargura;
    private Label lbBuscaLargura;
    private Label lbResultadoBuscaLargura;//quantos nós foram percorridos
    
    private Container pnBuscaProfundidade;
    private Label lbBuscaProfundidade;
    private Label lbResultadoBuscaProfundidade;
    
    private Container pnBuscaGulosa;
    private Label lbBuscaGulosa;
    private Label lbResultadoBuscaGulosa;
    
    private Container pnBuscasAStar;
    private Label lbBuscaAStar;
    private Label lbResultadoBuscaAStar;
    
    private Button btMenuPrincipal;

    @Override
    public int getID() {
        return Constantes.ID_EXPLORACAO_ACABOU;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.sbg = game;
        
        gui = new SimpleGUI(container, Constantes.textoFont());
        
        lbTitulo = new Label(Constantes.substituir("exAcabou.fim"));
        lbTitulo.setFont(Constantes.tituloFont());
        lbTitulo.setLocation(450, 150);
        gui.add(lbTitulo);
        
        pnBuscas = new Container(500, 230, 0, 0);
        gui.add(pnBuscas);
        
        //Busca em Largura
        pnBuscaLargura = new Container(500, 230, 0, 0);
        pnBuscaLargura.setBorderColor(pnBuscaLargura.getBackgroundColor());
        pnBuscaLargura.setAlignment(Container.HORIZONTAL_ALIGNMENT);
        pnBuscas.add(pnBuscaLargura);
        
        lbBuscaLargura = new Label(Constantes.substituir("exAcabou.buscaLargura"));
        lbBuscaLargura.setFont(Constantes.textoFont());
        pnBuscaLargura.add(lbBuscaLargura);
        
        lbResultadoBuscaLargura = new Label(nosBuscaLargura+"");
        lbResultadoBuscaLargura.setFont(Constantes.textoFont());
        pnBuscaLargura.add(lbResultadoBuscaLargura);
        
        //Busca em Profundidade
        pnBuscaProfundidade = new Container(500, 230, 0, 0);
        pnBuscaProfundidade.setBorderColor(pnBuscaLargura.getBackgroundColor());
        pnBuscaProfundidade.setAlignment(Container.HORIZONTAL_ALIGNMENT);
        pnBuscas.add(pnBuscaProfundidade);
        
        lbBuscaProfundidade = new Label(Constantes.substituir("exAcabou.buscaProfundidade"));
        lbBuscaProfundidade.setFont(Constantes.textoFont());
        pnBuscaProfundidade.add(lbBuscaProfundidade);
        
        lbResultadoBuscaProfundidade = new Label(nosBuscaProfundidade+"");
        lbResultadoBuscaProfundidade.setFont(Constantes.textoFont());
        pnBuscaProfundidade.add(lbResultadoBuscaProfundidade);
        
        //Busca Gulosa
        pnBuscaGulosa = new Container(500, 230, 0, 0);
        pnBuscaGulosa.setBorderColor(pnBuscaLargura.getBackgroundColor());
        pnBuscaGulosa.setAlignment(Container.HORIZONTAL_ALIGNMENT);
        pnBuscas.add(pnBuscaGulosa);
        
        lbBuscaGulosa = new Label(Constantes.substituir("exAcabou.buscaGulosa"));
        lbBuscaGulosa.setFont(Constantes.textoFont());
        pnBuscaGulosa.add(lbBuscaGulosa);
        
        lbResultadoBuscaGulosa = new Label(nosBuscaGulosa+"");
        lbResultadoBuscaGulosa.setFont(Constantes.textoFont());
        pnBuscaGulosa.add(lbResultadoBuscaGulosa);
        
        //Busca A*
        pnBuscasAStar = new Container(500, 230, 0, 0);
        pnBuscasAStar.setBorderColor(pnBuscaLargura.getBackgroundColor());
        pnBuscasAStar.setAlignment(Container.HORIZONTAL_ALIGNMENT);
        pnBuscas.add(pnBuscasAStar);
        
        lbBuscaAStar = new Label(Constantes.substituir("exAcabou.buscaAStar"));
        lbBuscaAStar.setFont(Constantes.textoFont());
        pnBuscasAStar.add(lbBuscaAStar);
        
        lbResultadoBuscaAStar = new Label(nosBuscaAStar+"");
        lbResultadoBuscaAStar.setFont(Constantes.textoFont());
        pnBuscasAStar.add(lbResultadoBuscaAStar);
        
        btMenuPrincipal = new Button(Constantes.substituir("exAcabou.menuPrincipal"));
        btMenuPrincipal.setFont(Constantes.textoFont());
        btMenuPrincipal.setLocation(530, 550);
        btMenuPrincipal.addAction(new Action(){
            @Override
            public void action() {
                voltar();
            }
        });
        gui.add(btMenuPrincipal);
        
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
        lbTitulo.setText(Constantes.substituir("exAcabou.fim"));
        lbBuscaLargura.setText(Constantes.substituir("exAcabou.buscaLargura"));
        lbBuscaProfundidade.setText(Constantes.substituir("exAcabou.buscaProfundidade"));
        lbBuscaGulosa.setText(Constantes.substituir("exAcabou.buscaGulosa"));
        lbBuscaAStar.setText(Constantes.substituir("exAcabou.buscaAStar"));
        btMenuPrincipal.setText(Constantes.substituir("exAcabou.menuPrincipal"));
        
        //atualizando os placares
        lbResultadoBuscaLargura.setText(nosBuscaLargura+"");
        lbResultadoBuscaProfundidade.setText(nosBuscaProfundidade+"");
        lbResultadoBuscaGulosa.setText(nosBuscaGulosa+"");
        lbResultadoBuscaAStar.setText(nosBuscaAStar+"");
    }
    
    private void voltar(){
        ((TelaLabirinto) sbg.getState(Constantes.ID_TELA_LABIRINTO)).fecharSessao();
        sbg.enterState(Constantes.ID_MENU_PRINCIPAL);
    }
    
    //gets e sets
    public int getNosBuscaLargura() {
        return nosBuscaLargura;
    }

    public void setNosBuscaLargura(int nosBuscaLargura) {
        this.nosBuscaLargura = nosBuscaLargura;
    }

    public int getNosBuscaProfundidade() {
        return nosBuscaProfundidade;
    }

    public void setNosBuscaProfundidade(int nosBuscaProfundidade) {
        this.nosBuscaProfundidade = nosBuscaProfundidade;
    }

    public int getNosBuscaGulosa() {
        return nosBuscaGulosa;
    }

    public void setNosBuscaGulosa(int nosBuscaGulosa) {
        this.nosBuscaGulosa = nosBuscaGulosa;
    }

    public int getNosBuscaAStar() {
        return nosBuscaAStar;
    }

    public void setNosBuscaAStar(int nosBuscaAStar) {
        this.nosBuscaAStar = nosBuscaAStar;
    }
    
    
}
