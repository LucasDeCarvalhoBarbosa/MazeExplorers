package Control;

import Biblioteca.No;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
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
    
    public static final int TAMANHO_TILE = 32;
    
    
    public static Ponto traduzirNoParaPonto(No no){
        int larguraTile = TAMANHO_TILE;
        int alturaTile = TAMANHO_TILE;
        
        float x = (no.getColuna() * larguraTile);
        float y = (no.getLinha() * alturaTile);
        
        //float x = 
        
        return new Ponto(x, y);
    }
    
    public static No traudzirPontoParaNo(Ponto ponto){
        int linha = (int) (ponto.getY() / TAMANHO_TILE);
        int coluna = (int) (ponto.getX() / TAMANHO_TILE);
        
        return new No(linha, coluna);
    }
    
    public static void  carregaIdioma(){
        Properties propriedades = new Properties();
        
        try {
            FileInputStream file = new FileInputStream("assets/interface/configuracoes/config.properties");
            propriedades.load(file);
            
            idiomaAtual =  propriedades.getProperty("idioma");
        } catch (IOException ex) {
            idiomaAtual = "en";
        }
    }
    
    public static String substituir(String idioma, String chave){
        iniciaIdiomas();
        if(idioma.equals("pt")){
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
    
    public static void escreveArquivo(File arquivo,List <String> linhas){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(arquivo);
        } catch (IOException ex) {}
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
        try {
            int i = 0;
            while(i<linhas.size()){
                if(!linhas.get(i).isEmpty()){
                    bufferedWriter.write(linhas.get(i));
                    bufferedWriter.newLine();
                }
                i++;
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ex) {}
        
    }
    
    public static AngelCodeFont textoFont() throws SlickException{
        return new AngelCodeFont("assets/interface/fonts/ocr20.fnt", 
                "assets/interface/fonts/ocr20_0.png");
    }
    
    public static AngelCodeFont tituloFont() throws SlickException{//
        return new AngelCodeFont("assets/interface/fonts/cornerstone32.fnt", 
        "assets/interface/fonts/cornerstone32_0.png");
    }
    
    public static AngelCodeFont mazeExplorersFont() throws SlickException{
        return new AngelCodeFont("assets/interface/fonts/closeandopen36.fnt", 
        "assets/interface/fonts/closeandopen36_0.png");
    }
    
}
