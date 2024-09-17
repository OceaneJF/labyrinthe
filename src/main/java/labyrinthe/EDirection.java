/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labyrinthe;

/**
 * @author ojfrancois
 */
public enum EDirection {
    NORD,
    SUD,
    EST,
    OUEST,
    CENTER;

    /**
     * Renvoie le nombre de salles parcourues horizontalement lorsqu'on suit
     * cette direction (0 pour Nord, Sud et Center, -1 pour Ouest, 1 pour Est).
     *
     * @param dir la direction à considérer
     * @return nombre de salles horizontales de cette direction
     */
    static int mvtHoriz(EDirection dir) {
        int dh = -2;
        switch (dir) {
            case CENTER:
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
     * Renvoie le nombre de salles parcourues verticalement lorsqu'on suit cette
     * direction (0 pour Est, Ouest et Center, -1 pour Nord, 1 pour Sud).
     *
     * @param dir la direction d'origine
     * @return nombre de salles verticales de cette direction
     */
    static int mvtVertic(EDirection dir) {
        int dv = -2;
        switch (dir) {
            case CENTER:
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
