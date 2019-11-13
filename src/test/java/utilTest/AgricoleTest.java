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
    public void testCalculerValeurFonciereLot_m2_v1() {
        double superficie=4.50;
        double prix_min= 5;
        
        Terrain t1 = new Terrain(0, 5, 8);
        double resultat = superficie * (t1.getPrix_m2_min());
        double resultatAttendu = superficie * prix_min;
                resultatAttendu =22.5;
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

        @Test
    public void testCalculerValeurFonciereLot_m2_v2() {
        double superficie=90.5;
        double prix_min= 105.50;
        
        Terrain t2 = new Terrain(0, 105.50, 8);
        double resultat = superficie * (t2.getPrix_m2_min());
        
    double resultatAttendu = superficie * prix_min;
                resultatAttendu =9547.75;
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }
    
    @Test
    public void testcalculerDroitsLot() {
        
                int nbDroits = 4;
        double valeurLot = 100.25;
        double resultatAttendu = 479.95;
        
        Lot lot1 = new Lot("lot 1", 4, 0, 465, "2015-10-14");
        
        double resultat = 500.00 - (lot1.getNombre_droits_passage() * valeurLot * 0.05);
  

        //double retour = MONTANT_BASE - (lot.getNombre_droits_passage() * valeurLot * COEF_DROITS);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);

    }
}
