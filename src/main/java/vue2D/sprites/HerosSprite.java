/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue2D.sprites;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import labyrinthe.*;
import personnages.Heros;
import java.util.Collection;

/**
 * @author ojfrancois
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {

    // le heros correspondant au sprite
    private Heros heros;
    // le labyrinthe dans lequel est affiché le sprite
    private ILabyrinthe labyrinthe;

    public HerosSprite(Heros h, ILabyrinthe lab) {
        super(h);
        this.heros = h;
        this.labyrinthe = lab;
        super.setImage(new Image("file:icons/link/LinkRunShieldL1.gif"));

    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (!isEnDeplacement()) {
            return heros.faitSonChoix(sallesAccessibles);
        }
        return heros.getPosition();
    }

    @Override
    public ISalle getPosition() {
        return heros.getPosition();
    }

    @Override
    public void setPosition(ISalle s) {
        heros.setPosition(s);
    }

    /**
     * Cette méthode permet de modifier la salle choisie du personage en fonction de la direction choisie par le joueur avec les touches du clavier 
     * @param t la touche préssée
     */
    @Override
    public void handle(KeyEvent t) {
        KeyCode code = t.getCode();
        EDirection d = null;
        int MD = 0;
        switch (code) {
            case LEFT:
                d = EDirection.OUEST;
                break;
            case RIGHT:
                d = EDirection.EST;
                break;
            case UP:
                d = EDirection.NORD;
                break;
            case DOWN:
                d = EDirection.SUD;
                break;
            case M:
                MD = 1;
                d=EDirection.CENTER;
                break;
            case D:
                MD = -1;
                d=EDirection.CENTER;
                break;
        }
        Salle s = (Salle)heros.getPosition();
        Etage etage = new Etage(s.getEtage().getNum() + MD);
        etage.addAll(s.getEtage());

           Salle suivante = s.suivante(d);
            if (suivante.getType().equals(ESalle.ESCALIER_MONTANT) || suivante.getType().equals(ESalle.ESCALIER_DESCENDANT)) {
                Labyrinthe lab = (Labyrinthe) labyrinthe;
                Etage newEtage = lab.getEtage(etage.getNum());
                suivante.setEtage(newEtage);
            }
        heros.setSalleChoisie(suivante);
    }

}

