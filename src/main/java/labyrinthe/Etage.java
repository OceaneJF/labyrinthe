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
    public void charger(String file) throws IOException {
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
            this.add(salle);
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

    boolean estDansPlateau(ISalle salle) {
        int l = salle.getEtage().getLargeur();
        int h = salle.getEtage().getHauteur();
        return salle.getX() > 0 && salle.getX() < l && salle.getY() > 0 && salle.getY() < h;
    }

    @Override
    public boolean add(ISalle salle) {
        if (!this.contains(salle)) {
            if (estDansPlateau(salle)) {
                return super.add(salle);
            }
        }
        return false;
    }

    @Override // Surcharge du addAll
    public boolean addAll(Collection<? extends ISalle> salles) {
        boolean allAdded = true;
        for (ISalle salle : salles) {
            boolean added = this.add(salle);
            if (!added) {
                allAdded = false;
            }
        }
        return allAdded;
    }
}
