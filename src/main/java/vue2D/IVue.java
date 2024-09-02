package vue2D;

import java.util.Collection;

import vue2D.sprites.ISprite;

/**
*
* @author INFO Professors team
*/
// une vue est une collection de sprites
public interface IVue extends Collection<ISprite>{
    public void dessiner();   
}
