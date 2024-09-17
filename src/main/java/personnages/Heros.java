/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personnages;

import labyrinthe.ISalle;

import java.util.Collection;

/**
 * @author ojfrancois
 */
public class Heros extends APersonnage {

    //La salle ou le joueur a choisit d'aller
    private ISalle salleChoisie;

    public Heros(ISalle position) {
        super(position);
    }

    /**
     * Cette méthode permet de récuperer la salle choisie
     * @return une salle, la salle choisie
     */
    public ISalle getSalleChoisie() {
        return salleChoisie;
    }

    /**
     * Cette méthode permet de modifier la salle choisie
     * @param salleChoisie , la nouvelle salle choisie
     */
    public void setSalleChoisie(ISalle salleChoisie) {
        this.salleChoisie = salleChoisie;
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (salleChoisie != null) {
            if (sallesAccessibles.contains(salleChoisie)) {
                return salleChoisie;
            }
        }
        return super.getPosition();
    }

}
