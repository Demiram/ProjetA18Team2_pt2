/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import modele.Lot;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 1995160
 */
public class LotTest {
    
    public LotTest() {
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
    
    
   //valider lot description non valide
    @Test
    public void test_description_null(){
        Lot lot = new Lot(null, 1, 1, 1.0, "");
        String messageAttendu = "Erreur: La description d'au moins un des lots est manquante.";
        String resultat = lot.validerLot();
        assertTrue("reponse attendue: "+messageAttendu+"; resultat: "+resultat, messageAttendu.equals(resultat));
    }
    
    //valider lot droits passage non valides
    @Test
    public void test_droits_tropBas(){
        Lot lot = new Lot("lot 1", -1, 1, 1.0, "");
        String messageAttendu = "Erreur au " + "lot 1" + ". Le nombre de droits de passages doit avoir une valeur non nulle et positive.";
        String resultat = lot.validerLot();
        assertTrue("reponse attendue: "+messageAttendu+"; resultat: "+resultat, messageAttendu.equals(resultat));
    }

    @Test
    public void test_droits_tropHauts(){
        Lot lot = new Lot("lot 1", 11, 1, 1.0, "");
        String messageAttendu = "Erreur au " + "lot 1" + ". Le nombre de droits de passages doit être compris entre 0 et 10.";
        String resultat = lot.validerLot();
        assertTrue("reponse attendue: "+messageAttendu+"; resultat: "+resultat, messageAttendu.equals(resultat));
    }
    
    //valider services non valides
    @Test
    public void test_services_tropBas(){
        Lot lot = new Lot("lot 1", 8, -1, 1.0, "");
        String messageAttendu = "Erreur au " + "lot 1" + ". Le nombre de services doit avoir une valeur non nulle et positive.";
        String resultat = lot.validerLot();
        assertTrue("reponse attendue: "+messageAttendu+"; resultat: "+resultat, messageAttendu.equals(resultat));
    }    
   
    @Test
    public void test_services_tropHaut(){
        Lot lot = new Lot("lot 1", 8, 11, 1.0, "");
        String messageAttendu = "Erreur au " + "lot 1" + ". Le nombre de services doit être compris entre 0 et 5.";
        String resultat = lot.validerLot();
        assertTrue("reponse attendue: "+messageAttendu+"; resultat: "+resultat, messageAttendu.equals(resultat));
    }
    
   //valider lot superficie non valide
    @Test
    public void test_superficie_tropBasse(){
        Lot lot = new Lot("lot 1", 8, 5, -1.0, "");
        String messageAttendu = "Erreur au " + "lot 1" + ". La superficie doit avoir une valeur non nulle et positive.";
        String resultat = lot.validerLot();
        assertTrue("reponse attendue: "+messageAttendu+"; resultat: "+resultat, messageAttendu.equals(resultat));
    }
    
    @Test
    public void test_superficie_tropHaute(){
        Lot lot = new Lot("lot 1", 8, 5, 55000.0, "");
        String messageAttendu = "Erreur au " + "lot 1" + ". La superficie doit être compris entre 0 et 50 000.";
        String resultat = lot.validerLot();
        assertTrue("reponse attendue: "+messageAttendu+"; resultat: "+resultat, messageAttendu.equals(resultat));
    }

    //valider presence date 
        @Test
    public void test_date_null(){
        Lot lot = new Lot("lot 1", 8, 5, 50000.0, null);
        String messageAttendu = "Erreur au " + "lot 1" + ". Il y manque une date de mesure.";

        String resultat = lot.validerLot();
        assertTrue("reponse attendue: "+messageAttendu+"; resultat: "+resultat, messageAttendu.equals(resultat));
    }
    
    //valider lot format date non valide
    @Test
    public void test_formatDate_vide(){
        Lot lot = new Lot("lot 1", 8, 5, 45000.0, "");
        String messageAttendu = "Le format de la date n'est pas valide dans "+"lot 1";
        String resultat = lot.validerLot();
        assertTrue("reponse attendue: "+messageAttendu+"; resultat: "+resultat, messageAttendu.equals(resultat));
    }
    
    @Test
    public void test_formatDate_mauvaisFormat(){
        Lot lot = new Lot("lot 1", 8, 5, 45000.0, "2000/10/25");
        String messageAttendu = "Le format de la date n'est pas valide dans "+"lot 1";
        String resultat = lot.validerLot();
        assertTrue("reponse attendue: "+messageAttendu+"; resultat: "+resultat, messageAttendu.equals(resultat));
    }
    
    // valider lot format date valide
    @Test
    public void test_valide(){
        Lot lot = new Lot("lot 1", 8, 5, 45000.0, "2000-10-25");
        String messageAttendu = "valide";
        String resultat = lot.validerLot();
        assertTrue("reponse attendue: "+messageAttendu+"; resultat: "+resultat, messageAttendu.equals(resultat));
    }    
     
}
