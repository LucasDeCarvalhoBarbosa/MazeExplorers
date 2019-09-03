package Control;

import de.lessvoid.nifty.Nifty;

/**
 *
 * @author Lucas Barbosa
 */
public class Constantes {
    
    //estados
    public static final int ID_MENU_PRINCIPAL = 1;
    public static final int ID_CONTROLA_MENUS_SIMPLES = 2;
    public static final int ID_CONFIGURACOES = 3;
    public static final int ID_ESCOLHER_TECNICAS = 4;
    public static final int ID_TELA_LABIRINTO = 5;
    
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
