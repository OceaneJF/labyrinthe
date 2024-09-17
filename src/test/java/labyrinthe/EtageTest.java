/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labyrinthe;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
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
        etage = new Etage();
        salle1 = new Salle(1, 3, ESalle.NORMALE, etage);
        salle2 = new Salle(2, 9, ESalle.NORMALE, etage);
        salle3 = new Salle(1, 3, ESalle.NORMALE, etage);
        salle4 = new Salle(0, 3, ESalle.NORMALE, etage);
        salle5 = new Salle(1, 40, ESalle.NORMALE, etage);
        expected = new ArrayList<>();

    }

    @After
    public void tearDown() {
        etage = new Etage();
        salle1 = new Salle(1, 3, ESalle.NORMALE, etage);
        salle2 = new Salle(2, 9, ESalle.NORMALE, etage);
        salle3 = new Salle(1, 3, ESalle.NORMALE, etage);
        salle4 = new Salle(0, 3, ESalle.NORMALE, etage);
        salle5 = new Salle(1, 40, ESalle.NORMALE, etage);
        expected = new ArrayList<>();
    }

    @Test
    public void testAdd() throws IOException {
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

    /**
     * Ce tester permet de déterminer si un étage est valide , c'est à dire qui ne contient pas de salles en double ni de salles avec des coordonnées invalide
     */
    @Test
    public void testValide() {
        for (int i = 1; i <= 9; i++) {
            try {
                etage.charger(String.format("etages/etage%dN.txt", i));

                boolean estValide = true;
                HashSet<ISalle> h = new HashSet<>();
                Salle sn;
                for (ISalle s : etage) {
                    h.add(s);
                    sn = new Salle(s.getX(), s.getY(), s.getType(), s.getEtage());
                    if (!etage.estDansPlateau(sn)) {
                        estValide = false;
                    }
                }
                assertTrue(h.size() == etage.size() && estValide);
            } catch (IOException e) {
                System.out.println("lecture impossible " + e.getMessage());
            }
        }
    }

    /**
     * Ce test permet de déterminer si un étage est invalide 
     */
    @Test
    public void testInvalide() {
        for (int i = 1; i <= 4; i++) {
            try {
                etage.charger(String.format("etages/etageInvalide%dN.txt", i));

                boolean estValide = true;
                HashSet<ISalle> h = new HashSet<>();
                Salle sn;
                for (ISalle s : etage) {
                    // s= new Salle(sa.getX(), sa.getY(),sa.getType(), sa.getEtage());
                    h.add(s);
                    sn = new Salle(s.getX(), s.getY(), s.getType(), s.getEtage());

                    if (!etage.estDansPlateau(sn)) {
                        estValide = false;
                    }
                }

                assertTrue(h.size() != etage.size() || !estValide);
            } catch (IOException e) {
                System.out.println("lecture impossible " + e.getMessage());
            }
        }
    }
}
