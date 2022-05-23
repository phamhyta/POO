package game.tile;

import game.math.AABB;

import java.awt.Graphics2D;

public abstract class TileMap {

    public abstract void render(Graphics2D g, AABB cam);
}
