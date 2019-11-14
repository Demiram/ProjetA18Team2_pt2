/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.Residentiel;
import java.util.ArrayList;
import java.util.List;
import modele.Lot;
import modele.Terrain;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Bernard
 */
public class ResidentielTest {

    public ResidentielTest() {
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
    @Test
    public void test_calculerValeurFoncière_s100_min50_max100() {
        double superficie = 100;
        Lot lot = new Lot();
        List<Lot> lots = new ArrayList<Lot>();
        lots.add(lot);
        Terrain t = new Terrain(1, 50.00, 100.00, lots);
        double resultatAttendu = 7500.0;
        double resultat = Residentiel.calculerValeurFonciereLot(t, superficie);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerValeurFoncière_s100p5_min50p5_max100p5() {
        double superficie = 100.5;
        Lot lot = new Lot();
        List<Lot> lots = new ArrayList<Lot>();
        lots.add(lot);
        Terrain t = new Terrain(1, 50.50, 100.50, lots);
        double resultatAttendu = 7587.75;
        double resultat = Residentiel.calculerValeurFonciereLot(t, superficie);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerValeurFoncière_s100p75_min50p35_max100p25() {
        double superficie = 100.75;
        Lot lot = new Lot();
        List<Lot> lots = new ArrayList<Lot>();
        lots.add(lot);
        Terrain t = new Terrain(1, 50.35, 100.25, lots);
        double resultatAttendu = 7586.48;
        double resultat = Residentiel.calculerValeurFonciereLot(t, superficie);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerDroitsLot_0_7500() {
        int nbDroits = 0;
        double valeurFonciere = 7500;
        double resultatAttendu = 500;
        double resultat = Residentiel.calculerDroitsLot(nbDroits, valeurFonciere);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerDroitsLot_1_7500() {
        int nbDroits = 1;
        double valeurFonciere = 7500;
        double resultatAttendu = -250;
        double resultat = Residentiel.calculerDroitsLot(nbDroits, valeurFonciere);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerDroitsLot_2_7500() {
        int nbDroits = 2;
        double valeurFonciere = 7500;
        double resultatAttendu = -1000;
        double resultat = Residentiel.calculerDroitsLot(nbDroits, valeurFonciere);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerDroitsLot_7_7500p55() {
        int nbDroits = 7;
        double valeurFonciere = 7500.55;
        double resultatAttendu = -4750.38;
        double resultat = Residentiel.calculerDroitsLot(nbDroits, valeurFonciere);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerDroitsLot_1_500() {
        int nbDroits = 1;
        double valeurFonciere = 500;
        double resultatAttendu = 450;
        double resultat = Residentiel.calculerDroitsLot(nbDroits, valeurFonciere);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerDroitsLot_2_500() {
        int nbDroits = 2;
        double valeurFonciere = 500;
        double resultatAttendu = 400;
        double resultat = Residentiel.calculerDroitsLot(nbDroits, valeurFonciere);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerDroitsLot_2_500p67() {
        int nbDroits = 2;
        double valeurFonciere = 500.67;
        double resultatAttendu = 399.87;
        double resultat = Residentiel.calculerDroitsLot(nbDroits, valeurFonciere);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    // tests pour Calculer Valeur Services
    @Test
    public void test_calculerValeurServices_0_5() {
        int superficie = 0;
        int nbDroits = 5;
        double resultatAttendu = 0;
        Lot lot = new Lot("Lot1", 0, nbDroits, superficie, "2015-10-25");
        double resultat = Residentiel.calculerValeurServices(lot);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerValeurServices_1_5() {
        int superficie = 1;
        int nbDroits = 5;
        double resultatAttendu = 0;
        Lot lot = new Lot("Lot1", 0, nbDroits, superficie, "2015-10-25");
        double resultat = Residentiel.calculerValeurServices(lot);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerValeurServices_499_0() {
        int superficie = 499;
        int nbDroits = 0;
        double resultatAttendu = 0;
        Lot lot = new Lot("Lot1", 0, nbDroits, superficie, "2015-10-25");
        double resultat = Residentiel.calculerValeurServices(lot);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerValeurServices_499_5() {
        int superficie = 499;
        int nbDroits = 5;
        double resultatAttendu = 0;
        Lot lot = new Lot("Lot1", 0, nbDroits, superficie, "2015-10-25");
        double resultat = Residentiel.calculerValeurServices(lot);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerValeurServices_500_5() {
        int superficie = 500;
        int nbDroits = 5;
        double resultatAttendu = 0;
        Lot lot = new Lot("Lot1", 0, nbDroits, superficie, "2015-10-25");
        double resultat = Residentiel.calculerValeurServices(lot);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerValeurServices_501_5() {
        int superficie = 501;
        int nbDroits = 5;
        double resultatAttendu = 2500;
        Lot lot = new Lot("Lot1", 0, nbDroits, superficie, "2015-10-25");
        double resultat = Residentiel.calculerValeurServices(lot);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerValeurServices_750_10() {
        int superficie = 750;
        int nbDroits = 10;
        double resultatAttendu = 5000;
        Lot lot = new Lot("Lot1", 0, nbDroits, superficie, "2015-10-25");
        double resultat = Residentiel.calculerValeurServices(lot);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerValeurServices_9999_1() {
        int superficie = 9999;
        int nbDroits = 1;
        double resultatAttendu = 500;
        Lot lot = new Lot("Lot1", 0, nbDroits, superficie, "2015-10-25");
        double resultat = Residentiel.calculerValeurServices(lot);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerValeurServices_10000_5() {
        int superficie = 10000;
        int nbDroits = 5;
        double resultatAttendu = 2500;
        Lot lot = new Lot("Lot1", 0, nbDroits, superficie, "2015-10-25");
        double resultat = Residentiel.calculerValeurServices(lot);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerValeurServices_10001_5() {
        int superficie = 10001;
        int nbDroits = 5;
        double resultatAttendu = 5000;
        Lot lot = new Lot("Lot1", 0, nbDroits, superficie, "2015-10-25");
        double resultat = Residentiel.calculerValeurServices(lot);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + resultat, resultatAttendu == resultat);
    }

    @Test
    public void test_calculerValeurTerrain() {
        //public Lot(String descriptionEntree, int nombre_droits_passage, int nombre_services, int superficie, String date_mesure) {
        Lot lot1 = new Lot("Lot1", 2, 2, 300, "4-02-2019");
        Lot lot2 = new Lot("Lot2", 2, 2, 600, "4-02-2019");
        Lot lot3 = new Lot("Lot3", 2, 2, 15000, "4-02-2019");
        List<Lot> lots = new ArrayList();
        lots.add(lot1);
        lots.add(lot2);
        lots.add(lot3);
        Terrain terrain = new Terrain(1, 50.00, 100.00, lots);
        Residentiel.calculerValeurTerrain(terrain);
        double valFonciereAttendue = 959233.80;
        double taxeScolaireAttendue = 11510.85;
        double taxeMunicipaleAttendue = 23980.85;
        boolean resultat = valFonciereAttendue == terrain.getValeur_fonciere_totale()
                && taxeScolaireAttendue == terrain.getTaxe_scolaire()
                && taxeMunicipaleAttendue == terrain.getTaxe_municipale();
        assertTrue("valfoncièreAttendue: " + valFonciereAttendue+", vs valeur obtenue: "+terrain.getValeur_fonciere_totale()
                + "\ntaxe scolaire attendue: " + taxeScolaireAttendue+", vs valeur obtenue: "+terrain.getTaxe_scolaire()
                + "\ntaxe muninipale attendue: " + taxeMunicipaleAttendue+", vs valeur obtenue: "+terrain.getTaxe_municipale(), 
                resultat);
    }


}
