package game.tile.blocks;



import game.graphics.Sprite;
import game.math.AABB;
import game.math.Vector2f;

import java.awt.*;

public class NormBlock extends Block {

    public NormBlock(Sprite sprite, Vector2f pos, int w, int h) {
        super(sprite, pos, w, h);
    }

    public boolean update(AABB p) {
        return false;
    }

    public Sprite getImage() { return sprite; }

    public boolean isInside(AABB p) {
        return false;
    }

    public void render(Graphics2D g){
        super.render(g);
    }

}
