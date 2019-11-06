package Control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.SlickException;

/**
 *
 * @author LucasBarbosa
 */
public class Constantes {
    
    public static String idiomaAtual = "en";//idioma padrão
    public static String IDIOMA_PADRAO = "en";
    
//    private static Properties configuracoes;
    private static Properties pt;
    private static Properties en;
    private static Properties es;
    
    public static final int ID_MENU_PRINCIPAL = 0;
    public static final int ID_CONFIGURACOES = 1;
    public static final int ID_CREDITOS = 2;
    public static final int ID_ESCOLHER_TECNICA = 3;
    public static final int ID_TELA_LABIRINTO = 4;
    public static final int ID_PAUSA = 5;
    public static final int ID_EXPLORACAO_ACABOU = 6;
    
//    public static Properties configuracoes(){
//        if(configuracoes==null){
//            configuracoes = new Properties();
//            try {
//                FileInputStream file = new FileInputStream("assets/interface/configuracoes/configuracoes.properties");
//                configuracoes.load(file);
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(Constantes.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(Constantes.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//        return configuracoes;
//    }
    
    public static String idiomaAtual(){
        Properties propriedades = new Properties();
        
        try {
            FileInputStream file = new FileInputStream("assets/Configuracoes/config.properties");
            propriedades.load(file);
            
            return propriedades.getProperty("idiomaPadrao");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Constantes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Constantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return IDIOMA_PADRAO;
    }
    
    public static String substituir(String idioma, String chave){
        iniciaIdiomas();
        if(idioma.equals("pt")){
            System.out.println("pt.getProperty("+chave+"): "+pt.getProperty(chave));
            return pt.getProperty(chave);
        }
        if(idioma.equals("es")){
            return es.getProperty(chave);
        }
        
        if(idioma.equals("en"))
            return en.getProperty(chave);
        
        return "fora do if (idioma: "+idioma+")";
    }
    
    public static String substituir(String chave){
        iniciaIdiomas();
        if(idiomaAtual.equals("pt")){
            return pt.getProperty(chave);
        }
        if(idiomaAtual.equals("es")){
            return es.getProperty(chave);
        }
        
        return en.getProperty(chave);
    }
    
    private static void iniciaIdiomas(){
        if(pt==null){
            
            pt = new Properties();
            en = new Properties();
            es = new Properties();

            try {
                FileInputStream file = new FileInputStream("assets/interface/idiomas/pt.properties");
                pt.load(file);

                file = new FileInputStream("assets/interface/idiomas/en.properties");
                en.load(file);

                file = new FileInputStream("assets/interface/idiomas/es.properties");
                es.load(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Constantes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Constantes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    public static AngelCodeFont textoFont() throws SlickException{
        return new AngelCodeFont("assets/interface/fonts/ocr16.fnt", 
                "assets/interface/fonts/ocr16_0.png");
    }
    
    public static AngelCodeFont tituloFont() throws SlickException{
        return new AngelCodeFont("assets/interface/fonts/closeandopen32.fnt", 
        "assets/interface/fonts/closeandopen32_0.png");
    }
    
}
