package service;

import model.ObjetConnecte;
import java.io.*;
import java.util.ArrayList;

public class ServiceAbonnement {

    private static final String FICHIER = "src/abonnements.txt";

    // Lire l'état d'abonnement d'un capteur
    public static boolean lireAbonnement(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(FICHIER))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split("=");
                if (parts[0].equals(id)) {
                    return Boolean.parseBoolean(parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Sauvegarder tous les abonnements
    public static void sauvegarderAbonnements(ArrayList<ObjetConnecte> capteurs) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FICHIER))) {
            for (ObjetConnecte c : capteurs) {
                pw.println(c.getId() + "=" + c.isAbonnementActif());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


