package nc.unc.gl.borne.gui;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import nc.unc.gl.borne.Metier.Carte.Carte;
import nc.unc.gl.borne.Metier.Joueur.Joueur;
import nc.unc.gl.borne.Metier.Partie.Observer;
import nc.unc.gl.borne.Metier.Partie.Partie;
import nc.unc.gl.borne.Metier.Pile.Pile;
import nc.unc.gl.borne.Metier.Pioche.Pioche;

@Route("plateau")
@Tag("borne-main")
@StyleSheet("frontend/login-rich-content.css")
public class PlateauCorrectif extends HtmlContainer implements Observer, HasUrlParameter<String> {
    private Div piocheDiv;
    private Button piocherButton;
    private HorizontalLayout cartesJoueur;
    private Image imagePioche = new Image("/cartes/back.png", "Pioche");

    private static Partie partie = new Partie();
    private final UI ui;
    private Joueur joueur;

    public PlateauCorrectif() {
        piocheDiv = new Div();
        piocheDiv.addClassName("pioche");

        piocherButton = new Button("Piocher", event -> {
            Pioche.piocher(joueur);
            afficherCartes();
        });
        piocherButton.setDisableOnClick(true);
        piocherButton.setEnabled(false);

        cartesJoueur = new HorizontalLayout();
        cartesJoueur.addClassName("footer");

        this.ui = UI.getCurrent();

        this.add(piocheDiv);
        this.add(piocherButton);
        this.add(imagePioche);
        this.add(cartesJoueur);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        partie.addObserveur(this);
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        partie.removeObserveur(this);
    }

    @Override
    public void update(Partie partie) {
        if (joueur.getIsMyTurn()) {
            piocherButton.setEnabled(true);
        }

        System.out.println(joueur.getNom() + " a pioché");
        ui.access(() -> this.add(joueur.getNom() + " a pioché"));

    }

    @Override
    public void setParameter(BeforeEvent event, String nomNouveauJoueur) {
        joueur = new Joueur(nomNouveauJoueur);
        partie.addJoueur(joueur);
        partie.distribuerToAllPlayers();
        this.afficherCartes();
    }

    /**
     * Affiche les cartes
     */
    public void afficherCartes() {
        System.out.println(joueur.getDeckJoueur().getCartes().size());
        for (Image img_carte : this.getListeImages()) {
            cartesJoueur.add(img_carte);
        }
    }

    /**
     * Retourne la liste des images
     * 
     * @return
     */
    private List<Image> getListeImages() {
        List<Image> listeImages = new ArrayList<Image>();
        for (Carte carte : joueur.getDeckJoueur().getCartes()) {
            Image image = new Image(carte.getPathImage(), carte.getEffet());
            // Resize les images

            listeImages.add(image);
        }
        return listeImages;
    }

    public void afficherMesPiles() {
        for (Deck deck : joueur.getListePiles().getPileBataille().getDeck()) {

        }
    }

    public void afficherOthersPlayers() {
        for (Joueur joueur : partie.getListeJoueurs().filter(j -> joueur != joueur)) {

        }
    }
}
