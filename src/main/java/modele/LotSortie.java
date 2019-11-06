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
public class LotSortie {
    private String description;
    private double valeur_par_lot;

    public LotSortie() {
    }

    public LotSortie(String description, double valeur_par_lot) {
        this.description = description;
        this.valeur_par_lot = valeur_par_lot;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValeur_par_lot() {
        return valeur_par_lot;
    }

    public void setValeur_par_lot(double valeur_par_lot) {
        this.valeur_par_lot = valeur_par_lot;
    }
}
