package labyrinthe;

import java.util.ArrayList;
import java.util.Collection;
import personnages.IPersonnage;

/**
 *
 * @author professor team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {
    
    private IEtage etageCourant = new Etage();

    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage heros) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ISalle getEntree() {
        return null;
    }

    @Override
    public ISalle getSortie() {
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
