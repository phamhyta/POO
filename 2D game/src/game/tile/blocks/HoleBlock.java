package game.tile.blocks;

import game.graphics.Sprite;
import game.math.AABB;
import game.math.Vector2f;

import java.awt.*;

public class HoleBlock extends Block {

    public HoleBlock(Sprite sprite, Vector2f pos, int w, int h) {
        super(sprite, pos, w, h);
    }

    public boolean update(AABB p) {
        return false;
    }

    public Sprite getImage() {
        return sprite;
    }

    public boolean isInside(AABB p) {

        if(p.getPos().x + p.getXOffset() < pos.x) return false;
        if(p.getPos().y + p.getYOffset() < pos.y) return false;
        if(w + pos.x < p.getWidth() + (p.getPos().x + p.getXOffset())) return false;
        if(h + pos.y < p.getHeight() + (p.getPos().y + p.getYOffset())) return false;
        
        return true;
    }

    public void render(Graphics2D g){
        super.render(g);
        
    }

}
