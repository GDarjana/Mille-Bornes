package nc.unc.gl.borne.Joueur;

import nc.unc.gl.borne.Carte.Carte;
import nc.unc.gl.borne.Deck.Deck;

public class Joueur {
    private final String nom;
    private boolean peutAvancer;
    private int score;
    private Deck deck_joueur;

    /**
     * Constructeur , initalise un nouveau joueur
     * 
     * @param nom Le nom du joueur
     */
    public Joueur(String nom) {
        this.nom = nom;
        this.peutAvancer = false;
        this.score = 0;
    }

    /**
     * Setter du deck du joueur
     * 
     * @param deck Le deck du joueur
     */
    public void setDeckJoueur(Deck deck) {
        this.deck_joueur = deck;
    }

    /**
     * Vérifie si le joueur est immunisé
     * 
     * @return
     */
    public boolean estImmuniseContre(Carte carte) {
        if (true) {
            return true;
        }
        return false;
    }

    /**
     * Renvoi le nom du joueur
     * 
     * @return
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Renvoi le score du joueur
     * 
     * @return
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Renvoi un booleen , determinant si le joueur peut avancer ou non
     * 
     * @return
     */
    public boolean getPeutAvancer() {
        return this.peutAvancer;
    }
}
