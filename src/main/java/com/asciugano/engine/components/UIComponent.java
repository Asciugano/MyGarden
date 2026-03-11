package com.asciugano.engine.components;

import com.asciugano.engine.UIManager.UITexture;
import com.asciugano.engine.utils.Color;

public class UIComponent implements Component {
    private UITexture ui;
    private Color color;

    public UIComponent(UITexture ui, Color color) { this.ui = ui; }

    public UITexture getUi() { return ui; }

    public Color getColor() { return color; }
}
