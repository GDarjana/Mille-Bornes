package nc.unc.gl.borne;

import java.util.*;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

import nc.unc.gl.borne.Carte.Carte;
import nc.unc.gl.borne.Joueur.Joueur;
import nc.unc.gl.borne.Pioche.Pioche;


@Route("plateau")
@StyleSheet("frontend/login-rich-content.css")
public class Plateau extends HorizontalLayout {
    public Plateau(){

        Pioche pioche = new Pioche();
        pioche.initialiserPioche();
        
        Div piocheDiv = new Div();
        Image imgPioche = new Image("/cartes/back.png", "pioche");
        piocheDiv.addClassName("pioche");
        piocheDiv.add(imgPioche);

        Joueur joueur = new Joueur("Jean");
        for(int i = 0; i < 4 ; i++ ){
            joueur.getDeckJoueur().ajouterCarte(pioche.getPioche().pop());
        }

        List<Image> list_images = new ArrayList<>(); 
        for(Carte carte : joueur.getDeckJoueur().getCartes()){
            list_images.add(new Image("/cartes/"+carte.getPathImage(),"carte"));
        }
        
        
        Div cartes = new Div();
        cartes.addClassName("footer");
        for(Image img_carte : list_images){
            cartes.add(img_carte);
        }

        Button button = new Button("Piocher");
        button.addClickListener(clickEvent -> {
            Carte carte_pioche = pioche.getPioche().pop();
            joueur.getDeckJoueur().ajouterCarte(carte_pioche);
            cartes.add(new Image("/cartes/"+carte_pioche.getPathImage(), "carte")); 
        });

        add(piocheDiv);
        add(button);
        add(cartes);
    }
}
