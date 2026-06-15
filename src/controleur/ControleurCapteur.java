package controleur;

import java.util.ArrayList;
import model.*;
import Vue.PanelCapteur;
import service.ServiceAbonnement;

public class ControleurCapteur {

    private ArrayList<ObjetConnecte> capteurs;
    private PanelCapteur panelCapteur;

    public ControleurCapteur(PanelCapteur panelCapteur) {
        this.panelCapteur = panelCapteur;
        capteurs = new ArrayList<>();
        initialiserCapteurs();
    }

    private void initialiserCapteurs() {
        Tensiometre t = new Tensiometre("TENSIO1");
        Balance b = new Balance("BALANCE1");
        Glucometre g = new Glucometre("GLUCO1");

        t.setAbonnement(ServiceAbonnement.lireAbonnement(t.getId()));
        b.setAbonnement(ServiceAbonnement.lireAbonnement(b.getId()));
        g.setAbonnement(ServiceAbonnement.lireAbonnement(g.getId()));

        capteurs.add(t);
        capteurs.add(b);
        capteurs.add(g);
    }

    // Retourne tous les capteurs
    public ArrayList<ObjetConnecte> getCapteurs() {
        return capteurs;
    }

    // Mesurer tous les capteurs
    public void mesurerTous() {
        for (ObjetConnecte c : capteurs) {
            if (c.isAbonnementActif()) {
                c.mesurer();
            }
        }
        panelCapteur.rafraichir();
    }

    // Activer/désactiver abonnement
    public void toggleAbonnement(int index) {
        if (index < 0 || index >= capteurs.size()) return;

        ObjetConnecte c = capteurs.get(index);
        c.setAbonnement(!c.isAbonnementActif());

        ServiceAbonnement.sauvegarderAbonnements(capteurs);
        panelCapteur.rafraichir();
    }
}
