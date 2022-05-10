package nc.unc.gl.borne.Carte.Categorie.Effet;

public enum ParadeEffet {
    FEU_VERT("Vous pouvez mettre un feu vert", "parade_feu.jpeg"),
    LIMITE_VITESSE("Vous enlevez votre limitation de vitesse", "parade_vitesse.jpeg"),
    ESSENCE("Vous faites de le plein d'essence", "parade_essence.jpeg"),
    ROUE_DE_SECOURS("Vous trouvez une roue de secours au bord de la route", "parade_crevaison.jpeg"),
    REPARATIONS("Vous appelez GéGé pour réparer l'auto", "parade_accident.jpeg");

    private final String pathToImage;
    private final String description;

    /**
     * Constructeur
     * 
     * @param description
     * @param pathToImage
     */
    ParadeEffet(String description, String pathToImage) {
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
