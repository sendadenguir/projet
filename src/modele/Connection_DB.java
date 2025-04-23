/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;



/**
 *
 * @author tango
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_DB {
    private static final String URL = "jdbc:mysql://localhost:3306/adoptease?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root"; // Ton utilisateur MySQL
    private static final String PASSWORD = ""; // Ton mot de passe MySQL

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Charger le driver JDBC
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie à la base de données !");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur : Driver JDBC non trouvé !");
        } catch (SQLException e) {
            System.out.println("Erreur : Impossible de se connecter à la base de données !");
        }
        return conn;
    }
}