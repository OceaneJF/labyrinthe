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
    
    @Test
    public void testValide() throws IOException{
        //Les fichiers qui font échouer le test sont :
//        at java.base/java.util.Objects.hashCode(Objects.java:103)
//	at com.iutbx.projetlaby/labyrinthe.Salle.hashCode(Salle.java:137)
//	at java.base/java.util.ArrayList.hashCodeRange(ArrayList.java:677)
//	at java.base/java.util.ArrayList.hashCode(ArrayList.java:664)
//	at java.base/java.util.Objects.hashCode(Objects.java:103)
        etage.charger("etages/etage1N.txt");
         HashSet<ISalle> h = new HashSet<>();
       //Salle s;
        for (ISalle s : etage) {
          // s= new Salle(sa.getX(), sa.getY(),sa.getType(), sa.getEtage());
           h.add(s);
        }
        assertTrue(h.size()==etage.size());

//        ArrayList<Integer> a= new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        a.add(3);
//        HashSet<Integer> h = new HashSet<>();
//        for (Integer num : a) {
//            h.add(num);
//        }
//        System.out.println(a.size());
//        System.out.println(h.size());

       
      


    }
}
