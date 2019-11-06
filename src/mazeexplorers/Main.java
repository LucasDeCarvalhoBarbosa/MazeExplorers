package mazeexplorers;

import Biblioteca.Caminho;
import Biblioteca.Direcoes.Direcao;
import Biblioteca.Labirinto;
import Biblioteca.No;
import Control.Acao;
import Biblioteca.Buscas.BuscaEmLargura;
import Biblioteca.Buscas.BuscaEmProfundidade;
import Biblioteca.Buscas.BuscaGulosa;
import Control.Constantes;
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
        
//        try{
//            janela = new AppGameContainer(new Main("Maze Explorers"));
//            janela.setDisplayMode(1280, 768, true);//true
//            janela.setShowFPS(false);//false
//            Constantes.carregaIdioma();
//            
//            janela.start();
//        } catch (SlickException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }

//int[][] tiles = { new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
//                                  new int[]{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,},
//                                  new int[]{0,1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,},
//                                  new int[]{0,1,0,0,1,0,0,1,1,1,1,0,0,1,1,1,1,0,1,0,1,0,0,1,0,0,0,1,0,0,1,1,1,0,1,1,1,0,1,0,},
//                                  new int[]{0,1,1,1,1,1,0,1,0,1,0,0,1,1,0,0,1,0,1,0,1,0,1,1,1,1,1,1,1,0,0,0,1,0,1,0,0,0,1,0,},
//                                  new int[]{0,1,0,0,0,0,0,1,0,1,1,1,1,0,0,1,1,1,1,0,1,0,0,0,0,1,0,0,1,1,1,0,1,1,1,1,1,1,1,0,},
//                                  new int[]{0,1,0,1,1,1,1,1,0,0,1,0,0,0,1,1,0,0,1,0,1,0,0,1,1,1,1,0,0,0,1,0,0,1,1,0,0,0,1,0,},
//                                  new int[]{0,1,1,1,0,0,0,0,0,1,1,0,0,0,1,0,0,0,1,0,1,0,0,1,0,0,1,1,1,0,1,0,0,0,1,1,1,0,1,0,},
//                                  new int[]{0,1,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,1,0,0,1,0,0,0,1,0,1,0,0,1,0,0,1,0,},
//                                  new int[]{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,},
//                                  new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
//                                  new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
//                                  new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
//                                  new int[]{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,},
//                                  new int[]{0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,1,0,},
//                                  new int[]{0,1,0,1,0,0,1,0,1,1,1,0,0,1,1,1,0,0,1,0,1,0,1,1,1,1,1,1,1,1,0,0,0,1,0,1,0,0,1,0,},
//                                  new int[]{0,1,0,1,1,0,1,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,1,0,0,0,1,0,0,1,1,1,1,1,1,1,1,0,1,0,},
//                                  new int[]{0,1,0,0,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,1,1,0,1,1,0,0,0,0,1,0,1,0,1,0,},
//                                  new int[]{0,1,0,0,0,0,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,0,0,0,1,1,1,1,0,0,0,0,0,1,0,},
//                                  new int[]{0,1,0,1,1,1,0,0,1,0,1,0,1,1,0,1,0,0,1,0,1,0,1,1,1,1,1,1,0,1,0,0,1,1,1,1,1,0,1,0,},
//                                  new int[]{0,1,0,0,1,0,0,1,1,1,1,0,0,1,1,1,1,0,1,0,1,0,0,0,1,0,0,1,1,1,0,0,1,0,0,0,1,0,1,0,},
//                                  new int[]{0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,},
//                                  new int[]{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,},
//                                  new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,}};
//                
//        No inicio = new No(11, 0);
//        No objetivo = new No(11, 39);   
//        Labirinto labirinto = new Labirinto(tiles, inicio, objetivo);
//        
//        BuscaGulosa busca = new BuscaGulosa(labirinto);//falta arrumar a em largura
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
