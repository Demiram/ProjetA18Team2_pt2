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
        assertTrue("Valeur attendue: "+valeurAttendue+", mais valeur obtenue: "+retour, valeurAttendue==retour);
    }

    @Test
    public void TestArrondir5CentSup_val3() {
        double valeur = 5.03;
        double valeurAttendue = 5.05;
        double retour = Utilitaire.arrondir5CentSup(valeur);
        assertTrue("Valeur attendue: "+valeurAttendue+", mais valeur obtenue: "+retour, valeurAttendue==retour);
    }

    @Test
    public void TestArrondir5CentSup_val5() {
        double valeur = 5.05;
        double valeurAttendue = 5.05;
        double retour = Utilitaire.arrondir5CentSup(valeur);
        assertTrue("Valeur attendue: "+valeurAttendue+", mais valeur obtenue: "+retour, valeurAttendue==retour);

    }
}
