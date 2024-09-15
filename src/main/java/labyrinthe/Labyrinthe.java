package labyrinthe;

import java.io.IOException;
import personnages.IPersonnage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import personnages.Heros;
import vue2D.sprites.HerosSprite;

/**
 * @author professor team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    private IEtage etageCourant = new Etage();

    public Labyrinthe() throws IOException {
        try {
            etageCourant.charger("etages/etageInvalide1N.txt");
            this.addAll(etageCourant);
        } catch (ExceptionInvalidFile e) {
            etageCourant.charger("etages/etage1N.txt");
            Etage etage2 = new Etage(2);
            etage2.charger("etages/etage2N.txt");
            this.addAll(etageCourant);
            this.addAll(etage2);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage heros) {
        ISalle position = heros.getPosition();
        ArrayList<ISalle> sallesAccessibles = new ArrayList<>();
        if (heros instanceof HerosSprite) {
            for (ISalle s : etageCourant) { // étage courant pour ne pas passé a travers les murs.
                if (s.estAdjacente(position)) {
                    sallesAccessibles.add(s);
                }
            }
        } else {
            for (ISalle s : etageCourant) {
                if (s.estAdjacente(position) && (s.getType() != ESalle.ESCALIER_DESCENDANT && s.getType() != ESalle.ESCALIER_MONTANT)) {
                    sallesAccessibles.add(s);
                }
            }

        }
        return sallesAccessibles;
    }

    public ISalle salleAleatoire() {
        Random rand = new Random();
        int numSalle = rand.nextInt(this.size());
        return this.get(numSalle);
    }

    @Override
    public ISalle getEntree() {
        for (ISalle salle : this) {
            if (salle.getType().equals(ESalle.ENTREE)) {
                return salle;
            }
        }
        return null;
    }

    @Override
    public ISalle getSortie() {
        for (ISalle salle : this) {
            if (salle.getType().equals(ESalle.SORTIE)) {
                return salle;
            }
        }
        return null;
    }

    @Override
    public IEtage getEtageCourant() {
        return this.etageCourant;
    }

    @Override
    public void setEtageCourant(IEtage etage) {
        this.etageCourant = etage;
    }

    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    public Etage getEtage(int etageNum) {
        Etage e = null;
        boolean found = false;
        int i = 0;
        while (!found || i < this.size()) {
            if (this.get(i).getEtage().getNum() == etageNum) {
                e = (Etage) this.get(i).getEtage();
                found = true;
            }
            i++;
        }

        return e;
    }
}
