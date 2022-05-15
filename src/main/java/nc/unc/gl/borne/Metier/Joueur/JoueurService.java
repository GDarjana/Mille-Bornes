package nc.unc.gl.borne.Metier.Joueur;

public class JoueurService {
    public static String nomJoueur;

    public static void setNomJoueur(String nom){
        nomJoueur = nom;
    }
    public static String getNomJoueur(){
        return nomJoueur;
    }
}
