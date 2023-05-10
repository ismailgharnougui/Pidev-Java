/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author medmo
 */
public class Command {
    private int id;
    private int idClient;
    private String comDate;
    private float totalCost;
    private String payMethod;
    private String livMethod;
    private String etatCommande;
    private String adresse;

    public Command() {
    }

    public Command(int idClient, float totalCost, String payMethod, String livMethod, String adresse) {
        this.idClient = idClient;
        this.totalCost = totalCost;
        this.payMethod = payMethod;
        this.livMethod = livMethod;
        this.adresse = adresse;
    }

    public Command(int id, int idClient, String comDate, float totalCost, String payMethod, String livMethod, String etatCommande, String adresse) {
        this.id = id;
        this.idClient = idClient;
        this.comDate = comDate;
        this.totalCost = totalCost;
        this.payMethod = payMethod;
        this.livMethod = livMethod;
        this.etatCommande = etatCommande;
        this.adresse = adresse;
    }
    
    public Command(int id, int idClient, String comDate, float totalCost, String payMethod, String livMethod,String etatCommande ) {
        this.id = id;
        this.idClient = idClient;
        this.comDate = comDate;
        this.totalCost = totalCost;
        this.payMethod = payMethod;
        this.livMethod = livMethod;
        this.etatCommande = etatCommande;
    }

    public Command(int id, String etatCommande) {
        this.id = id;
        this.etatCommande = etatCommande;
    }
    
    
    

    public int getId() {
        return id;
    }
    public int getIdClient() {
        return idClient;
    }

    public String getComDate() {
        return comDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public String getLivMethod() {
        return livMethod;
    }
    public String getEtatCommande() {
        return etatCommande;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public void setComDate(String comDate) {
        this.comDate = comDate;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public void setLivMethod(String livMethod) {
        this.livMethod = livMethod;
    }
    public void setEtatCommande(String etatCommande) {
        this.etatCommande = etatCommande;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }
    
    
    @Override
    public String toString() {
        return "Command{" + "id=" + id + ", idClient=" + idClient + ", comDate=" + comDate + ", totalCost=" + totalCost + ", payMethod=" + payMethod + ", livMethod=" + livMethod + ", etatCommande=" + etatCommande + '}';
    }
    
}
