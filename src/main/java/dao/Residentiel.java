/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.text.DecimalFormat;
import java.util.Set;
import modele.Lot;
import modele.Terrain;
import util.CalculTaxes;
import util.Utilitaire;

/**
 *
 * @author 0249248
 */
public class Residentiel {

    private static final double VALEUR_BASE = 733.77; // valeur fixe de départ pour le calcul de la valeur foncière totale du terrain
    private static final double MONTANT_BASE = 500.00; // montant de base pour le calcul de la valeur des droits de passage
    private static final double COEF_DROITS = 0.1; // coefficient de multiplication pour les droits de passage

    public static void calculerValeurTerrain(Terrain t) {
        double totalLots = 0;
        //pour chaque lot, calculer la valeur du lot et l'additionner au total
        for (Lot lot : t.getLots()) {
            double valeurLot = 0;
            valeurLot = calculerValeurFonciereLot(t, lot.getSuperficie());
            valeurLot += calculerDroitsLot(lot.getNombre_droits_passage(), valeurLot);
            valeurLot += calculerValeurServices(lot);
            lot.setValeur_par_lot(valeurLot);
            totalLots += valeurLot;
        }
        t.setValeur_fonciere_totale(Utilitaire.arrondir5CentSup(MONTANT_BASE + totalLots));
        t.setTaxe_scolaire(CalculTaxes.CalculerTaxeScolaire(totalLots));
        t.setTaxe_municipale(CalculTaxes.CalculerTaxeMunicipale(totalLots));
    }

    public static double calculerValeurFonciereLot(Terrain t, double superficie) {
        double retour = superficie * (t.getPrix_m2_min() + t.getPrix_m2_max()) / 2.0;
        return Utilitaire.arrondirDecimales(retour, 2);
    }

    public static double calculerDroitsLot(int nbDroits, double valeurLot) {
        double retour = MONTANT_BASE - (nbDroits * valeurLot * COEF_DROITS);
        return Utilitaire.arrondirDecimales(retour, 2);
    }

    public static double calculerValeurServices(Lot lot) {
        double retour = 0;
        if (lot.getSuperficie() > 10000) {
            retour = lot.getNombre_services() * 1000.00;
        } else if (lot.getSuperficie() > 500) {
            retour = lot.getNombre_services() * 500.00;
        }
        return Utilitaire.arrondirDecimales(retour, 2);
    }
}
