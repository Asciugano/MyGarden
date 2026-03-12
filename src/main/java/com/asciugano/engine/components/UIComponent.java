package com.asciugano.engine.components;

import com.asciugano.engine.UIManager.UITexture;
import org.joml.Vector3f;

public class UIComponent implements Component {
    private UITexture ui;
    private Vector3f color;

    public UIComponent(UITexture ui, Vector3f color) { this.ui = ui; }

    public UITexture getUi() { return ui; }

    public Vector3f getColor() { return color; }
}
