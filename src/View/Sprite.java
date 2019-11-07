package View;

import Biblioteca.Buscas.Busca;
import Biblioteca.Buscas.BuscaEmLargura;
import Biblioteca.Buscas.BuscaEmProfundidade;
import Biblioteca.Buscas.BuscaGulosa;
import Biblioteca.Caminho;
import Biblioteca.Direcoes.Direcao;
import Biblioteca.Direcoes.DirecaoBaixo;
import Biblioteca.Direcoes.DirecaoBaixoDireita;
import Biblioteca.Direcoes.DirecaoBaixoEsquerda;
import Biblioteca.Direcoes.DirecaoCima;
import Biblioteca.Direcoes.DirecaoCimaDireita;
import Biblioteca.Direcoes.DirecaoCimaEsquerda;
import Biblioteca.Direcoes.DirecaoDireita;
import Biblioteca.Direcoes.DirecaoEsquerda;
import Biblioteca.No;
import Control.Acao;
import Control.Constantes;
import static Control.Constantes.TAMANHO_TILE;
import Control.Ponto;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    private Caminho caminho;
    private int nosPercorridos;
    private boolean encontrouObjetivo;
    
    private Ponto localizacao;
    private No noAtual;
    private float velocidade;
    
    GameContainer container;
    int delta;
    
    private Animation atual;
    private final Animation cima;
    private final Animation direita;
    private final Animation baixo;
    private final Animation esquerda;
    
    public static final int BUSCA_LARGURA = 0;
    public static final int BUSCA_PROFUNDIDADE = 1;
    public static final int BUSCA_GULOSA = 2;
    public static final int BUSCA_A_STAR = 3;
    
    private static final int ATRASO = 3;//1 ou melho 3
    
    public Sprite(Ponto localizacao, Direcao direcaoInicial, Busca busca, GameContainer container) throws SlickException{
        this.nosPercorridos = 0;
        this.encontrouObjetivo = false;
        this.localizacao = localizacao;
        this.velocidade = 1f;//0.06f ou ultimanente: 0.2f, melhor 1
        this.container = container;
        
        String nomeSprite;

        this.busca = busca;

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
    
    public void andarCima(GameContainer container, int delta/*, Direcao direcaoAnterior*/){
        atual = cima;
        
        No noCima = new No(noAtual.getLinha()-1, noAtual.getColuna());
        Ponto destino = Constantes.traduzirNoParaPonto(noCima);
        
        int contador = 0;
        while(localizacao.getY()>=destino.getY()){
            localizacao.setY( (localizacao.getY() - (delta * velocidade)));
            atual.update(delta);
            
            try {Thread.sleep(ATRASO);} catch (InterruptedException ex) {}
            contador++;
        }
        System.out.println("Cima\tprecisei de "+contador);
        
    }
    
    public void andarCimaDireita(GameContainer container, int delta){
        Random r = new Random();
        if(r.nextInt(2)==0)
            atual = cima;
        else
            atual = direita;
        
        No cimaDireita = new No(noAtual.getLinha()-1, noAtual.getColuna()+1);
        Ponto destino = Constantes.traduzirNoParaPonto(cimaDireita);
        
        int contador = 0;
        while((localizacao.getY()>=destino.getY()) && (localizacao.getX()<=destino.getX())){
            localizacao.setY( (localizacao.getY() - (delta * velocidade)));
            localizacao.setX( (localizacao.getX() + (delta * velocidade)));
            atual.update(delta);
            
            try {Thread.sleep(ATRASO);} catch (InterruptedException ex) {}
            contador++;
        }
        System.out.println("CimaDireita\tprecisei de "+contador);
    }
    
    //vai andar para o nó exatamante a direita
    public void andarDireita(GameContainer container, int delta/*, Direcao direcaoAnterior*/){
        atual = direita;
        
        No noDireita = new No(noAtual.getLinha(), noAtual.getColuna()+1);
        Ponto destino = Constantes.traduzirNoParaPonto(noDireita);

        int contador = 0;
        while(localizacao.getX()<=destino.getX()){
            localizacao.setX( (localizacao.getX() + (delta * velocidade)));
            atual.update(delta);
            
            try {Thread.sleep(ATRASO);} catch (InterruptedException ex) {}
            contador++;
        }
        System.out.println("Direita\tprecisei de "+contador);
    }
    
    public void andarBaixoDireita(GameContainer container, int delta){
        Random r = new Random();
        if(r.nextInt(2)==0)
            atual = baixo;
        else
            atual = direita;
        
        No baixoDireita = new No(noAtual.getLinha()+1, noAtual.getColuna()+1);
        Ponto destino = Constantes.traduzirNoParaPonto(baixoDireita);
        
        while((localizacao.getY()<=destino.getY()) && (localizacao.getX()<=destino.getX())){
            localizacao.setY( (localizacao.getY() + (delta * velocidade)));
            localizacao.setX( (localizacao.getX() + (delta * velocidade)));
            atual.update(delta);
            
            try {Thread.sleep(ATRASO);} catch (InterruptedException ex) {}
            
        }
    }
    
    public void andarBaixo(GameContainer container, int delta/*, Direcao direcaoAnterior*/){
        atual = baixo;
        
        No noBaixo = new No(noAtual.getLinha()+1, noAtual.getColuna());
        Ponto destino = Constantes.traduzirNoParaPonto(noBaixo);
        
        while(localizacao.getY()<=destino.getY()){
            localizacao.setY( (localizacao.getY() + (delta * velocidade)));
            atual.update(delta);
            
            try {Thread.sleep(ATRASO);} catch (InterruptedException ex) {}
            
        }
        
    }
    
    public void andarBaixoEsquerda(GameContainer container, int delta){
        Random r = new Random();
        if(r.nextInt(2)==0)
            atual = baixo;
        else
            atual = esquerda;
        
        No baixoEsquerda = new No(noAtual.getLinha()+1, noAtual.getColuna()-1);
        Ponto destino = Constantes.traduzirNoParaPonto(baixoEsquerda);
        
        while((localizacao.getY()<=destino.getY()) && (localizacao.getX()>=destino.getX())){
            localizacao.setY( (localizacao.getY() + (delta * velocidade)));
            localizacao.setX((localizacao.getX() - (delta * velocidade)));
            atual.update(delta);
            
            try {Thread.sleep(ATRASO);} catch (InterruptedException ex) {}
            
        }
    }
    
    public void andarEsquerda(GameContainer container, int delta/*, Direcao direcaoAnterior*/){
        atual = esquerda;
        
        No noEsquerda = new No(noAtual.getLinha(), noAtual.getColuna()-1);
        Ponto destino = Constantes.traduzirNoParaPonto(noEsquerda);
        
        while(localizacao.getX()>=destino.getX()){
            localizacao.setX((localizacao.getX() - (delta * velocidade)));
            atual.update(delta);
            
            try {Thread.sleep(ATRASO);} catch (InterruptedException ex) {}
            
        }
        
    }
    
    public void andarCimaEsquerda(GameContainer container, int delta){
        Random r = new Random();
        if(r.nextInt(2)==0)
            atual = cima;
        else
            atual = esquerda;
        
        No cimaEsquerda = new No(noAtual.getLinha()-1, noAtual.getColuna()-1);
        Ponto destino = Constantes.traduzirNoParaPonto(cimaEsquerda);
        
        while((localizacao.getY()>=destino.getY()) && (localizacao.getX()>=destino.getX())){
            localizacao.setY( (localizacao.getY() - (delta * velocidade)));
            localizacao.setX((localizacao.getX() - (delta * velocidade)));
            atual.update(delta);
            
            try {Thread.sleep(ATRASO);} catch (InterruptedException ex) {}
            
        }
        
    }
    
    public void andarAteNo(No no, GameContainer container, int delta){
        //Direcao direcao = noAtual.direcaoEmRelacao(no);
        Direcao direcao = no.direcaoEmRelacao(noAtual);
        
        System.out.println("\n\n--------------------"+direcao+"--------------------");
        
        if(direcao instanceof DirecaoCima){
            andarCima(container, delta);
            System.out.println("andar cima");
        }
        else if(direcao instanceof DirecaoCimaDireita){
            andarCimaDireita(container, delta);
            System.out.println("andar cima e andar direita");
        }
        else if(direcao instanceof DirecaoDireita){
            andarDireita(container, delta);
            System.out.println("andar direita");
        }
        else if(direcao instanceof DirecaoBaixoDireita){
            andarBaixoDireita(container, delta);
            System.out.println("andar baixo e andar direita");
        }
        else if(direcao instanceof DirecaoBaixo){
            andarBaixo(container, delta);
            System.out.println("andar baixo");
        }
        else if(direcao instanceof DirecaoBaixoEsquerda){
            andarBaixoEsquerda(container, delta);
            System.out.println("andar baixo e andar esquerda");
        }
        else if(direcao instanceof DirecaoEsquerda){
            andarEsquerda(container, delta);
            System.out.println("andar esquerda");
        }
        else if(direcao instanceof DirecaoCimaEsquerda){
            andarCimaEsquerda(container, delta);
            System.out.println("andar cima e andar esquerda");
        }
        
    }
    
    @Override
    public void run(){
        caminho = busca.buscar(new Acao(){
            @Override
            public void acao(No no, Direcao direcao) {
                //opção 1
                noAtual = Constantes.traudzirPontoParaNo(localizacao);
                andarAteNo(no, container, delta);
                
                nosPercorridos++;
            }
        });
        
        encontrouObjetivo = true;
    }
    
    //gets e sets
    public Caminho getCaminho() {
        return caminho;
    }

    public void setCaminho(Caminho caminho) {
        this.caminho = caminho;
    }

    public int getNosPercorridos() {
        return nosPercorridos;
    }

    public void setNosPercorridos(int nosPercorridos) {
        this.nosPercorridos = nosPercorridos;
    }

    public boolean isEncontrouObjetivo() {
        return encontrouObjetivo;
    }

    public void setEncontrouObjetivo(boolean encontrouObjetivo) {
        this.encontrouObjetivo = encontrouObjetivo;
    }

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

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }
    
}
