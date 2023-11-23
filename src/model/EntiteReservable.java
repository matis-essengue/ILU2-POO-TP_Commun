package model;

public abstract class EntiteReservable<T extends Formulaire> {
    CalendrierAnnuel calendrier;
    int num;

    protected EntiteReservable() {
        this.calendrier = new CalendrierAnnuel();
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    public boolean estLibre(T formulaire) {
        return this.calendrier.estLibre(formulaire.getJour(), formulaire.getMois());
    }

    public abstract boolean compatible(T formulaire);

    public abstract Reservation reserver(T formulaire);
}
