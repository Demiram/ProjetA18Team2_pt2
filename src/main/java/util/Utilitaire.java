/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import modele.Terrain;
import net.sf.json.JSONObject;

/**
 *
 * @author Bernard
 */
public class Utilitaire {
    
    
    //calcul de l'arrondissement au 5 cent supérieur
    //le double que reçoit cette méthode doit déjà avoir été arrondit à la seconde décimale
    public static double arrondir5CentSup(double montant_de_base){
        montant_de_base = arrondirDecimales(montant_de_base, 2.0)*100;  
        while (montant_de_base%5>0){
            montant_de_base++;
        }
        return montant_de_base/100;
    }
    
    public static double arrondirDecimales(double nombreAArondir, double nbDecimales){
        
        double coefficient = Math.pow(10.0, nbDecimales);
        double nombreArrondi = Math.round(nombreAArondir*coefficient)/coefficient;
        return nombreArrondi;
    }
    
    public static String validationComplete(Terrain terrain) {
        int i = 0;
        String validFlag = "valide";
        
        while(i < terrain.getLots().size() && validFlag.equals("valide")) {
            validFlag = terrain.getLots().get(i).validerLot();
            
            i++;
        }
        
        return validFlag;
    }
}
