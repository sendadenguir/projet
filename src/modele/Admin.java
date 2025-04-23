/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;


public class Admin {
    private int id;
    private String nom;
    private String prenom;
    private int telephone;
    private String mot_de_passe;
    private String email;

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   public String getPrenom() {
        return prenom;
    }

   public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

  public int getTelephone() {
        return telephone;
    }

   public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

  public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}