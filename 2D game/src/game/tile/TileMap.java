package game.tile;

import game.math.BoundingBox;

import java.awt.Graphics2D;

public abstract class TileMap {

    public abstract void render(Graphics2D g, BoundingBox cam);
}
