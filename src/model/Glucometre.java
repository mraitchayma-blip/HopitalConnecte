package model;

import java.util.Random;

public class Glucometre extends ObjetConnecte {

    private Random random = new Random();

    public Glucometre(String id) {
        this.id = id;
        this.nom = "Glucomètre " + id;
        this.abonnementActif = true;
        this.seuilMin = 70;
        this.seuilMax = 180;
        this.valeur = 0;
    }

    @Override
    public void mesurer() {
        valeur = 70 + random.nextInt(111); // 70 à 180
    }
}

