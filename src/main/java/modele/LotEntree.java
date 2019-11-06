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
public class LotEntree {
    private String description;
    private int nombre_droits_passage;
    private int nombre_services;
    private int superficie;
    private String date_mesure;

    public LotEntree() {
    }

    public LotEntree(String description, int nombre_droits_passage, int nombre_services, int superficie, String date_mesure) {
        this.description = description;
        this.nombre_droits_passage = nombre_droits_passage;
        this.nombre_services = nombre_services;
        this.superficie = superficie;
        this.date_mesure = date_mesure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public String getDate_mesure() {
        return date_mesure;
    }

    public void setDate_mesure(String date_mesure) {
        this.date_mesure = date_mesure;
    }
    
    
}
