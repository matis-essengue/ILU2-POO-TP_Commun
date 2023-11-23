package model;

public abstract class EntiteReservable {
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

    public boolean estLibre(Formulaire formulaire) {
        return this.calendrier.estLibre(formulaire.getJour(), formulaire.getMois());
    }

    public abstract boolean compatible(Formulaire formulaire);

    protected abstract <T extends Reservation> T reserver(Formulaire formulaire);
}
