/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue2D.sprites;

import javafx.scene.image.Image;
import labyrinthe.*;
import java.util.Collection;
import personnages.Monstre;

/**
 * @author ojfrancois
 */
public class MonstreSprite extends ASprite {
    //le monstre correspondant au sprite
    private Monstre monstre;
    //le labyrinthe dans lequel se trouve le monstre
    private ILabyrinthe labyrinthe;

    public MonstreSprite(Monstre m, ILabyrinthe lab) {
        super(m);
        this.monstre = m;
        this.labyrinthe = lab;
        super.setImage(new Image("file:icons/monstre0.gif"));

    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (!isEnDeplacement()) {
            return monstre.faitSonChoix(sallesAccessibles);
        }
        return monstre.getPosition();
    }

    @Override
    public ISalle getPosition() {
        return monstre.getPosition();
    }

    @Override
    public void setPosition(ISalle s) {
        monstre.setPosition(s);
    }

}
