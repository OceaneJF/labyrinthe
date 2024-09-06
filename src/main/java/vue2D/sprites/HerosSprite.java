/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue2D.sprites;

import javafx.scene.input.KeyEvent;
import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import labyrinthe.EDirection;
import labyrinthe.ESalle;
import labyrinthe.Etage;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Labyrinthe;
import labyrinthe.Salle;
import personnages.Heros;
import personnages.IPersonnage;

/**
 *
 * @author ojfrancois
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {

    private Heros heros;
    private ILabyrinthe labyrinthe;

    public HerosSprite(Heros h, ILabyrinthe lab) {
        super(h);
        this.heros = h;
        this.labyrinthe = lab;
        super.setImage(new Image("file:icons/link/LinkRunShieldL1.gif"));

    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return heros.faitSonChoix(sallesAccessibles);
    }

    @Override
    public ISalle getPosition() {
        return heros.getPosition();
    }

    @Override
    public void setPosition(ISalle s) {
        heros.setPosition(s);
    }

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
                break;
            case D:
                MD = -1;
                break;
        }
        ISalle positionActuelle = heros.getPosition();
        Salle s = new Salle(positionActuelle.getX(), positionActuelle.getY(), positionActuelle.getType(), new Etage(positionActuelle.getEtage().getNum() + MD));
        Salle suivante = null;
        if (d != null) {
            suivante = s.suivante(d);
        } else {
            suivante = s;
        }
        heros.setSalleChoisie(suivante);
    }

}
