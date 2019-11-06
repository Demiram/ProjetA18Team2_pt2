/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author 0249248
 */
public class TerrainEntree {
    private int type_terrain;
    private double prix_m2_min;
    private double prix_m2_max;
    private LotEntree[] lots;

    public TerrainEntree() {
    }

    public TerrainEntree(int type_terrain, double prix_m2_min, double prix_m2_max, LotEntree[] lots) {
        this.type_terrain = type_terrain;
        this.prix_m2_min = prix_m2_min;
        this.prix_m2_max = prix_m2_max;
        this.lots = lots;
    }

    public TerrainEntree(int type_terrain, double prix_m2_min, double prix_m2_max) {
        this.type_terrain = type_terrain;
        this.prix_m2_min = prix_m2_min;
        this.prix_m2_max = prix_m2_max;
    }

    
    public int getType_terrain() {
        return type_terrain;
    }

    public void setType_terrain(int type_terrain) {
        this.type_terrain = type_terrain;
    }

    public double getPrix_m2_min() {
        return prix_m2_min;
    }

    public void setPrix_m2_min(double prix_m2_min) {
        this.prix_m2_min = prix_m2_min;
    }

    public double getPrix_m2_max() {
        return prix_m2_max;
    }

    public void setPrix_m2_max(double prix_m2_max) {
        this.prix_m2_max = prix_m2_max;
    }

    public LotEntree[] getLots() {
        return lots;
    }

    public void setLots(LotEntree[] lots) {
        this.lots = lots;
    }
    
    
}
