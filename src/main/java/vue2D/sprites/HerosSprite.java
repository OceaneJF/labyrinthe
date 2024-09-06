/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue2D.sprites;

import javafx.scene.input.KeyEvent;
import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import labyrinthe.ISalle;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
