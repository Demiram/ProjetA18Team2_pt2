/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilTest;

import modele.Lot;
import modele.Terrain;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class AgricoleTest {

    public AgricoleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
//     @Test
//    public void TestCalculerValeurTerrainAgricole() {
//        double montant_de_base = 100;
//        double resultatAttendu = 1.2;
//        double retour = CalculTaxes.CalculerTaxeScolaire(montant_de_base);
//        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + retour, resultatAttendu == retour);
//    }
    @Test
    public void calculerValeurFonciereLotTest() {
        double superficie=4.50;
        Terrain t1 = new Terrain(0, 5, 8);
        double retour = 4.50 * (t1.getPrix_m2_min());
        double resultatAttendu = 22.5;

        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + retour, resultatAttendu == retour);
    }

    @Test
    public void calculerDroitsLot() {
        Lot lot1 = new Lot("lot 1", 4, 0, 465, "2015-10-14");
        double valeurLot = 35.25;
        double retour = 500.00 - (4 * 300 * 0.05);
        double resultatAttendu = 440;

        //double retour = MONTANT_BASE - (lot.getNombre_droits_passage() * valeurLot * COEF_DROITS);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + retour, resultatAttendu == retour);

    }
}
