/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.Utilitaire;
import util.CalculTaxes;
import modele.Terrain;
import modele.Lot;

/**
 *
 * @author 0249248
 */
public class Agricole {
     private static final double VALEUR_BASE = 733.77; // valeur fixe de départ pour le calcul de la valeur foncière totale du terrain
    private static final double MONTANT_BASE = 500.00; // montant de base pour le calcul de la valeur des droits de passage
    private static final double COEF_DROITS = 0.05; // coefficient de multiplication pour les droits de passage

    
        public static void calculerValeurTerrainAgricole(Terrain t) {
         double totalLots = 0;
        //pour chaque lot, calculer la valeur du lot et l'additionner au total
        for (Lot lot : t.getLots()) {
            double valeurLot;
            valeurLot = calculerValeurFonciereLot(t, lot.getSuperficie());
            valeurLot += calculerDroitsLot(lot, valeurLot);
            //valeurLot += calculerValeurServices(lot);
            lot.setValeur_par_lot(valeurLot);
            totalLots += valeurLot;
        }
            t.setValeur_fonciere_totale(Utilitaire.arrondir5CentSup(VALEUR_BASE+totalLots));
            t.setTaxe_scolaire(CalculTaxes.CalculerTaxeScolaire(t.getValeur_fonciere_totale()));
            t.setTaxe_municipale(CalculTaxes.CalculerTaxeMunicipale(t.getValeur_fonciere_totale()));
        
    }

        
    public static double calculerValeurFonciereLot(Terrain t, double superficie) {
    double retour = superficie * (t.getPrix_m2_min());
    return (Utilitaire.arrondirDecimales(retour, 2));
    } 

    public static double calculerDroitsLot(Lot lot, double valeurLot) {
        double retour = MONTANT_BASE - (lot.getNombre_droits_passage() * valeurLot * COEF_DROITS);
        return (Utilitaire.arrondirDecimales(retour, 2));
    }
    
    
}
