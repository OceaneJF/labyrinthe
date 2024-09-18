/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ISalle;
import personnages.IPersonnage;

import static vue2D.AVue.UNITE;

/**
 * @author ojfrancois
 */
public abstract class ASprite implements ISprite {

    //le personnage correspondant au sprite
    private IPersonnage perso;
    // les coordonnées du sprite
    private int xpix;
    private int ypix;
    // la vitesse de déplacement
    private int pixel = 1;
    //l'image correspondant au personnage
    private Image image;
  
    private boolean enDeplacement = false;

    public ASprite(IPersonnage perso) {
        this.perso = perso;
        xpix = perso.getPosition().getX() * UNITE;
        ypix = perso.getPosition().getY() * UNITE;
    }

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

    /**
     * Cette méthode permet de dessiner le sprite
     * @param g le GraphicContext
     */
    @Override
    public void dessiner(GraphicsContext g) {
        g.drawImage(image, xpix, ypix, UNITE, UNITE);
    }

    /**
     * Cette méthode permet de mettre à jour les coordonnéescorrespondant à la position du sprite
     * @param xpix un int, coordonnées x
     * @param ypix un int, coordonnées y
     */
    @Override
    public void setCoordonnees(int xpix, int ypix) {
        this.xpix = xpix;
        this.ypix = ypix;
    }

    /**
     * Cette méthode permet mettre à jour les coordonnées du sprite pour que son déplacement soit plus fluide
     */
    public void updatePosition() {
        ISalle sprite = perso.getPosition();
        double cibleX = sprite.getX() * UNITE;
        double cibleY = sprite.getY() * UNITE;

        if (cibleX != xpix) {
            xpix += move(cibleX, xpix) * pixel;
            enDeplacement = true;
        } else {
            xpix = (int) cibleX;
        }

        if (cibleY != ypix) {
            ypix += move(cibleY, ypix) * pixel;
            enDeplacement = true;
        } else {
            ypix = (int) cibleY;
        }

        setCoordonnees((int) xpix, (int) ypix);

        if (xpix == cibleX && ypix == cibleY) {
            enDeplacement = false;
        }
    }

    /**
     * Cette méthode permet de déplacer le sprite en ajustant progressivement sa position actuelle
     * en fonction de la position cible. Elle retourne une valeur indiquant la direction du mouvement.
     *
     * @param cible La position cible à atteindre.
     * @param pos La position actuelle du sprite.
     * @return 1 si la position actuelle est inférieure à la cible (déplacement vers la droite ou le bas),
     *         -1 si la position actuelle est supérieure à la cible (déplacement vers la gauche ou le haut),
     *         0 si la position actuelle est égale à la cible (pas de déplacement).
     */
    private int move(double cible, int pos) {
        if (cible - pos > 0) {
            return 1;
        } else if (cible - pos < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Cette méthode permet de savoir si un sprite est en cours de déplacement ou non 
     * @return un booléen, vrai si le sprite est en déplacement, false sinon 
     */
    public boolean isEnDeplacement() {
        return enDeplacement;
    }
}
