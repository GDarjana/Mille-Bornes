package nc.unc.gl.borne.gui;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import nc.unc.gl.borne.Metier.Carte.Carte;
import nc.unc.gl.borne.Metier.Joueur.Joueur;
import nc.unc.gl.borne.Metier.Partie.Observer;
import nc.unc.gl.borne.Metier.Partie.Partie;
import nc.unc.gl.borne.Metier.Pile.Pile;
import nc.unc.gl.borne.Metier.Pioche.Pioche;
import nc.unc.gl.borne.gui.Component.Card;
import nc.unc.gl.borne.gui.Component.Defausse;
import nc.unc.gl.borne.gui.Component.DepotJoueur;

@Route("plateau")
@Tag("borne-main")
@StyleSheet("frontend/plateau.css")
public class PlateauCorrectif extends VerticalLayout implements Observer, HasUrlParameter<String> {
    private Div piocheDiv;
    private Button piocherButton;
    private HorizontalLayout cartesJoueur;
    private Image imagePioche = new Image("/cartes/back.png", "Pioche");

    private static Partie partie = new Partie();
    private final UI ui;
    private Joueur joueur;
    private DepotJoueur depotJoueur;
    private Defausse defausse;

    public PlateauCorrectif() {
        addClassName("-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        
        Div piocheDiv = new Div();
        Image imgPioche = new Image("/cartes/back.png", "pioche");
        imgPioche.setWidth(117, Unit.PIXELS);
        imgPioche.setHeight(200, Unit.PIXELS);
        piocheDiv.addClassName("pioche");
        piocherButton = new Button(imgPioche);

        piocherButton.addClickListener(clickEvent -> {
            Pioche.piocher(joueur);
            partie.maj();
            afficherCartes();
        });

        cartesJoueur = new HorizontalLayout();
        cartesJoueur.addClassName("footer");

        defausse = new Defausse();
        defausse.addDropListener(e -> {
            e.getDragData().ifPresent(data -> {
                Carte carte = (Carte) data;
                joueur.poserMaCarte("DEFAUSSER", joueur, carte);
                afficherCartes();
            });
        });

        this.ui = UI.getCurrent();

        piocheDiv.add(piocherButton);

        this.add(cartesJoueur);
        this.add(defausse);
        this.add(piocheDiv);
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
        cartesJoueur.removeAll();
        System.out.println(joueur.getDeckJoueur().getCartes().size());
        for (Card card : this.getCards()) {
            cartesJoueur.add(card);
        }
    }

    private List<Card> getCards(){
        List<Card> listeCards = new ArrayList<Card>();
        for(Carte carte : joueur.getDeckJoueur().getCartes()){
            Card card = new Card(carte);
            listeCards.add(card);
        }
        return listeCards;
    }
}
