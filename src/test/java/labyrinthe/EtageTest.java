/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labyrinthe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author ojfrancois
 */
public class EtageTest {
    
    private static Etage etage;
    
    @BeforeClass
    public static void setUpClass() {
    etage= new Etage();
            }
    
    
    private boolean estDansPlateau(Salle salle){
        int largeur=salle.getEtage().getLargeur();
        int hauteur=salle.getEtage().getHauteur();
        return salle.getX()>0 && salle.getX()<largeur && salle.getY()>0 && salle.getY()<hauteur;     
    }

    
    
    @Test
    public void testValide() throws IOException{
        //Les fichiers qui font échouer le test sont :
//        at java.base/java.util.Objects.hashCode(Objects.java:103)
//	at com.iutbx.projetlaby/labyrinthe.Salle.hashCode(Salle.java:137)
//	at java.base/java.util.ArrayList.hashCodeRange(ArrayList.java:677)
//	at java.base/java.util.ArrayList.hashCode(ArrayList.java:664)
//	at java.base/java.util.Objects.hashCode(Objects.java:103)
        etage.charger("etages/etage1N.txt");
        boolean estValide =true;
         HashSet<Salle> h = new HashSet<>();
       Salle sn;
        for (ISalle s : etage) {
           sn= new Salle(s.getX(), s.getY(),s.getType(), s.getEtage());
           if(!estDansPlateau(sn)){
               estValide=false;
           }
           h.add(sn);
        }
        //Si le hashet est plus petit que la arraylist alors il y avait des classes en double dans l'étage 
        //Le test passe si l'étage n'a pas de salle en double et les coordonnées de touttes les salles sont dans le plateau 
        assertTrue(h.size()==etage.size() && estValide);

    }
}
