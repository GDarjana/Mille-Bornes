package nc.unc.gl.borne.Pile;

import nc.unc.gl.borne.Carte.Carte;

public class ListePiles {
    private Pile pileBataille;
    private Pile pileVitesse;
    private Pile pileBorne;
    private static String messageCarteCantBePlace = "La carte ne peut pas être placée";

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
    public String ajouterCarte(Carte carte) {
        switch (carte.getType()) {
            case "ATTAQUE":
                return checkPileBatailleWhenAttack(carte);
            case "PARADE":
                return checkPileBatailleWhenDefend(carte);
            case "BORNE":
                return checkPileBorne(carte);
        }
        return "AÏE";
    }

    /**
     * Vérifie la pile bataille quand une carte attaque veut être posée
     * 
     * @param carte
     */
    public String checkPileBatailleWhenAttack(Carte carte) {
        if (!this.pileBataille.cardIsPresent(carte) && !this.pileBataille.isParadePresent(carte)) {
            this.pileBataille.ajouterCarteToPile(carte);
            return "Carte [" + carte.getEffet() + "] placée";
        } else {
            return messageCarteCantBePlace;
        }
    }

    /**
     * Vérifie la pile bataille quand une carte parade veut être posée
     * 
     * @param carte
     */
    public String checkPileBatailleWhenDefend(Carte carte) {
        if (!this.pileBataille.cardIsPresent(carte) && (this.pileBataille.getCounteredAttack(carte) != null)) {
            this.pileBataille.ajouterCarteToPile(carte);
            this.pileBataille.counterAttack(carte);
            // Enlever la carte parade et la carte attaque concernée
            return "Carte Parade [" + carte.getEffet() + "] placée";
        } else {
            return messageCarteCantBePlace;
        }
    }

    /**
     * Vérifie la pile borne , BORNE
     * 
     * @param carte
     */
    public String checkPileBorne(Carte carte) {

        // Ajoute la carte à la pile BORNE
        this.getPileBorne().ajouterCarteToPile(carte);
        return "BORNE";
    }
}
