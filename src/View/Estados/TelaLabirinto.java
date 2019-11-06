package View.Estados;

import Biblioteca.Buscas.BuscaAStar;
import Biblioteca.Buscas.BuscaEmLargura;
import Biblioteca.Buscas.BuscaEmProfundidade;
import Biblioteca.Buscas.BuscaGulosa;
import Biblioteca.Direcoes.Direcao;
import Biblioteca.Direcoes.DirecaoBaixo;
import Biblioteca.Direcoes.DirecaoCima;
import Biblioteca.Direcoes.DirecaoDireita;
import Biblioteca.Direcoes.DirecaoEsquerda;
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
import View.Modelos;
import View.Sprite;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;

/**
 *
 * @author Lucas Barbosa
 */
public class TelaLabirinto extends BasicGameState {
        
    private StateBasedGame sbg;
    
    private LabirintoVisual labirintoVisual;
    
    private BuscaEmLargura buscaEmLargura;
    private BuscaEmProfundidade buscaEmProfundidade;
    private BuscaGulosa buscaGulosa;
    private BuscaAStar buscaAStar;
    
    private Sprite spriteBuscaLargura;
    private Sprite spriteBuscaProfundidade;
    private Sprite spriteBuscaGulosa;
    private Sprite spriteBuscaAStar;
    
    public void buscasSelecionadas(boolean largura, boolean profundidade, boolean gulosa, boolean aStar){
        LabirintoVisual labirintoVisual = null;
        try {
            Random r = new Random();
            labirintoVisual = Modelos.geraLabirinto(0);//r.nextInt(3)
        } catch (SlickException ex) {
            Logger.getLogger(TelaLabirinto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.labirintoVisual = labirintoVisual;
        
        if(largura){
            buscaEmLargura = new BuscaEmLargura(labirintoVisual.getLabirinto());
            
            Ponto p = labirintoVisual.traduzirNoParaPonto(labirintoVisual.getLabirinto().getInicio());
            Direcao d = labirintoVisual.getDirecaoInicial();
            try {
                spriteBuscaLargura = new Sprite(p, d, Sprite.BUSCA_LARGURA);
            } catch (SlickException ex) {
                Logger.getLogger(TelaLabirinto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(profundidade){
            buscaEmProfundidade = new BuscaEmProfundidade(labirintoVisual.getLabirinto());
            
            Ponto p = labirintoVisual.traduzirNoParaPonto(labirintoVisual.getLabirinto().getInicio());
            Direcao d = labirintoVisual.getDirecaoInicial();
            try {
                spriteBuscaProfundidade = new Sprite(p, d, Sprite.BUSCA_PROFUNDIDADE);
            } catch (SlickException ex) {
                Logger.getLogger(TelaLabirinto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(gulosa){
            buscaGulosa = new BuscaGulosa(labirintoVisual.getLabirinto());
            
            Ponto p = labirintoVisual.traduzirNoParaPonto(labirintoVisual.getLabirinto().getInicio());
            Direcao d = labirintoVisual.getDirecaoInicial();
            try {
                spriteBuscaGulosa = new Sprite(p, d, Sprite.BUSCA_GULOSA);
            } catch (SlickException ex) {
                Logger.getLogger(TelaLabirinto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(aStar){
            buscaAStar = new BuscaAStar(labirintoVisual.getLabirinto());
            
            Ponto p = labirintoVisual.traduzirNoParaPonto(labirintoVisual.getLabirinto().getInicio());
            Direcao d = labirintoVisual.getDirecaoInicial();
            try {
                spriteBuscaAStar = new Sprite(p, d, Sprite.BUSCA_A_STAR);
            } catch (SlickException ex) {
                Logger.getLogger(TelaLabirinto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void fecharSessao(){
        labirintoVisual = null;
        
        buscaEmLargura = null;
        buscaEmProfundidade = null;
        buscaGulosa = null;
        buscaAStar = null;
        
        spriteBuscaLargura = null;
        spriteBuscaProfundidade = null;
        spriteBuscaGulosa = null;
        spriteBuscaAStar = null;
    }

    @Override
    public int getID() {
        return Constantes.ID_TELA_LABIRINTO;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.sbg = game;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        labirintoVisual.render(0, 0);
        
        if(spriteBuscaLargura!=null){
            spriteBuscaLargura.desenha(spriteBuscaLargura.getLocalizacao().getX(), spriteBuscaLargura.getLocalizacao().getY());
            
            g.setColor(Color.white);
        g.setFont(new AngelCodeFont("assets/interface/fonts/arial14B.fnt", 
                "assets/interface/fonts/arial14B_0.png"));
        g.drawString(Constantes.substituir("lab.buscaLargura"),
                spriteBuscaLargura.getLocalizacao().getX()-15, spriteBuscaLargura.getLocalizacao().getY()-12);
        }
        
        if(spriteBuscaProfundidade!=null){
            spriteBuscaProfundidade.desenha(spriteBuscaProfundidade.getLocalizacao().getX(), spriteBuscaProfundidade.getLocalizacao().getY());
            
            g.setColor(Color.white);
        g.setFont(new AngelCodeFont("assets/interface/fonts/arial14B.fnt", 
                "assets/interface/fonts/arial14B_0.png"));
        g.drawString(Constantes.substituir("lab.buscaProfundidade"),
                spriteBuscaProfundidade.getLocalizacao().getX()-20, spriteBuscaProfundidade.getLocalizacao().getY()-12);
        }
        
        if(spriteBuscaGulosa!=null){
            spriteBuscaGulosa.desenha(spriteBuscaGulosa.getLocalizacao().getX(), spriteBuscaGulosa.getLocalizacao().getY());
            
            g.setColor(Color.white);
        g.setFont(new AngelCodeFont("assets/interface/fonts/arial14B.fnt", 
                "assets/interface/fonts/arial14B_0.png"));
        g.drawString(Constantes.substituir("lab.buscaGulosa"),
                spriteBuscaGulosa.getLocalizacao().getX()-10, spriteBuscaGulosa.getLocalizacao().getY()-12);
        }
        
        if(spriteBuscaAStar!=null){
            spriteBuscaAStar.desenha(spriteBuscaAStar.getLocalizacao().getX(), spriteBuscaAStar.getLocalizacao().getY());
            
            g.setColor(Color.white);
        g.setFont(new AngelCodeFont("assets/interface/fonts/arial14B.fnt", 
                "assets/interface/fonts/arial14B_0.png"));
        g.drawString(Constantes.substituir("lab.buscaAStar"),
                spriteBuscaAStar.getLocalizacao().getX()+5, spriteBuscaAStar.getLocalizacao().getY()-12);
        }
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
        
//        //por enquanto, depois apagar
        Input input = container.getInput();
        if(input.isKeyDown(Input.KEY_W)){
            spriteBuscaAStar.andarCima(container, delta, new DirecaoBaixo());
        }
        if(input.isKeyDown(Input.KEY_S)){
            spriteBuscaAStar.andarBaixo(container, delta, new DirecaoCima());
        }
        if(input.isKeyDown(Input.KEY_A)){
            spriteBuscaAStar.andarEsquerda(container, delta, new DirecaoDireita());
        }
        if(input.isKeyDown(Input.KEY_D)){
            spriteBuscaAStar.andarDireita(container, delta, new DirecaoEsquerda());
        }
        
    }
    
}
