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
import labyrinthe.ISalle;
import labyrinthe.Salle;
import personnages.Heros;
import personnages.IPersonnage;

/**
 *
 * @author ojfrancois
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent>{
    

    public HerosSprite(IPersonnage perso) {
        super(perso);
        super.setImage(new Image ("file : icons/link/LinkRunShieldL1.gif") );
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ISalle getPosition() {
        return null;
    }

    @Override
    public void setPosition(ISalle s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void handle(KeyEvent t) {
       KeyCode code= t.getCode();
       EDirection d=null;
       int MD=0;
        switch (code) {
            case LEFT:
                d=EDirection.OUEST;
                break;
            case RIGHT:
                d=EDirection.EST;
                break;
            case UP:
                d=EDirection.NORD;
                break;
            case DOWN:
                d=EDirection.SUD;
                break;
            case M:
                MD=1;
                break;
            case D:
                MD=-1;
                break;
            default:
                throw new AssertionError();
        }
        ISalle positionActuelle=super.getPerso().getPosition();
        Salle s= new Salle(positionActuelle.getX(), positionActuelle.getY(), positionActuelle.getType(),new Etage(positionActuelle.getEtage().getNum()+MD) );
        Salle suivante=null;
        if(d!=null) {
            suivante= s.suivante(d);
        }
        super.getPerso().setPosition(suivante);
       
 
    }

    
    
}
