package nc.unc.gl.borne.Carte.Categorie.Type;

import nc.unc.gl.borne.Carte.CarteInterface;
import nc.unc.gl.borne.Carte.Categorie.Effet.AttaqueEffet;
import nc.unc.gl.borne.Joueur.Joueur;

public class Attaque implements CarteInterface {
    private AttaqueEffet effet;
    private String type = "ATTAQUE";

    /**
     * Constructeur
     * 
     * @param effet
     */
    public Attaque(AttaqueEffet effet) {
        this.effet = effet;
    }

    /**
     * Permet au joueur de poser sa carte d'attaque contre un advesaire
     * 
     * @param cible
     */
    public String poserCarte(Joueur cible) {
        appliquerEffet(cible);
        return "CARTE ATTAQUE POSÉE";
    }

    /**
     * Appliquer l'effet de la carte sur la cible
     * 
     * @param cible
     */
    public void appliquerEffet(Joueur cible) {
        switch (this.effet) {
            case FEU_ROUGE:
            case LIMITE_VITESSE:
            case CREVAISON:
            case ACCIDENT:
            case PANNE_ESSENCE:
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
