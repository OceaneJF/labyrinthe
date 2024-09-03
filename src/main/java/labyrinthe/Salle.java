/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labyrinthe;

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

    @Override
    public boolean estAdjacente(ISalle autre) {
        return false;
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
