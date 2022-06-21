package game.gameObject.npc;

import game.gameObject.Entity;
import game.graphics.SpriteSheet;
import game.math.Vector2f;

import game.util.Camera;
import game.util.KeyHandler;
import game.util.MouseHandler;


import java.awt.*;

public class NPC_1 extends Entity {

    public NPC_1(Camera cam, SpriteSheet spriteSheet, Vector2f orgin, int size){
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
