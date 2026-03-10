package com.asciugano.game.terrain.tiles.components;

import com.asciugano.engine.components.Component;
import com.asciugano.engine.models.TexturedModel;
import com.asciugano.game.terrain.tiles.TileType;

public class TileComponent implements Component {
    private TileType tileType;
    private boolean canModify;
    private TexturedModel model;

    public TileComponent(TileType tileType, boolean canModify) {
        this.tileType = tileType;
        this.canModify = canModify;
    }

    public TileType getTileType() { return tileType; }

    public void setTileType(TileType tileType) { this.tileType = tileType; }

    public boolean isCanModify() { return canModify; }

    public void setCanModify(boolean canModify) { this.canModify = canModify; }
}
