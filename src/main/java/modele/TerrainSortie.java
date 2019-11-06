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
public class TerrainSortie {
    private double valeur_fonciere_totale;
    private double taxe_scolaire;
    private double taxe_municipale;
    private LotSortie[] lotissements;

    public TerrainSortie() {
    }

    public TerrainSortie(double valeur_fonciere_totale, double taxe_scolaire, double taxe_municipale, LotSortie[] lotissements) {
        this.valeur_fonciere_totale = valeur_fonciere_totale;
        this.taxe_scolaire = taxe_scolaire;
        this.taxe_municipale = taxe_municipale;
        this.lotissements = lotissements;
    }

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

    public LotSortie[] getLotissements() {
        return lotissements;
    }

    public void setLotissements(LotSortie[] lotissements) {
        this.lotissements = lotissements;
    }
    
    
}
