package nc.unc.gl.borne.Carte;

import nc.unc.gl.borne.Carte.Categorie.Type.CarteInterface;
import nc.unc.gl.borne.Joueur.Joueur;

public class Carte<T> implements CarteInterface {
    private T categorie;

    public Carte(T categorie) {
        this.categorie = categorie;
    }

    public T getCategorie() {
        return this.categorie;
    }

    /**
     * Affiche aux joueurs les différentes cartes qu'il possède
     */
    @Override
    public String getEffet() {
        return ((CarteInterface) this.categorie).getEffet();
    }

    /**
     * Le joueur appel cette fonction lorsqu'il vaut poser une carte
     */
    @Override
    public String poserCarte(Joueur cible) {
        return ((CarteInterface) this.categorie).poserCarte(cible);
    }

}
