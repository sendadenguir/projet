/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import modele.Client;
import controller.ClientController;
import modele.Animal;
import controller.AnimalController;
import view.ViewLogin;
public class App {
    public static void main(String[] args) {
          // Démarrer l'application avec la vue de login
        java.awt.EventQueue.invokeLater(() -> {
            new ViewLogin().setVisible(true);
        });

        
    }
}
