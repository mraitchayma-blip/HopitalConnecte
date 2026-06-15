package Vue;

import model.ObjetConnecte;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PanelCapteur extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private ArrayList<ObjetConnecte> capteurs;

    public PanelCapteur(ArrayList<ObjetConnecte> capteurs) {
        this.capteurs = capteurs;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Capteurs"));

        tableModel = new DefaultTableModel(
                new String[]{"ID", "Nom", "Valeur", "Abonnement", "État"}, 0
        );

        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        rafraichir();
    }

    public void rafraichir() {
        tableModel.setRowCount(0);
        for (ObjetConnecte c : capteurs) {
            tableModel.addRow(new Object[]{
                    c.getId(),
                    c.getNom(),
                    c.getValeur(),
                    c.isAbonnementActif(),
                    c.getEtat()
            });
        }
    }

    public int getLigneSelectionnee() {
        return table.getSelectedRow();
    }
}





