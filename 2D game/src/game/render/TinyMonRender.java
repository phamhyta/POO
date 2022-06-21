package game.render;

<<<<<<< HEAD
import game.gameObject.monster.Enemy;
import game.gameObject.monster.TinyBox;
import game.gameObject.monster.TinyMon;
=======
import game.gameObject.enemy.TinyMon;
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
import game.graphics.SpriteSheet;
import game.util.Camera;

import java.awt.*;

public class TinyMonRender extends EntityRender{
    private TinyMon tiny;
    public TinyMonRender(Camera camera, TinyMon tiny, SpriteSheet spriteSheet) {
        super(camera,tiny, spriteSheet);
        this.tiny = tiny;
<<<<<<< HEAD
        ATTACK = 0;
=======

        ATTACK_DOWN = 2;
        ATTACK_UP = 3;
        ATTACK_LEFT = 1;
        ATTACK_RIGHT = 0;
        SKILL_UP=0;
        SKILL_DOWN=0;
        SKILL_LEFT=0;
        SKILL_RIGHT=0;
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        FALLEN = 0;
        UP = 3;
        DOWN = 2;
        LEFT = 1;
        RIGHT = 0;

        ani.setNumFrames(3, 0);
        currentAnimation = 0;
    }

<<<<<<< HEAD
    public void update() {
        super.update();
    }

=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.setColor(Color.red);
<<<<<<< HEAD
        g.fillRect((int) (tiny.getPos().getWorldVar().x + tiny.getBounds().getXOffset()), (int) (tiny.getPos().getWorldVar().y - 5), 24, 5);

        g.setColor(Color.green);
        g.fillRect((int) (tiny.getPos().getWorldVar().x +tiny.getBounds().getXOffset()), (int) (tiny.getPos().getWorldVar().y - 5), (int) (24 * tiny.getHealthPercent()), 5);
=======
        g.fillRect((int) (tiny.getPos().getWorldVar().x + 20), (int) (tiny.getPos().getWorldVar().y ), 24, 5);

        g.setColor(Color.green);
        g.fillRect((int) (tiny.getPos().getWorldVar().x +20), (int) (tiny.getPos().getWorldVar().y ), (int) (24 * tiny.getHealthPercent()), 5);
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6

    }
}
