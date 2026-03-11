package com.asciugano.game.UI;

import com.asciugano.engine.UIManager.UIShader;
import com.asciugano.engine.UIManager.UITexture;
import com.asciugano.engine.components.ComponentUser;
import com.asciugano.engine.components.TransformationComponent;
import com.asciugano.engine.components.UIComponent;
import com.asciugano.engine.terrains.Terrain;
import com.asciugano.engine.utils.Color;
import com.asciugano.game.entity.tiles.Tile;
import org.joml.Vector3f;

public class TileSelector extends ComponentUser {
    private Tile selectedTile;

    public TileSelector(UITexture ui, Color color) {
        addComponent(new UIComponent(ui, color));
        addComponent(new TransformationComponent(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0), 1));
    }

    public void update(float dt, Tile newTile) {
        this.selectedTile = newTile;
    }

    public Tile getSelectedTile() { return selectedTile; }

    public void setSelectedTile(Tile selectedTile) { this.selectedTile = selectedTile; }

    public void setSelectedTile(Vector3f point) { this.selectedTile = Terrain.getTileFromWorld(point.x, point.z); }
}
