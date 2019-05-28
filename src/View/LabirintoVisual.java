package View;

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
    
    
    public LabirintoVisual(){
        localizacao = new Ponto(0f, 0f);
    }
    
    public Ponto traduzirNoParaPonto(No no){
        int larguraTile = mapa.getTileWidth();
        int alturaTile = mapa.getTileHeight();
        
        float x = /*localizacao.getX() +*/ (no.getColuna() * larguraTile);
        float y = /*localizacao.getY() +*/ (no.getLinha() * alturaTile);
        
        return new Ponto(x, y);
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
    
}
