package com.asciugano.engine.entities;

import com.asciugano.engine.components.Component;
import com.asciugano.engine.components.ComponentType;
import com.asciugano.engine.models.TexturedModel;

public class MeshComponent extends Component {
    private TexturedModel model;


    public MeshComponent() {
        super(new ComponentType("MeshComponent", true));
    }

    public void setModel(TexturedModel model) { this.model = model; }

    public TexturedModel getModel() { return model; }
}
