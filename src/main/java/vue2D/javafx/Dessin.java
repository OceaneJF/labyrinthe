package vue2D.javafx;

import java.util.ArrayList;
import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import labyrinthe.ESalle;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import vue2D.AVue;
import vue2D.sprites.ISprite;
import labyrinthe.IEtage;
import labyrinthe.Salle;

/**
 *
 * @author INFO Professors team
 */
public class Dessin extends Canvas {

    private Collection<ISprite> sprites;
    private int unite;

    // donnees labyrinthe labyrinthe
    private ILabyrinthe labyrinthe;
    private ISalle entree;
    private ISalle sortie;
    private int largeur;
    private int hauteur;

    private GraphicsContext tampon;
    private Image murImage;
    private Image solImage;
    private Image escalierM;
    private Image escalierD;
    private Image entreeImg;
    private Image sortieImg;
    private Image salleImg;
    private int tailleLinkH = 6;
    private int tailleLinkL = 2;

    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites) {
        this.labyrinthe = labyrinthe;
        this.sprites = sprites;
        this.unite = AVue.UNITE;
        entree = labyrinthe.getEntree();
        sortie = labyrinthe.getSortie();
        largeur = labyrinthe.getEtageCourant().getLargeur();
        hauteur = labyrinthe.getEtageCourant().getHauteur();
        setWidth(largeur * unite);
        System.out.println(largeur * unite + " / " + hauteur * unite);
        setHeight(hauteur * unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
    }

    public void chargementImages() {
        murImage = new Image("file:icons/mur0.gif");
        solImage = new Image("file:icons/ground.gif");
        escalierM = new Image("file:icons/up.gif");
        escalierD = new Image("file:icons/down.gif");
        entreeImg = new Image("file:icons/groundP.gif");
        sortieImg = new Image("file:icons/sortie.gif");
        salleImg = new Image("file:icons/ground.gif");
    }

    public void dessinFond() {
        tampon.drawImage(solImage, 0, 0, unite * largeur,
                unite * hauteur);
    }

    /**
     * Cette méthode permet de dessiner tous les murs d'un étage
     *
     * @param etage l'étage
     */
    public void dessinMurs(IEtage etage) {
        ArrayList<Salle> voisines;
        for (ISalle iS : etage) {
            Salle s = new Salle(iS.getX(), iS.getY(), iS.getType(), iS.getEtage());
            voisines = s.voisines();
            for (Salle v : voisines) {
                if (!etage.contains(v)) {
                    tampon.drawImage(murImage, v.getX() * unite, v.getY() * unite, unite, unite);
                }
            }
        }
    }

    public void dessinSprites() {
        for (ISprite s : sprites) {
            if (s.getPosition().getEtage().getNum() == labyrinthe.getEtageCourant().getNum()) {
                s.dessiner(tampon);
            }
        }
    }

    public void dessinSalles(IEtage etage) {
        for (ISalle s : etage) {
            Color c = Color.rgb(200, 200, 200);
            dessinSalle(s, c);
        }
    }

    public void dessinSalle(ISalle s, Color c) {
        tampon.drawImage(image(s), s.getX() * unite, s.getY() * unite, unite, unite);

    }

    /**
     * Cette méthode retourne l'image correspondant au type de Salle
     *
     * @param s la salle
     * @return l'image correspondante
     */
    private Image image(ISalle s) {
        switch (s.getType()) {
            case ENTREE:
                return entreeImg;
            case ESCALIER_DESCENDANT:
                return escalierD;
            case ESCALIER_MONTANT:
                return escalierM;
            case NORMALE:
                return salleImg;
            case SORTIE:
                return sortieImg;
            default:
                throw new AssertionError();
        }
    }

    public void dessinPlusCourtChemin(ISprite p) {
        // ...
    }

}
