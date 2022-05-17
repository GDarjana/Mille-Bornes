package nc.unc.gl.borne.gui.Component;

import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;

public class Defausse extends Div implements DropTarget<Card> {

    public Defausse() {
        this.setActive(true);
        this.setDropEffect(DropEffect.MOVE);
        this.addClassNames("defausse");
    }    
}
