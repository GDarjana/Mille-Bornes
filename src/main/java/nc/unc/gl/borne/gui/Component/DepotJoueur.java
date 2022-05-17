package nc.unc.gl.borne.gui.Component;

import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;

import nc.unc.gl.borne.Metier.Joueur.Joueur;

public class DepotJoueur extends Div implements DropTarget<Card> {
    private Joueur joueur;

    public DepotJoueur(Boolean isActive, Joueur joueur) {
        this.joueur = joueur;
        if (isActive) {
            this.setActive(isActive);
            this.setDropEffect(DropEffect.MOVE);
        }

    }

    public Joueur getJoueur(){
        return joueur;
    }
}
