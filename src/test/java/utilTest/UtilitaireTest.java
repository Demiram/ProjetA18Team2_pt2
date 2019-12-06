/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilTest;

import java.util.ArrayList;
import java.util.List;
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
 * @author Bernard
 */
public class UtilitaireTest {

    public UtilitaireTest() {
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
    public void TestArrondir5CentSup_val0() {
        double valeur = 5.00;
        double valeurAttendue = 5.00;
        double retour = Utilitaire.arrondir5CentSup(valeur);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);
    }

    @Test
    public void TestArrondir5CentSup_val3() {
        double valeur = 5.03;
        double valeurAttendue = 5.05;
        double retour = Utilitaire.arrondir5CentSup(valeur);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);
    }

    @Test
    public void TestArrondir5CentSup_val5() {
        double valeur = 5.05;
        double valeurAttendue = 5.05;
        double retour = Utilitaire.arrondir5CentSup(valeur);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);

    }

    @Test
    public void TestArrondir5CentSup_val88() {
        double valeur = 0.88;
        double valeurAttendue = 0.9;
        double retour = Utilitaire.arrondir5CentSup(valeur);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);

    }

    @Test
    public void TestarrondirDecimales_1_2() {
        double valeur = 0.001;
        double valeurAttendue = 0.00;
        double retour = Utilitaire.arrondirDecimales(valeur, 2);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);
    }

    @Test
    public void TestarrondirDecimales_5_2() {
        double valeur = 0.005;
        double valeurAttendue = 0.01;
        double retour = Utilitaire.arrondirDecimales(valeur, 2);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);
    }

    @Test
    public void TestarrondirDecimales_9_2() {
        double valeur = 0.009;
        double valeurAttendue = 0.01;
        double retour = Utilitaire.arrondirDecimales(valeur, 2);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);
    }

    @Test
    public void TestarrondirDecimales_9_3() {
        double valeur = 0.0009;
        double valeurAttendue = 0.001;
        double retour = Utilitaire.arrondirDecimales(valeur, 3);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);
    }

    @Test
    public void TestarrondirDecimales_4_3() {
        double valeur = 0.0004;
        double valeurAttendue = 0.000;
        double retour = Utilitaire.arrondirDecimales(valeur, 3);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);
    }

    @Test
    public void TestarrondirDecimales_m8_2() {
        double valeur = -0.008;
        double valeurAttendue = -0.01;
        double retour = Utilitaire.arrondirDecimales(valeur, 2);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);
    }

    @Test
    public void TestarrondirDecimales_m4_2() {
        double valeur = -0.004;
        double valeurAttendue = 0;
        double retour = Utilitaire.arrondirDecimales(valeur, 2);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);
    }

    @Test
    public void TestarrondirDecimales_m385_2() {
        double valeur = -4750.385;
        double valeurAttendue = -4750.38;
        double retour = Utilitaire.arrondirDecimales(valeur, 2);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);
    }

    @Test
    public void TestarrondirDecimales_385_2() {
        double valeur = 0.385;
        double valeurAttendue = 0.39;
        double retour = Utilitaire.arrondirDecimales(valeur, 2);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);
    }

    @Test
    public void TestarrondirDecimales_mZ385_2() {
        double valeur = -0.385;
        double valeurAttendue = -0.38;
        double retour = Utilitaire.arrondirDecimales(valeur, 2);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);
    }

    @Test
    public void TestarrondirDecimales_mZ388_2() {
        double valeur = -0.388;
        double valeurAttendue = -0.39;
        double retour = Utilitaire.arrondirDecimales(valeur, 2);
        assertTrue("Valeur attendue: " + valeurAttendue + ", mais valeur obtenue: " + retour, valeurAttendue == retour);
    }
    
    
    //test pour la validation globale
    @Test
    public void test_validation_globale_valide(){
        Lot lot = new Lot("lot 1", 8, 5, 45000.0, "2000-10-25");
        List<Lot> liste = new ArrayList<Lot>();
        liste.add(lot);
        Terrain terrain = new Terrain(1, 5.00, 5.00, liste);
        String messageAttendu = "valide";
        String resultat = Utilitaire.validationComplete(terrain);
        assertTrue("reponse attendue: "+messageAttendu+"; resultat: "+resultat, messageAttendu.equals(resultat));
    }
    
    @Test
    public void test_validation_champManquant(){
        Lot lot = new Lot("lot 1", 8, 5, 45000.0, "2000-10-25");
        List<Lot> liste = new ArrayList<Lot>();
        liste.add(lot);
        Terrain terrain = new Terrain(1, 5.00, 5.00, null);
        String messageAttendu = "il doit avoir au moins un lot";
        String resultat = Utilitaire.validationComplete(terrain);
        assertTrue("reponse attendue: "+messageAttendu+"; resultat: "+resultat, messageAttendu.equals(resultat));
    }
}
