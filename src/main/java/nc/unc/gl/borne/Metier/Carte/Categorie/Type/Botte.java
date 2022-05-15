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
    public String poserCarte(Joueur cible) {
        appliquerBotte(cible);
        return "CARTE BOTTE POSÉE";
    }

    public void appliquerBotte(Joueur cible) {
        switch (this.effet) {
            case VEHICULE_PRIORITAIRE:
            case CITERNE_ESSENCE:
            case INCREVABLE:
            case AS_DU_VOLANT:
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