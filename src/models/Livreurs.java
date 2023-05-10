/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;

/**
 *
 * @author hp
 */
public class Livreurs {
   
    private int id;
    private String telephone, nom, prenom, region;

    public Livreurs(String telephone, String nom, String prenom, String region) {
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
        this.region = region;
    }

    public Livreurs(int id, String telephone, String nom, String prenom, String region) {
        this.id = id;
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
        this.region = region;
    }

    public Livreurs() {
    }

    public Livreurs(String telephone, String nom, String prenom) {
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Livreurs(int id, String telephone, String nom, String prenom) {
        this.id = id;
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public String getNum_tel() {
        return telephone;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum_tel(String telephone) {
        this.telephone = telephone;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRegion_livreur() {
        return region;
    }

    public void setRegion_livreur(String region) {
        this.region = region;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.telephone);
        hash = 53 * hash + Objects.hashCode(this.nom);
        hash = 53 * hash + Objects.hashCode(this.prenom);
        hash = 53 * hash + Objects.hashCode(this.region);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livreurs other = (Livreurs) obj;
        if (!Objects.equals(this.telephone, other.telephone)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.region, other.region)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Livreurs{" + "id=" + id + ", num_tel=" + telephone + ", nom=" + nom + ", prenom=" + prenom + ", region_livreur=" + region + '}';
    }

    

    
        


    
   

    

    
    
    
}
