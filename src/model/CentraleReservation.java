package model;

public class CentraleReservation<E extends EntiteReservable<F>, F extends Formulaire> {
    private E[] entites;
    private int nbEntites;

    public CentraleReservation(E[] entites) {
        this.entites = entites;
        this.nbEntites = 0;
    }

    public int ajouterEntite(E entite) {
        this.entites[this.nbEntites] = entite;
        this.entites[this.nbEntites].setNum(++this.nbEntites);
        return this.nbEntites;
    }

    public int[] donnerPossibilites(F formulaire) {
        int[] dispos = new int[this.nbEntites];
        for (int i = 0; i < this.nbEntites; i++) {
            if (this.entites[i].estLibre(formulaire) && this.entites[i].compatible(formulaire)) {
                dispos[i] = this.entites[i].getNum();
            } else {
                dispos[i] = 0;
            }
        }
        return dispos;
    }

    public Reservation reserver(int numEntite, F formulaire) {
        if (numEntite < 0 || numEntite >= this.nbEntites) {
            throw new IllegalArgumentException("Numéro d'entité invalide");
        }
        if (!this.entites[numEntite - 1].estLibre(formulaire)) {
            throw new IllegalArgumentException("Entité déjà réservée");
        }
        if (!this.entites[numEntite - 1].compatible(formulaire)) {
            System.out.println("Entité incompatible avec le formulaire");
            throw new IllegalArgumentException("Entité incompatible avec le formulaire");
        }
        formulaire.setIdentificationEntite(numEntite);
        return this.entites[numEntite - 1].reserver(formulaire);
    }
}
