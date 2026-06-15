package model;

import java.util.Random;

public class Balance extends ObjetConnecte {

    private Random random = new Random();

    public Balance(String id) {
        this.id = id;
        this.nom = "Balance " + id;
        this.abonnementActif = true;
        this.seuilMin = 40;
        this.seuilMax = 120;
        this.valeur = 0;
    }

    @Override
    public void mesurer() {
        valeur = 40 + random.nextInt(81); // 40 à 120
    }
}


