package game.gameObject.monster;

import game.util.Camera;
import game.math.Vector2f;

public class TinyMon extends Enemy {

    public TinyMon(Camera cam, Vector2f origin, int size) {
        super(cam, origin, size);
        xOffset = size / 4;
        yOffset = size / 4;
        damage = 10;
        acc = 1f;
        deacc = 2f;
        maxSpeed = 2f;
        r_sense = 550;
        r_attackrange = 32;
        r_enemyArea= 500;
        EXP=3;
        coin = 5;

    }
}
