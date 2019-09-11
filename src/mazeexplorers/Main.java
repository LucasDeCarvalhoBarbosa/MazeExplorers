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
import Control.Buscas.BuscaEmLargura;
import Control.Buscas.BuscaEmProfundidade;
import Control.Buscas.BuscaGulosa;
import Control.Configuracoes;
import Control.Traducao;
import View.Interface.TelaConfiguracoes;
import View.Interface.TelaControlaMenusSimples;
import View.Interface.TelaEscolherTecnicas;
import View.Interface.TelaLabirinto;
import de.lessvoid.nifty.slick2d.NiftyStateBasedGame;
import java.util.ArrayList;
import java.util.List;
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
//        configuracoes = new Configuracoes();
//        int larguraTela = Integer.parseInt(configuracoes.getProperty("larguraTela"));
//        int alturaTela = Integer.parseInt(configuracoes.getProperty("alturaTela"));
//        boolean telaCheia = Boolean.parseBoolean(configuracoes.getProperty("telaCheia"));
//        
//        try{
//            janela = new AppGameContainer(new Main("Maze Explorers"));
//            janela.setDisplayMode(larguraTela, alturaTela, telaCheia);
//            janela.setShowFPS(false);//false
//            janela.start();
//        } catch (SlickException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }


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
//        BuscaEmLargura busca = new BuscaEmLargura(labirinto);
//        Caminho caminho = busca.buscar(new Acao(){
//            @Override
//            public void acao(No no, Direcao direcao) {
//                System.out.println(no+" "+direcao);
//            }
//        });
//        
//        System.out.println("\n\n\n"+caminho);

        Main isto = new Main("");
        isto.novosTestes();
        
    }
    
    public void novosTestes(){
        int[][] matriz = {new int[]{1, 1, 1, 1, 1, 1, 1},
                          new int[]{1, 1, 1, 1, 1, 1, 1},
                          new int[]{1, 1, 1, 1, 1, 1, 1},
                          new int[]{1, 1, 1, 1, 1, 1, 1},
                          new int[]{1, 1, 1, 1, 1, 1, 1},
                          new int[]{1, 1, 1, 1, 1, 1, 1},
                          new int[]{1, 1, 1, 1, 1, 1, 1},
        };
        
        No inicio = new No(3, 3);
        No objetivo = new No(6, 6);
        Labirinto labirinto = new Labirinto(matriz, inicio, objetivo);
        System.out.println(labirinto);
        
        Caminho caminho = new Caminho();
        
        Nivel nivel1 = new Nivel(inicio.getVizinhos(labirinto.getEspaco(), caminho));
        nivel1.labirinto = labirinto;
        System.out.println("Nível 1 tamanho == "+nivel1.tamanho());
        System.out.println("nível 1:\n"+nivel1);
        
        Nivel nivel2 = nivel1.geraProximoNivel(caminho);
        System.out.println("Nível 2 tamanho == "+nivel2.tamanho());
        System.out.println("nível 2:\n"+nivel2);
        
        Nivel nivel3 = nivel2.geraProximoNivel(caminho);
        System.out.println("Nível 3 tamanho == "+nivel3.tamanho());
        System.out.println("nível 3:\n"+nivel3);
    }
    
    //apagar
    public class Nivel {
        
        private List<No> nos;
        public Labirinto labirinto;//apagar
        
        public Nivel(List<No> nos){
            this.nos = nos;
        }
        
        /**
         * Gera o próximo Nivel a partir deste.
         * 
         * @param caminho o caminho que está percorrendo.
         * @return o próximo nível.
         */
        public Nivel geraProximoNivel(Caminho caminho){
            List<No> lista = new ArrayList<>();
            
            for(int i=0;i<nos.size();i++){
                
                List<No> vizinhos = nos.get(i).getVizinhos(labirinto.getEspaco(), caminho);
                for(int j=0;j<vizinhos.size();j++){
                    //System.out.println("vizinho #"+i+" "+vizinhos.get(j));
                    if((!lista.contains(vizinhos.get(j))) && (!nos.contains(vizinhos.get(j))))
                        lista.add(vizinhos.get(j));
                }

            }
            
            Nivel proximoNivel = new Nivel(lista);
            proximoNivel.labirinto = labirinto;
            return proximoNivel;
        }
        
        /**
         * Retorna No que está na posição informada.
         * 
         * @param i a posição que deseja obter o No.
         * @return o No que está na possição informada.
         */
        public No get(int i){
            return nos.get(i);
        }
        
        /**
         * A quantidade de nós (No) que o Nivel possui.
         * 
         * @return o tamanho do nível.
         */
        public int tamanho(){
            return nos.size();
        }
        
        /**
         * Representação do nível em X e O, onde:<br>
         * X: um No que pertence ao Nivel.<br>
         * O: um No que <b>não</b> pertence ao Nivel.
         * 
         * @return 
         */
        @Override
        public String toString(){
            String s = "";
            for(int i=0;i<labirinto.getEspaco().length;i++){
                for(int j=0;j<labirinto.getEspaco()[i].length;j++){
                    
                    if(nos.contains(labirinto.getEspaco()[i][j]))
                        s += "X  ";
                    else
                        s += "O  ";
                    
                }
                s += "\n";
            }
            
            return s;
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
