package model;

public class FormulaireRestaurant extends Formulaire {
    private int numService;
    private int nbPersonnes;

    public FormulaireRestaurant(int jour, int mois, int nbPersonnes, int numService) {
        super(jour, mois);
        if (numService < 1 || numService > 2) {
            throw new IllegalArgumentException("Numéro de service invalide");
        }
        this.numService = numService;
        this.nbPersonnes = nbPersonnes;
    }

    public int getNombrePersonnes() {
        return nbPersonnes;
    }

    public int getNumService() {
        return numService;
    }
}
