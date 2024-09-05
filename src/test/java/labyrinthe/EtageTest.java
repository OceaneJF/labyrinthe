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
    private static Salle salle1;
    private static Salle salle2;
    private static Salle salle3;
    private static Salle salle4;
    private static Salle salle5;
    private static ArrayList<Salle> expected;
    
    
    @BeforeClass
    public static void setUpClass() {
    etage= new Etage();
    salle1=new Salle(1, 3, ESalle.NORMALE, etage);
    salle2=new Salle(2, 9, ESalle.NORMALE, etage);
    salle3=new Salle(1, 3, ESalle.NORMALE, etage);
    salle4=new Salle(0, 3, ESalle.NORMALE, etage);
    salle5=new Salle(1, 40, ESalle.NORMALE, etage);
    expected=new ArrayList<>();
    
            }
    
    @After
    public void tearDown() {
         etage= new Etage();
    salle1=new Salle(1, 3, ESalle.NORMALE, etage);
    salle2=new Salle(2, 9, ESalle.NORMALE, etage);
    salle3=new Salle(1, 3, ESalle.NORMALE, etage);
    salle4=new Salle(0, 3, ESalle.NORMALE, etage);
    salle5=new Salle(1, 40, ESalle.NORMALE, etage);
    expected=new ArrayList<>();
    }
    
    

    
    
    @Test
    public void testAdd() throws IOException{
        etage.add(salle1);
        etage.add(salle2);
        expected.add(salle1);
        expected.add(salle2);
        //cas ou le labyrinth est valide 
        assertArrayEquals(expected.toArray(), etage.toArray());
        //cas ou le labyrinth est pas valide car une salle est en double 
        etage.add(salle3);
         assertArrayEquals(expected.toArray(), etage.toArray());
        //cas ou le labyrinth n'est pas valide car une salle et en dehors du plateau 
          etage.add(salle4);
          assertArrayEquals(expected.toArray(), etage.toArray());
        //cas ou le labyrinth n'est pas valide car une salle et en dehors du plateau 
        etage.add(salle5);
          assertArrayEquals(expected.toArray(), etage.toArray());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

       
        
        
        

    }
}
