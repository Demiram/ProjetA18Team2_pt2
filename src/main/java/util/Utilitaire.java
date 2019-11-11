/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Bernard
 */
public class Utilitaire {
    
    
    //calcul de l'arrondissement au 5 cent supérieur
    //le double que reçoit cette méthode doit déjà avoir été arrondit à la seconde décimale
    public static double arrondir5CentSup(double montant_de_base){
        montant_de_base = montant_de_base*100;
        while (montant_de_base%5>0){
            montant_de_base++;
        }
        return montant_de_base/100;
    }
    
}
