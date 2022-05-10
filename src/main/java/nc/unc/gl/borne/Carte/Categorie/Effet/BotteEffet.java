package nc.unc.gl.borne.Carte.Categorie.Effet;

public enum BotteEffet {
    VEHICULE_PRIORITAIRE("Immunise contre les attaque de limites de vitesse", "botte_vitesse.jpeg"),
    CITERNE_ESSENCE("Immunise contrel es attaques de panne d'essence", "botte_essence.jpeg"),
    INCREVABLE("Immunise contre les attaques de crevaison", "botte_crevaison.jpeg"),
    AS_DU_VOLANT("Immunise contre les attaque accident", "botte_accident.jpeg");

    private final String pathToImage;
    private final String description;

    /**
     * Constructeur
     * 
     * @param description
     * @param pathToImage
     */
    BotteEffet(String description, String pathToImage) {
        this.description = description;
        this.pathToImage = pathToImage;
    }

    /**
     * Renvoi l'url l'image
     * 
     * @return Le pathToImage
     */
    public String get_path_image() {
        return this.pathToImage;
    }

    /**
     * Renvoi la description de l'attaque
     * 
     * @return La description
     */
    public String get_description() {
        return this.description;
    }
}
