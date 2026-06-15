package Vue;

import controleur.ControleurCapteur;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class FenetrePrincipale extends JFrame {

    private PanelCapteur panelCapteur;
    private JTextArea alertes;

    public FenetrePrincipale() {
        setTitle("Hôpital Connecté");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Zone d'alertes
        alertes = new JTextArea(5, 50);
        alertes.setEditable(false);
        JScrollPane scrollAlertes = new JScrollPane(alertes);

        // Panel temporaire pour initialisation du contrôleur
        PanelCapteur panelCapteurTemp = new PanelCapteur(new ArrayList<>());

        // Création du contrôleur
        ControleurCapteur controleur = new ControleurCapteur(panelCapteurTemp);

        // Panel capteur réel
        panelCapteur = new PanelCapteur(controleur.getCapteurs());

        // Panel des boutons
        PanelAbonnement panelAbonnement = new PanelAbonnement(
                () -> controleur.mesurerTous(),
                () -> controleur.toggleAbonnement(panelCapteur.getLigneSelectionnee())
        );

        // Layout
        setLayout(new BorderLayout());
        add(panelAbonnement, BorderLayout.NORTH);
        add(panelCapteur, BorderLayout.CENTER);
        add(scrollAlertes, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FenetrePrincipale::new);
    }
}

