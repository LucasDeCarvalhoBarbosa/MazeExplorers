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
    
    private static final String MAPA_3 = "assets/Labirintos/Modelo3/Mapa.tmx";
    
    public static LabirintoVisual geraLabirinto(int labirintoEscolhido) throws SlickException{
        No[][] espaco;
        switch(labirintoEscolhido){
            case 0:
                return geraLabirinto(3);
                
            case 1:
                return geraLabirinto(3);
                
            case 2:
                return geraLabirinto(3);
                
            case 3:
                espaco = new No[20][20];
                espaco[0][0] = new No(0, 0, false);
                espaco[0][1] = new No(0, 1, false);
                espaco[0][2] = new No(0, 2, false);
                espaco[0][3] = new No(0, 3, false);
                espaco[0][4] = new No(0, 4, false);
                espaco[0][5] = new No(0, 5, false);
                espaco[0][6] = new No(0, 6, false);
                espaco[0][7] = new No(0, 7, false);
                espaco[0][8] = new No(0, 8, false);
                espaco[0][9] = new No(0, 9, false);
                espaco[0][10] = new No(0, 10, false);
                espaco[0][11] = new No(0, 11, false);
                espaco[0][12] = new No(0, 12, false);
                espaco[0][13] = new No(0, 13, false);
                espaco[0][14] = new No(0, 14, false);
                espaco[0][15] = new No(0, 15, false);
                espaco[0][16] = new No(0, 16, false);
                espaco[0][17] = new No(0, 17, false);
                espaco[0][18] = new No(0, 18, false);
                espaco[0][19] = new No(0, 19, false);
                espaco[1][0] = new No(1, 0, true);
                espaco[1][1] = new No(1, 1, true);
                espaco[1][2] = new No(1, 2, true);
                espaco[1][3] = new No(1, 3, true);
                espaco[1][4] = new No(1, 4, true);
                espaco[1][5] = new No(1, 5, true);
                espaco[1][6] = new No(1, 6, true);
                espaco[1][7] = new No(1, 7, true);
                espaco[1][8] = new No(1, 8, true);
                espaco[1][9] = new No(1, 9, true);
                espaco[1][10] = new No(1, 10, true);
                espaco[1][11] = new No(1, 11, true);
                espaco[1][12] = new No(1, 12, true);
                espaco[1][13] = new No(1, 13, true);
                espaco[1][14] = new No(1, 14, true);
                espaco[1][15] = new No(1, 15, true);
                espaco[1][16] = new No(1, 16, true);
                espaco[1][17] = new No(1, 17, true);
                espaco[1][18] = new No(1, 18, true);
                espaco[1][19] = new No(1, 19, false);
                espaco[2][0] = new No(2, 0, false);
                espaco[2][1] = new No(2, 1, false);
                espaco[2][2] = new No(2, 2, false);
                espaco[2][3] = new No(2, 3, false);
                espaco[2][4] = new No(2, 4, false);
                espaco[2][5] = new No(2, 5, false);
                espaco[2][6] = new No(2, 6, false);
                espaco[2][7] = new No(2, 7, false);
                espaco[2][8] = new No(2, 8, false);
                espaco[2][9] = new No(2, 9, false);
                espaco[2][10] = new No(2, 10, false);
                espaco[2][11] = new No(2, 11, false);
                espaco[2][12] = new No(2, 12, false);
                espaco[2][13] = new No(2, 13, false);
                espaco[2][14] = new No(2, 14, false);
                espaco[2][15] = new No(2, 15, false);
                espaco[2][16] = new No(2, 16, false);
                espaco[2][17] = new No(2, 17, false);
                espaco[2][18] = new No(2, 18, true);
                espaco[2][19] = new No(2, 19, false);
                espaco[3][0] = new No(3, 0, false);
                espaco[3][1] = new No(3, 1, true);
                espaco[3][2] = new No(3, 2, true);
                espaco[3][3] = new No(3, 3, true);
                espaco[3][4] = new No(3, 4, true);
                espaco[3][5] = new No(3, 5, true);
                espaco[3][6] = new No(3, 6, true);
                espaco[3][7] = new No(3, 7, true);
                espaco[3][8] = new No(3, 8, true);
                espaco[3][9] = new No(3, 9, true);
                espaco[3][10] = new No(3, 10, false);
                espaco[3][11] = new No(3, 11, false);
                espaco[3][12] = new No(3, 12, false);
                espaco[3][13] = new No(3, 13, true);
                espaco[3][14] = new No(3, 14, true);
                espaco[3][15] = new No(3, 15, true);
                espaco[3][16] = new No(3, 16, true);
                espaco[3][17] = new No(3, 17, false);
                espaco[3][18] = new No(3, 18, true);
                espaco[3][19] = new No(3, 19, false);
                espaco[4][0] = new No(4, 0, false);
                espaco[4][1] = new No(4, 1, true);
                espaco[4][2] = new No(4, 2, false);
                espaco[4][3] = new No(4, 3, false);
                espaco[4][4] = new No(4, 4, false);
                espaco[4][5] = new No(4, 5, false);
                espaco[4][6] = new No(4, 6, false);
                espaco[4][7] = new No(4, 7, false);
                espaco[4][8] = new No(4, 8, false);
                espaco[4][9] = new No(4, 9, true);
                espaco[4][10] = new No(4, 10, true);
                espaco[4][11] = new No(4, 11, true);
                espaco[4][12] = new No(4, 12, false);
                espaco[4][13] = new No(4, 13, false);
                espaco[4][14] = new No(4, 14, true);
                espaco[4][15] = new No(4, 15, false);
                espaco[4][16] = new No(4, 16, true);
                espaco[4][17] = new No(4, 17, true);
                espaco[4][18] = new No(4, 18, true);
                espaco[4][19] = new No(4, 19, false);
                espaco[5][0] = new No(5, 0, false);
                espaco[5][1] = new No(5, 1, true);
                espaco[5][2] = new No(5, 2, false);
                espaco[5][3] = new No(5, 3, false);
                espaco[5][4] = new No(5, 4, false);
                espaco[5][5] = new No(5, 5, true);
                espaco[5][6] = new No(5, 6, false);
                espaco[5][7] = new No(5, 7, true);
                espaco[5][8] = new No(5, 8, false);
                espaco[5][9] = new No(5, 9, false);
                espaco[5][10] = new No(5, 10, false);
                espaco[5][11] = new No(5, 11, true);
                espaco[5][12] = new No(5, 12, false);
                espaco[5][13] = new No(5, 13, false);
                espaco[5][14] = new No(5, 14, true);
                espaco[5][15] = new No(5, 15, false);
                espaco[5][16] = new No(5, 16, false);
                espaco[5][17] = new No(5, 17, false);
                espaco[5][18] = new No(5, 18, false);
                espaco[5][19] = new No(5, 19, false);
                espaco[6][0] = new No(6, 0, false);
                espaco[6][1] = new No(6, 1, true);
                espaco[6][2] = new No(6, 2, true);
                espaco[6][3] = new No(6, 3, true);
                espaco[6][4] = new No(6, 4, true);
                espaco[6][5] = new No(6, 5, true);
                espaco[6][6] = new No(6, 6, true);
                espaco[6][7] = new No(6, 7, true);
                espaco[6][8] = new No(6 ,8, true);
                espaco[6][9] = new No(6, 9, true);
                espaco[6][10] = new No(6, 10, false);
                espaco[6][11] = new No(6, 11, true);
                espaco[6][12] = new No(6, 12, false);
                espaco[6][13] = new No(6, 13, false);
                espaco[6][14] = new No(6, 14, true);
                espaco[6][15] = new No(6, 15, false);
                espaco[6][16] = new No(6, 16, true);
                espaco[6][17] = new No(6, 17, true);
                espaco[6][18] = new No(6, 18, true);
                espaco[6][19] = new No(6, 19, false);
                espaco[7][0] = new No(7, 0, false);
                espaco[7][1] = new No(7, 1, false);
                espaco[7][2] = new No(7, 2, false);
                espaco[7][3] = new No(7, 3, true);
                espaco[7][4] = new No(7, 4, false);
                espaco[7][5] = new No(7, 5, false);
                espaco[7][6] = new No(7, 6, true);
                espaco[7][7] = new No(7, 7, false);
                espaco[7][8] = new No(7, 8, false);
                espaco[7][9] = new No(7, 9, true);
                espaco[7][10] = new No(7, 10, false);
                espaco[7][11] = new No(7, 11, false);
                espaco[7][12] = new No(7, 12, false);
                espaco[7][13] = new No(7, 13, true);
                espaco[7][14] = new No(7, 14, true);
                espaco[7][15] = new No(7, 15, true);
                espaco[7][16] = new No(7, 16, true);
                espaco[7][17] = new No(7, 17, false);
                espaco[7][18] = new No(7, 18, true);
                espaco[7][19] = new No(7, 19, false);
                espaco[8][0] = new No(8, 0, false);
                espaco[8][1] = new No(8, 1, true);
                espaco[8][2] = new No(8, 2, false);
                espaco[8][3] = new No(8, 3, true);
                espaco[8][4] = new No(8, 4, true);
                espaco[8][5] = new No(8, 5, true);
                espaco[8][6] = new No(8, 6, true);
                espaco[8][7] = new No(8, 7, true);
                espaco[8][8] = new No(8, 8, true);
                espaco[8][9] = new No(8, 9, true);
                espaco[8][10] = new No(8, 10, false);
                espaco[8][11] = new No(8, 11, true);
                espaco[8][12] = new No(8, 12, true);
                espaco[8][13] = new No(8, 13, true);
                espaco[8][14] = new No(8, 14, false);
                espaco[8][15] = new No(8, 15, false);
                espaco[8][16] = new No(8, 16, false);
                espaco[8][17] = new No(8, 17, false);
                espaco[8][18] = new No(8, 18, true);
                espaco[8][19] = new No(8, 19, false);
                espaco[9][0] = new No(9, 0, false);
                espaco[9][1] = new No(9, 1, true);
                espaco[9][2] = new No(9, 2, false);
                espaco[9][3] = new No(9, 3, true);
                espaco[9][4] = new No(9, 4, false);
                espaco[9][5] = new No(9, 5, false);
                espaco[9][6] = new No(9, 6, false);
                espaco[9][7] = new No(9, 7, false);
                espaco[9][8] = new No(9, 8, false);
                espaco[9][9] = new No(9, 9, true);
                espaco[9][10] = new No(9, 10, false);
                espaco[9][11] = new No(9, 11, false);
                espaco[9][12] = new No(9, 12, false);
                espaco[9][13] = new No(9, 13, true);
                espaco[9][14] = new No(9, 14, true);
                espaco[9][15] = new No(9, 15, false);
                espaco[9][16] = new No(9, 16, true);
                espaco[9][17] = new No(9, 17, true);
                espaco[9][18] = new No(9, 18, true);
                espaco[9][19] = new No(9, 19, false);
                espaco[10][0] = new No(10, 0, false);
                espaco[10][1] = new No(10, 1, true);
                espaco[10][2] = new No(10, 2, true);
                espaco[10][3] = new No(10, 3, true);
                espaco[10][4] = new No(10, 4, true);
                espaco[10][5] = new No(10, 5, true);
                espaco[10][6] = new No(10, 6, false);
                espaco[10][7] = new No(10, 7, false);
                espaco[10][8] = new No(10, 8, false);
                espaco[10][9] = new No(10, 9, true);
                espaco[10][10] = new No(10, 10, false);
                espaco[10][11] = new No(10, 11, false);
                espaco[10][12] = new No(10, 12, false);
                espaco[10][13] = new No(10, 13, false);
                espaco[10][14] = new No(10, 14, true);
                espaco[10][15] = new No(10, 15, false);
                espaco[10][16] = new No(10, 16, false);
                espaco[10][17] = new No(10, 17, false);
                espaco[10][18] = new No(10, 18, true);
                espaco[10][19] = new No(10, 19, false);
                espaco[11][0] = new No(11, 0, false);
                espaco[11][1] = new No(11, 1, false);
                espaco[11][2] = new No(11, 2, false);
                espaco[11][3] = new No(11, 3, false);
                espaco[11][4] = new No(11, 4, false);
                espaco[11][5] = new No(11, 5, true);
                espaco[11][6] = new No(11, 6, false);
                espaco[11][7] = new No(11, 7, true);
                espaco[11][8] = new No(11, 8, true);
                espaco[11][9] = new No(11, 9, true);
                espaco[11][10] = new No(11, 10, true);
                espaco[11][11] = new No(11, 11, false);
                espaco[11][12] = new No(11, 12, true);
                espaco[11][13] = new No(11, 13, false);
                espaco[11][14] = new No(11, 14, true);
                espaco[11][15] = new No(11, 15, true);
                espaco[11][16] = new No(11, 16, false);
                espaco[11][17] = new No(11, 17, true);
                espaco[11][18] = new No(11, 18, true);
                espaco[11][19] = new No(11, 19, false);
                espaco[12][0] = new No(12, 0, false);
                espaco[12][1] = new No(12, 1, true);
                espaco[12][2] = new No(12, 2, true);
                espaco[12][3] = new No(12, 3, true);
                espaco[12][4] = new No(12, 4, true);
                espaco[12][5] = new No(12, 5, true);
                espaco[12][6] = new No(12, 6, false);
                espaco[12][7] = new No(12, 7, true);
                espaco[12][8] = new No(12, 8, false);
                espaco[12][9] = new No(12, 9, true);
                espaco[12][10] = new No(12, 10, false);
                espaco[12][11] = new No(12, 11, false);
                espaco[12][12] = new No(12, 12, true);
                espaco[12][13] = new No(12, 13, false);
                espaco[12][14] = new No(12, 14, false);
                espaco[12][15] = new No(12, 15, true);
                espaco[12][16] = new No(12, 16, false);
                espaco[12][17] = new No(12, 17, false);
                espaco[12][18] = new No(12, 18, false);
                espaco[12][19] = new No(12, 19, false);
                espaco[13][0] = new No(13, 0, false);
                espaco[13][1] = new No(13, 1, true);
                espaco[13][2] = new No(13, 2, false);
                espaco[13][3] = new No(13, 3, false);
                espaco[13][4] = new No(13, 4, true);
                espaco[13][5] = new No(13, 5, false);
                espaco[13][6] = new No(13, 6, false);
                espaco[13][7] = new No(13, 7, true);
                espaco[13][8] = new No(13, 8, true);
                espaco[13][9] = new No(13, 9, true);
                espaco[13][10] = new No(13, 10, true);
                espaco[13][11] = new No(13, 11, false);
                espaco[13][12] = new No(13, 12, true);
                espaco[13][13] = new No(13, 13, true);
                espaco[13][14] = new No(13, 14, false);
                espaco[13][15] = new No(13, 15, true);
                espaco[13][16] = new No(13, 16, true);
                espaco[13][17] = new No(13, 17, true);
                espaco[13][18] = new No(13, 18, false);
                espaco[13][19] = new No(13, 19, false);
                espaco[14][0] = new No(14, 0, false);
                espaco[14][1] = new No(14, 1, true);
                espaco[14][2] = new No(14, 2, true);
                espaco[14][3] = new No(14, 3, false);
                espaco[14][4] = new No(14, 4, true);
                espaco[14][5] = new No(14, 5, true);
                espaco[14][6] = new No(14, 6, false);
                espaco[14][7] = new No(14, 7, true);
                espaco[14][8] = new No(14, 8, false);
                espaco[14][9] = new No(14, 9, false);
                espaco[14][10] = new No(14, 10, true);
                espaco[14][11] = new No(14, 11, false);
                espaco[14][12] = new No(14, 12, false);
                espaco[14][13] = new No(14, 13, true);
                espaco[14][14] = new No(14, 14, false);
                espaco[14][15] = new No(14, 15, true);
                espaco[14][16] = new No(14, 16, false);
                espaco[14][17] = new No(14, 17, true);
                espaco[14][18] = new No(14, 18, true);
                espaco[14][19] = new No(14, 19, false);
                espaco[15][0] = new No(15, 0, false);
                espaco[15][1] = new No(15, 1, false);
                espaco[15][2] = new No(15, 2, true);
                espaco[15][3] = new No(15, 3, false);
                espaco[15][4] = new No(15, 4, false);
                espaco[15][5] = new No(15, 5, false);
                espaco[15][6] = new No(15, 6, false);
                espaco[15][7] = new No(15, 7, true);
                espaco[15][8] = new No(15, 8, true);
                espaco[15][9] = new No(15, 9, true);
                espaco[15][10] = new No(15, 10, true);
                espaco[15][11] = new No(15, 11, true);
                espaco[15][12] = new No(15, 12, true);
                espaco[15][13] = new No(15, 13, true);
                espaco[15][14] = new No(15, 14, true);
                espaco[15][15] = new No(15, 15, true);
                espaco[15][16] = new No(15, 16, false);
                espaco[15][17] = new No(15, 17, true);
                espaco[15][18] = new No(15, 18, false);
                espaco[15][19] = new No(15, 19, false);
                espaco[16][0] = new No(16, 0, true);
                espaco[16][1] = new No(16, 1, true);
                espaco[16][2] = new No(16, 2, true);
                espaco[16][3] = new No(16, 3, true);
                espaco[16][4] = new No(16, 4, true);
                espaco[16][5] = new No(16, 5, true);
                espaco[16][6] = new No(16, 6, true);
                espaco[16][7] = new No(16, 7, true);
                espaco[16][8] = new No(16, 8, false);
                espaco[16][9] = new No(16, 9, true);
                espaco[16][10] = new No(16, 10, false);
                espaco[16][11] = new No(16, 11, true);
                espaco[16][12] = new No(16, 12, false);
                espaco[16][13] = new No(16, 13, false);
                espaco[16][14] = new No(16, 14, false);
                espaco[16][15] = new No(16, 15, true);
                espaco[16][16] = new No(16, 16, true);
                espaco[16][17] = new No(16, 17, true);
                espaco[16][18] = new No(16, 18, true);
                espaco[16][19] = new No(16, 19, false);
                espaco[17][0] = new No(17, 0, false);
                espaco[17][1] = new No(17, 1, false);
                espaco[17][2] = new No(17, 2, true);
                espaco[17][3] = new No(17, 3, false);
                espaco[17][4] = new No(17, 4, false);
                espaco[17][5] = new No(17, 5, true);
                espaco[17][6] = new No(17, 6, false);
                espaco[17][7] = new No(17, 7, true);
                espaco[17][8] = new No(17, 8, true);
                espaco[17][9] = new No(17, 9, true);
                espaco[17][10] = new No(17, 10, true);
                espaco[17][1] = new No(17, 11, true);
                espaco[17][12] = new No(17, 12, true);
                espaco[17][13] = new No(17, 13, true);
                espaco[17][14] = new No(17, 14, false);
                espaco[17][15] = new No(17, 15, true);
                espaco[17][16] = new No(17, 16, false);
                espaco[17][17] = new No(17, 17, true);
                espaco[17][18] = new No(17, 18, false);
                espaco[17][19] = new No(17, 19, false);
                espaco[18][0] = new No(18, 0, false);
                espaco[18][1] = new No(18, 1, true);
                espaco[18][2] = new No(18, 2, true);
                espaco[18][3] = new No(18, 3, false);
                espaco[18][4] = new No(18, 4, true);
                espaco[18][5] = new No(18, 5, true);
                espaco[18][6] = new No(18, 6, false);
                espaco[18][7] = new No(18, 7, true);
                espaco[18][8] = new No(18, 8, true);
                espaco[18][9] = new No(18, 9, false);
                espaco[18][10] = new No(18, 10, true);
                espaco[18][11] = new No(18, 11, false);
                espaco[18][12] = new No(18, 12, false);
                espaco[18][13] = new No(18, 13, true);
                espaco[18][14] = new No(18, 14, false);
                espaco[18][15] = new No(18, 15, true);
                espaco[18][16] = new No(18, 16, true);
                espaco[18][17] = new No(18, 17, true);
                espaco[18][18] = new No(18, 18, true);
                espaco[18][19] = new No(18, 19, false);
                espaco[19][0] = new No(19, 0, false);
                espaco[19][1] = new No(19, 1, false);
                espaco[19][2] = new No(19, 2, false);
                espaco[19][3] = new No(19, 3, false);
                espaco[19][4] = new No(19, 4, false);
                espaco[19][5] = new No(19, 5, false);
                espaco[19][6] = new No(19, 6, false);
                espaco[19][7] = new No(19, 7, false);
                espaco[19][8] = new No(19, 8, false);
                espaco[19][9] = new No(19, 9, false);
                espaco[19][10] = new No(19, 10, false);
                espaco[19][11] = new No(19, 11, false);
                espaco[19][12] = new No(19, 12, false);
                espaco[19][13] = new No(19, 13, false);
                espaco[19][14] = new No(19, 14, false);
                espaco[19][15] = new No(19, 15, false);
                espaco[19][16] = new No(19, 16, false);
                espaco[19][17] = new No(19, 17, false);
                espaco[19][18] = new No(19, 18, false);
                espaco[19][19] = new No(19, 19, false);
                
                LabirintoVisual visual = new LabirintoVisual();
                visual.labirinto = new Labirinto(espaco, new No(0, 16), new No(0, 1));
                visual.mapa = new TiledMap(MAPA_3);
                visual.tamanhoTiles = 32;
                return visual;
                
            case 4:
                return geraLabirinto(3);
                
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
