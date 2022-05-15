package nc.unc.gl.borne.Metier.Carte.Categorie.Type;

import nc.unc.gl.borne.Metier.Carte.CarteInterface;
import nc.unc.gl.borne.Metier.Carte.Categorie.Effet.AttaqueEffet;
import nc.unc.gl.borne.Metier.Joueur.Joueur;

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
     * Appliquer l'effet de la carte sur la cible
     * 
     * @param cible
     */
    @Override
    public void appliquerEffet(Joueur cible) {
        cible.setPeutAvancer(false);
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
