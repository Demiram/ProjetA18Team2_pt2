/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team2.projetmaven.a18tp1_maven;

import dao.Agricole;
import dao.Commercial;
import dao.Residentiel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import manipJson.FileWriter;
import manipJson.IOJson;
import static manipJson.IOJson.traiterEntreeTerrain;
import modele.Terrain;
import net.sf.json.JSONObject;
import util.Utilitaire;

/**
 *
 * @author 0249248
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here.
        Terrain terrain = null;
        String inputPath = args[0];
        String outputPath = args[1];
        try {
            terrain = traiterEntreeTerrain(inputPath);
        } catch (IOException e) {
            System.out.println(inputPath + ": file not found");
        }
        String valide = Utilitaire.validationComplete(terrain);
        if (valide.equals("valide")) {
            switch (terrain.getType_terrain()) {
                case 0:
                    Agricole.calculerValeurTerrainAgricole(terrain);
                    break;
                case 1:
                    Residentiel.calculerValeurTerrain(terrain);
                    break;
                case 2:
                    Commercial.calculCommercial(terrain);
                    break;
                default:
                    System.out.println("type de terrain inconnu");
                    break;

            }
            try {
                IOJson.traiterSortieTerrain(terrain, outputPath);
            } catch (IOException e) {
                System.out.println(outputPath + ": you cannot create the file in that path");
            }
        } else {
            JSONObject erreur = IOJson.lancerErreur(valide);
            try {
                FileWriter.saveStringIntoFile(outputPath, erreur.toString());
            } catch (IOException ex) {
                System.out.println(outputPath + ": you cannot create the file in that path");
            }

        }

    }
}
