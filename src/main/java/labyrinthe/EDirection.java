/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labyrinthe;

/**
 *
 * @author ojfrancois
 */
public enum EDirection {
    NORD,
    SUD,
    EST,
    OUEST;
    
    /**
     * Renvoie le nombre de cases parcourues horizontalement lorsqu'on suit
     * cette direction (0 pour Nord et Sud, -1 pour Ouest, 1 pour Est).
     *
     * @param dir la direction à considérer
     * @return nombre de cases horizontales de cette direction
     */
    static int mvtHoriz(EDirection dir) {
        int dh = -2;
        switch (dir) {
            case NORD:
            case SUD:
                dh = 0;
                break;
            case EST:
                dh = 1;
                break;
            case OUEST:
                dh = -1;
                break;
        }
        return dh;
    }
    
    /**
     * Renvoie le nombre de cases parcourues verticalement lorsqu'on suit cette
     * direction (0 pour Est et Ouest, -1 pour Nord, 1 pour Sud).
     *
     * @param dir la direction d'origine
     * @return nombre de cases verticales de cette direction
     */
    static int mvtVertic(EDirection dir) {
        int dv = -2;
        switch (dir) {
            case EST:
            case OUEST:
                dv = 0;
                break;
            case NORD:
                dv = -1;
                break;
            case SUD:
                dv = 1;
                break;
        }
        return dv;
    }
}
