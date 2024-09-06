/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue2D.sprites;

import java.util.Collection;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import static vue2D.AVue.UNITE;

/**
 *
 * @author ojfrancois
 */
public abstract class ASprite implements ISprite {
  
    private IPersonnage perso;
    private int xpix ;
    private int ypix ;
    private Image image;

    public ASprite(IPersonnage perso) {
        this.perso = perso;
    }

//    public ASprite(IPersonnage perso, int xpix, int ypix, Image image) {
//        this.perso = perso;
//        this.xpix = xpix;
//        this.ypix = ypix;
//        this.image = image;
//    }
    
      public IPersonnage getPerso() {
        return perso;
    }

    public void setPerso(IPersonnage perso) {
        this.perso = perso;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
        public int getXpix() {
        return xpix;
    }

    public int getYpix() {
        return ypix;
    }
    

    @Override
    public void dessiner(GraphicsContext g) {
      
        g.drawImage(image,xpix, ypix , UNITE,UNITE);
          
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        this.xpix = xpix;
         this.ypix = ypix;
    }

    
    
}
