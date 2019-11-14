/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import modele.Lot;
import modele.Terrain;
import util.Utilitaire;

/**
 *
 * @author 0249248
 */
public class Commercial {
    public static void calculCommercial(Terrain terrain) {
        calculValeurLotsCommerciaux(terrain);
        calculDroitsPassageLotsCommerciaux(terrain);
        calculMontantServicesLotsCommerciaux(terrain);
        calculValeurFonciereTerrainCommercial(terrain);
        
    }
    
    private static void calculValeurLotsCommerciaux(Terrain terrain) {
        List<Lot> lots = terrain.getLots();
        
        for(int i = 0; i < lots.size();i++) {
            lots.get(i).setValeur_par_lot(terrain.getPrix_m2_max() * 
                    lots.get(i).getSuperficie());
        }
    }
    
    private static void calculDroitsPassageLotsCommerciaux(Terrain terrain) {
        List<Lot> lots = terrain.getLots();
        
        for(int i = 0; i < lots.size();i++) {
            lots.get(i).setMontantDroitsPassage(500 - (lots.get(i).getNombre_droits_passage() * 
                    (0.15 * lots.get(i).getValeur_par_lot())));
        }
    }
    
    private static void calculMontantServicesLotsCommerciaux(Terrain terrain) {
        List<Lot> lots = terrain.getLots();
        double montant;
        
        for(int i = 0; i < lots.size();i++) {
            if(lots.get(i).getSuperficie() <= 500) {
                montant = lots.get(i).getNombre_services() * 500;
            } else {
                montant = lots.get(i).getNombre_services() * 1500;
            }
            if(montant > 5000) { montant = 5000; }
            
            lots.get(i).setMontantServices(montant);
        }
    }
    
    private static void calculValeurFonciereLotsCommerciaux(Terrain terrain) {
        List<Lot> lots = terrain.getLots();
        
        for(int i = 0; i < lots.size();i++) {
            lots.get(i).setValeurFonciere(lots.get(i).getValeur_par_lot() + 
                    lots.get(i).getMontantDroitsPassage() + lots.get(i).getMontantServices());
        }
    }
    
    private static void calculValeurFonciereTerrainCommercial(Terrain terrain) {
        List<Lot> lots = terrain.getLots();
        double valeurFonciere = 733.77;
        
        for(int i = 0; i < lots.size();i++) {
            valeurFonciere += lots.get(i).getValeurFonciere();
        }
        
        terrain.setValeur_fonciere_totale(Utilitaire.arrondir5CentSup(valeurFonciere));
    }
    
    private static void calculTaxeScolaire(Terrain terrain) {
        
    }
    
    private static void calculTaxeMunicipale(Terrain terrain) {
        
    }
}
