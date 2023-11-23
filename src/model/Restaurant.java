package model;

public class Restaurant {
    private CentraleReservation<Table, FormulaireRestaurant> centrale;

    public Restaurant() {
        Table[] tables = new Table[10];
        this.centrale = new CentraleReservation<>(tables);
    }

    private class Table extends EntiteReservable<FormulaireRestaurant> {
        private int nbChaises;
        private CalendrierAnnuel calendrierDeuxiemeService;

        public Table(int nbChaises) {
            this.nbChaises = nbChaises;
            this.calendrierDeuxiemeService = new CalendrierAnnuel();
        }

        @Override
        public Reservation reserver(FormulaireRestaurant formulaire) {
            int jour = formulaire.getJour();
            int mois = formulaire.getMois();
            int numEntite = formulaire.getIdentificationEntite();

            if (formulaire.getNumService() == 1) {
                if (this.calendrier.reserver(jour, mois)) {
                    return new ReservationRestaurant(jour, mois, 1, numEntite);
                } else {
                    return null;
                }
            } else {
                if (this.calendrierDeuxiemeService.reserver(jour, mois)) {
                    return new ReservationRestaurant(jour, mois, 2, numEntite);
                } else {
                    return null;
                }
            }
        }

        @Override
        public boolean compatible(FormulaireRestaurant formulaire) {
            if (formulaire.getNombrePersonnes() == this.nbChaises
                    || formulaire.getNombrePersonnes() == this.nbChaises - 1) {
                int jour = formulaire.getJour();
                int mois = formulaire.getMois();
                if (formulaire.getNumService() == 1) {
                    return this.calendrier.estLibre(jour, mois);
                } else {
                    return this.calendrierDeuxiemeService.estLibre(jour, mois);
                }
            }
            return false;
        }
    }

    public void ajouterTable(int nbChaises) {
        Table table = new Table(nbChaises);
        this.centrale.ajouterEntite(table);
    }

    public Reservation reserver(int numEntite, FormulaireRestaurant formulaire) {
        return this.centrale.reserver(numEntite, formulaire);
    }

    public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
        return this.centrale.donnerPossibilites(formulaire);
    }

}
