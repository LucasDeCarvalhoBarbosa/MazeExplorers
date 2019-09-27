package Control;

import de.lessvoid.nifty.Nifty;

/**
 *
 * @author Lucas Barbosa
 */
public class Constantes {
    
    //estados
    public static final int ID_MENU = 1;
    public static final int ID_LABIRINTO = 2;
    
    public static void carregarNifty(Nifty nifty){
        nifty.fromXml("assets/Interface/Telas/MenuPrincipal.xml", "start");
        nifty.addXml("assets/Interface/Telas/Creditos.xml");
        nifty.addXml("assets/Interface/Telas/EscolherTecnicas.xml");
        nifty.addXml("assets/Interface/Telas/ExplicacaoBuscaEmProfundidade.xml");
        nifty.addXml("assets/Interface/Telas/ExplicacaoBuscaEmLargura.xml");
        nifty.addXml("assets/Interface/Telas/ExplicacaoBuscaGulosa.xml");
        nifty.addXml("assets/Interface/Telas/ExplicacaoBuscaAEstrela.xml");
        nifty.addXml("assets/Interface/Telas/TelaLabirinto.xml");
    }
    
}
