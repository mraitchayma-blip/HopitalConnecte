package Vue;

import javax.swing.*;
import java.awt.*;

public class FenetreAccueil extends JFrame {

    public FenetreAccueil() {
        setTitle("Hôpital connecté - Accueil");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnCapteurs = new JButton("Gérer les capteurs");
        JButton btnAbonnements = new JButton("Gérer les abonnements");

        btnCapteurs.addActionListener(e -> new FenetreCapteur());
        btnAbonnements.addActionListener(e -> new FenetreAbonnement());

        setLayout(new GridLayout(2, 1, 20, 20));
        add(btnCapteurs);
        add(btnAbonnements);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FenetreAccueil::new);
    }
}


