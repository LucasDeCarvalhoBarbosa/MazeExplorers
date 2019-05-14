package Biblioteca;

import Biblioteca.Direcoes.Direcao;
import Biblioteca.Direcoes.DirecaoBaixo;
import Biblioteca.Direcoes.DirecaoBaixoDireita;
import Biblioteca.Direcoes.DirecaoBaixoEsquerda;
import Biblioteca.Direcoes.DirecaoCima;
import Biblioteca.Direcoes.DirecaoCimaDireita;
import Biblioteca.Direcoes.DirecaoCimaEsquerda;
import Biblioteca.Direcoes.DirecaoDireita;
import Biblioteca.Direcoes.DirecaoEsquerda;
import Biblioteca.Labirinto;
import Biblioteca.No;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Lucas Barbosa
 */
public class GeradorLabirinto {
    
    private int larguraMIN;
    private int larguraMAX;
    private int alturaMIN;
    private int alturaMAX;
    
    private No inicio;
    private No objetivo;

    private List<No> bordas;
    
    public GeradorLabirinto(int larguraMIN, int larguraMAX, int alturaMIN, int alturaMAX){
        this.alturaMIN = alturaMIN;
        this.alturaMAX = alturaMAX;
        this.larguraMIN = larguraMIN;
        this.larguraMAX = larguraMAX;
    }
    
    public Labirinto geraLabirinto(){
        No[][] espaco = escolheTamanhoLabirinto();
        geraInicioEObjetivo(espaco);
        Labirinto labirinto = new Labirinto(espaco, inicio, objetivo);
        labirinto.bloquearTudo();//começa com tudo bloqueado
        
        criaCaminhos(espaco, labirinto.getInicio(), labirinto.getObjetivo(), 4);//temporário 1
        
        
//        Caminho reta = new Caminho();
//        reta.adiciona(new No(0, 0, true));
//        reta.adiciona(new No(1, 1, true));
//        reta.adiciona(new No(2, 2, true));
//        reta.adiciona(new No(3, 3, true));
//        reta.adiciona(new No(4, 4, true));
//        reta.adiciona(new No(5, 5, true));
//        desenhaCaminho(espaco, reta);
        
        return labirinto;
    }
    
    private No[][] escolheTamanhoLabirinto(){//certo
        Random r = new Random();
        int largura = r.nextInt(larguraMAX - larguraMIN + 1) + larguraMIN;
        int altura = r.nextInt(alturaMAX - alturaMIN + 1) + alturaMIN;
        No[][] espaco =  new No[largura][altura];
        inicializaLabirinto(espaco);
        return espaco;
      }
    
    private No[][] inicializaLabirinto(No[][] labirinto){
        for(int i=0;i<labirinto.length;i++){
          for(int j=0;j<labirinto[i].length;j++){
          labirinto[i][j] = new No(i, j);
          labirinto[i][j].setLivre(true);
          }
        }
        return labirinto;
      }
    
    private void geraInicioEObjetivo(No[][] espaco){//certo
        bordas = new ArrayList<>();
        int alturaLabirinto = espaco.length;
        int larguraLabirinto = espaco[0].length;

        for(int i=0;i<alturaLabirinto;i++){
          for(int j=0;j<larguraLabirinto;j++){

            if((i==0)||(j==0)||(i==alturaLabirinto-1)||(j==larguraLabirinto-1)){
              bordas.add(new No(i, j));
            }

          }
        }
        Random r = new Random();
        inicio = bordas.get(r.nextInt(bordas.size()));
        bordas.remove(inicio);
        do{
        objetivo = bordas.get(r.nextInt(bordas.size()-1));
        }while((objetivo.getLinha()==inicio.getLinha())||(objetivo.getColuna()==inicio.getColuna()));
        bordas.remove(objetivo);
      }
    
    private void criaCaminhos(No[][]espaco, No inicio, No objetivo, int qtdCaminhos){
        Random r = new Random();
        No noAtual = inicio;
        for(int i=0;i<qtdCaminhos-1;i++){                       //para ficar fora das bordas
            
            //int distanciaMINcaminho = (int) ((int) (espaco.length * espaco[0].length) / 12.5);
            //No fimReta = geraNoHaDistancia(espaco, noAtual, 4, true);
            
            No fimReta = new No(r.nextInt(espaco.length-1)+1, r.nextInt(espaco[i].length-1)+1);
            System.out.println("fimReta: ("+fimReta.getLinha()+", "+fimReta.getColuna()+")");
            
            Caminho reta = tracaReta(noAtual, fimReta);
            //System.out.println("caminho #"+i+": "+reta.caminhoEmString());
            espaco = desenhaCaminho(espaco, reta);
            
            noAtual = fimReta;
        }
        Caminho caminhoAoObjetivo = tracaReta(noAtual, objetivo);
        //System.out.println("caminho final: "+caminhoAoObjetivo.caminhoEmString());
        espaco = desenhaCaminho(espaco, caminhoAoObjetivo);//A ultima reta terminará no objetivo.
    }
    
    private No[][] desenhaCaminho(No[][] espaco, Caminho caminho){
        for(int i=0;i<caminho.getCaminho().size();i++){
            No noAtual = caminho.getCaminho().get(i);
            espaco[noAtual.getLinha()][noAtual.getColuna()].setLivre(true);
        }
        
        return espaco;
    }
    
    //Métodos auxiliares
    private Caminho tracaReta(No no1, No no2){
        Caminho reta = new Caminho();
        reta.adiciona(no1);
        No noAtual = no1;
        while(!noAtual.equals(no2)){
            Direcao direcao = noAtual.direcaoEmRelacao(no2);
            
            if(direcao instanceof DirecaoCima)
                noAtual = new No(noAtual.getLinha()+1, noAtual.getColuna());
            
            else if(direcao instanceof DirecaoCimaDireita)
                noAtual = new No(noAtual.getLinha()+1, noAtual.getColuna()-1);
            
            else if(direcao instanceof DirecaoDireita)
                noAtual = new No(noAtual.getLinha(), noAtual.getColuna()-1);
            
            else if(direcao instanceof DirecaoBaixoDireita)
                noAtual = new No(noAtual.getLinha()-1, noAtual.getColuna()-1);
            
            else if(direcao instanceof DirecaoBaixo)
                noAtual = new No(noAtual.getLinha()-1, noAtual.getColuna());
            
            else if(direcao instanceof DirecaoBaixoEsquerda)
                noAtual = new No(noAtual.getLinha()-1, noAtual.getColuna()+1);
            
            else if(direcao instanceof DirecaoEsquerda)
                noAtual = new No(noAtual.getLinha(), noAtual.getColuna()+1);
            
            else if(direcao instanceof DirecaoCimaEsquerda)
                noAtual = new No(noAtual.getLinha()+1, noAtual.getColuna()+1);
            
            reta.adiciona(noAtual);
        }
        //reta.adiciona(no2);
        
        return reta;
    }
    
}
