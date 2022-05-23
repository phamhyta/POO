package game.gameObject;

import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.util.Camera;
import game.util.KeyHandler;
import game.util.MouseHandler;

import java.awt.*;

public class NPC extends Entity{
    public NPC(Camera cam, SpriteSheet spriteSheet, Vector2f orgin, int size){
        super(spriteSheet, orgin, size);

    }

    public void render(Graphics2D g) {
        g.drawImage(ani.getImage().image, (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
    }

    public void update(double time){

    }

    public void input(MouseHandler mouse, KeyHandler key) {

    }
}
