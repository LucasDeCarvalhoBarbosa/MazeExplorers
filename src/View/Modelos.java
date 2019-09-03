package View;

import Biblioteca.Labirinto;
import Biblioteca.No;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Lucas Barbosa
 */
public class Modelos {
    
    private static final String MAPA_0 = "assets/Labirintos/Modelo0/Mapa.tmx";
    
    public static LabirintoVisual geraLabirinto(int labirintoEscolhido) throws SlickException{
        LabirintoVisual visual = new LabirintoVisual();
        No inicio;
        No objetivo;
        
        switch(labirintoEscolhido){
            
            case 0:
                int[][] tiles ={new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                                new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                                new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0},
                                new int[]{0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
                                new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0},
                                new int[]{0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                                new int[]{0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
                                new int[]{0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0},
                                new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                                new int[]{0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0},
                                new int[]{0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                                new int[]{0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0},
                                new int[]{0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0},
                                new int[]{0 ,0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0},
                                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0},
                                new int[]{0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0},
                                new int[]{0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0},
                                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
                
                inicio = new No(16, 0);
                objetivo = new No(1, 0);
                visual.setLabirinto(new Labirinto(tiles, inicio, objetivo));    
                visual.setMapa(new TiledMap(MAPA_0));
                visual.setTamanhoTiles(32);
                return visual;
                
            default:
                return geraLabirinto(0);
                
        }
        
    }
    
    public No[][] geraEspaco(){ 
        return new No[1][1];//por enquanto
    }
    
    public No getInicio(){
        return new No(0, 0);//por enquanto
    }
    
    public No getObjetivo(){
        return new No(0, 0);//por enquanto
    }
    
}
