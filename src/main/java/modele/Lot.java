/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Demi
 */
public class Lot {

    //vars entrees
    private String descriptionEntree;
    private String date_mesure;
    //les valeurs allouées ci-bas serviront à vérifier qu'une valeur été transmise au moment de la construction
    private int nombre_droits_passage = -1;
    private int nombre_services = -1;
    private double superficie = -1;

    //vars de traitements
    private double montantDroitsPassage;
    private double montantServices;
    private double valeurFonciere;

    //vars sorties
    private String descriptionSortie;
    private double valeur_par_lot;

    //constr entrees
    public Lot() {
    }

    public Lot(String descriptionEntree, int nombre_droits_passage, int nombre_services, double superficie, String date_mesure) {
        this.descriptionEntree = descriptionEntree;
        this.nombre_droits_passage = nombre_droits_passage;
        this.nombre_services = nombre_services;
        this.superficie = superficie;
        this.date_mesure = date_mesure;
    }

    public String validerLot() {
        String message = "valide";

        //vérification de la description. Elle doit être non null (le caractère unique est vérifié dans la méthode validerTerrain
        if (this.descriptionEntree == null || this.descriptionEntree.length() == 0) {
            return "Erreur: La description d'au moins un des lots est manquante.";
        }

        //vérification des droits de passage. Il doit être non nul et être entre 0 et 10
        if (this.nombre_droits_passage < 0) {
            return "Erreur au " + this.descriptionEntree + ". Le nombre de droits de passages doit avoir une valeur non nulle et positive.";
        } else if (this.nombre_droits_passage > 10) {
            return "Erreur au " + this.descriptionEntree + ". Le nombre de droits de passages doit être compris entre 0 et 10.";
        }

        //vérification des services ils doivent être entre 0 et 5 et être non null
        if (this.nombre_services < 0) {
            return "Erreur au " + this.descriptionEntree + ". Le nombre de services doit avoir une valeur non nulle et positive.";
        } else if (this.nombre_services > 5) {
            return "Erreur au " + this.descriptionEntree + ". Le nombre de services doit être compris entre 0 et 5.";
        }

        //vérification de la superficie. Elle doit être non nulle et comprise entre 0 et 50 000
        if (this.superficie < 0) {
            return "Erreur au " + this.descriptionEntree + ". La superficie doit avoir une valeur non nulle et positive.";
        } else if (this.superficie > 50000.0) {
            return "Erreur au " + this.descriptionEntree + ". La superficie doit être compris entre 0 et 50 000.";
        }

        //vérification de la date de la mesure. Elle doit être non nulle et en format ISO8601
        if (this.date_mesure == null) {
            return "Erreur au " + this.descriptionEntree + ". Il y manque une date de mesure.";
        }

        
        //vérification de la validité du format de la date
        if(!validerFormat(this.date_mesure)){
            return "Le format de la date n'est pas valide dans "+this.descriptionEntree;
        }
        
        return message;
    }

    public boolean validerFormat(String date) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date formattedDate = null;
        try {
            formattedDate = dateFormatter.parse(date);
        } catch (ParseException ex) {
            return false;
        }
        return true;
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
