/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Lot;
import modele.Terrain;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Demi
 */
public class IOJson {
    public static Terrain traiterEntreeTerrain(String inputPath) throws IOException {
        String json = FileReader.loadFileIntoString(inputPath);
        Terrain terrain = new Terrain();
        List<Lot> entreeLotsArr = new ArrayList<Lot>();
        Lot lotEntreeJson = new Lot();
        
        String entreeDescriptionLot;
        int entreeNbDroitsPassageLot;
        int entreeNbServicesLot;
        int entreeSuperficieLot;
        String entreeDateMesureLot;
        
        JSONObject mainObject = JSONObject.fromObject(json);
        
        terrain.setType_terrain(mainObject.getInt("type_terrain"));
        terrain.setPrix_m2_min(mainObject.getDouble("prix_m2_min"));
        terrain.setPrix_m2_max(mainObject.getDouble("prix_m2_max"));
        
        JSONArray lots = mainObject.getJSONArray("lotissements");
        JSONObject singleLot;
        for(int i = 0;i < lots.size();i++) {
            singleLot = lots.getJSONObject(i);

            entreeDescriptionLot = singleLot.getString("description");
            entreeNbDroitsPassageLot = singleLot.getInt("nombre_droits_passage");
            entreeNbServicesLot = singleLot.getInt("nombre_services");
            entreeSuperficieLot = singleLot.getInt("superficie");
            entreeDateMesureLot = singleLot.getString("date_mesure");
            entreeLotsArr.add(new Lot(entreeDescriptionLot,entreeNbDroitsPassageLot,
                entreeNbServicesLot,entreeSuperficieLot,entreeDateMesureLot));
            
            entreeDescriptionLot = "";
            entreeNbDroitsPassageLot = 0;
            entreeNbServicesLot = 0;
            entreeSuperficieLot = 0;
            entreeDateMesureLot = "";
        }
        
        terrain.setLots(entreeLotsArr);
        
        return terrain;
    }
    
    public static void traiterSortieTerrain(Terrain terrain, String outputPath) throws IOException {
        JSONObject mainObject = new JSONObject();
        List<Lot> lots = terrain.getLots();
        JSONArray lotsJson = new JSONArray();
        JSONObject singleLot = new JSONObject();
        
        mainObject.accumulate("valeur_fonciere_totale", terrain.getValeur_fonciere_totale() + " $");
        mainObject.accumulate("taxe_scolaire", terrain.getTaxe_scolaire() + " $");
        mainObject.accumulate("taxe_municipale", terrain.getTaxe_municipale() + " $");
        
        for(int i = 0; i < lots.size(); i++) {
            
            singleLot.accumulate("description", lots.get(i).getDescriptionEntree());
            singleLot.accumulate("valeur_par_lot", lots.get(i).getValeur_par_lot() + " $");
            lotsJson.add(singleLot);
            singleLot.clear();
        }
        
        mainObject.accumulate("lotissements", lotsJson);
        FileWriter.saveStringIntoFile(outputPath, mainObject.toString());
    }
}
