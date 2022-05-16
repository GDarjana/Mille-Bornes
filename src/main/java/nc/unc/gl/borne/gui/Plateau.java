package nc.unc.gl.borne.gui;

import java.util.*;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import nc.unc.gl.borne.Metier.ObserverService;
import nc.unc.gl.borne.Metier.Carte.Carte;
import nc.unc.gl.borne.Metier.Joueur.Joueur;
import nc.unc.gl.borne.Metier.Joueur.JoueurService;
import nc.unc.gl.borne.Metier.Pioche.Pioche;


@StyleSheet("frontend/login-rich-content.css")
public class Plateau extends VerticalLayout {
    private Joueur joueur1;
    private Joueur joueur2;
    private Pioche pioche;
    private List<Image> liste_cartes = new ArrayList<>(); 

    public Plateau(){

        addClassName("-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        joueur1 = ObserverService.getJoueur(JoueurService.getNomJoueur());
        joueur2 = ObserverService.getJoueur2(JoueurService.getNomJoueur());
        pioche = ObserverService.getPioche();

        getCartesJoueur();

        HorizontalLayout cartes = new HorizontalLayout();
        cartes.addClassName("footer");
        for(Image img_carte : liste_cartes){
            cartes.add(img_carte);
        }
        
        Div piocheDiv = new Div();
        Image imgPioche = new Image("/cartes/back.png", "pioche");
        piocheDiv.addClassName("pioche");

        Button button = new Button(imgPioche);
        button.addClickListener(clickEvent -> {
            Carte carte_pioche = pioche.getPioche().pop();
            joueur1.getDeckJoueur().ajouterCarte(carte_pioche);
            Image img = new Image(carte_pioche.getPathImage(), "carte");
            img.setWidth(117, Unit.PIXELS);
            img.setHeight(200, Unit.PIXELS);
            cartes.add(img); 
        });
        
        piocheDiv.add(button);

        add(piocheDiv);
        add(cartes);
    }

    private void getCartesJoueur(){
        for(Carte carte : joueur1.getDeckJoueur().getCartes()){
            Image img = new Image(carte.getPathImage(),"carte");
            img.setWidth(117, Unit.PIXELS);
            img.setHeight(200, Unit.PIXELS);
            liste_cartes.add(img);
        }
    }
}
