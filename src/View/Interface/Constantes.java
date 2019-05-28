package View.Interface;

import de.lessvoid.nifty.Nifty;

/**
 *
 * @author Lucas Barbosa
 */
public class Constantes {
    
    public static final int idMenuPrincipal = 1;
    public static final int idCreditos = 2;
    public static final int idConfiguracoes = 3;
    public static final int idEscolherTecnicas = 4;
    public static final int idTelaLabirinto = 5;
    
    public static void carregarNifty(Nifty nifty){
        nifty.fromXml("assets/Interface/Telas/MenuPrincipal.xml", "start");
        nifty.addXml("assets/Interface/Telas/Creditos.xml");
        nifty.addXml("assets/Interface/Telas/EscolherTecnicas.xml");
        nifty.addXml("assets/Interface/Telas/TelaLabirinto.xml");
    }
    
}
