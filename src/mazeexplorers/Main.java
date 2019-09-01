package mazeexplorers;

import Control.Configuracoes;
import Control.Traducao;
import View.Interface.TelaConfiguracoes;
import View.Interface.TelaControlaMenusSimples;
import View.Interface.TelaEscolherTecnicas;
import View.Interface.TelaLabirinto;
import de.lessvoid.nifty.slick2d.NiftyStateBasedGame;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Lucas Barbosa
 */
public class Main extends NiftyStateBasedGame{
    
    private static AppGameContainer janela;
    public static Configuracoes configuracoes;
    
    public Main(String titulo){
        super(titulo);
    }

    public static void main(String[] args) throws SlickException {
        configuracoes = new Configuracoes();
        int larguraTela = Integer.parseInt(configuracoes.getProperty("larguraTela"));
        int alturaTela = Integer.parseInt(configuracoes.getProperty("alturaTela"));
        boolean telaCheia = Boolean.parseBoolean(configuracoes.getProperty("telaCheia"));
        
        try{
            janela = new AppGameContainer(new Main("Maze Explorers"));
            janela.setDisplayMode(larguraTela, alturaTela, telaCheia);
            janela.setShowFPS(false);//false
            janela.start();
        } catch (SlickException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        Traducao traducao = new Traducao(configuracoes.getProperty("idioma"));
        
        TelaControlaMenusSimples menusSimples = new TelaControlaMenusSimples();
        menusSimples.setTraducao(traducao);//não passo pelo contrutor porque  o xml da tela vai chamar
        
        TelaEscolherTecnicas escolherTecnicas = new TelaEscolherTecnicas();
        escolherTecnicas.setTraducao(traducao);//não passo pelo contrutor porque  o xml da tela vai chamar
        
        TelaConfiguracoes telaConfigs = new TelaConfiguracoes();
        telaConfigs.setTraducao(traducao);//não passo pelo contrutor porque  o xml da tela vai chamar
        
        TelaLabirinto telaLabirinto = new TelaLabirinto();
        telaLabirinto.setTraducao(traducao);//não passo pelo contrutor porque  o xml da tela vai chamar
        
        this.addState(menusSimples);
        this.addState(escolherTecnicas);
        this.addState(telaConfigs);
        //this.addState(telaLabirinto);
    }
    
    //É só usar Main.mudaResolucao(); em configurações
    public static void mudaResolucao(int largura, int altura, boolean telaCheia){
        try {
            janela.setDisplayMode(largura, altura, telaCheia);
        } catch (SlickException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
