package nc.unc.gl.borne.Carte.Categorie.Type;

import nc.unc.gl.borne.Carte.CarteInterface;
import nc.unc.gl.borne.Carte.Categorie.Effet.ParadeEffet;
import nc.unc.gl.borne.Joueur.Joueur;

public class Parade implements CarteInterface {
    private ParadeEffet effet;
    private String type = "PARADE";

    public Parade(ParadeEffet effet) {
        this.effet = effet;
    }

    @Override
    public String poserCarte(Joueur cible) {
        appliquerEffet(cible);
        return "CARTE PARADE POSÉE";
    }

    /**
     * Appliquer l'effet de la carte sur la cible
     * 
     * @param cible
     */
    public void appliquerEffet(Joueur cible) {
        switch (this.effet) {
            case FEU_VERT:
            case LIMITE_VITESSE:
            case ESSENCE:
            case ROUE_DE_SECOURS:
            case REPARATIONS:
                break;
        }
    }

    @Override
    public String getEffet() {
        return this.effet.name().toString();
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getPathImage() {
        return this.effet.get_path_image();
    }

}
