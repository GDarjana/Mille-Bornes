package nc.unc.gl.borne.Metier;

import com.vaadin.flow.component.UI;

import nc.unc.gl.borne.Metier.Pioche.Pioche;
import nc.unc.gl.borne.Metier.Joueur.Joueur;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ObserverService {
    private UI ui = new UI();
    public static Pioche pioche = new Pioche();
    private final static Map<String, Joueur> sessions = new ConcurrentHashMap<>();

    private static boolean check = false;

    private Joueur joueur;

    public ObserverService(Joueur joueur){
        this.joueur = joueur;
        sessions.put(this.joueur.getNom(), this.joueur);
    }

    public static Pioche getPioche(){
        return pioche;
    }

    public UI getCurrentUI() {
        UI ui = UI.getCurrent();
        if (ui == null) {
            throw new IllegalStateException("UI instance is not available. "
                + "It means that you are calling this method "
                + "out of a normal workflow where it's always implicitly set. "
                + "That may happen if you call the method from the custom thread without "
                + "'UI::access' or from tests without proper initialization.");
        }
        return ui;
    }

    public UI getCurrent() {
        return ui.getCurrent();
    }

    public static Joueur getJoueur(String key) {
        return sessions.get(key);
    }

    public static Joueur getAutreJoueur(String key) {
        String newKey = "";
        Set<String> liste = sessions.keySet();
        Object[] res = liste.toArray();

        if (res[0] == key) {
            newKey = (String) res[1];
        }
        else{
            newKey = (String) res[0];
        }

        return sessions.get(newKey);
    }

    public static void lancerPartie(){
        if (check)
            return;
        pioche.initialiserPioche();
        Collection<Joueur> liste = sessions.values();
        Object[] res = liste.toArray();
        Joueur j1 = (Joueur) res[0];
        Joueur j2 = (Joueur) res[1];
        distribuer(pioche, j1, j2);
        check = true;
    }
    public static Map<String, Joueur> getAllSessions(){return sessions;}

    public static void distribuer(Pioche pioche, Joueur joueur1, Joueur joueur2){
        for (int i = 0; i < 6; i++) {
            joueur1.getDeckJoueur().ajouterCarte(pioche.getPioche().pop());
            joueur2.getDeckJoueur().ajouterCarte(pioche.getPioche().pop());
        }
    }
}