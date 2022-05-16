package nc.unc.gl.borne.Metier.Partie;

import java.util.ArrayList;
import java.util.List;

import nc.unc.gl.borne.Metier.Joueur.Joueur;
import nc.unc.gl.borne.Metier.Pioche.Pioche;

public class Partie {
    private List<Joueur> listeJoueurs = new ArrayList<Joueur>();
    private static Pioche pioche = new Pioche();
    private static boolean partieFinie = false;
    private int indiceJoueurJouant = 0;

    public Pioche getPioche() {
        return pioche;
    }

    public boolean isPartieFinie() {
        return partieFinie;
    }

    public void addJoueur(Joueur joueur) {
        this.listeJoueurs.add(joueur);
    }

    public List<Joueur> getListeJoueurs() {
        return this.listeJoueurs;
    }

    /**
     * Renvoi une partie
     * 
     * @return
     */
    public static Partie initPartie() {
        return new Partie();
    }

    /**
     * Modifie l'indice de parcours de la liste en fonction de sa position dans la
     * liste
     */
    public void setNextIndiceJoueurJouant() {
        int nextIndice = getIndiceJoueurJouant() + 1;
        if (!isNextTour(nextIndice)) {
            setIndiceJoueurJouant(nextIndice);
        } else {
            setIndiceJoueurJouant(0);
        }
    }

    public int getIndiceJoueurJouant() {
        return this.indiceJoueurJouant;
    }

    /**
     * Modifie l'indice d parcours de la liste
     * 
     * @param indice
     */
    public void setIndiceJoueurJouant(int indice) {
        this.indiceJoueurJouant = indice;
    }

    /**
     * Récupère le joueur pouvant jouer çàd le joueur courant
     * 
     * @return
     */
    public Joueur getCurrentPlayer() {
        return listeJoueurs.stream()
                .filter(joueur -> joueur.getIsMyTurn() == true)
                .findAny()
                .orElse(null);
    }

    public void updatePartie() {
        updateNextPlayer();
    }

    /**
     * Vérifie si l'indice courant est le dernier de la liste
     * çàd , si c'est le case , réinitisalise l'indice et donne la main au joueur à
     * la posistion 0 de la liste
     * sinon incrémente de 1
     * 
     * @param indice
     * @return
     */
    public boolean isNextTour(int indice) {
        return indice > listeJoueurs.size() - 1;
    }

    /**
     * Le joueur correspondant à l'indice , peut jouer
     */
    public void setNextPlayerCanPlay() {
        listeJoueurs.get(indiceJoueurJouant).setPeutJouer(true);
    }

    /**
     * Si le joueur a fini de jouer , update l'indice et donne la main ou joueur
     * suivant
     */
    public void updateNextPlayer() {
        if (listeJoueurs.get(indiceJoueurJouant).getIsMyTurn() == false) {
            this.setNextIndiceJoueurJouant();
            this.setNextPlayerCanPlay();
        }
    }

}
