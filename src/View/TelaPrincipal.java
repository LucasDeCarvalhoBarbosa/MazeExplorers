package View;

import Biblioteca.Direcoes.DirecaoBaixo;
import Biblioteca.Direcoes.DirecaoCima;
import Biblioteca.Direcoes.DirecaoDireita;
import Biblioteca.Direcoes.DirecaoEsquerda;
import Biblioteca.No;
import Control.Ponto;
import View.Entrada.ContextoDeEntrada;
import View.Entrada.EntradaMenu;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Lucas Barbosa
 */
public class TelaPrincipal extends BasicGame{
    
    private LabirintoVisual labirintoVisual;
    private Sprite sprite;
    private ContextoDeEntrada entrada;

    public TelaPrincipal(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        entrada = new EntradaMenu(container.getInput(), labirintoVisual);
        labirintoVisual = Modelos.geraLabirinto(0);
        sprite = new Sprite(labirintoVisual.traduzirNoParaPonto(labirintoVisual.getLabirinto().getInicio()), new DirecaoDireita());
        
        //testando a traduão de npos para pontos na tela.
        System.out.println(labirintoVisual.getLabirinto().getInicio());
        System.out.println(labirintoVisual.traduzirNoParaPonto(labirintoVisual.getLabirinto().getInicio()));
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        entrada.verificarEntrada();
        
        //testando a movimentação
        //sprite.andarDireita(container, delta, new DirecaoEsquerda());
        //sprite.andarEsquerda(container, delta, new DirecaoDireita());
    }
    
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        labirintoVisual.getMapa().render((int) labirintoVisual.getLocalizacao().getX(), (int) labirintoVisual.getLocalizacao().getY());
        sprite.desenha(sprite.getLocalizacao().getX(), sprite.getLocalizacao().getY());
    }
    
}
