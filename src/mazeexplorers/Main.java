package mazeexplorers;

import Biblioteca.Buscas.Busca;
import Biblioteca.Buscas.BuscaAStar;
import Biblioteca.Caminho;
import Biblioteca.Direcoes.Direcao;
import Biblioteca.Labirinto;
import Biblioteca.No;
import Control.Acao;
import Biblioteca.Buscas.BuscaEmLargura;
import Biblioteca.Buscas.BuscaEmProfundidade;
import Biblioteca.Buscas.BuscaGulosa;
import Control.Constantes;
import Control.Ponto;
import View.Estados.Configuracoes;
import View.Estados.Creditos;
import View.Estados.EscolherTecnicas;
import View.Estados.ExploracaoAcabou;
import View.Estados.MenuPrincipal;
import View.Estados.Pausa;
import View.Estados.TelaLabirinto;
import View.Modelos;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas Barbosa
 */
public class Main extends StateBasedGame {
    
    private static AppGameContainer janela;
    
    public Main(String name) {
        super(name);
    }
    
    public static void main(String[] args) throws SlickException {
        
        try{
            janela = new AppGameContainer(new Main("Maze Explorers"));
            janela.setDisplayMode(1280, 768, false);//true
            janela.setShowFPS(false);//false
            Constantes.carregaIdioma();
            
            janela.start();
        } catch (SlickException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static boolean noEmDiagonal(No no1, No no2){
        boolean vertical = false;
        boolean horizontal = false;
        
        if((no1.getLinha()<no2.getLinha()) || (no1.getLinha()>no2.getLinha()))
            vertical = true;
        
        if((no1.getColuna()<no2.getColuna()) || (no1.getColuna()>no2.getColuna()))
            horizontal = true;
        
        return vertical && horizontal;
    }
    
    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new MenuPrincipal());
        this.addState(new Configuracoes());
        this.addState(new Creditos());
        this.addState(new EscolherTecnicas());
        this.addState(new TelaLabirinto());
        this.addState(new Pausa());
        this.addState(new ExploracaoAcabou());
    }
    
}
