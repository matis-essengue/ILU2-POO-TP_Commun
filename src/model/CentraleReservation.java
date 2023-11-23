package model;

public class CentraleReservation<T extends EntiteReservable> {
    private T[] entites;
    private int nbEntites;

    public CentraleReservation(T[] entites) {
        this.entites = entites;
        if (entites.length != 0) {
            throw new IllegalArgumentException("Le tableau d'entités doit être vide");
        }
        this.nbEntites = 0;
    }

    public int ajouterEntite(T entite) {
        this.entites[this.nbEntites] = entite;
        return this.nbEntites++;
    }

    public int[] donnePossibilites(Formulaire formulaire) {
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

    public Reservation reserver(int numEntite, Formulaire formulaire) {
        if (numEntite < 0 || numEntite >= this.nbEntites) {
            throw new IllegalArgumentException("Numéro d'entité invalide");
        }
        if (!this.entites[numEntite].estLibre(formulaire)) {
            throw new IllegalArgumentException("Entité déjà réservée");
        }
        if (!this.entites[numEntite].compatible(formulaire)) {
            throw new IllegalArgumentException("Entité incompatible avec le formulaire");
        }
        formulaire.setIdentificationEntite(numEntite);
        return this.entites[numEntite].reserver(formulaire);
    }
}
