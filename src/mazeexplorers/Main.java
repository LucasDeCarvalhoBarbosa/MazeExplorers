package mazeexplorers;

import Biblioteca.Caminho;
import Biblioteca.Direcoes.Direcao;
import Biblioteca.Labirinto;
import Biblioteca.No;
import Control.Acao;
import Biblioteca.Buscas.BuscaEmLargura;
import View.Estados.Configuracoes;
import View.Estados.Creditos;
import View.Estados.EscolherTecnicas;
import View.Estados.ExploracaoAcabou;
import View.Estados.MenuPrincipal;
import View.Estados.Pausa;
import View.Estados.TelaLabirinto;
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
            janela.setDisplayMode(1280, 768, true);//true
            janela.setShowFPS(false);//false
            
            
            janela.start();
        } catch (SlickException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }


//        int[][] matriz = {new int[]{0, 0, 0, 0, 0, 0, 0, 0},
//                          new int[]{1, 0, 0, 0, 1, 1, 1, 1},
//                          new int[]{0, 1, 1, 1, 1, 0, 0, 0},
//                          new int[]{0, 1, 1, 0, 1, 1, 1, 0},
//                          new int[]{0, 1, 0, 1, 0, 1, 1, 0},
//                          new int[]{0, 1, 0, 0, 1, 0, 0, 0},
//                          new int[]{0, 1, 1, 1, 1, 1, 0, 0},
//                          new int[]{0, 0, 0, 0, 0, 0, 1, 0},
//        };
//        
//        No inicio = new No(1, 0);
//        No objetivo = new No(7, 6);
//        Labirinto labirinto = new Labirinto(matriz, inicio, objetivo);
//        System.out.println(labirinto);
//        
//        BuscaEmLargura busca = new BuscaEmLargura(labirinto);//falta arrumar a em largura
//        Caminho caminho = busca.buscar(new Acao(){
//            @Override
//            public void acao(No no, Direcao direcao) {
//                System.out.println(no+" "+direcao);
//            }
//        });
//        
//        System.out.println("\n\n\n"+caminho);
//        System.out.println(labirinto);

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
