/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipJson;

import java.util.ArrayList;
import java.util.List;
import modele.Terrain;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 0249248
 */
public class IOJsonTest {

    public IOJsonTest() {
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

    /**
     * Test of lancerErreur method, of class IOJson.
     */
    @Test
    public void testLancerErreur_String() {
        String message = "abc";
        JSONObject expResult = new JSONObject();
        JSONObject result = IOJson.lancerErreur(message);

        expResult.accumulate("message", "abc");

        assertEquals(expResult, result);
    }

    /**
     * Test of lancerErreur method, of class IOJson.
     */


    /**
     * Test of validerEntreeDouble method, of class IOJson.
     */
    @Test
    public void testValiderEntreeDouble_entreeVirgule() {
        String str = "0,01";
        double expResult = 0.01;
        double result = IOJson.validerEntreeDouble(str);

        assertEquals(expResult, result, 0);
    }

    /**
     * Test of validerEntreeDouble method, of class IOJson.
     */
    @Test
    public void testValiderEntreeDouble_entreeVirguleEspaceDollar() {
        String str = "0,01 $";
        double expResult = 0.01;
        double result = IOJson.validerEntreeDouble(str);

        assertEquals(expResult, result, 0);
    }

    /**
     * Test of validerEntreeDouble method, of class IOJson.
     */
    @Test
    public void testValiderEntreeDouble_entreePoint() {
        String str = "0.01";
        double expResult = 0.01;
        double result = IOJson.validerEntreeDouble(str);

        assertEquals(expResult, result, 0);
    }
}
