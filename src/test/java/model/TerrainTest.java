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
     public void TesterDescriptionNonValideTerrain() {    
        // descriptionEntree = -1;

     String messageAttendu=
             " le type de terrain doit prendre la valeur 0, 1 ou 2";
     List<Lot> lots = new ArrayList<Lot>();
     Lot lot = new Lot("lot1", 11, 1, 5.0, "2015-10-14");
     lots.add(lot);
     
     Terrain t1= new Terrain(-1,500.00,1000.00,lots);    
     String messageRetour= t1.validerTerrain();
     
     assertTrue( "Message attendu :" + messageAttendu +  ",mais message obtenu :" +
            messageRetour, messageAttendu == messageRetour );
             
     }
     
          public void TesterDescriptionNonValideTerrain2() {    
        // descriptionEntree = 3;

     String messageAttendu=
             " le type de terrain doit prendre la valeur 0, 1 ou 2";
     List<Lot> lots = new ArrayList<Lot>();
     Lot lot = new Lot("lot2", 12, 2, 10.0, "2015-10-14");
     lots.add(lot);
     
     Terrain t1= new Terrain(3,300.00,700.00,lots);    
     String messageRetour= t1.validerTerrain();
     
     assertTrue( "Message attendu :" + messageAttendu +  ",mais message obtenu :" +
            messageRetour, messageAttendu == messageRetour );
             
     }
          
    public void TesterDescriptionValideTerrain() {    
        // descriptionEntree = 2;

     String messageAttendu=
             "valide";
     List<Lot> lots = new ArrayList<Lot>();
     Lot lot = new Lot("lot2", 12, 2, 10.0, "2017-11-16");
     lots.add(lot);
     
     Terrain t1= new Terrain(2,200.00,600.00,lots);    
     String messageRetour= t1.validerTerrain();
     
     assertTrue( "Message attendu :" + messageAttendu +  ",mais message obtenu :" +
            messageRetour, messageAttendu == messageRetour );
             
     }      
          
          
}
