/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipJson;

import java.io.IOException;
//import org.json.JSONArray;
//import org.json.JSONObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/*
import net.sf.json-lib;
import net.sf.json.JSONObject;
*/

/**
 *
 * @author 0249248
 */
public class EntreeJson {
    public void traiterEntree() throws IOException{
        String json = FileReader.loadFileIntoString("json/test01.json");
        
        JSONObject mainObject = JSONObject.fromObject(json);
        JSONArray lots = mainObject.getJSONArray("lotissements");
        JSONObject singleLot;
        JSONObject typeTerrain;
        
        
    }

}
