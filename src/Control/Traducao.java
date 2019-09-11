package Control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Barbosa
 */
public class Traducao {
    
    private static Properties dicionario;
    
    private String idioma;
    
    public static final String CAMINHO_ARQUIVO_IDIOMA = "assets/Configuracoes/Idiomas/";
    
    public Traducao(String idioma){
        this.idioma = idioma;
        carregaArquivoIdioma();
    }
    
    private void carregaArquivoIdioma(){
        dicionario = new Properties();
        FileInputStream input;
        try {
            input = new FileInputStream(CAMINHO_ARQUIVO_IDIOMA+idioma+".properties");
            dicionario.load(input);
        } catch (IOException ex) {
            switch(idioma){
                case "pt":
                    criaArquivoIdiomaPortugues();
                    break;
                    
                case "en":
                    criaArquivoIdiomaIngles();
                    break;
                    
                case "es":
                    criaArquivoIdiomaEspanhol();
                    break;
                    
                default:
                    idioma = "pt";
                    criaArquivoIdiomaPortugues();
            }
            
        }
    }
    
    private void criaArquivoIdiomaPortugues(){
        dicionario = new Properties();
        dicionario.setProperty("mp.explorar", "Explorar");
        dicionario.setProperty("mp.configuracoes", "Configurações");
        dicionario.setProperty("mp.creditos", "Créditos");
        dicionario.setProperty("mp.sair", "Sair");
        dicionario.setProperty("et.titulo", "Selecione a(s) técnicas para explorar o labirinto");
        dicionario.setProperty("et.buscaLargura", "Busca em Largura");
        dicionario.setProperty("et.buscaProfundidade", "Busca em Profundidade");
        dicionario.setProperty("et.buscaGulosa", "Busca Gulosa");
        dicionario.setProperty("et.buscaAEstrela", "A*");
        dicionario.setProperty("et.voltar", "Voltar");
        dicionario.setProperty("et.confirmar", "Confirmar");
        dicionario.setProperty("c.desenvolvedores", "Desenvolvedores");
        dicionario.setProperty("c.creditosAdicionais", "Créditos adicionais");
        dicionario.setProperty("c.nome1", "Charles Gabriel (Pelo personagem usado)");
        dicionario.setProperty("c.nome2", "Kjpargeter (pela imagem de fundo)");
        
        salvaArquivoIdioma();
    }
    
    private void criaArquivoIdiomaIngles(){
        dicionario = new Properties();
        dicionario.setProperty("mp.explorar", "Explore");
        dicionario.setProperty("mp.configuracoes", "Settings");
        dicionario.setProperty("mp.creditos", "Credit");
        dicionario.setProperty("mp.sair", "Exit");
        dicionario.setProperty("et.titulo", "Choose techniques to explore the maze");
        dicionario.setProperty("et.buscaLargura", "Breadth-first search");
        dicionario.setProperty("et.buscaProfundidade", "Depth-first search");
        dicionario.setProperty("et.buscaGulosa", "Greedy algorithm");
        dicionario.setProperty("et.buscaAEstrela", "A*");
        dicionario.setProperty("et.voltar", "back");
        dicionario.setProperty("et.confirmar", "confirm");
        dicionario.setProperty("c.desenvolvedores", "developers");
        dicionario.setProperty("c.creditosAdicionais", "Additional Credits");
        dicionario.setProperty("c.nome1", "Charles Gabriel (by the character used)");
        dicionario.setProperty("c.nome2", "Kjpargeter (by background image)");
        
        salvaArquivoIdioma();
    }
    
    private void criaArquivoIdiomaEspanhol(){
        dicionario = new Properties();
        dicionario.setProperty("mp.explorar", "Explorar");
        dicionario.setProperty("mp.configuracoes", "Configuraciones");
        dicionario.setProperty("mp.creditos", "Créditos");
        dicionario.setProperty("mp.sair", "Partir");
        dicionario.setProperty("et.titulo", "Seleccionar técnicas para explorar el laberinto.");
        dicionario.setProperty("et.buscaLargura", "Búsqueda en anchura");
        dicionario.setProperty("et.buscaProfundidade", "Búsqueda de profundidad");
        dicionario.setProperty("et.buscaGulosa", "Búsqueda codiciosa");
        dicionario.setProperty("et.buscaAEstrela", "Búsqueda A*");
        dicionario.setProperty("et.voltar", "Volver");
        dicionario.setProperty("et.confirmar", "Confirmar");
        dicionario.setProperty("c.desenvolvedores", "Desarrolladores");
        dicionario.setProperty("c.creditosAdicionais", "Créditos Adicionales");
        dicionario.setProperty("c.nome1", "Charles Gabriel (Por el personaje usado)");
        dicionario.setProperty("c.nome2", "Kjpargeter (por imagen de fondo)");
        
        salvaArquivoIdioma();
    }
    
    public void salvaArquivoIdioma(){
        try {
            FileOutputStream output = new FileOutputStream(CAMINHO_ARQUIVO_IDIOMA+idioma+".properties");
            dicionario.store(output, "Tradução de MazeExplorers");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuracoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuracoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String traduz(String key){
        return dicionario.getProperty(key);
    }
    
    /**
     * Fingindo ser do tipo Property para encurtar a chamada.
     * Retorna o valor da propriedade inforamada.
     * 
     * @param key
     * @return o valor da key informada
     */
    public String getProperty(String key){
        return dicionario.getProperty(key);
    }
    
    /**
     * Fingindo ser do tipo Property para encurtar a chamada.
     * Designina o valor da a propriedade inforamada.
     * 
     * @param key
     * @param valor 
     */
    public void setProperty(String key, String valor){
        dicionario.setProperty(key, valor);
    }
    
    //gets e sets
    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
}
