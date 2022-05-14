package nc.unc.gl.borne.Deck;

import java.util.ArrayList;
import java.util.List;

import nc.unc.gl.borne.Carte.Carte;

/**
 * Deck d'un joueur , objet représentant les cartes que possèdent un joueur
 * 
 * 
 */
public class Deck {
    private List<Carte> deck = new ArrayList<Carte>();

    public Deck() {
    }

    public void ajouterCarte(Carte carte) {
        this.deck.add(carte);
    }

    public void enleverCarte(Carte carte) {
        this.deck.remove(carte);
    }

    public List<Carte> getDeck() {
        return this.deck;
    }

    public String getDeckEffets() {
        String effets = "";
        for (Carte carte : this.deck) {
            effets += carte.getEffet() + "\n";
        }
        return effets;
    }

    public String getDeckCartesImages() {
        String paths = "";
        for (Carte carte : this.deck) {
            paths += carte.getPathImage() + "\n";
        }
        return paths;
    }

    // -----------------------------<Vérification_atouts>------------------------------------
    // PARADE
    public boolean isParadeFeuVertPresent() {
        for (Carte c : this.deck) {
            if (c.getEffet() == "FEU_VERT") {
                return true;
            }
        }
        return false;
    }

}
