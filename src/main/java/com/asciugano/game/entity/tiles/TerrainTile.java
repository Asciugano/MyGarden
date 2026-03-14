package com.asciugano.game.entity.tiles;

import com.asciugano.engine.models.ColoredModel;
import com.asciugano.engine.models.MeshBuilder;
import com.asciugano.engine.utils.Color;

public abstract class TerrainTile extends Tile {
    protected ColoredModel model;

    public TerrainTile(Tile tile) {
        super(tile.getGridX(), tile.getGridZ());
        MeshBuilder meshBuilder = new MeshBuilder();
        generateMeshVertices(meshBuilder);
        this.model = new ColoredModel(
                meshBuilder.getVertices(),
                meshBuilder.getNormals(),
                meshBuilder.getColors(),
                meshBuilder.getIndices()
        );
    }

    public ColoredModel getModel() { return model; }

    public abstract float getEdgeHeight();
    public abstract Color getEdgeColor();
    protected abstract void generateMeshVertices(MeshBuilder meshBuilder);
}
