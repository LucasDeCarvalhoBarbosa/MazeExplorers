package View.Estados;

import Biblioteca.Buscas.BuscaAStar;
import Biblioteca.Buscas.BuscaEmLargura;
import Biblioteca.Buscas.BuscaEmProfundidade;
import Biblioteca.Buscas.BuscaGulosa;
import Biblioteca.Direcoes.Direcao;
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
import java.io.File;
import java.util.List;
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
    
    private Sprite spriteBuscaLargura;
    private Sprite spriteBuscaProfundidade;
    private Sprite spriteBuscaGulosa;
    private Sprite spriteBuscaAStar;
    
    public void buscasSelecionadas(boolean largura, boolean profundidade, boolean gulosa, boolean aStar){
        LabirintoVisual labirintoVisual = null;
        try {
            Random r = new Random();
            labirintoVisual = Modelos.geraLabirinto(r.nextInt(3));//r.nextInt(3)
        } catch (SlickException ex) {
            Logger.getLogger(TelaLabirinto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.labirintoVisual = labirintoVisual;
        
        
        if(largura){
            Ponto p = Constantes.traduzirNoParaPonto(labirintoVisual.getLabirinto().getInicio());
            Direcao d = labirintoVisual.getDirecaoInicial();
            try {
                spriteBuscaLargura = new Sprite(p, d, new BuscaEmLargura(labirintoVisual.getLabirinto()), sbg.getContainer());
            } catch (SlickException ex) {
                Logger.getLogger(TelaLabirinto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            spriteBuscaLargura.start();
        }
        
        if(profundidade){
            Ponto p = Constantes.traduzirNoParaPonto(labirintoVisual.getLabirinto().getInicio());
            Direcao d = labirintoVisual.getDirecaoInicial();
            try {
                spriteBuscaProfundidade = new Sprite(p, d, new BuscaEmProfundidade(labirintoVisual.getLabirinto()), sbg.getContainer());
            } catch (SlickException ex) {
                Logger.getLogger(TelaLabirinto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            spriteBuscaProfundidade.start();
        }
        
        if(gulosa){
            Ponto p = Constantes.traduzirNoParaPonto(labirintoVisual.getLabirinto().getInicio());
            Direcao d = labirintoVisual.getDirecaoInicial();
            try {
                spriteBuscaGulosa = new Sprite(p, d, new BuscaGulosa(labirintoVisual.getLabirinto()), sbg.getContainer());
            } catch (SlickException ex) {
                Logger.getLogger(TelaLabirinto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            spriteBuscaGulosa.start();
        }
        
        if(aStar){  
            Ponto p = Constantes.traduzirNoParaPonto(labirintoVisual.getLabirinto().getInicio());
            Direcao d = labirintoVisual.getDirecaoInicial();
            try {
                spriteBuscaAStar = new Sprite(p, d, new BuscaAStar(labirintoVisual.getLabirinto()), sbg.getContainer());
            } catch (SlickException ex) {
                Logger.getLogger(TelaLabirinto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            spriteBuscaAStar.start();
        }
    }
    
    public void fecharSessao(){
        labirintoVisual = null;
        
        spriteBuscaLargura = null;
        spriteBuscaProfundidade = null;
        spriteBuscaGulosa = null;
        spriteBuscaAStar = null;
    }
    
    public void atualizaDeltaSprites(int delta){
        if(spriteBuscaLargura!=null){
            spriteBuscaLargura.setDelta(delta);
        }
        if(spriteBuscaProfundidade!=null){
            spriteBuscaProfundidade.setDelta(delta);
        }
        if(spriteBuscaGulosa!=null){
            spriteBuscaGulosa.setDelta(delta);
        }
        if(spriteBuscaAStar!=null){
            spriteBuscaAStar.setDelta(delta);
        }
    }
    
    public void verificaTodosEncontraram(){
        if(todosEncontraramObjetivo()){//se todos já encontrarm o objetivo
            ExploracaoAcabou acabou = (ExploracaoAcabou) sbg.getState(Constantes.ID_EXPLORACAO_ACABOU);
            
            if(spriteBuscaLargura!=null){
                List<String> linhas = spriteBuscaLargura.getCaminho().caminhoParaListString();
                Constantes.escreveArquivo(new File("resultado_busca_largura.txt"), linhas);
                
                acabou.setNosBuscaLargura(spriteBuscaLargura.getNosPercorridos());
            }else
                acabou.setNosBuscaLargura(0);
            
            if(spriteBuscaProfundidade!=null){
                List<String> linhas = spriteBuscaProfundidade.getCaminho().caminhoParaListString();
                Constantes.escreveArquivo(new File("resultado_busca_gulosa.txt"), linhas);
                
                acabou.setNosBuscaProfundidade(spriteBuscaProfundidade.getNosPercorridos());
            }else
                acabou.setNosBuscaProfundidade(0);
            
            if(spriteBuscaGulosa!=null){
                List<String> linhas = spriteBuscaGulosa.getCaminho().caminhoParaListString();
                Constantes.escreveArquivo(new File("resultado_busca_gulosa.txt"), linhas);
                
                acabou.setNosBuscaGulosa(spriteBuscaGulosa.getNosPercorridos());
            }else
                acabou.setNosBuscaGulosa(0);
            
            if(spriteBuscaAStar!=null){
                List<String> linhas = spriteBuscaAStar.getCaminho().caminhoParaListString();
                Constantes.escreveArquivo(new File("resultado_busca_gulosa.txt"), linhas);
                
                acabou.setNosBuscaAStar(spriteBuscaAStar.getNosPercorridos());
            }else acabou.setNosBuscaAStar(0);
            
            sbg.enterState(Constantes.ID_EXPLORACAO_ACABOU);
        }
    }
    
    private boolean todosEncontraramObjetivo(){
        boolean largura = false;
        boolean profundidade = false;
        boolean gulosa = false;
        boolean aStar = false;
        
        if(spriteBuscaLargura==null)
            largura = true;
        else
            largura = spriteBuscaLargura.isEncontrouObjetivo();
        
        if(spriteBuscaProfundidade==null)
            profundidade = true;
        else profundidade = spriteBuscaProfundidade.isEncontrouObjetivo();
        
        if(spriteBuscaGulosa==null)
            gulosa = true;
        else gulosa = spriteBuscaGulosa.isEncontrouObjetivo();
        
        if(spriteBuscaAStar==null)
            aStar = true;
        else aStar = spriteBuscaAStar.isEncontrouObjetivo();

        return largura && profundidade && gulosa && aStar;
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
        
        atualizaDeltaSprites(delta);
        
        verificaTodosEncontraram();
    }
    
}
