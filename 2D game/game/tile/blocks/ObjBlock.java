package game.tile.blocks;

import game.graphics.Sprite;
import game.math.BoundingBox;
import game.math.Vector2f;

import java.awt.*;

public class ObjBlock extends Block {
    
    public ObjBlock(Sprite sprite, Vector2f pos, int w, int h) {
        super(sprite, pos, w, h);
    }

    public boolean update(BoundingBox p) {
        return true;
    }

    public Sprite getImage() {
        return sprite;
    }
    
    public boolean isInside(BoundingBox p) {
        return false;
    }

    public void render(Graphics2D g){
        super.render(g);
    }

}
