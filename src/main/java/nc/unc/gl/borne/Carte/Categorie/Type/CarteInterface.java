package nc.unc.gl.borne.Carte.Categorie.Type;

import nc.unc.gl.borne.Joueur.Joueur;

public interface CarteInterface {
    public String getEffet();

    public String poserCarte(Joueur cible);

    public String getType();
}
