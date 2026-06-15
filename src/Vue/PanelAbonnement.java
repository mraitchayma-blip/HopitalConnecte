package Vue;

import javax.swing.*;
import java.awt.*;

public class PanelAbonnement extends JPanel {

    public PanelAbonnement(Runnable actionMesurer, Runnable actionAbonnement) {

        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder("Actions"));

        JButton btnMesurer = new JButton("Activer Abonnement");
        btnMesurer.addActionListener(e -> actionMesurer.run());

        JButton btnAbonnement = new JButton(" Désactiver Abonnement");
        btnAbonnement.addActionListener(e -> actionAbonnement.run());

        add(btnMesurer);
        add(btnAbonnement);
    }
}

