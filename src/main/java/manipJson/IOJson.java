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
        if(!jObj.has("type_terrain")) {
            if(jObj.has("type terrain")) {
                jObj.accumulate("type_terrain", jObj.get("type terrain"));
            } else if(jObj.has("typeterrain")) {
                jObj.accumulate("type_terrain", jObj.get("typeterrain"));
            }
        }
        
        if(!jObj.has("prix_m2_min")) {
            if(jObj.has("prix_m2 min")) {
                jObj.accumulate("prix_m2_min", jObj.get("prix_m2 min"));
            } else if(jObj.has("prix m2_min")) {
                jObj.accumulate("prix_m2_min", jObj.get("prix m2_min"));
            } else if(jObj.has("prix m2 min")) {
                jObj.accumulate("prix_m2_min", jObj.get("prix m2 min"));
            } else if(jObj.has("prixm2min")) {
                jObj.accumulate("prix_m2_min", jObj.get("prixm2min"));
            }
        }
        
        if(!jObj.has("prix_m2_max")) {
            if(jObj.has("prix_m2 max")) {
                jObj.accumulate("prix_m2_max", jObj.get("prix_m2 max"));
            } else if(jObj.has("prix m2_max")) {
                jObj.accumulate("prix_m2_max", jObj.get("prix m2_max"));
            } else if(jObj.has("prix m2 max")) {
                jObj.accumulate("prix_m2_max", jObj.get("prix m2 max"));
            } else if(jObj.has("prixm2max")) {
                jObj.accumulate("prix_m2_max", jObj.get("prixm2max"));
            }
        }
        
        JSONArray lots = new JSONArray();
        JSONObject singleLot = new JSONObject();
        
        if(!jObj.has("lotissements")) {
            lots = jObj.getJSONArray("lotissements");
            
            for(int i = 0; i < lots.size(); i++) {
                singleLot = lots.getJSONObject(i);
                
                if(!singleLot.has("nombre_droits_passage")) {
                    if(singleLot.has("nombre_droits passage")) {
                        singleLot.accumulate("nombre_droits_passage", jObj.get("nombre_droits passage"));
                    } else if(singleLot.has("nombre droits_passage")) {
                        singleLot.accumulate("nombre_droits_passage", jObj.get("nombre droits_passage"));
                    } else if(singleLot.has("nombre droits passage")) {
                        singleLot.accumulate("nombre_droits_passage", jObj.get("nombre droits passage"));
                    } else if(singleLot.has("nombredroitspassage")) {
                        singleLot.accumulate("nombre_droits_passage", jObj.get("nombredroitspassage"));
                    }
                }
                
                if(!jObj.has("nombre_services")) {
                    if(jObj.has("nombre services")) {
                        jObj.accumulate("nombre_services", jObj.get("nombre services"));
                    } else if(jObj.has("nombreservices")) {
                        jObj.accumulate("nombre_services", jObj.get("nombreservices"));
                    }
                }
                
                if(!jObj.has("date_mesure")) {
                    if(jObj.has("date mesure")) {
                        jObj.accumulate("date_mesure", jObj.get("date mesure"));
                    } else if(jObj.has("datemesure")) {
                        jObj.accumulate("date_mesure", jObj.get("datemesure"));
                    }
                }
            }
        }
        
        return jObj;
    }


}
