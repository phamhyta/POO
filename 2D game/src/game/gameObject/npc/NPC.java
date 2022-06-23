package game.gameObject.npc;

import game.gameObject.Entity;
import game.graphics.SpriteSheet;
import game.math.BoundingBox;
import game.math.Vector2f;
import game.states.GameStateManager;
import game.util.Camera;
import game.util.KeyHandler;
import game.util.MouseHandler;

import java.awt.*;

public class NPC extends Entity {
    protected BoundingBox sense;
    protected int r_sense;
    protected int xOffset;
    protected int yOffset;
    protected Graphics2D g2;
    public NPC(Vector2f origin, int size) {
        super(origin, size);

        xOffset = size / 4;
        yOffset = size / 4;
        r_sense = 30;
        bounds.setWidth(42);
        bounds.setHeight(20);
        bounds.setXOffset(16);
        bounds.setYOffset(40);

        sense = new BoundingBox(new Vector2f(origin.x + size / 2 - r_sense / 2, origin.y + size / 2 - r_sense / 2), r_sense);

    }

    public void setG2(Graphics2D g2) { this.g2 = g2; }
    public Graphics2D getG2() { return g2; }

    public void update(double time){

    }


    public void input(MouseHandler mouse, KeyHandler key) {

    }
}
