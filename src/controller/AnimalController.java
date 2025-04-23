/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import modele.Animal;
import modele.Connection_DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tango
 */
public class AnimalController {
     private Connection conn;

    public AnimalController() {
        this.conn = Connection_DB.getConnection();
    }

    // Ajouter un animal
    public boolean ajouterAnimal(Animal animal) {
        
       
     String sql = "INSERT INTO animal (nom, age, poids, taille, prix, sexe, statut) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
           
            pstmt.setString(1, animal.getNom());
            pstmt.setString(2, animal.getAge());
            pstmt.setString(3, animal.getPoids());
            pstmt.setString(4, animal.getTaille());
            pstmt.setString(5, animal.getPrix());
            pstmt.setString(6, animal.getSexe());
            pstmt.setString(7, animal.getStatut());
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                // Récupérer l'ID généré
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        animal.setIdAnimal(rs.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'animal: " + e.getMessage());
        }
        return false;
    }   

    // Modifier un animal
  /* public boolean modifierAnimal(Animal animal) {
        String sql = "UPDATE animal SET nom = ?, age = ?, poids = ?, taille = ?, prix = ?, sexe = ?, statut = ? WHERE idAnimal = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, animal.getNom());
            pstmt.setString(2, animal.getAge());
            pstmt.setString(3, animal.getPoids());
            pstmt.setString(4, animal.getTaille());
            pstmt.setString(5, animal.getPrix());
            pstmt.setString(6, animal.getSexe());
            pstmt.setString(7, animal.getStatut());
            pstmt.setInt(8, animal.getIdAnimal());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification de l'animal: " + e.getMessage());
        }
        return false;
    }

   /* // Supprimer un animal
    public boolean supprimerAnimal(int idAnimal) {
        String sql = "DELETE FROM animal WHERE idAnimal = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idAnimal);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'animal: " + e.getMessage());
        }
        return false;
    }

    // Récupérer un animal par son ID
    public Animal trouverAnimalParId(int idAnimal) {
        String sql = "SELECT * FROM animal WHERE idAnimal = ?";
        Animal animal = null;
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idAnimal);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    animal = new Animal();
                    animal.setIdAnimal(rs.getInt("idAnimal"));
                    animal.setNom(rs.getString("nom"));
                    animal.setAge(rs.getInt("age"));
                    animal.setPoids(rs.getString("poids"));
                    animal.setTaille(rs.getString("taille"));
                    animal.setPrix(rs.getString("prix"));
                    animal.setSexe(rs.getString("sexe"));
                    animal.setStatut(rs.getString("statut"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de l'animal: " + e.getMessage());
        }
        return animal;
    }

    // Lister tous les animaux
    public List<Animal> listerTousAnimaux() {
        List<Animal> animaux = new ArrayList<>();
        String sql = "SELECT * FROM animal";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setIdAnimal(rs.getInt("idAnimal"));
                animal.setNom(rs.getString("nom"));
                animal.setAge(rs.getInt("age"));
                animal.setPoids(rs.getString("poids"));
                animal.setTaille(rs.getString("taille"));
                animal.setPrix(rs.getString("prix"));
                animal.setSexe(rs.getString("sexe"));
                animal.setStatut(rs.getString("statut"));
                
                animaux.add(animal);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors du listage des animaux: " + e.getMessage());
        }
        return animaux;
    }

    // Méthode utilitaire pour fermer la connexion
    public void fermerConnexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la fermeture de la connexion: " + e.getMessage());
        }
    }*/

    public Animal trouverAnimalParId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}