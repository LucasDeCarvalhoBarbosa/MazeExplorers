package mazeexplorers;

import View.Interface.Creditos;
import View.Interface.EscolherTecnicas;
import View.Interface.MenuPrincipal;
import View.Interface.TelaLabirinto;
import View.TelaPrincipal;
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
    
    public Main(String titulo){
        super(titulo);
    }

    public static void main(String[] args) {
        try{
            AppGameContainer janela = new AppGameContainer(new Main("Maze Explorers"));
            janela.setDisplayMode(800, 600, false);//true
            janela.setShowFPS(false);//false
            janela.start();
        } catch (SlickException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Testes
        
        //Labirinto labirinto = Modelos.geraLabirinto(3);
//        GeradorLabirinto gerador = new GeradorLabirinto(10, 10, 10, 10);
//        Labirinto labirinto = gerador.geraLabirinto();
        //System.out.println(labirinto);
        
        //BuscaEmProfundidade
//        BuscaEmProfundidade buscaEmProfundidade = new BuscaEmProfundidade(labirinto);
//        Caminho caminho = buscaEmProfundidade.buscar(new Acao(){
//            @Override
//            public void acao(No no, Direcao direcao) {
//                System.out.println(no+"\t"+direcao);
//            }
//            
//        });
//        System.out.println(caminho);

        //BuscaEmLargura
//        Busca buscaEmLargura = new BuscaEmLargura(labirinto);
//        Caminho caminho = buscaEmLargura.buscar(new Acao(){
//            @Override
//            public void acao(No no, Direcao direcao) {
//                //System.out.println(no+"\t"+direcao);
//            }
//            
//        });
//        System.out.println(caminho);
    }
    
    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new MenuPrincipal());
        this.addState(new Creditos());
        this.addState(new EscolherTecnicas());
        //this.addState(new TelaLabirinto());
    }
    
}
