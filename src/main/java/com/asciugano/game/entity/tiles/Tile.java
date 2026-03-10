package com.asciugano.game.terrain.tiles;

import com.asciugano.game.Entity;

public class Tile extends Entity {
    private int gridX, gridY;

    public Tile(int gridX, int gridY) {
        this.gridX = gridX;
        this.gridY = gridY;
    }

    public int getGridX() { return gridX; }

    public void setGridX(int gridX) { this.gridX = gridX; }

    public int getGridY() { return gridY; }

    public void setGridY(int gridY) { this.gridY = gridY; }
}
