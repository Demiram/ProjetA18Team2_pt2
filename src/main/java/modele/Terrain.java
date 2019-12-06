/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;

/**
 *
 * @author Demi
 */
public class Terrain {

    //vars entrees
    private int type_terrain;
    private double prix_m2_min;
    private double prix_m2_max;
    private List<Lot> lots;

    //vars sorties
    private double valeur_fonciere_totale;
    private double taxe_scolaire;
    private double taxe_municipale;

    //constr entrees
    public Terrain() {
    }

    public Terrain(int type_terrain, double prix_m2_min, double prix_m2_max, List<Lot> lots) {
        this.type_terrain = type_terrain;
        this.prix_m2_min = prix_m2_min;
        this.prix_m2_max = prix_m2_max;
        this.lots = lots;
    }

    public Terrain(int type_terrain, double prix_m2_min, double prix_m2_max) {
        this.type_terrain = type_terrain;
        this.prix_m2_min = prix_m2_min;
        this.prix_m2_max = prix_m2_max;
    }

    //get set entrees
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

    public List<Lot> getLots() {
        return lots;
    }

    public void setLots(List<Lot> lots) {
        this.lots = lots;
    }

    //get set sorties
    public double getValeur_fonciere_totale() {
        return valeur_fonciere_totale;
    }

    public void setValeur_fonciere_totale(double valeur_fonciere_totale) {
        this.valeur_fonciere_totale = valeur_fonciere_totale;
    }

    public double getTaxe_scolaire() {
        return taxe_scolaire;
    }

    public void setTaxe_scolaire(double taxe_scolaire) {
        this.taxe_scolaire = taxe_scolaire;
    }

    public double getTaxe_municipale() {
        return taxe_municipale;
    }

    public void setTaxe_municipale(double taxe_municipale) {
        this.taxe_municipale = taxe_municipale;
    }

    public String validerTerrain() {
        String message = "valide";
        
        if (lots == null){ 
          return "il doit avoir au moins un lot";
        }
        
        if (lots.isEmpty() || this.lots.size()< 1){ 
          return "il doit avoir au moins un lot";
        }
        
         //le nombre de lots ne doit jamais depasser 10 lots
        if (this.lots.size()> 10){
            return "le nombre de lots ne doit pas dépasser 10 lots";
        }
//        //un terrain doit avoir au moins un lot
//         if (this.lots.size()< 1){
//            return "il doit y avoir au moins un lot";
//        }        
        //parcourrir la liste des lots 
        //et verifier qu'ils ont des descriptions differentes         
        for (int i = 0; i < this.lots.size(); i++) {
            System.out.println("Entree dans la boucle. i="+i+" et "+"liste de taille "+this.lots.size());
            for (int j = i + 1; j < this.lots.size(); j++) {
                    System.out.println("i: "+i+" j: "+j);

                if (lots.get(i).getDescriptionEntree().equals(lots.get(j).getDescriptionEntree())) {
                    return "La description des lots doit etre unique";
                }
            }
        }
        //verifier que le type de terrain est entre 0 et 2 inclusivement
        if (type_terrain < 0 || type_terrain > 2) {
            return " le type de terrain doit prendre la valeur 0, 1 ou 2";
        }
        //prix_m2-min sup = a 0
        if (prix_m2_max < 0) {
            return "le montant du prix maximum ne doit pas etre negatif";
        }
        //prix_m2-min sup = a 0
        if (prix_m2_min < 0) {
            return "le montant du prix minimum ne doit pas etre negatif";
        }
       
        return message;
    }

}
