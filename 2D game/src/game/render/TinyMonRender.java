package game.render;

import game.gameObject.enemy.TinyMon;
import game.graphics.SpriteSheet;
import game.util.Camera;

import java.awt.*;

public class TinyMonRender extends EntityRender{
    private TinyMon tiny;
    public TinyMonRender(TinyMon tiny, SpriteSheet spriteSheet) {
        super(tiny, spriteSheet);
        this.tiny = tiny;

        ATTACK_DOWN = 2;
        ATTACK_UP = 3;
        ATTACK_LEFT = 1;
        ATTACK_RIGHT = 0;
        SKILL_UP=0;
        SKILL_DOWN=0;
        SKILL_LEFT=0;
        SKILL_RIGHT=0;
        FALLEN = 0;
        UP = 3;
        DOWN = 2;
        LEFT = 1;
        RIGHT = 0;

        ani.setNumFrames(3, 0);
        currentAnimation = 0;
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);

        g.setColor(Color.red);
        g.fillRect((int) (tiny.getPos().getWorldVar().x + 20), (int) (tiny.getPos().getWorldVar().y ), 24, 5);

        g.setColor(Color.green);
        g.fillRect((int) (tiny.getPos().getWorldVar().x +20), (int) (tiny.getPos().getWorldVar().y ), (int) (24 * tiny.getHealthPercent()), 5);

    }
}
