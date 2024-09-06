/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;
import vue2D.sprites.HerosSprite;

/**
 *
 * @author ojfrancois
 */
public class Heros extends APersonnage {

    private ISalle salleChoisie;

    public Heros(ISalle position) {
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
        if(sallesAccessibles.contains(salleChoisie)) {
            return salleChoisie;
        }
        return super.getPosition();
    }
    
}
