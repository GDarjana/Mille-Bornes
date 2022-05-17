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
@PageTitle("Menu")
public class MenuViewCorrectif extends VerticalLayout {
    private final TextField pseudo;
    private final Div divMenuCotainer = new Div();
    private final Button boutonJouer;
    private final Image fond = new Image("Images/MilleBorne.PNG", "Titre");
    private static Partie partie = Partie.getInstance();

    public MenuViewCorrectif() {
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
                rejoindrePartie();
            } else {
                Notification.show("Vous devez entrer un pseudo");
            }
        });
        boutonJouer.setText("Matchmaking...");

        divMenuCotainer.add(pseudo, boutonJouer);
        this.add(fond);
        this.add(divMenuCotainer);
    }

    /**
     * Renvoi la vue du plateau
     */
    public void rejoindrePartie() {
        if(!partie.getListeAttente().contains(pseudo.getValue())){
            partie.addJoueurAttente(pseudo.getValue());
            Notification.show("En attente de joueur");
        }

        while(partie.getListeAttente().size() < 2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        this.getUI().ifPresent(ui -> ui.navigate(PlateauCorrectif.class, pseudo.getValue()));
        
    }
}
