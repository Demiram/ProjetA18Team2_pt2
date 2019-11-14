/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
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
 * @author 0249248
 */
public class CommercialTest {
    
    public CommercialTest() {
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
    
    @Test
    private static void calculValeurLotsCommerciaux() {
        Terrain terrain = new Terrain();
        Lot lot = new Lot();
        
        dao.Commercial.calculValeurLotsCommerciaux(terrainTest);
        
    }
}
