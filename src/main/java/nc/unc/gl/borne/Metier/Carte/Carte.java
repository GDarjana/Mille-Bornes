package nc.unc.gl.borne.Metier.Carte;

import nc.unc.gl.borne.Metier.Joueur.Joueur;

public class Carte<T> implements CarteInterface {
    private T categorie;

    public Carte(T categorie) {
        this.categorie = categorie;
    }

    public T getCategorie() {
        return this.categorie;
    }

    /**
     * Retourne le nom de l'effet de la carte
     */
    @Override
    public String getEffet() {
        return ((CarteInterface) this.categorie).getEffet();
    }

    /**
     * Le joueur appel cette fonction lorsqu'il vaut poser une carte
     */
    public String poserCarte(Joueur cible) {
        ((CarteInterface) this.categorie).appliquerEffet(cible);
        return cible.getListePiles().ajouterCarte(this);
    }

    @Override
    public String getType() {
        return ((CarteInterface) this.categorie).getType();
    }

    @Override
    public String getPathImage() {
        return ((CarteInterface) this.categorie).getPathImage();
    }

    @Override
    public void appliquerEffet(Joueur cible) {

    }

}
