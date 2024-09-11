package vue2D.javafx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import labyrinthe.IEtage;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import vue2D.AVue;
import vue2D.sprites.ISprite;

import java.util.ArrayList;
import java.util.Collection;
import vue2D.sprites.ASprite;
import vue2D.sprites.HerosSprite;

/**
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
        ISalle sPerso=null;
        Color c= null;
        for (ISprite sp : sprites) {
            if (sp instanceof HerosSprite) {
                ASprite sh= (ASprite) sp;
                sPerso=sh.getPerso().getPosition();
            }
        }
        for (ISalle s : etage) {
            System.out.println(distance(s,sPerso)); 
            if (s.equals(sPerso) || distance(s,sPerso)<5 ) {
                c = Color.rgb(200, 200, 200);
            }else if(distance(s,sPerso)<10){
                 c = Color.rgb(110, 109, 109);
            }else{
                c = Color.rgb(64, 64, 64);
            }
            dessinSalle(s, c);
        }
    }
    
    /**
     * Cette méthode calcule la distance entre deux salle 
     * @param s1 la premiere salle 
     * @param s2 la deuxieme salle 
     * @return un double, la distance ( en valeur absolue) de sdeux salles 
     */
    public double distance(ISalle s1,ISalle s2){
        return Math.abs(Math.sqrt(Math.pow(s2.getX()-s1.getX(),2) + Math.pow(s2.getY()-s1.getY(),2)));
    }

    public void dessinSalle(ISalle s, Color c) {
        int x=s.getX() * unite;
        int y=s.getY() * unite;
        if (image(s)!=null) {
            tampon.drawImage(image(s),x, y, unite, unite);
        } else{
            tampon.setFill(c);
            tampon.fillRect(x, y, unite, unite);
        }
        

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
                return null;
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
