package Vue;

import javax.swing.*;


public class FenetreAbonnement extends JFrame {

    public FenetreAbonnement() {
        setTitle("Gestion des abonnements");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        
        PanelAbonnement panel = new PanelAbonnement(
            () -> JOptionPane.showMessageDialog(this, "Activer!"),
            () -> JOptionPane.showMessageDialog(this, "Désactiver !")
        );

        add(panel);

        setVisible(true);
    }
}

