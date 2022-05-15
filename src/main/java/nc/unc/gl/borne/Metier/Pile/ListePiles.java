package nc.unc.gl.borne.Metier.Pile;

import nc.unc.gl.borne.Metier.Carte.Carte;

public class ListePiles {
    private Pile pileBataille;
    private Pile pileVitesse;
    private Pile pileBorne;
    private Pile pileBotte;
    private static String messageCarteCantBePlace = "La carte ne peut pas être placée";

    public ListePiles() {
        this.pileBataille = initPileBataille();
        this.pileVitesse = initPileVitesse();
        this.pileBorne = initPileBornes();
        this.pileBotte = initPileBotte();
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
     * Initialise la pile des bottes
     * 
     * @return
     */
    private Pile initPileBotte() {
        return new Pile(PileEnum.BOTTE);
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
     * Retourne la pile botte
     * 
     * @return
     */
    public Pile getPileBotte() {
        return this.pileBotte;
    }

    /**
     * Vérifie le type de la carte et renvoi la fonction appropriée pour vérifier la
     * pile
     * 
     * @param carte
     */
    public String ajouterCarte(Carte carte) {
        switch (carte.getType()) {
            case "BOTTE":
                return checkPileBotte(carte);
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

    public String checkPileBotte(Carte carte) {
        this.pileBataille.cleanCorrespondingAttack(carte);
        this.pileBataille.ajouterCarteToPile(carte);
        return "Carte Botte [" + carte.getEffet() + "] placée";
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
