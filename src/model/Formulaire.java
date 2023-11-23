package model;

public abstract class Formulaire {
    private int jour;
    private int mois;
    private int numEntite;

    protected Formulaire(int jour, int mois) {
        this.jour = jour;
        this.mois = mois;
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getIdentificationEntite() {
        return numEntite;
    }

    public void setIdentificationEntite(int numEntite) {
        this.numEntite = numEntite;
    }
}
