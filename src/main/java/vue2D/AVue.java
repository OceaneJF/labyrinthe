package vue2D;

import labyrinthe.ISalle;
import vue2D.sprites.ISprite;

import java.util.ArrayList;

/**
 * @author INFO Professors team
 */
public abstract class AVue extends ArrayList<ISprite> implements IVue {

    public static final int UNITE = 20;

    @Override
    public boolean add(ISprite sprite) {
        super.add(sprite);
        ISalle s = sprite.getPosition();
        System.out.println(s.getEtage().getNum());
        sprite.setCoordonnees(s.getX() * UNITE, s.getY() * UNITE);
        return true;
    }

}
