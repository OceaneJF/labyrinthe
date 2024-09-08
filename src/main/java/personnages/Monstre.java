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

    private ISalle salleChoisie;

    public Monstre(ISalle position) {
        super(position);
    }

    public ISalle getSalleChoisie() {
        return salleChoisie;
    }

    public void setSalleChoisie(ISalle salleChoisie) {
        this.salleChoisie = salleChoisie;
    }

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
