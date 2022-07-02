package game.gameObject.enemy;

import game.math.Vector2f;

public class Minataur extends Enemy {
    public Minataur(Vector2f origin, int size) {
        super(origin, size);
        xOffset = size / 4;
        yOffset = size / 4;
        maxHealth= 200;
        health= 200;
        EXP =30;
        damage = 30;
        acc = 1f;
        deacc = 2f;
        maxSpeed = 2f;
        r_sense = 700;
        r_attackrange = 32;
        coin =10;

        hasIdle = true;
        useRight = true;
        right = true;
    }
}
