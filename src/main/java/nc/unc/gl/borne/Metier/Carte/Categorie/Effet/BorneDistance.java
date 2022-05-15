package nc.unc.gl.borne.Metier.Carte.Categorie.Effet;

public enum BorneDistance {
    VINGT_CINQ("25", "borne_25.jpeg"),
    CINQUANTE("50", "borne_50.jpeg"),
    SOIXANTE_QUINZE("75", "borne_75.jpeg"),
    CENT("100", "borne_100.jpeg"),
    DEUX_CENTS("200", "borne_200.jpeg");

    private final String pathToImage;
    private final String description;

    /**
     * Constructeur
     * 
     * @param description
     * @param pathToImage
     */
    BorneDistance(String description, String pathToImage) {
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
