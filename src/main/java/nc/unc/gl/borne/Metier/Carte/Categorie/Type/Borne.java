package nc.unc.gl.borne.Metier.Carte.Categorie.Type;

import nc.unc.gl.borne.Metier.Carte.CarteInterface;
import nc.unc.gl.borne.Metier.Carte.Categorie.Effet.BorneDistance;

public class Borne implements CarteInterface {
    private BorneDistance distance;
    private String type = "BORNE";

    public Borne(BorneDistance distance) {
        this.distance = distance;
    }

    /**
     * Retourne l'effet de la carte
     */
    @Override
    public String getEffet() {
        return this.distance.name().toString();
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
        return this.distance.get_path_image();
    }

    /**
     * Retourne la description de la carte
     */
    @Override
    public String getDescription() {
        return this.distance.get_description();
    }
}
