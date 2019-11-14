/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
    public void calculValeurLotsCommerciaux_Siprixmax4_superficie100retourne400() {
        Lot lot = new Lot("", 0, 0, 100, "");
        List<Lot> lots = new ArrayList<Lot>();
        lots.add(lot);
        Terrain terrain = new Terrain(2, 0, 4, lots);
        
        dao.Commercial.calculValeurLotsCommerciaux(terrain);
        
        assertEquals(400.0, terrain.getLots().get(0).getValeur_par_lot(),0);
    }
    
    @Test
    public void calculDroitsPassageLotsCommerciaux_Sinbpassage5_Etvaleurlot100_retourne400() {
        Lot lot = new Lot("", 5, 0, 0, "");
        List<Lot> lots = new ArrayList<Lot>();
        lot.setValeur_par_lot(1000.0);
        lots.add(lot);
        Terrain terrain = new Terrain(2, 0, 4, lots);
        
        dao.Commercial.calculDroitsPassageLotsCommerciaux(terrain);
        
        assertEquals(-250.0, terrain.getLots().get(0).getMontantDroitsPassage(),0);
    }
    
    @Test
    public void calculMontantServicesLotsCommerciaux_SiNbservice5_Et_superficie100retourne2500() {
        Lot lot = new Lot("", 0, 5, 100, "");
        List<Lot> lots = new ArrayList<Lot>();
        lots.add(lot);
        Terrain terrain = new Terrain(0, 0, 0, lots);
        
        dao.Commercial.calculMontantServicesLotsCommerciaux(terrain);
        
        assertEquals(2500.0, terrain.getLots().get(0).getMontantServices(),0);
    }
    
    @Test
    public void calculValeurFonciereLotsCommerciaux() {
        Lot lot = new Lot();
        List<Lot> lots = new ArrayList<Lot>();
        
        lot.setValeur_par_lot(500.0);
        lot.setMontantDroitsPassage(100.0);
        lot.setMontantServices(500.0);
        
        lots.add(lot);
        Terrain terrain = new Terrain(0, 0, 0, lots);
        
        dao.Commercial.calculValeurFonciereLotsCommerciaux(terrain);
        
        assertEquals(1100.0, terrain.getLots().get(0).getValeurFonciere(),0);
    }
    
    @Test
    public void calculValeurFonciereTerrainCommercial() {
        Lot lot = new Lot();
        List<Lot> lots = new ArrayList<Lot>();
        double expected = 0;
        
        lot.setValeurFonciere(500);
        
        expected = 733.8 + 500;
        
        lots.add(lot);
        Terrain terrain = new Terrain(0, 0, 0, lots);
        
        dao.Commercial.calculValeurFonciereTerrainCommercial(terrain);
        
        assertEquals(expected, terrain.getValeur_fonciere_totale(),0);
    }
}
