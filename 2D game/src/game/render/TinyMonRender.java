package game.render;

import game.gameObject.monster.Enemy;
import game.graphics.SpriteSheet;

import java.awt.*;

public class TinyMonRender extends EnemyRender{
    public TinyMonRender(Enemy enemy, SpriteSheet spriteSheet) {
        super(enemy, spriteSheet);
        ATTACK = 0;
        FALLEN = 0;
        UP = 3;
        DOWN = 2;
        LEFT = 0;
        RIGHT = 1;

        ani.setNumFrames(3, 0);
        currentAnimation = 0;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
    }
}
