package mazeexplorers;

import View.TelaPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Lucas Barbosa
 */
public class Main {

    public static void main(String[] args) {
        try{
            AppGameContainer janela = new AppGameContainer(new TelaPrincipal("Tela"));
            janela.setDisplayMode(1366, 768, true);//true
            janela.setShowFPS(true);//false
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
    
}
