package game.game_object.enemy;

import game.math.Vector2f;

public class TinyMon extends Enemy {

    public TinyMon(Vector2f origin, int size) {
        super( origin, size);
        xOffset = size / 4;
        yOffset = size / 4;
        maxHealth= 100;
        health= 100;
        damage = 20;
        acc = 1f;
        deacc = 2f;
        maxSpeed = 2f;
        r_sense = 550;
        r_attackrange = 32;
        r_enemyArea= 500;
        EXP=20;
        coin = 5;

    }
}
