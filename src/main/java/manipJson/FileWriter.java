/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipJson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author 0249248
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
/*
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
*/
public class FileWriter {
    public static void saveStringIntoFile(String filePath, String contentToSave)
    throws FileNotFoundException, IOException {
        File f = new File(filePath);
        FileUtils.writeStringToFile(f, contentToSave, "UTF-8");
    }
}
