/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DecimalFormat;

/**
 *
 * @author Bernard
 */
public class CalculTaxes {

    private static double TAXE_SCOLAIRE = 0.012;
    private static double TAXE_MUNICIPALE = 0.025;

    //calcul de la taxe scolaire
    public static double CalculerTaxeScolaire(double montant_de_base) {
        double taxes = montant_de_base * TAXE_SCOLAIRE;
        System.out.println("montant taxes: "+taxes);
        return Utilitaire.arrondir5CentSup(taxes);
    }

    // calcul de la taxe municipale
    public static double CalculerTaxeMunicipale(double montant_de_base) {
        double taxes = montant_de_base * TAXE_MUNICIPALE;
        return Utilitaire.arrondir5CentSup(taxes);
    }
}
