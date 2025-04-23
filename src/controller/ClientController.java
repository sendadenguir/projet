package controller;

import modele.Client;
import modele.Connection_DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientController {
    private final Connection conn;

    public ClientController() {
        this.conn = Connection_DB.getConnection();
    }

    // Ajouter un nouveau client
   
    public boolean ajouterClient(Client client) {
        String sql = "INSERT INTO client (nom, prenom, telephone, mot_de_passe, email, ville) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, client.getNom());
            pstmt.setString(2, client.getPrenom());
            pstmt.setInt(3, client.getTelephone());
            pstmt.setString(4, client.getMot_de_passe());
            pstmt.setString(5, client.getEmail());
            pstmt.setString(6, client.getVille());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du client: " + e.getMessage());
            return false;
        }
    

    }

  

    // Authentifier un client
    public Client authentifierClient(String email, String motDePasse) {
        String sql = "SELECT * FROM client WHERE email = ? AND mot_de_passe = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, motDePasse);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                client.setTelephone(rs.getInt("telephone"));
                client.setMot_de_passe(rs.getString("mot_de_passe"));
                client.setEmail(rs.getString("email"));
                client.setVille(rs.getString("ville"));
                return client;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'authentification: " + e.getMessage());
        }
        return null;
    }
}