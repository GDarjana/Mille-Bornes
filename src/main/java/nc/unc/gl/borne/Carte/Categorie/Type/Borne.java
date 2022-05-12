package nc.unc.gl.borne.Carte.Categorie.Type;

import nc.unc.gl.borne.Carte.Categorie.Effet.BorneDistance;
import nc.unc.gl.borne.Joueur.Joueur;

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

    /**
     * Permet au joueur de poser sa carte et ajoute le score à son compteur si il
     * n'est pas bloqué
     * 
     * @param cible
     */
    public String poserCarte(Joueur cible) {
        appliquerDistance(cible);
        return "CARTE BORNE POSÉE";
    }

    /**
     * Appliquer l'effet de la carte sur la cible
     * 
     * @param cible
     */
    public void appliquerDistance(Joueur cible) {
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
    public String getEffet() {
        return this.distance.name().toString();
    }

    @Override
    public String getType() {
        return this.type;
    }
}
