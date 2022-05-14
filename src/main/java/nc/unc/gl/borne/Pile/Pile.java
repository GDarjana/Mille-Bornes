package nc.unc.gl.borne.Pile;

import nc.unc.gl.borne.Carte.Carte;
import nc.unc.gl.borne.Deck.Deck;

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
    public boolean isParadeFeuVertPresent() {
        for (Carte c : this.getDeck().getCartes()) {
            if (c.getEffet() == "FEU_VERT") {
                return true;
            }
        }
        return false;
    }

    public boolean isParadeLimiteVitessePresent() {
        for (Carte c : this.getDeck().getCartes()) {
            if (c.getEffet() == "LIMITE_VITESSE") {
                return true;
            }
        }
        return false;
    }

    public boolean isParadeEssencePresent() {
        for (Carte c : this.getDeck().getCartes()) {
            if (c.getEffet() == "ESSENCE") {
                return true;
            }
        }
        return false;
    }

    public boolean isParadeRoueSecoursPresent() {
        for (Carte c : this.getDeck().getCartes()) {
            if (c.getEffet() == "ROUE_DE_SECOURS") {
                return true;
            }
        }
        return false;
    }

    public boolean isParadeReparationsPresent() {
        for (Carte c : this.getDeck().getCartes()) {
            if (c.getEffet() == "REPARATIONS") {
                return true;
            }
        }
        return false;
    }

    // ----------<ATTQUE>----------
    public Carte isAttackFeuRougePresent() {
        for (Carte c : this.getDeck().getCartes()) {
            if (c.getEffet() == "FEU_ROUGE") {
                return c;
            }
        }
        return null;
    }

    public Carte isAttackLimiteVitesse() {
        for (Carte c : this.getDeck().getCartes()) {
            if (c.getEffet() == "FEU_ROUGE") {
                return c;
            }
        }
        return null;
    }

    public Carte isAttackPanneEssencePresent() {
        for (Carte c : this.getDeck().getCartes()) {
            if (c.getEffet() == "PANNE_ESSENCE") {
                return c;
            }
        }
        return null;
    }

    public Carte isAttackCrevaisonPresent() {
        for (Carte c : this.getDeck().getCartes()) {
            if (c.getEffet() == "CREVAISON") {
                return c;
            }
        }
        return null;
    }

    public Carte isAttackAccidentPresent() {
        for (Carte c : this.getDeck().getCartes()) {
            if (c.getEffet() == "ACCIDENT") {
                return c;
            }
        }
        return null;
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
                if (this.isParadeFeuVertPresent()) {
                    return true;
                }
            case "LIMITE_VITESSE":
                if (this.isParadeLimiteVitessePresent()) {
                    return true;
                }
            case "PANNE_ESSENCE":
                if (this.isParadeEssencePresent()) {
                    return true;
                }
            case "CREVAISON":
                if (this.isParadeRoueSecoursPresent()) {
                    return true;
                }
            case "ACCIDENT":
                if (this.isParadeReparationsPresent()) {
                    return true;
                }
        }
        return false;
    }

    public Carte getCounteredAttack(Carte carte) {
        Carte carteToCounter;
        switch (carte.getEffet()) {
            case "FEU_VERT":
                if ((carteToCounter = this.isAttackFeuRougePresent()) != null) {
                    return carteToCounter;
                }
            case "LIMITE_VITESSE":
                if ((carteToCounter = this.isAttackLimiteVitesse()) != null) {
                    return carteToCounter;
                }
            case "PANNE_ESSENCE":
                if ((carteToCounter = this.isAttackPanneEssencePresent()) != null) {
                    return carteToCounter;
                }
            case "ROUE_DE_SECOURS":
                if ((carteToCounter = this.isAttackCrevaisonPresent()) != null) {
                    return carteToCounter;
                }
            case "REPARATIONS":
                if ((carteToCounter = this.isAttackAccidentPresent()) != null) {
                    return carteToCounter;
                }
        }
        return null;
    }

    public void counterAttack(Carte carte) {
        Carte carteContrer = this.getCounteredAttack(carte);
        if (carteContrer != null) {
            this.getDeck().enleverCarte(carte);
            this.getDeck().enleverCarte(carteContrer);
        }
    }
}
