package nc.unc.gl.borne.Metier.Deck;

import java.util.ArrayList;
import java.util.List;

import nc.unc.gl.borne.Metier.Carte.Carte;

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

    public List<Carte> getCartes() {
        return this.deck;
    }

    /**
     * Retourne les effets des cartes présentes dans le deck
     * 
     * @return
     */
    public String getDeckEffets() {
        String effets = "";
        for (Carte carte : this.deck) {
            effets += carte.getEffet() + "\n";
        }
        return effets;
    }

    /**
     * Retourne les path des images des cartes présentes dans le deck
     * 
     * @return
     */
    public String getDeckCartesImages() {
        String paths = "";
        for (Carte carte : this.deck) {
            paths += carte.getPathImage() + "\n";
        }
        return paths;
    }

}
