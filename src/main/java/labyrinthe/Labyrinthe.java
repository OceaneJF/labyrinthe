package labyrinthe;

import personnages.IPersonnage;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author professor team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    private IEtage etageCourant = new Etage();

    public Labyrinthe() {
        try {
            etageCourant.charger("etages/etage1N.txt");
            Etage etage2 = new Etage();
            etage2.charger("etages/etage2N.txt");
            this.addAll(etageCourant);
            this.addAll(etage2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage heros) {
        ISalle position = heros.getPosition();
        ArrayList<ISalle> sallesAccessibles = new ArrayList<>();
        for (ISalle s : etageCourant) { // étage courant pour ne pas passé a travers les murs.
            if (s.estAdjacente(position)) {
                sallesAccessibles.add(s);
            }
        }
        return sallesAccessibles;
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
}
