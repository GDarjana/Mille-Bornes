package nc.unc.gl.borne.Metier.Carte.Categorie.Type;

import nc.unc.gl.borne.Metier.Carte.CarteInterface;
import nc.unc.gl.borne.Metier.Carte.Categorie.Effet.BorneDistance;
import nc.unc.gl.borne.Metier.Joueur.Joueur;

public class Borne implements CarteInterface {
    private BorneDistance distance;
    private String type = "BORNE";

    public Borne(BorneDistance distance) {
        this.distance = distance;
    }

    public void poserBorne() {
        switch (this.distance) {
            case VINGT_CINQ:
            case CINQUANTE:
            case SOIXANTE_QUINZE:
            case CENT:
            case DEUX_CENTS:
                break;
        }
    }

    @Override
    public void appliquerEffet(Joueur cible) {
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
}
