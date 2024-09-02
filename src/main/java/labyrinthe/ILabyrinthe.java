package labyrinthe;

import java.util.Collection;

import personnages.IPersonnage;

/**
 *
 * @author INFO Professors team
 */
// un labyrinthe est une collection de salles, reparties sur plusieurs etages
public interface ILabyrinthe extends Collection<ISalle>{ 
    public Collection<ISalle> sallesAccessibles(IPersonnage heros);  // renvoie les salles accessibles pour le heros
    public ISalle getEntree(); // accesseur sur l'entree 
    public ISalle getSortie(); // accesseur sur la sortie
    public IEtage getEtageCourant(); // accesseurs sur l'etage affiche
    public void setEtageCourant(IEtage etage);
    public Collection<ISalle> chemin(ISalle u, ISalle v); // un plus court chemin entre u et v
}
