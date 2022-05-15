package nc.unc.gl.borne.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import nc.unc.gl.borne.Metier.ObserverService;
import nc.unc.gl.borne.Metier.Joueur.Joueur;
import nc.unc.gl.borne.Metier.Joueur.JoueurService;

import com.vaadin.flow.component.UI;

@Route(value = "")
@PageTitle("Menu")
public class MenuView extends VerticalLayout {
    private final TextField pseudo;

    private ObserverService observer;
    private Joueur joueur;

    public MenuView(){
        addClassName("-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);


        Div menu = new Div();
        pseudo = new TextField();
        pseudo.setRequired(true);
        pseudo.setLabel("Entrer votre pseudo");
        Button play = new Button();
        play.addClickListener(buttonClickEvent -> jouer());
        play.setText("Jouer");
        menu.add(pseudo,play);
        Image titre = new Image("Images/MilleBorne.PNG","Titre");
        add(titre);
        add(menu);
    }
    private void jouer(){
        if(pseudo.getOptionalValue().isPresent()){
            String nom = pseudo.getValue();
            joueur = new Joueur(nom);

            observer = new ObserverService(joueur);

            while (observer.getListJoueurs().size() < 2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            observer.lancerPartie();
            JoueurService.setNomJoueur(nom);
            observer.getCurrent().navigate(Plateau.class);
            }
            else{
                Notification.show("Vous devez entrer un pseudo");
            }
        }

}