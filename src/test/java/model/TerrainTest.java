/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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

/**
 *
 * @author usager
 */
public class TerrainTest {

    public TerrainTest() {
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
    public void TesterListeLots_empty() {

        String messageAttendu
                = "il doit avoir au moins un lot";
        List<Lot> lots = new ArrayList<Lot>();

        Terrain t1 = new Terrain(3, 300.00, 700.00, lots);
        String messageRetour = t1.validerTerrain();

        assertTrue("Message attendu :" + messageAttendu + ",mais message obtenu :"
                + messageRetour, messageAttendu == messageRetour);

    }

    @Test
    public void TesterListeLots_null() {

        String messageAttendu
                = "il doit avoir au moins un lot";
        List<Lot> lots = null;

        Terrain t1 = new Terrain(3, 300.00, 700.00, lots);
        String messageRetour = t1.validerTerrain();

        assertTrue("Message attendu :" + messageAttendu + ",mais message obtenu :"
                + messageRetour, messageAttendu == messageRetour);

    }

    @Test
    public void TesterListeLots_supDix() {

        String messageAttendu
                = "le nombre de lots ne doit pas dépasser 10 lots";
        List<Lot> lots = new ArrayList<Lot>();
        Lot lot = new Lot("lot1", 1, 1, 5.0, "2015-10-14");
        Lot lot2 = new Lot("lot2", 1, 1, 5.0, "2015-10-14");
        Lot lot3 = new Lot("lot3", 1, 1, 5.0, "2015-10-14");
        Lot lot4 = new Lot("lot4", 1, 1, 5.0, "2015-10-14");
        Lot lot5 = new Lot("lot5", 1, 1, 5.0, "2015-10-14");
        Lot lot6 = new Lot("lot6", 1, 1, 5.0, "2015-10-14");
        Lot lot7 = new Lot("lot7", 1, 1, 5.0, "2015-10-14");
        Lot lot8 = new Lot("lot8", 1, 1, 5.0, "2015-10-14");
        Lot lot9 = new Lot("lot9", 1, 1, 5.0, "2015-10-14");
        Lot lot10 = new Lot("lot10", 1, 1, 5.0, "2015-10-14");
        Lot lot11 = new Lot("lot11", 1, 1, 5.0, "2015-10-14");

        lots.add(lot);
        lots.add(lot2);
        lots.add(lot3);
        lots.add(lot4);
        lots.add(lot5);
        lots.add(lot6);
        lots.add(lot7);
        lots.add(lot8);
        lots.add(lot9);
        lots.add(lot10);
        lots.add(lot11);

        Terrain t1 = new Terrain(-1, 500.00, 1000.00, lots);
        String messageRetour = t1.validerTerrain();

        assertTrue("Message attendu :" + messageAttendu + ",mais message obtenu :"
                + messageRetour, messageAttendu == messageRetour);

    }

    @Test
    public void TesterListeLots_doublons() {

        String messageAttendu
                = "La description des lots doit etre unique";
        List<Lot> lots = new ArrayList<Lot>();
        Lot lot = new Lot("lot1", 1, 1, 5.0, "2015-10-14");
        Lot lot2 = new Lot("lot2", 1, 1, 5.0, "2015-10-14");
        Lot lot3 = new Lot("lot2", 1, 1, 5.0, "2015-10-14");

        lots.add(lot);
        lots.add(lot2);
        lots.add(lot3);
        Terrain t1 = new Terrain(-1, 500.00, 1000.00, lots);
        String messageRetour = t1.validerTerrain();

        assertTrue("Message attendu :" + messageAttendu + ",mais message obtenu :"
                + messageRetour, messageAttendu == messageRetour);

    }

    @Test
    public void TesterDescriptionNonValideTerrain() {
        // descriptionEntree = -1;

        String messageAttendu
                = " le type de terrain doit prendre la valeur 0, 1 ou 2";
        List<Lot> lots = new ArrayList<Lot>();
        Lot lot = new Lot("lot1", 11, 1, 5.0, "2015-10-14");
        lots.add(lot);

        Terrain t1 = new Terrain(-1, 500.00, 1000.00, lots);
        String messageRetour = t1.validerTerrain();

        assertTrue("Message attendu :" + messageAttendu + ",mais message obtenu :"
                + messageRetour, messageAttendu == messageRetour);

    }

    public void TesterDescriptionNonValideTerrain2() {
        // descriptionEntree = 3;

        String messageAttendu
                = " le type de terrain doit prendre la valeur 0, 1 ou 2";
        List<Lot> lots = new ArrayList<Lot>();
        Lot lot = new Lot("lot2", 12, 2, 10.0, "2015-10-14");
        lots.add(lot);

        Terrain t1 = new Terrain(3, 300.00, 700.00, lots);
        String messageRetour = t1.validerTerrain();

        assertTrue("Message attendu :" + messageAttendu + ",mais message obtenu :"
                + messageRetour, messageAttendu == messageRetour);

    }

    public void TesterDescriptionValideTerrain() {
        // descriptionEntree = 2;

        String messageAttendu
                = "valide";
        List<Lot> lots = new ArrayList<Lot>();
        Lot lot = new Lot("lot2", 12, 2, 10.0, "2017-11-16");
        lots.add(lot);

        Terrain t1 = new Terrain(2, 200.00, 600.00, lots);
        String messageRetour = t1.validerTerrain();

        assertTrue("Message attendu :" + messageAttendu + ",mais message obtenu :"
                + messageRetour, messageAttendu == messageRetour);

    }

    public void TesterPrixMinNonValideTerrain() {
        // prix_m2_min < 0 ;

        String messageAttendu
                = "le montant du prix minimum ne doit pas etre negatif";
        List<Lot> lots = new ArrayList<Lot>();
        Lot lot = new Lot("lot2", 12, 2, 10.0, "2017-11-16");
        lots.add(lot);

        Terrain t1 = new Terrain(2, -200.00, 600.00, lots);
        String messageRetour = t1.validerTerrain();

        assertTrue("Message attendu :" + messageAttendu + ",mais message obtenu :"
                + messageRetour, messageAttendu == messageRetour);

    }

    public void TesterPrixMaxNonValideTerrain() {
        // prix_m2_max < 0 

        String messageAttendu
                = "le montant du prix max ne doit pas etre negatif";
        List<Lot> lots = new ArrayList<Lot>();
        Lot lot = new Lot("lot2", 12, 2, 10.0, "2017-11-16");
        lots.add(lot);

        Terrain t1 = new Terrain(2, 200.00, -600.00, lots);
        String messageRetour = t1.validerTerrain();

        assertTrue("Message attendu :" + messageAttendu + ",mais message obtenu :"
                + messageRetour, messageAttendu == messageRetour);

    }
}
