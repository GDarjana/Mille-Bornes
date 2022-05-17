package nc.unc.gl.borne.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import nc.unc.gl.borne.Metier.Partie.Partie;

@Route(value = "")
@PageTitle("Acceuil")
public class Acceuil extends VerticalLayout {
    private final TextField pseudo;
    private final Div divMenuCotainer = new Div();
    private final Button boutonJouer;
    private final Image fond = new Image("Images/MilleBorne.PNG", "Titre");
    private static Partie partie = Partie.getInstance();

    public Acceuil() {
        this.addClassName("-view");
        this.setSizeFull();
        this.setAlignItems(Alignment.CENTER);
        this.setJustifyContentMode(JustifyContentMode.CENTER);

        pseudo = new TextField();
        pseudo.setRequired(true);
        pseudo.setLabel("Entrer votre pseudo");

        boutonJouer = new Button();
        boutonJouer.addClickListener(buttonClickEvent -> {
            if (!this.pseudo.isEmpty()) {
                rechercherPartie();
            } else {
                Notification.show("Vous devez entrer un pseudo");
            }
        });
        boutonJouer.setText("Rechercher une partie");

        divMenuCotainer.add(pseudo, boutonJouer);
        this.add(fond);
        this.add(divMenuCotainer);
    }

    /**
     * Renvoi la vue du plateau
     */
    public void rechercherPartie() {
        if (!partie.getListeAttente().contains(pseudo.getValue())) {
            partie.addJoueurAttente(pseudo.getValue());
            System.out.println(pseudo.getValue() + " en attente");
            Notification.show("En attente de joueur");
            this.add(new TextField("Vous êtes en file d'attente"));

        }
        if (partie.getListeAttente().size() > 1) {
            this.getUI().ifPresent(ui -> ui.navigate(Plateau.class, pseudo.getValue()));
        }

    }
}
