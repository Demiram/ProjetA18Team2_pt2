/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.CalculTaxes;

/**
 *
 * @author Bernard
 */
public class CalculTaxesTest {

    public CalculTaxesTest() {
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
    public void TestCalculerTaxeScolaireVal100() {
        double montant_de_base = 100;
        double resultatAttendu = 1.2;
        double retour = CalculTaxes.CalculerTaxeScolaire(montant_de_base);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + retour, resultatAttendu == retour);
    }

    @Test
    public void TestCalculerTaxeScolaireVal50() {
        double montant_de_base = 50;
        double resultatAttendu = 0.6;
        double retour = CalculTaxes.CalculerTaxeScolaire(montant_de_base);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + retour, resultatAttendu == retour);
    }

    @Test
    public void TestCalculerTaxeScolaireVal73() {
        double montant_de_base = 73;
        double resultatAttendu = 0.9;
        double retour = CalculTaxes.CalculerTaxeScolaire(montant_de_base);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + retour, resultatAttendu == retour);
    }

    @Test
    public void TestCalculerTaxeScolaireVal50p5() {
        double montant_de_base = 50.5;
        double resultatAttendu = 0.65;
        double retour = CalculTaxes.CalculerTaxeScolaire(montant_de_base);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + retour, resultatAttendu == retour);
    }

    @Test
    public void CalculerTaxeMunicipaleVal100() {
        double montant_de_base = 100;
        double resultatAttendu = 2.5;
        double retour = CalculTaxes.CalculerTaxeMunicipale(montant_de_base);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + retour, resultatAttendu == retour);
    }

    @Test
    public void CalculerTaxeMunicipaleVal50() {
        double montant_de_base = 50;
        double resultatAttendu = 1.25;
        double retour = CalculTaxes.CalculerTaxeMunicipale(montant_de_base);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + retour, resultatAttendu == retour);
    }

    @Test
    public void CalculerTaxeMunicipaleVal50p5() {
        double montant_de_base = 50.5;
        double resultatAttendu = 1.3;
        double retour = CalculTaxes.CalculerTaxeMunicipale(montant_de_base);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + retour, resultatAttendu == retour);
    }

    @Test
    public void TestCalculerTaxeMunicipaleVal73() {
        double montant_de_base = 73;
        double resultatAttendu = 1.85;
        double retour = CalculTaxes.CalculerTaxeMunicipale(montant_de_base);
        assertTrue("résultat attendu: " + resultatAttendu + ", mais résultat obtenu: " + retour, resultatAttendu == retour);
    }

}
