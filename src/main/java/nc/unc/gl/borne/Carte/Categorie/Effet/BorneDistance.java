package nc.unc.gl.borne.Carte.Categorie.Effet;

public enum BorneDistance {
    VINGT_CINQ("Ajoutez 25 à votre compteur", "borne_25.jpeg"),
    CINQUANTE("Ajoutez 50 à votre compteur", "borne_50.jpeg"),
    SOIXANTE_QUINZE("Ajoutez 75 à votre compteur", "borne_75.jpeg"),
    CENT("Ajoutez 100 à votre compteur", "borne_100.jpeg"),
    DEUX_CENTS("Ajoutez 200 à votre compteur", "borne_200.jpeg");

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
