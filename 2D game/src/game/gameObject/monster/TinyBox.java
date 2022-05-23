package game.gameObject.monster;

import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.util.Camera;

import java.awt.*;

public class TinyBox extends Enemy {
    public TinyBox(Camera cam, SpriteSheet spriteSheet, Vector2f origin, int size) {
        super(cam, spriteSheet, origin, size);
        xOffset = size / 4;
        yOffset = size / 4;

        damage = 10;
        acc = 1f;
        deacc = 2f;
        maxSpeed = 2f;
        r_sense = 350;
        r_attackrange = 32;
        coin =10;

        ATTACK = 0;
        IDLE = 0;
        FALLEN = 1;
        UP = 1;
        DOWN = 1;
        LEFT = 1;
        RIGHT = 1;

        hasIdle = true;
        useRight = true;

        ani.setNumFrames(3, 0);
        ani.setNumFrames(5, 1);

        currentAnimation = IDLE;
        right = true;
    }
    @Override
    public void render(Graphics2D g) {
        if(cam.getBounds().collides(this.bounds)) {

            //if(isInvincible)
            if(useRight && left) {
                g.drawImage(ani.getImage().image, (int) (pos.getWorldVar().x) + size, (int) (pos.getWorldVar().y), -size, size, null);
            } else {
                g.drawImage(ani.getImage().image, (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
            }


            // Health Bar UI
            g.setColor(Color.red);
            g.fillRect((int) (pos.getWorldVar().x + bounds.getXOffset()), (int) (pos.getWorldVar().y - 5), 24, 5);

            g.setColor(Color.green);
            g.fillRect((int) (pos.getWorldVar().x + bounds.getXOffset()), (int) (pos.getWorldVar().y - 5), (int) (24 * healthpercent), 5);

        }
    }

}
