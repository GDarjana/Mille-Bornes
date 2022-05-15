package nc.unc.gl.borne.Metier.Carte.Categorie.Type;

import nc.unc.gl.borne.Metier.Carte.CarteInterface;
import nc.unc.gl.borne.Metier.Carte.Categorie.Effet.BotteEffet;
import nc.unc.gl.borne.Metier.Joueur.Joueur;

public class Botte implements CarteInterface {

    private BotteEffet effet;
    private String type = "BOTTE";

    public Botte(BotteEffet effet) {
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
