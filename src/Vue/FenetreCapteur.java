package Vue;

import model.ObjetConnecte;
import model.Tensiometre;
import model.Glucometre;
import model.Balance;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FenetreCapteur extends JFrame {

    private ArrayList<ObjetConnecte> capteurs;
    private JPanel panelCentral;
    private JLabel lblValeur;
    private JLabel lblEtat;
    private JButton btnMesurer;

    public FenetreCapteur() {
        setTitle("Gestion des capteurs");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        capteurs = new ArrayList<>();
        capteurs.add(new Tensiometre("T1"));
        capteurs.add(new Glucometre("G1"));
        capteurs.add(new Balance("B1"));

        panelCentral = new JPanel();
        add(panelCentral, BorderLayout.CENTER);

        // Affiche la liste initiale des capteurs
        afficherListeCapteurs();

        setVisible(true);
    }

    // Affiche un bouton pour chaque capteur
    private void afficherListeCapteurs() {
        panelCentral.removeAll();
        panelCentral.setLayout(new GridLayout(capteurs.size(), 1, 5, 5));

        for (ObjetConnecte c : capteurs) {
            JButton btn = new JButton(c.getNom());
            ObjetConnecte capteurCourant = c; // important pour le listener
            btn.addActionListener(e -> afficherDetailCapteur(capteurCourant));
            panelCentral.add(btn);
        }

        panelCentral.revalidate();
        panelCentral.repaint();
    }

    // Affiche les détails d’un capteur sélectionné
    private void afficherDetailCapteur(ObjetConnecte c) {
    panelCentral.removeAll();
    panelCentral.setLayout(new GridLayout(5, 1, 5, 5));

    JLabel lblNom = new JLabel("Capteur : " + c.getNom(), SwingConstants.CENTER);
    lblValeur = new JLabel("Valeur : " + c.getValeur());
    lblEtat = new JLabel("État : " + c.getEtat());

    // Bouton Mesurer
    btnMesurer = new JButton("Mesurer");
    btnMesurer.addActionListener(e -> {
        c.mesurer();
        lblValeur.setText("Valeur : " + c.getValeur());
        lblEtat.setText("État : " + c.getEtat());
    });

    // Bouton Retour
    JButton btnRetour = new JButton("Retour aux capteurs");
    btnRetour.addActionListener(e -> afficherListeCapteurs());

    // Ajout des composants au panel
    panelCentral.add(lblNom);
    panelCentral.add(lblValeur);
    panelCentral.add(lblEtat);
    panelCentral.add(btnMesurer);
    panelCentral.add(btnRetour);

    panelCentral.revalidate();
    panelCentral.repaint();
}

}