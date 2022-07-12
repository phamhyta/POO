package game.render;

import game.game_object.enemy.TinyMon;
import game.graphics.SpriteSheet;

import java.awt.*;

public class TinyMonRender extends EntityRender{
    private TinyMon tiny;
    public TinyMonRender(TinyMon tiny, SpriteSheet spriteSheet) {
        super(tiny, spriteSheet);
        this.tiny = tiny;

        ATTACK_DOWN = 1;
        ATTACK_UP = 1;
        ATTACK_LEFT = 1;
        ATTACK_RIGHT = 0;
        SKILL_UP=1;
        SKILL_DOWN=1;
        SKILL_LEFT=1;
        SKILL_RIGHT=0;
        IDLE = 0;
        FALLEN = 1;
        UP = 1;
        DOWN = 1;
        LEFT = 1;
        RIGHT = 0;




        ani.setNumFrames(8, 0);
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
