package nc.unc.gl.borne.Metier.Pile;

import nc.unc.gl.borne.Metier.Carte.Carte;
import nc.unc.gl.borne.Metier.Deck.Deck;

public class Pile {
    private PileEnum nomPile;
    private Deck deck;

    public Pile(PileEnum nomPile) {
        this.nomPile = nomPile;
        this.deck = new Deck();
    }

    public String getNomPile() {
        return this.nomPile.name().toString();
    }

    public Deck getDeck() {
        return this.deck;
    }

    /**
     * Ajoute une carte au deck de la pile
     * 
     * @param carte
     */
    public void ajouterCarteToPile(Carte carte) {
        this.deck.ajouterCarte(carte);
    }

    public void enleverCarte(Carte carte) {
        this.deck.enleverCarte(carte);
    }

    /**
     * Vérifie si une carte du même effet et déjà présente dans la pile ou non
     * 
     * @param carte
     * @return
     */
    public boolean cardIsPresent(Carte carte) {
        for (Carte c : this.deck.getCartes()) {
            if (c.getEffet() == carte.getEffet()) {
                return true;
            }
        }
        return false;
    }

    // -----------------------------<Vérification_atouts>------------------------------------
    // ----------<Parade>----------
    /**
     * Vérifie si la carte parade correspondante à une carte attaque est présente
     * dans la pile bataille , la retorune si elle est présent , null sinon
     * 
     * @param paradeName
     * @return
     */
    public Boolean isCorrespondingParadePresent(String paradeName, String botteName) {
        for (Carte c : this.getDeck().getCartes()) {
            if ((c.getEffet() == paradeName) || (c.getEffet() == botteName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vérifie si une parade à la carte concernée est présente
     * 
     * @param carte
     * @return
     */
    public boolean isParadePresent(Carte carte) {
        switch (carte.getEffet()) {
            case "FEU_ROUGE":
                if (this.isCorrespondingParadePresent("FEU_VERT", null)) {
                    return true;
                }
            case "LIMITE_VITESSE":
                if (this.isCorrespondingParadePresent("LIMITE_VITESSE", "VEHICULE_PRIORITAIRE")) {
                    return true;
                }
            case "PANNE_ESSENCE":
                if (this.isCorrespondingParadePresent("PANNE_ESSENCE", "CITERNE_ESSENCE")) {
                    return true;
                }
            case "CREVAISON":
                if (this.isCorrespondingParadePresent("ROUE_DE_SECOURS", "INCREVABLE")) {
                    return true;
                }
            case "ACCIDENT":
                if (this.isCorrespondingParadePresent("REPARATIONS", "AS_DU_VOLANT")) {
                    return true;
                }
        }
        return false;
    }

    /**
     * Enlève la carte attaque correspondante à l'immunité de la botte
     * 
     * @param carte
     */
    public void cleanCorrespondingAttack(Carte carte) {
        Carte carteToCounter = this.getCounteredAttack(carte);
        if (carteToCounter != null) {
            this.deck.enleverCarte(carteToCounter);
        }
    }

    // ----------<Attaque>----------
    /**
     * Vérifie si la carte attaque correspondante à une carte parade est présente
     * dans la pile bataille , la retorune si elle est présent , null sinon
     * 
     * @param attackName
     * @return
     */
    public Carte isCorrespondingAttackPresent(String attackName) {
        for (Carte c : this.getDeck().getCartes()) {
            if (c.getEffet() == attackName) {
                return c;
            }
        }
        return null;
    }

    /**
     * Récupère la carte correspondante à la carte parade ou à la botte
     * 
     * @param carte
     * @return
     */
    public Carte getCounteredAttack(Carte carte) {
        Carte carteToCounter;
        switch (carte.getEffet()) {
            case "FEU_VERT":
                if ((carteToCounter = this.isCorrespondingAttackPresent("FEU_ROUGE")) != null) {
                    return carteToCounter;
                }
            case "VEHICULE_PRIORITAIRE":
            case "LIMITE_VITESSE":
                if ((carteToCounter = this.isCorrespondingAttackPresent("LIMITE_VITESSE")) != null) {
                    return carteToCounter;
                }
            case "CITERNE_ESSENCE":
            case "PANNE_ESSENCE":
                if ((carteToCounter = this.isCorrespondingAttackPresent("PANNE_ESSENCE")) != null) {
                    return carteToCounter;
                }
            case "INCREVABLE":
            case "ROUE_DE_SECOURS":
                if ((carteToCounter = this.isCorrespondingAttackPresent("CREVAISON")) != null) {
                    return carteToCounter;
                }
            case "AS_DU_VOLANT":
            case "REPARATIONS":
                if ((carteToCounter = this.isCorrespondingAttackPresent("ACCIDENT")) != null) {
                    return carteToCounter;
                }
        }
        return null;
    }

    /**
     * Contre ataque lorsqu'une carte parade est posée
     * Enlève la carte parade et la carte attaque correspondante
     * 
     * @param carte
     */
    public void counterAttack(Carte carte) {
        Carte carteContrer = this.getCounteredAttack(carte);
        if (carteContrer != null) {
            this.enleverCarte(carte);
            this.enleverCarte(carteContrer);
        }
    }
}
