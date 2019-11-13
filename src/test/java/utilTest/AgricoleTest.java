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
import util.Utilitaire;

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
        double superficie=150.00;
        double prix_min= 45.5;
        double resultatAttendu = 6825;
        
        Terrain t1 = new Terrain(0, 45.5, 8);
        double retour = superficie * (t1.getPrix_m2_min());
        double resultat = (Utilitaire.arrondirDecimales(retour, 2));
        
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

        @Test
    public void testCalculerValeurFonciereLot_m2_v2() {
        double superficie=100.00;
        double prix_min= 105.55;
          double resultatAttendu = 10555;
          
        Terrain t2 = new Terrain(0, 105.55, 6);
        double retour = superficie * (t2.getPrix_m2_min());
        double resultat = (Utilitaire.arrondirDecimales(retour, 2));
              
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }
    
            @Test
    public void testCalculerValeurFonciereLot_m2_v3() {
        double superficie=120.00;
        double prix_min= 105.457;
        
        Terrain t3 = new Terrain(0, 105.457, 9);
        double retour = superficie * (t3.getPrix_m2_min());
        
    double resultatAttendu = superficie * prix_min;
                resultatAttendu =12654.84;
    double  resultat = (Utilitaire.arrondirDecimales(retour, 2));
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }
    
    @Test
    public void testcalculerDroitsLot_v1() {
        
                int nbDroits = 4;
        double valeurLot = 100.25;
        double resultatAttendu = 500-(4*100.25*0.05);
              //  479.95;
        
        Lot lot1 = new Lot("lot 1", 4, 0, 465, "2015-10-14");
        
        double retour = 500.00 - (lot1.getNombre_droits_passage() * valeurLot * 0.05);
          double  resultat = (Utilitaire.arrondirDecimales(retour, 2));
          
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);

    }
    
        @Test
    public void testcalculerDroitsLot_v2() {
        
        int nbDroits = 8;
        double valeurLot = 100.257;
        double resultatAttendu = 459.9;
              //  479.95;
        
        Lot lot3 = new Lot("lot 3", 8, 3, 3333, "2013-06-20");
        
        double retour = 500.00 - (lot3.getNombre_droits_passage() * valeurLot * 0.05);
        double resultat = (Utilitaire.arrondirDecimales(retour, 2));
          
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);

    }
}
