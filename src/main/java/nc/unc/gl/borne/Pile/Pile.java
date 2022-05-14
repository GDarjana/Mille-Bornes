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
        for (Carte c : this.deck.getDeck()) {
            if (c.getEffet() == carte.getEffet()) {
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
                if (this.getDeck().isParadeFeuVertPresent()) {
                    return true;
                }
        }
        return false;
    }

}
