package nc.unc.gl.borne.Metier.Joueur;

import nc.unc.gl.borne.Metier.Deck.Deck;
import nc.unc.gl.borne.Metier.Pile.ListePiles;

public class Joueur {
    private final String nom;
    private boolean peutAvancer;
    private int score;
    private Deck deck_joueur;
    private ListePiles pilesJoueur;

    /**
     * Constructeur , initalise un nouveau joueur
     * 
     * @param nom Le nom du joueur
     */
    public Joueur(String nom) {
        this.nom = nom;
        this.peutAvancer = false;
        this.score = 0;
        this.deck_joueur = new Deck();
        this.pilesJoueur = new ListePiles();
    }

    /**
     * Setter du deck du joueur
     * 
     * @param deck Le deck du joueur
     */
    public void setDeckJoueur(Deck deck) {
        this.deck_joueur = deck;
    }

    public Deck getDeckJoueur() {
        return this.deck_joueur;
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

    public void setPeutAvancer(boolean peutAvancer) {
        this.peutAvancer = peutAvancer;
    }

    public ListePiles getListePiles() {
        return pilesJoueur;
    }

}
