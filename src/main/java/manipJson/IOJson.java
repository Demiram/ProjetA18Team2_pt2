/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modele.Lot;
import modele.Terrain;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Demi
 */
public class IOJson {
    public static Terrain traiterEntreeTerrain() throws IOException{
        String json = FileReader.loadFileIntoString("json/test01.json");
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
    
    public static void traiterSortieTerrain(Terrain terrain) {
        
    }
}
