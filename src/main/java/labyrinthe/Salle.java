/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labyrinthe;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author ojfrancois
 */
public class Salle implements ISalle{
    // Coordonnée x de la salle
    private int x;
    //Coordonnée y de la salle 
    private int y;
    //Type de la salle 
    private ESalle type;
    //Etage ou se trouve la salle 
    private IEtage etage;
    
    public Salle(int x, int y, ESalle type, IEtage etage) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.etage = etage;
    }
    
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setType(ESalle type) {
        this.type = type;
    }

    public void setEtage(IEtage etage) {
        this.etage = etage;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
       return y;
    }

    @Override
    public ESalle getType() {
        return type;
    }

    @Override
    public IEtage getEtage() {
        return etage;
    }
    
    /**
     * Cette méthode vérifie si la salle est dans l'étage
     * @return 
     */
    private boolean estDansEtage(Salle salle){
        int largeur=salle.getEtage().getLargeur();
        int hauteur=salle.getEtage().getHauteur();
        return salle.getX()>=0 && salle.getX()<largeur && salle.getY()>=0 && salle.getY()<hauteur; 
        
    }
    
    /**
     * Retourne les coordonnées de toutes les cases voisines.
     * 
     * @param coord coordonnées de la case considérée
     * @param taille taille du plateau (carré)
     * @return les coordonnées de toutes les cases voisines
     */
    private ArrayList<Salle> voisines(ISalle salle) {
        ArrayList<Salle> voisines = new ArrayList<>();
        for (EDirection dir : EDirection.values()) {
            if (estDansEtage(suivante(salle,dir))) {
                voisines.add(suivante(salle,dir));
            }         
        }
        return voisines;
    }

     /**
     * Renvoie la salle suivante
     *
     * @param d la direction à suivre
     * @return les coordonnées de la case suivante
     */
    private Salle suivante(ISalle salle, EDirection d) {
        return new Salle(salle.getX() + EDirection.mvtVertic(d), 
                salle.getY() + EDirection.mvtHoriz(d),ESalle.NORMALE, etage);
    }
    
    @Override
    public boolean estAdjacente(ISalle autre) {
        Arraylist<Salle> salleAdjacentes= voisines(autre);
        return salleAdjacentes.contains(autre);
    }
    
    /**
     * Deux salle sont identique si elles on les memes coordonnées et le meme étage 
     * @param obj l'objet que l'on veut comparer
     * @return true si les salle sont identiques , false sinon
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salle other = (Salle) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return Objects.equals(this.etage, other.etage);
    }
/**
 * Deux salle sont identique si elles on les memes coordonnées et le meme étage 
 * @return le hashCode
 */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.x;
        hash = 79 * hash + this.y;
        hash = 79 * hash + Objects.hashCode(this.etage);
        return hash;
    }
    
}
