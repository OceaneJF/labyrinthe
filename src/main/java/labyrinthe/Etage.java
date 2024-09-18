package labyrinthe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author INFO Professors team
 */
public class Etage extends ArrayList<ISalle> implements IEtage {

    private int largeur;
    private int hauteur;
    private int num;

    public Etage() {
        largeur = 40;
        hauteur = 40;
        num = 1;
    }

    public Etage(int id) {
        this.num = id;
    }

    @Override
    public void charger(String file) throws ExceptionInvalidFile, IOException {
        this.clear();
        List<String> lignes = Files.readAllLines(Paths.get(file));
        Salle salle;
        // dimensions
        String entete = lignes.get(0);
        String[] mots = entete.split(" ");
        largeur = Integer.parseInt(mots[0]);
        hauteur = Integer.parseInt(mots[1]);
        lignes.remove(0);
        // salles
        for (String ligne : lignes) {
            mots = ligne.split(" ");
            salle = new Salle(Integer.parseInt(mots[0]), Integer.parseInt(mots[1]), recupType(mots[2]), this);
            boolean aAjoute = this.add(salle);
            if (!aAjoute) {
                throw new ExceptionInvalidFile("le fichier est invalide");
            }
        }
    }

    /**
     * Cette méthode permet de récuperer le type d'une salle en fonction de la
     * lettre passé en parametre
     *
     * @param mot la lettre correspondant au type de la salle
     * @return le type de la salle
     */
    private ESalle recupType(String mot) {
        switch (mot) {
            case "N":
                return ESalle.NORMALE;
            case "M":
                return ESalle.ESCALIER_MONTANT;
            case "D":
                return ESalle.ESCALIER_DESCENDANT;
            case "E":
                return ESalle.ENTREE;
            case "S":
                return ESalle.SORTIE;
        }
        return null;
    }

    @Override
    public int getLargeur() {
        return largeur;
    }

    @Override
    public int getHauteur() {
        return hauteur;
    }

    @Override
    public int getNum() {
        return num;
    }

    /**
     * Cette méthode permet de savoir si les coordonnées d'une salle sont valide 
     * @param salle la salle que l'on veut vérifier
     * @return un booléen , vrai si les coordonnées de la salle sont valide, false sinon 
     */
    boolean estDansPlateau(ISalle salle) {
        int l = salle.getEtage().getLargeur();
        int h = salle.getEtage().getHauteur();
        return salle.getX() >= 0 && salle.getX() < l && salle.getY() >= 0 && salle.getY() < h;
    }

    /**
     * Cette méthode ajoute une salle à un étage seulement si celle-ci n'est pas déjà présente dans l'étage et que ses coordonnées sont valide
     * @param salle la salle que l'on veut ajouter 
     * @return un booléen: vrai si la salle a été ajouté, false sinon 
     */
    @Override
    public boolean add(ISalle salle) {
        if (!this.contains(salle)) {
            if (estDansPlateau(salle)) {
                return super.add(salle);
            }
        }
        return false;
    }

}
