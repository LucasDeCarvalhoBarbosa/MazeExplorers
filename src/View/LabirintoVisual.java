package View;

import Biblioteca.Direcoes.Direcao;
import Biblioteca.Labirinto;
import Biblioteca.No;
import Control.Ponto;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Lucas Barbosa
 */
public class LabirintoVisual {
    
    private Labirinto labirinto;
    private TiledMap mapa;
    private Ponto localizacao;
    
    private int tamanhoTiles;
    
    private Direcao direcaoInicial;
    
    
    public LabirintoVisual(){
        localizacao = new Ponto(0f, 0f);
    }
    
    public void render(int x, int y){
        mapa.render(x, y);
    }
    
    //gets e sets
    public Labirinto getLabirinto() {
        return labirinto;
    }

    public void setLabirinto(Labirinto labirinto) {
        this.labirinto = labirinto;
    }

    public TiledMap getMapa() {
        return mapa;
    }

    public void setMapa(TiledMap mapa) {
        this.mapa = mapa;
    }

    public Ponto getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Ponto localizacao) {
        this.localizacao = localizacao;
    }

    public int getTamanhoTiles() {
        return tamanhoTiles;
    }

    public void setTamanhoTiles(int tamanhoTiles) {
        this.tamanhoTiles = tamanhoTiles;
    }

    public Direcao getDirecaoInicial() {
        return direcaoInicial;
    }

    public void setDirecaoInicial(Direcao direcaoInicial) {
        this.direcaoInicial = direcaoInicial;
    }
    
}
