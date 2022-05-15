package nc.unc.gl.borne.Metier.Carte;

import nc.unc.gl.borne.Metier.Joueur.Joueur;

public interface CarteInterface {
    public String getEffet();

    public String getType();

    public void appliquerEffet(Joueur cible);

    public String getPathImage();

}
