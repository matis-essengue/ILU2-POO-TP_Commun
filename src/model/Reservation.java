package model;

public abstract class Reservation {
    private int jour;
    private int mois;

    protected Reservation(int jour, int mois) {
        this.jour = jour;
        this.mois = mois;
    }

    public String toString() {
        return "Le " + this.jour + "/" + this.mois + "\n";
    }
}
