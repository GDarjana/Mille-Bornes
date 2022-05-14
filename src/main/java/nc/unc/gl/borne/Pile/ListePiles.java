package nc.unc.gl.borne.Pile;

import nc.unc.gl.borne.Carte.Carte;

public class ListePiles {
    private Pile pileBataille;
    private Pile pileVitesse;
    private Pile pileBorne;

    public ListePiles() {
        this.pileBataille = initPileBataille();
        this.pileVitesse = initPileVitesse();
        this.pileBorne = initPileBornes();
    }

    /**
     * Initalise la pile bataille
     * 
     * @return
     */
    private Pile initPileBataille() {
        return new Pile(PileEnum.BATAILLE);
    }

    /**
     * Initalise la pile vitesse
     * 
     * @return
     */
    private Pile initPileVitesse() {
        return new Pile(PileEnum.VITESSE);
    }

    /**
     * Initailise la pile borne
     */
    private Pile initPileBornes() {
        return new Pile(PileEnum.BORNE);
    }

    /**
     * Retourne la pile bataille
     * 
     * @return
     */
    public Pile getPileBataille() {
        return this.pileBataille;
    }

    /**
     * Retourne la pile vitesse
     * 
     * @return
     */
    public Pile getPileVitesse() {
        return this.pileVitesse;
    }

    /**
     * Retourne la pile borne
     * 
     * @return
     */
    public Pile getPileBorne() {
        return this.pileBorne;
    }

    /**
     * Vérifie le type de la carte et renvoi la fonction appropriée pour vérifier la
     * pile
     * 
     * @param carte
     */
    public void checkPile(Carte carte) {
        switch (carte.getType()) {
            case "ATTAQUE":
                checkPileBatailleWhenAttack(carte);
                break;
            case "PARADE":
                checkPileBatailleWhenDefend(carte);
                break;
            case "BORNE":
                checkPileBorne(carte);
                break;
        }
    }

    /**
     * Vérifie la pile bataille quand une carte attaque veut être posée
     * 
     * @param carte
     */
    public String checkPileBatailleWhenAttack(Carte carte) {
        if (!this.pileBataille.cardIsPresent(carte) && !this.pileBataille.isParadePresent(carte)) {
            this.pileBataille.ajouterCarteToPile(carte);
            return "Carte " + carte.getEffet() + " placé";
        } else {
            return "Le joueur est protégé";
        }
    }

    /**
     * Vérifie la pile bataille quand une carte parade veut être posée
     * 
     * @param carte
     */
    public String checkPileBatailleWhenDefend(Carte carte) {
        switch (carte.getEffet()) {

        }
        // Ajoute la carte à la pile BATAILLE
        this.getPileBataille().ajouterCarteToPile(carte);
        return null;
    }

    /**
     * Vérifie la pile borne , BORNE
     * 
     * @param carte
     */
    public void checkPileBorne(Carte carte) {

        // Ajoute la carte à la pile BORNE
        this.getPileBorne().ajouterCarteToPile(carte);
    }
}
