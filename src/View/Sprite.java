package View;

import Biblioteca.Buscas.Busca;
import Biblioteca.Buscas.BuscaEmLargura;
import Biblioteca.Buscas.BuscaEmProfundidade;
import Biblioteca.Buscas.BuscaGulosa;
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
public class Sprite extends Thread {
    
    private Busca busca;
    
    private Ponto localizacao;
    private float velocidade;
    
    private Animation atual;
    private final Animation cima;
    private final Animation direita;
    private final Animation baixo;
    private final Animation esquerda;
    
    public static final int BUSCA_LARGURA = 0;
    public static final int BUSCA_PROFUNDIDADE = 1;
    public static final int BUSCA_GULOSA = 2;
    public static final int BUSCA_A_STAR = 3;
    
    public Sprite(Ponto localizacao, Direcao direcaoInicial, Busca busca) throws SlickException{
        this.localizacao = localizacao;
        this.velocidade = 0.06f;
        
        String nomeSprite;
        
//        switch (codSprite) {
//            case BUSCA_LARGURA:
//                nomeSprite = "vampiro/";
//                break;
//            case BUSCA_PROFUNDIDADE:
//                nomeSprite = "fantasma/";
//                break;
//            case BUSCA_GULOSA:
//                nomeSprite = "abobora/";
//                break;
//            default:
//                nomeSprite = "bruxa/";
//                break;
//        }

        if(busca instanceof BuscaEmLargura){
            nomeSprite = "vampiro/";
        }else if(busca instanceof BuscaEmProfundidade){
            nomeSprite = "fantasma/";
        }else if(busca instanceof BuscaGulosa){
            nomeSprite = "abobora/";
        }else
            nomeSprite = "bruxa/";
            
        String caminho = "assets/Sprites/"+nomeSprite;
        
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
    
    @Override
    public void run(){
        
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
