package model;
public abstract class ObjetConnecte {
    protected String id;
    protected String nom;
    protected boolean abonnementActif;
    protected double valeur;
    protected double seuilMin;
    protected double seuilMax;

    public abstract void mesurer();

    public boolean estEnAlerte() {
        return valeur < seuilMin || valeur > seuilMax;
    }

    public String getEtat() {
        if (!abonnementActif) return "Abonnement expiré";
        if (estEnAlerte()) return "ALERTE";
        return "OK";
    }

    // ----- NOUVEAUX GETTERS -----
    public String getId() {
        return id;
    }

    public boolean isAbonnementActif() {
        return abonnementActif;
    }

    public double getValeur() {
        return valeur;
    }

    public String getNom() {
        return nom;
    }

    // ----- SETTER pour abonnement -----
    public void setAbonnement(boolean actif) {
        this.abonnementActif = actif;
    }
}



