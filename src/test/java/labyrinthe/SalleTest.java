/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package labyrinthe;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gothmog
 */
public class SalleTest {

    public SalleTest() {
    }


    private static Salle salle1;
    private static Salle salle2;
    private static Salle salle3;
    private static Salle salle4;
    private static Salle salle5;
    private static Salle salle6;
    private static Salle salle7;
    private static Etage etage;

   
    @BeforeClass
    public static void setUpClass() {
        etage=new Etage();
        salle1=new Salle(1,4,ESalle.NORMALE,etage);
        salle2=new Salle(25,7,ESalle.ENTREE,etage);
        salle3=new Salle(39,39,ESalle.SORTIE,etage);
        salle4=new Salle(25,39,ESalle.ESCALIER_MONTANT,etage);
        salle5=new Salle(1,1,ESalle.NORMALE,etage);
        salle6=new Salle(2,5,ESalle.NORMALE,etage);
        salle7=new Salle(1,5,ESalle.NORMALE,etage);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
         etage=new Etage();
        salle1=new Salle(1,4,ESalle.NORMALE,etage);
        salle2=new Salle(25,7,ESalle.ENTREE,etage);
        salle3=new Salle(39,39,ESalle.SORTIE,etage);
        salle4=new Salle(25,39,ESalle.ESCALIER_MONTANT,etage);
        salle5=new Salle(1,1,ESalle.NORMALE,etage);
        salle6=new Salle(2,5,ESalle.NORMALE,etage);
        salle7=new Salle(1,5,ESalle.NORMALE,etage);
        
    }
    
    @Test
    public void testGetX(){
        assertTrue(1==salle1.getX());
        assertTrue(25==salle2.getX());
    }
    
      @Test
    public void testGetY(){
        assertTrue(39==salle4.getY());
        assertTrue(5==salle6.getY());
    }
    
     @Test
    public void testGetEtage(){
         assertEquals(etage, salle1.getEtage());
    }
    
     @Test
    public void testGetType(){
        assertEquals(ESalle.NORMALE, salle1.getType());
        assertEquals(ESalle.ENTREE, salle2.getType());
        assertEquals(ESalle.SORTIE, salle3.getType());
        assertEquals(ESalle.ESCALIER_MONTANT, salle4.getType());
    }
    
    
     @Test
    public void testSetX(){
        salle7.setY(2);
         assertTrue(salle7.getY()==2);
    }
    
     @Test
    public void testSetY(){
        salle2.setY(3);
         assertTrue(salle2.getY()==3);
    }
    
     @Test
    public void testSetType(){
        salle1.setType(ESalle.ENTREE);
        assertEquals(ESalle.ENTREE, salle1.getType());
         salle2.setType(ESalle.NORMALE);
        assertEquals(ESalle.NORMALE, salle2.getType());
         salle3.setType(ESalle.ENTREE);
        assertEquals(ESalle.ENTREE, salle3.getType());
         salle4.setType(ESalle.SORTIE);
        assertEquals(ESalle.SORTIE, salle4.getType());
    }
    
     
     @Test
    public void testSetEtage(){
        Etage e3 = new Etage(3);
        salle3.setEtage(e3);
         assertEquals(e3, salle3.getEtage());
    }
    
    
    @Test
    public void testSuivante(){
        //direction NORD
        Salle sN= new Salle(2,4, ESalle.NORMALE, etage);
        assertTrue(sN.equals( salle6.suivante(EDirection.NORD)));
        //direction SUD
        Salle sS= new Salle(2,6, ESalle.NORMALE, etage);
        assertTrue(sS.equals( salle6.suivante(EDirection.SUD)));
        //direction EST
        Salle sE= new Salle(3,5, ESalle.NORMALE, etage);
        assertTrue(sE.equals( salle6.suivante(EDirection.EST)));
        //direction OUEST
        Salle sO= new Salle(1,5, ESalle.NORMALE, etage);
        assertTrue(sO.equals( salle6.suivante(EDirection.OUEST)));
               
    }
    

    
    @Test
    public void testVoisines(){
        //cas ou la salle a 4 voisines 
        ArrayList<Salle> voisines = salle6.voisines();
        ArrayList<Salle> voisinesExpected =new ArrayList<>();
        Salle sh = new Salle(2,4,ESalle.NORMALE,etage);
        Salle sb = new Salle(2,6,ESalle.NORMALE,etage);
        Salle sd = new Salle(3,5,ESalle.NORMALE,etage);
        Salle sg = new Salle(1,5,ESalle.NORMALE,etage);
        voisinesExpected.add(sg);
        voisinesExpected.add(sd);
        voisinesExpected.add(sb);
        voisinesExpected.add(sh);
        assertArrayEquals(voisinesExpected.toArray(), voisines.toArray());
       
    }
    
     @Test
    public void testEstAdjacente(){
    //la salle1 est adjacente à la salle 7
         assertTrue(salle1.estAdjacente(salle7));
    // la salle7 est adjacente à la salle 1
     assertTrue(salle7.estAdjacente(salle1));
    // la salle 7 est adjacente à la salle 6 et inversement 
     assertTrue(salle7.estAdjacente(salle6));
      assertTrue(salle6.estAdjacente(salle7));
    }
    
      @Test
    public void testEquals(){
        //cas ou les salles ont le meme type
          assertTrue(salle2.equals(salle2));
        // cas ou les salles n'ont pas le meme type 
        Salle s = new Salle(1,4,ESalle.ENTREE,etage);
          assertTrue(salle1.equals(s));
    }
    
     @Test
    public void testHashCode(){
        //cas ou les salles ont le meme type
          assertEquals(salle2.hashCode(),salle2.hashCode());
        // cas ou les salles n'ont pas le meme type 
        Salle s = new Salle(1,4,ESalle.ENTREE,etage);
          assertEquals(s.hashCode(),salle1.hashCode());
    }
    
}
