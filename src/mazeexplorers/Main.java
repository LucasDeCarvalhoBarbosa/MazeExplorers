package mazeexplorers;

import Biblioteca.Caminho;
import Biblioteca.Direcoes.Direcao;
import Biblioteca.Direcoes.DirecaoBaixo;
import Biblioteca.Direcoes.DirecaoCima;
import Biblioteca.Direcoes.DirecaoDireita;
import Biblioteca.Direcoes.DirecaoEsquerda;
import Biblioteca.Labirinto;
import Biblioteca.No;
import Control.Acao;
import Control.Buscas.BuscaAStar;
import Control.Buscas.BuscaEmLargura;
import Control.Buscas.BuscaEmProfundidade;
import Control.Buscas.BuscaGulosa;
import Control.Configuracoes;
import Control.Traducao;
import View.Estados.EstadoJogo;
import View.Estados.EstadoMenu;
import View.Estados.Jogo;
import de.lessvoid.nifty.slick2d.NiftyStateBasedGame;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    
    private static Main unica;
    
    private Main(String titulo){
        super(titulo);
    }
    
    public static Main getInstance(){
        if(unica==null){
            unica = new Main("Maze Explorers");
        }
        
        return unica;
    }
    
    

    public static void main(String[] args) throws SlickException {
//        configuracoes = new Configuracoes();
//        int larguraTela = Integer.parseInt(configuracoes.getProperty("larguraTela"));
//        int alturaTela = Integer.parseInt(configuracoes.getProperty("alturaTela"));
//        boolean telaCheia = Boolean.parseBoolean(configuracoes.getProperty("telaCheia"));
//        
//        try{
//            janela = new AppGameContainer(new Main("Maze Explorers"));
//            janela.setDisplayMode(larguraTela, alturaTela, telaCheia);
//            janela.setShowFPS(false);//false
//            
//            
//            janela.start();
//        } catch (SlickException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }


        int[][] matriz = {new int[]{0, 0, 0, 0, 0, 0, 0, 0},
                          new int[]{1, 0, 0, 0, 1, 1, 1, 1},
                          new int[]{0, 1, 1, 1, 1, 0, 0, 0},
                          new int[]{0, 1, 1, 0, 1, 1, 1, 0},
                          new int[]{0, 1, 0, 1, 0, 1, 1, 0},
                          new int[]{0, 1, 0, 0, 1, 0, 0, 0},
                          new int[]{0, 1, 1, 1, 1, 1, 0, 0},
                          new int[]{0, 0, 0, 0, 0, 0, 1, 0},
        };
        
        No inicio = new No(1, 0);
        No objetivo = new No(7, 6);
        Labirinto labirinto = new Labirinto(matriz, inicio, objetivo);
        System.out.println(labirinto);
        
        BuscaEmLargura busca = new BuscaEmLargura(labirinto);//falta arrumar a em largura
        Caminho caminho = busca.buscar(new Acao(){
            @Override
            public void acao(No no, Direcao direcao) {
                System.out.println(no+" "+direcao);
            }
        });
        
        System.out.println("\n\n\n"+caminho);
        System.out.println(labirinto);

    }
    
    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        Traducao traducao = new Traducao(configuracoes.getProperty("idioma"));
        
        EstadoMenu menu = new EstadoMenu();
        menu.setAplicacao(this);//não passo pelo construtor porque  o xml da tela vai chamar
        menu.setTraducao(traducao);
        
//        EstadoJogo jogo = new EstadoJogo();
//        jogo.setTraducao(traducao);//não passo pelo construtor porque  o xml da tela vai chamar
        
        this.addState(menu);
        //this.addState(jogo);
        
        Jogo jogo = new Jogo();
        this.addState(jogo);
    }
    
    public void mudaEstado(int idEstado){
        this.enterState(idEstado);
        JOptionPane.showMessageDialog(null, "Total de estados: "+this.getStateCount()+"\nestado atual: "+this.getCurrentStateID());
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
