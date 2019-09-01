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
public class Configuracoes {
    
    private final String ARQUIVO_CONFIGS = "assets/Configuracoes/config.properties";
    
    private final String IDIOMA_PADRAO = "pt";
    private final String LARGURA_TELA_PADRAO = "800";
    private final String ALTURA_TELA_PADRAO = "600";
    private final String TELA_CHEIA = "false";//true
    
    private Properties configs;
    
    public Configuracoes(){
        carregaConfigs();
    }
    
    private void carregaConfigs(){
        configs = new Properties();
        FileInputStream input;
        try {
            input = new FileInputStream(ARQUIVO_CONFIGS);
            configs.load(input);
        } catch (IOException ex) {
            criaArquivoConfigs();
        }
    }
    
    private void criaArquivoConfigs(){
        configs = new Properties();
        configs.setProperty("idioma", IDIOMA_PADRAO);
        configs.setProperty("larguraTela", LARGURA_TELA_PADRAO);
        configs.setProperty("alturaTela", ALTURA_TELA_PADRAO);
        configs.setProperty("telaCheia", TELA_CHEIA);
        
        salvaArquivoConfigs();
    }
    
    public void salvaArquivoConfigs(){
        try {
            FileOutputStream output = new FileOutputStream(ARQUIVO_CONFIGS);
            configs.store(output, "Propriedades de MazeExplorers");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuracoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuracoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Fingindo ser do tipo Property para encurtar a chamada.
     * Retorna o valor da propriedade inforamada
     * 
     * @param key
     * @return o valor da key informada
     */
    public String getProperty(String key){
        return configs.getProperty(key);
    }
    
    /**
     * Fingindo ser do tipo Property para encurtar a chamada.
     * Designina o valor da a propriedade inforamada.
     * 
     * @param key
     * @param valor 
     */
    public void setProperty(String key, String valor){
        configs.setProperty(key, valor);
    }
    
}
