package nc.unc.gl.borne.Metier;

import com.vaadin.flow.component.UI;

import nc.unc.gl.borne.Metier.Pioche.Pioche;
import nc.unc.gl.borne.Metier.Joueur.Joueur;

import java.util.*;

public class ObserverService {
    private UI ui = new UI();
    public static Pioche pioche = new Pioche();
    private static List<Joueur> listeJoueur = new ArrayList<>();

    private static boolean check = false;

    public ObserverService(Joueur joueur){
        listeJoueur.add(joueur);
    }

    public static Pioche getPioche(){
        return pioche;
    }

    public UI getCurrent() {
        return ui.getCurrent();
    }

    public static Joueur getJoueur(String nom) {
        return listeJoueur.stream()
        .filter(Joueur -> nom.equals(Joueur.getNom()))
        .findAny()
        .orElse(null);
    }

    public static Joueur getJoueur2(String nom) {
        String nouveauNom;

        if (listeJoueur.get(0).getNom() == nom) {
            nouveauNom = listeJoueur.get(1).getNom();
        }
        else{
            nouveauNom = listeJoueur.get(0).getNom();
        }

        return listeJoueur.stream()
        .filter(Joueur -> nouveauNom.equals(Joueur.getNom()))
        .findAny()
        .orElse(null);
    }

    public static void lancerPartie(){
        if (check)
            return;
        pioche.initialiserPioche();
        pioche.distribuerAll(listeJoueur);
        check = true;
    }

    public List<Joueur> getListJoueurs(){
        return listeJoueur;
    }
    
}
