package game.gameObject.monster;

import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.util.Camera;

import java.awt.*;

public class TinyBox extends Enemy {
    public TinyBox(Camera cam, Vector2f origin, int size) {
        super(cam, origin, size);
        xOffset = size / 4;
        yOffset = size / 4;

        damage = 10;
        acc = 1f;
        deacc = 2f;
        maxSpeed = 2f;
        r_sense = 350;
        r_attackrange = 32;
        coin =10;
        hasIdle = true;
        useRight = true;

        right = true;
    }


}
