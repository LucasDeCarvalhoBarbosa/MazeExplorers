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
import Control.Ponto;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Lucas Barbosa
 */
public class Sprite {
    
    private Ponto localizacao;
    private float velocidade;
    
    private Animation atual;
    private final Animation cima;
    private final Animation direita;
    private final Animation baixo;
    private final Animation esquerda;
    
    public Sprite(Ponto localizacao, Direcao direcaoInicial) throws SlickException{
        this.localizacao = localizacao;
        this.velocidade = 0.06f;
        
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
        atual = cima;
        atual.update(delta);
        localizacao.setY( (localizacao.getY() - (delta * velocidade)));
    }
    
    public void andarDireita(GameContainer container, int delta, Direcao direcaoAnterior){
        atual = direita;
        atual.update(delta);
        localizacao.setX( (localizacao.getX() + (delta * velocidade)));
    }
    
    public void andarBaixo(GameContainer container, int delta, Direcao direcaoAnterior){
        atual = baixo;
        atual.update(delta);
        localizacao.setY( (localizacao.getY() + (delta * velocidade)));
    }
    
    public void andarEsquerda(GameContainer container, int delta, Direcao direcaoAnterior){
        atual = esquerda;
        atual.update(delta);
        localizacao.setX((localizacao.getX() - (delta * velocidade)));
    }
    
    //gets e sets
    public Ponto getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Ponto localizacao) {
        this.localizacao = localizacao;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }
    
}
