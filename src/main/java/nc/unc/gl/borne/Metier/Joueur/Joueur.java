package nc.unc.gl.borne.Metier.Joueur;

import nc.unc.gl.borne.Metier.Carte.Carte;
import nc.unc.gl.borne.Metier.Deck.Deck;
import nc.unc.gl.borne.Metier.Pile.ListePiles;

public class Joueur {
    private final String nom;
    private boolean peutAvancer;
    private int score;
    private Deck deck_joueur;
    private ListePiles pilesJoueur;
    private boolean isMyTurn;
    private boolean hasDrawn;

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
        this.score = this.getListePiles().getPileBorne().getPileBorneScore();
        return this.score;
    }

    /**
     * Renvoi un booleen , determinant si le joueur peut avancer ou non
     * 
     * @return
     */
    public boolean getPeutAvancer() {
        return this.getListePiles().getPileBataille().getDeck().isFeuVertPresent();
    }

    /**
     * Détermine si le joueur peut avancer ou non
     * 
     * @param peutAvancer
     */
    public void checkEtatPeutAvancer() {
        this.peutAvancer = this.getListePiles().getPileBataille().isAnyAttackCardPresent();
    }

    /**
     * Retourne la liste des piles du joueur
     * 
     * @return
     */
    public ListePiles getListePiles() {
        return pilesJoueur;
    }

    public Boolean getIsMyTurn() {
        return isMyTurn;
    }

    public void setPeutJouer(Boolean isMyTurn) {
        this.isMyTurn = isMyTurn;
    }

    /**
     * Fonction appelée lorsque c'est le tour du joueur
     * 
     * 
     * @param action Le nom de l'action , POSER ou DEFAUSSER
     * @param cible  La cible , null si le joueur defausse
     * @param carte  La carte que le joueur veut jouer / defausser
     */
    public String poserMaCarte(String action, Joueur cible, Carte carte) {
        String statut = null;
        switch (action) {
            case "POSER":
                Carte carteToPlay = this.deck_joueur.getSpecificCarte(carte);
                statut = carteToPlay.poserCarte(cible);
                break;
            case "DEFAUSSER":
                this.deck_joueur.enleverCarte(carte);
                return "Carte [" + carte.getEffet() + "] défaussée";
        }
        return statut;
    }

    /**
     * Renvoi le booleen correspondant à vrai si le joueur à piocher , faux sinon
     * 
     * @return
     */
    public boolean getHasDrawn() {
        return this.hasDrawn;
    }

    public void setHasDrawn(boolean hasDrawn) {
        this.hasDrawn = hasDrawn;
    }

}
