package View;

import Biblioteca.Direcoes.Direcao;
import Biblioteca.Direcoes.DirecaoBaixo;
import Biblioteca.Direcoes.DirecaoBaixoDireita;
import Biblioteca.Direcoes.DirecaoBaixoEsquerda;
import Biblioteca.Direcoes.DirecaoCima;
import Biblioteca.Direcoes.DirecaoCimaDireita;
import Biblioteca.Direcoes.DirecaoCimaEsquerda;
import Biblioteca.Direcoes.DirecaoDireita;
import Biblioteca.Direcoes.DirecaoEsquerda;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Lucas Barbosa
 */
public class Sprite {
    
    private Animation atual;
    
    private Animation cima;
    private Animation direita;
    private Animation baixo;
    private Animation esquerda;
    
    public Sprite(Direcao direcaoInicial) throws SlickException{
        String caminho = "assets/Sprites/personagem1/";
        
        Image[] imagensCima = new Image[]{new Image(caminho+"cima1.png"), new Image(caminho+"cima2.png"), new Image(caminho+"cima3.png")};
        Image[] imagensDireita = new Image[]{new Image(caminho+"direita1.png"), new Image(caminho+"direita2.png"), new Image(caminho+"direita3.png")};
        Image[] imagensBaixo = new Image[]{new Image(caminho+"baixo1.png"), new Image(caminho+"baixo2.png"), new Image(caminho+"baixo3.png")};
        Image[] imagensEsquerda = new Image[]{new Image(caminho+"esquerda1.png"), new Image(caminho+"esquerda2.png"), new Image(caminho+"esquerda3.png")};
        
        int[] duracaoDaAnimacao = new int[]{300, 300, 300};
        
        cima = new Animation(imagensCima, duracaoDaAnimacao, false);
        direita = new Animation(imagensDireita, duracaoDaAnimacao, false);
        baixo = new Animation(imagensBaixo, duracaoDaAnimacao, false);
        esquerda = new Animation(imagensEsquerda, duracaoDaAnimacao, false);
        
        atual = atribuiDirecaoInicial(direcaoInicial);
    }
    
    private Animation atribuiDirecaoInicial(Direcao direcaoInicial){
        if(direcaoInicial instanceof DirecaoCima)
            return cima;
        
        if((direcaoInicial instanceof DirecaoCimaDireita)||(direcaoInicial instanceof DirecaoDireita)||(direcaoInicial instanceof DirecaoBaixoDireita))
            return direita;
        
        if(direcaoInicial instanceof DirecaoBaixo)
            return baixo;
        
        if((direcaoInicial instanceof DirecaoBaixoEsquerda)||(direcaoInicial instanceof DirecaoEsquerda)||(direcaoInicial instanceof DirecaoCimaEsquerda))
            return esquerda;
        
        return direita;
    }
    
    public void desenha(float x, float y){
        atual.draw(x, y);
    }
    
    public void andarCima(GameContainer container, int delta, Direcao direcaoAnterior){
        
    }
    
    public void andarDireita(GameContainer container, int delta, Direcao direcaoAnterior){
        
    }
    
    public void andarBaixo(GameContainer container, int delta, Direcao direcaoAnterior){
        
    }
    
    public void andarEsquerda(GameContainer container, int delta, Direcao direcaoAnterior){
        
    }
    
}
