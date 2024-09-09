package vue2D;

import labyrinthe.ISalle;
import vue2D.sprites.ISprite;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author INFO Professors team
 */
public abstract class AVue extends CopyOnWriteArrayList<ISprite> implements IVue {

    public static final int UNITE = 20;

    @Override
    public boolean add(ISprite sprite) {
        super.add(sprite);
        ISalle s = sprite.getPosition();
//        for (int i = 1; i < UNITE; i++) {
//            temporisation(1000);
            sprite.setCoordonnees(s.getX() * UNITE, s.getY() * UNITE);
//            this.dessiner();
//            
//        }
        
        return true;
    }
//    
//    protected void temporisation(int nb) {
//        try {
//            Thread.sleep(nb); // pause de nb millisecondes
//        } catch (InterruptedException ie) {
//        }
//    }

}
