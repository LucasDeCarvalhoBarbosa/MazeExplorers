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



//        int[][] tiles = {new int[]{1,0,1,0,1,},
//                         new int[]{1,1,1,1,1,},
//                         new int[]{0,0,1,0,0,},
//                         new int[]{0,1,1,1,0,},
//                         new int[]{0,0,1,0,0,},
//        };
//        No inicio = new No(0, 2);
//        No objetivo = new No(4, 2);
//        Labirinto labirinto = new Labirinto(tiles, inicio, objetivo);
//        
//        Busca busca1 = new BuscaEmLargura(labirinto);
//        Busca busca2 = new BuscaEmProfundidade(labirinto);
//        Busca busca3 = new BuscaGulosa(labirinto);
//        Busca busca4 = new BuscaAStar(labirinto);
//        
//        System.out.println(busca1);
//        System.out.println(busca2);
//        System.out.println(busca3);
//        System.out.println(busca4);

//        Ponto ponto = new Ponto(64, 0);
//        System.out.println(ponto+" : "+Constantes.traudzirPontoParaNo(ponto));

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
