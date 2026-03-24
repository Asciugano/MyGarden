package com.asciugano.game.UI;

import com.asciugano.engine.UIManager.UIEntity;
import com.asciugano.engine.UIManager.UITexture;
import com.asciugano.engine.handlers.mouse.MouseHandler;
import com.asciugano.engine.terrains.Terrain;
import com.asciugano.game.entity.tiles.Tile;
import org.joml.Vector2f;
import org.joml.Vector3f;

public class TileSelector extends UIEntity {
  private Tile selectedTile;

  public TileSelector(UITexture ui, Vector3f color) {
    super(ui, color, new Vector2f(1, 1));
  }

  private void onClick() {
  }

  public void update(float dt, Tile newTile) {
    if (newTile != null) {
      Vector3f tilePos = new Vector3f(0, 0, 0);
      this.position = new Vector2f(tilePos.x, tilePos.z);
      selectedTile = newTile;
    } else if (selectedTile != null) {
      if (MouseHandler.LEFT_PRESSED) {
        onClick();
      }
    }
  }

  public Tile getSelectedTile() {
    return selectedTile;
  }

  public void setSelectedTile(Tile selectedTile) {
    this.selectedTile = selectedTile;
  }

  // public void setSelectedTile(Vector3f point) { this.selectedTile =
  // Terrain.getTileFromWorld(point.x, point.z); }
}
