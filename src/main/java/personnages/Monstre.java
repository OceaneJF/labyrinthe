/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personnages;

import java.util.ArrayList;
import labyrinthe.ISalle;

import java.util.Collection;
import java.util.Random;

/**
 * @author ojfrancois
 */
public class Monstre extends APersonnage {
// la salle ou le monstre a choisit d'aller
    private ISalle salleChoisie;

    public Monstre(ISalle position) {
        super(position);
    }

    /**
     * Cette méthode permet de récupérer la salle choisie par le monstre 
     * @return une salle, la salle choisie par le monstre 
     */
    public ISalle getSalleChoisie() {
        return salleChoisie;
    }
    /**
     * Cette méthode permet de modifier la salle choisie par le monstre 
     * @param salleChoisie , la nouvelle salle choisie 
     */
    public void setSalleChoisie(ISalle salleChoisie) {
        this.salleChoisie = salleChoisie;
    }

    /**
     * Cette méthode permet de choisir une salle aléatoirement parmis les salles accéssibles et de la retourner
     * @param sallesAccessibles, la liste des salles accessibles par le monstre
     * @return une salle, la salle choisie aléatoirement parmis les salles accessibles
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (sallesAccessibles.size() > 0) {
            int nbSalleAccessibles = sallesAccessibles.size();
            Random rand = new Random();
            int numSalle = rand.nextInt(nbSalleAccessibles);
            ArrayList<ISalle> array = new ArrayList(sallesAccessibles);
            return array.get(numSalle);
        }
        return super.getPosition();
    }

}
