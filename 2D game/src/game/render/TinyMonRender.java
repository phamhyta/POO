package game.render;

import game.gameObject.enemy.TinyMon;
import game.graphics.SpriteSheet;
import game.util.Camera;

import java.awt.*;

public class TinyMonRender extends EntityRender{
    private TinyMon tiny;
    public TinyMonRender(Camera camera, TinyMon tiny, SpriteSheet spriteSheet) {
        super(camera,tiny, spriteSheet);
        this.tiny = tiny;
        ATTACK = 0;
        FALLEN = 0;
        UP = 3;
        DOWN = 2;
        LEFT = 1;
        RIGHT = 0;

        ani.setNumFrames(3, 0);
        currentAnimation = 0;
    }

    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.setColor(Color.red);
        g.fillRect((int) (tiny.getPos().getWorldVar().x + tiny.getBounds().getXOffset()), (int) (tiny.getPos().getWorldVar().y - 5), 24, 5);

        g.setColor(Color.green);
        g.fillRect((int) (tiny.getPos().getWorldVar().x +tiny.getBounds().getXOffset()), (int) (tiny.getPos().getWorldVar().y - 5), (int) (24 * tiny.getHealthPercent()), 5);

    }
}
