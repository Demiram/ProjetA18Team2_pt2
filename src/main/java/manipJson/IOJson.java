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
        
        // consoliderNomsProprietes remplace les " " par "_"
        JSONObject mainObject = consoliderNomsProprietes(JSONObject.fromObject(json.toLowerCase()));
        
        terrain.setType_terrain(mainObject.getInt("type_terrain"));
        terrain.setPrix_m2_min(validerEntreeDouble(mainObject.getString("prix_m2_min")));
        terrain.setPrix_m2_max(validerEntreeDouble(mainObject.getString("prix_m2_max")));

        JSONArray lots = mainObject.getJSONArray("lotissements");
        JSONObject singleLot;
        for (int i = 0; i < lots.size(); i++) {
            singleLot = lots.getJSONObject(i);

            entreeDescriptionLot = singleLot.getString("description");
            entreeNbDroitsPassageLot = singleLot.getInt("nombre_droits_passage");
            entreeNbServicesLot = singleLot.getInt("nombre_services");
            entreeSuperficieLot = singleLot.getInt("superficie");
            entreeDateMesureLot = singleLot.getString("date_mesure");
            entreeLotsArr.add(new Lot(entreeDescriptionLot, entreeNbDroitsPassageLot,
                    entreeNbServicesLot, entreeSuperficieLot, entreeDateMesureLot));

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

        for (int i = 0; i < lots.size(); i++) {

            singleLot.accumulate("description", lots.get(i).getDescriptionEntree());
            singleLot.accumulate("valeur_par_lot", lots.get(i).getValeur_par_lot() + " $");
            lotsJson.add(singleLot);
            singleLot.clear();
        }

        mainObject.accumulate("lotissements", lotsJson);
        FileWriter.saveStringIntoFile(outputPath, mainObject.toString());
    }

    public static JSONObject lancerErreur(String message) {
        JSONObject mainObject = new JSONObject();

        mainObject.accumulate("message", message);

        return mainObject;
    }

    public static double validerEntreeDouble(String str) {
        StringBuilder strB = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                strB.append('.');
            } else if (str.charAt(i) != ' ' && str.charAt(i) != '$') {
                strB.append(str.charAt(i));
            }
        }

        return Double.parseDouble(strB.toString());
    }
    public static JSONObject consoliderNomsProprietes(JSONObject jObj) {
        if(!jObj.has("valeur_fonciere_totale")) {
            if(jObj.has("valeur fonciere totale")) {
                jObj.accumulate("valeur_fonciere_totale", jObj.get("valeur fonciere totale"));
            } else if(jObj.has("valeur_fonciere totale")) {
                jObj.accumulate("valeur_fonciere_totale", jObj.get("valeur_fonciere totale"));
            } else if(jObj.has("valeur fonciere_totale")) {
                jObj.accumulate("valeur_fonciere_totale", jObj.get("valeur fonciere_totale"));
            } else if(jObj.has("valeurfoncieretotale")) {
                jObj.accumulate("valeur_fonciere_totale", jObj.get("valeurfoncieretotale"));
            }
        }
        
        if(!jObj.has("taxe_scolaire")) {
            if(jObj.has("taxe scolaire")) {
                jObj.accumulate("taxe_scolaire", jObj.get("taxe scolaire"));
            } else if(jObj.has("taxescolaire")) {
                jObj.accumulate("taxe_scolaire", jObj.get("taxescolaire"));
            }
        }
        
        if(!jObj.has("taxe_municipale")) {
            if(jObj.has("taxe municipale")) {
                jObj.accumulate("taxe_municipale", jObj.get("taxe municipale"));
            } else if(jObj.has("taxemunicipale")) {
                jObj.accumulate("taxe_municipale", jObj.get("taxemunicipale"));
            }
        }
        
        JSONArray lots = new JSONArray();
        JSONObject singleLot = new JSONObject();
        
        if(!jObj.has("lotissements")) {
            lots = jObj.getJSONArray("lotissements");
            
            for(int i = 0; i < lots.size(); i++) {
                singleLot = lots.getJSONObject(i);
                
                if(!singleLot.has("valeur_par_lot")) {
                    if(singleLot.has("valeur par lot")) {
                        singleLot.accumulate("valeur_par_lot", jObj.get("valeur par lot"));
                    } else if(singleLot.has("valeur_par lot")) {
                        singleLot.accumulate("valeur_par_lot", jObj.get("valeur_par lot"));
                    } else if(singleLot.has("valeur par_lot")) {
                        singleLot.accumulate("valeur_par_lot", jObj.get("valeur par_lot"));
                    } else if(singleLot.has("valeurparlot")) {
                        singleLot.accumulate("valeur_par_lot", jObj.get("valeurparlot"));
                    }
                }
                
            }
        }
        
        return jObj;
    }

    public static JSONObject lancerErreur(List<String> message) {
        JSONObject mainObject = new JSONObject();
        JSONArray messages = new JSONArray();
        JSONObject singleMessage = new JSONObject();

        for (int i = 0; i < message.size(); i++) {
            singleMessage.accumulate("message", message.get(i));
            messages.add(singleMessage);
            singleMessage.clear();
        }

        mainObject.accumulate("messages", messages);
        return mainObject;
    }
}
