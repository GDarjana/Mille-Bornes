package nc.unc.gl.borne.Carte;

import nc.unc.gl.borne.Joueur.Joueur;

public interface CarteInterface {
    public String getEffet();

    public String getType();

    public String poserCarte(Joueur cible);

    public String getPathImage();

}
