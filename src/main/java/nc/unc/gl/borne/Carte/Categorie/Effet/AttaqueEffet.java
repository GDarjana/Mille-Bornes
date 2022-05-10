package nc.unc.gl.borne.Carte.Categorie.Effet;

public enum AttaqueEffet {
    FEU_ROUGE("Mettez un feu rouge à votre adversaire", "attaque_feu.jpeg"),
    LIMITE_VITESSE("Avance à deux à l'heure le bowrdel", "attaque_vitesse.jpeg"),
    PANNE_ESSENCE("Yossi plus d'essence monf ?", "attaque_essence.jpeg"),
    CREVAISON("Crevez le pneu d'un adversaire oklm", "attaque_feu.jpeg"),
    ACCIDENT("L'adversaire a trop bu et se prend un poteau", "attaque_accident.jpeg");

    private final String pathToImage;
    private final String description;

    /**
     * Constructeur
     * 
     * @param description
     * @param pathToImage
     */
    AttaqueEffet(String description, String pathToImage) {
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
