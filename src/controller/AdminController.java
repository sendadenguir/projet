/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import modele.Connection_DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modele.Admin;



public class AdminController {
    private final Connection conn;
      public AdminController() {
        this.conn = Connection_DB.getConnection();
    }

      
      
      // Authentifier un admin
    public Admin LoginAdmin(String email, String mot_de_passe) {
        String sql = "SELECT * FROM admin WHERE email = ? AND mot_de_passe = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, mot_de_passe);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setNom(rs.getString("nom"));
                admin.setPrenom(rs.getString("prenom"));
                admin.setTelephone(rs.getInt("telephone"));
                admin.setMot_de_passe(rs.getString("mot_de_passe"));
                admin.setEmail(rs.getString("email"));
               return admin;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'authentification: " + e.getMessage());
        }
        return null;
    }
        
        
    
    }
    

