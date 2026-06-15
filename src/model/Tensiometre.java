package model;

import java.util.Random;

public class Tensiometre extends ObjetConnecte {

    private Random random = new Random();

    public Tensiometre(String id) {
        this.id = id;
        this.nom = "Tensiomètre " + id;
        this.abonnementActif = true;
        this.seuilMin = 90; // exemple
        this.seuilMax = 140;
        this.valeur = 0;
    }

    @Override
    public void mesurer() {
        // Simule une mesure aléatoire entre 90 et 140
        valeur = 90 + random.nextInt(51); // 90 + 0..50
    }
}


