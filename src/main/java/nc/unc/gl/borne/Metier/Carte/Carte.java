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
        String statutPose = cible.getListePiles().ajouterCarte(this);
        cible.checkEtatPeutAvancer();
        return statutPose;
    }

    /**
     * Retourne le type de la carte
     */
    @Override
    public String getType() {
        return ((CarteInterface) this.categorie).getType();
    }

    /**
     * Retourne le path vers l'image de la
     */
    @Override
    public String getPathImage() {
        return "/cartes/"+((CarteInterface) this.categorie).getPathImage();
    }

    /**
     * Retourne la description de la carte
     */
    @Override
    public String getDescription() {
        return ((CarteInterface) this.categorie).getDescription();
    }

}
