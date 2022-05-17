package nc.unc.gl.borne.gui.Component;

import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;

import nc.unc.gl.borne.gui.PlateauCorrectif;

public class DepotJoueur extends Div implements DropTarget<Card>{

    public DepotJoueur(Boolean isActive){
        if(isActive){
            this.setActive(isActive);
            this.setDropEffect(DropEffect.MOVE);
            this.addClassName("depot_joueur");
        }
        
    }
}
