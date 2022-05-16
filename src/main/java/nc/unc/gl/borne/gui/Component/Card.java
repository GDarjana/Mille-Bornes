package nc.unc.gl.borne.gui.Component;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.dnd.EffectAllowed;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;

import nc.unc.gl.borne.Metier.Carte.Carte;

public class Card extends Div implements DragSource<Card> {
    private Carte carte;
    private Image image = new Image();

    public Card(Carte carte){
        this.carte = carte;
        this.setDraggable(true);
        this.setDragData(carte);
        this.image.setSrc(carte.getPathImage());
        this.image.setWidth(117, Unit.PIXELS);
        this.image.setHeight(200, Unit.PIXELS);
        this.add(image);
        this.setEffectAllowed(EffectAllowed.MOVE);
        this.addClassName("div_carte_joueur");
    }

    public Image getImage(){
        return image;
    }

    public Carte getCarte(){
        return carte;
    }

}

