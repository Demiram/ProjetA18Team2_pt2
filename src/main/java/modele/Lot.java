/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Demi
 */
public class Lot {
    //vars entrees
    private String descriptionEntree;
    private int nombre_droits_passage;
    private int nombre_services;
    private double superficie;
    private String date_mesure;
    
    //vars de traitements
    private double montantDroitsPassage;
    private double montantServices;
    private double valeurFonciere;
    
    //vars sorties
    private String descriptionSortie;
    private double valeur_par_lot;
    
    //constr entrees
    public Lot() {}
    
    public Lot(String descriptionEntree, int nombre_droits_passage, int nombre_services, double superficie, String date_mesure) {
        this.descriptionEntree = descriptionEntree;
        this.nombre_droits_passage = nombre_droits_passage;
        this.nombre_services = nombre_services;
        this.superficie = superficie;
        this.date_mesure = date_mesure;
    }
    
    //get set entrees
    public String getDescriptionEntree() {
        return descriptionEntree;
    }
    
    public void setDescriptionEntree(String descriptionEntree) {
        this.descriptionEntree = descriptionEntree;
    }
    
    public int getNombre_droits_passage() {
        return nombre_droits_passage;
    }
    
    public void setNombre_droits_passage(int nombre_droits_passage) {
        this.nombre_droits_passage = nombre_droits_passage;
    }
    
    public int getNombre_services() {
        return nombre_services;
    }
    
    public void setNombre_services(int nombre_services) {
        this.nombre_services = nombre_services;
    }
    
    public double getSuperficie() {
        return superficie;
    }
    
    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }
    
    public String getDate_mesure() {
        return date_mesure;
    }
    
    public void setDate_mesure(String date_mesure) {
        this.date_mesure = date_mesure;
    }
    
    //get set traitements
    public double getMontantDroitsPassage() {
        return montantDroitsPassage;
    }

    public void setMontantDroitsPassage(double montantDroitsPassage) {
        this.montantDroitsPassage = montantDroitsPassage;
    }

    public double getMontantServices() {
        return montantServices;
    }

    public void setMontantServices(double montantServices) {
        this.montantServices = montantServices;
    }

    public double getValeurFonciere() {
        return valeurFonciere;
    }

    public void setValeurFonciere(double valeurFonciere) {
        this.valeurFonciere = valeurFonciere;
    }
    
    
    //get set sorties
     public String getDescriptionSortie() {
        return descriptionSortie;
    }
     
    public void setDescription(String descriptionSortie) {
        this.descriptionSortie = descriptionSortie;
    }
    
    public double getValeur_par_lot() {
        return valeur_par_lot;
    }
    
    public void setValeur_par_lot(double valeur_par_lot) {
        this.valeur_par_lot = valeur_par_lot;
    }
}
