package vue2D.javafx;

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
        System.out.println(largeur * unite+" / "+hauteur * unite);
        setHeight(hauteur * unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
    }

    public void chargementImages() {
        murImage = new Image("file:icons/mur0.gif");
        solImage = new Image("file:icons/pyramide.png");
        escalierM = new Image("file:icons/up.gif");
        escalierD = new Image("file:icons/down.gif");
        entreeImg = new Image("file:icons/groundP.gif");
        sortieImg = new Image("file:icons/sortie.gif");
        salleImg=new Image("file:icons/ground.gif");
    }

    public void dessinFond() {
        tampon.drawImage(solImage, 0, 0, unite * largeur,
                unite * hauteur);
    }

    public void dessinSalles(IEtage etage) {
        for (ISalle s : etage) {
            Color c = Color.rgb(200, 200, 200);
            dessinSalle(s, c);
        }
    }

    public void dessinSalle(ISalle s, Color c) {
   
        switch (s.getType()) {
            case ENTREE:
                         tampon.drawImage(entreeImg,s.getX()*largeur, s.getY()*hauteur , unite,unite);
                break;
                  case ESCALIER_DESCENDANT:
                           tampon.drawImage(escalierD,s.getX()*largeur, s.getY()*hauteur , unite,unite);
                          
                break;
                case ESCALIER_MONTANT:
                           tampon.drawImage(escalierM, s.getX()*largeur, s.getY()*hauteur , unite,unite);
                           
                break;
                case NORMALE:
                         tampon.drawImage(entreeImg, s.getX()*largeur, s.getY()*hauteur , unite,unite);
                          
                break;
                case SORTIE:
                     tampon.drawImage(sortieImg, s.getX()*hauteur, s.getY()*largeur, unite,unite);
                break;
            default:
                throw new AssertionError();
        }
    }

    public void dessinPlusCourtChemin(ISprite p) {
        // ...
    }

}
