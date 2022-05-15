package nc.unc.gl.borne.Metier.Carte.Categorie.Type;

import nc.unc.gl.borne.Metier.Carte.CarteInterface;
import nc.unc.gl.borne.Metier.Carte.Categorie.Effet.ParadeEffet;
import nc.unc.gl.borne.Metier.Joueur.Joueur;

public class Parade implements CarteInterface {
    private ParadeEffet effet;
    private String type = "PARADE";

    public Parade(ParadeEffet effet) {
        this.effet = effet;
    }

    @Override
    public void appliquerEffet(Joueur cible) {
    }

    /**
     * Retourne l'effet de la carte
     */
    @Override
    public String getEffet() {
        return this.effet.name().toString();
    }

    /**
     * Retourne le type de la carte
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Retourne le path vers l'image de la carte
     */
    @Override
    public String getPathImage() {
        return this.effet.get_path_image();
    }

}
