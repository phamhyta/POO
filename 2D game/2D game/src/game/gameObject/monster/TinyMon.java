package game.gameObject.monster;

import game.gameObject.Enemy;

import game.graphics.SpriteSheet;
import game.util.Camera;
import game.math.Vector2f;

public class TinyMon extends Enemy {

    public TinyMon(Camera cam, SpriteSheet spriteSheet, Vector2f origin, int size) {
        super(cam, spriteSheet, origin, size);
        xOffset = size / 4;
        yOffset = size / 4;

        damage = 10;
        acc = 1f;
        deacc = 2f;
        maxSpeed = 2f;
        r_sense = 550;
        r_attackrange = 32;
        r_enemyArea= 500;

        ATTACK = 0;
        FALLEN = 0;
        UP = 3;
        DOWN = 2;
        LEFT = 1;
        RIGHT = 0;
        EXP=3;

        coin = 5;


        ani.setNumFrames(3, 0);
//        ani.setNumFrames(5, 1);

        currentAnimation = 0;

    }

    }
