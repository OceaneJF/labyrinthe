package labyrinthe;

/**
 *
 * @author INFO Professors team
 */
// une salle a des coordonnees dans la grille de son etage
public interface ISalle {
    public int getX(); // abcisse
    public int getY(); // ordonnee
    public ESalle getType(); // type
    public IEtage getEtage(); // etage de la salle
    public boolean estAdjacente( ISalle autre); // indique si une salle est adjacente a une autre
}
