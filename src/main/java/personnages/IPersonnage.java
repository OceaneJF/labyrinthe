package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
*
* @author INFO Professors team
*/
// un personnage peut choisir une salle parmi les salles adjacentes a sa position 
public interface IPersonnage {
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles); // renvoie une salle parmi sallesAccesibles
    public ISalle getPosition(); // renvoie sa position courante
    public void setPosition( ISalle s); // definit sa position courante
}
