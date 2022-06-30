package game.gameObject.enemy;

import game.gameObject.Player;
import game.graphics.Animation;
import game.math.BoundingBox;
import game.math.Vector2f;

public class Wizard_BOSS extends Enemy {

    public Wizard_BOSS (Vector2f origin, int size) {
        super(origin, size);
        xOffset = size / 4;
        yOffset = size / 4;
        maxHealth= 200;
        health= 200;
        EXP =30;
        damage = 30;
        acc = 1f;
        deacc = 2f;
        maxSpeed = 0;
        r_sense = 100000;
        r_attackrange = 32;
        coin =10;

        hasIdle = true;
        useRight = true;
        right = true;

    }
    public void addForce(float a, boolean vertical) {
//        if(!vertical) {dx -= a;}
//        else {dy -= a;}
    }



}
