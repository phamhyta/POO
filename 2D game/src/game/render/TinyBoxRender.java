package game.render;


import game.gameObject.monster.TinyBox;
import game.graphics.SpriteSheet;
import game.util.Camera;

import java.awt.*;

public class TinyBoxRender extends EntityRender{
    private TinyBox tiny;
    public TinyBoxRender(Camera camera,TinyBox tiny, SpriteSheet spriteSheet) {
        super(camera,tiny, spriteSheet);
        this.tiny= tiny;

        ATTACK = 0;
        IDLE = 0;
        FALLEN = 1;
        UP = 1;
        DOWN = 1;
        LEFT = 1;
        RIGHT = 1;

        ani.setNumFrames(3, 0);
        ani.setNumFrames(5, 1);

        currentAnimation = IDLE;
    }

    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics2D g) {
        if(camera.getBounds().collides(tiny.getBounds())) {

            if(tiny.useRight && tiny.isLeft()) {
                g.drawImage(ani.getImage().image, (int) (tiny.getPos().getWorldVar().x) + tiny.getSize(), (int) (tiny.getPos().getWorldVar().y), -tiny.getSize(), tiny.getSize(), null);
            } else {
                g.drawImage(ani.getImage().image, (int) (tiny.getPos().getWorldVar().x), (int) (tiny.getPos().getWorldVar().y), tiny.getSize(), tiny.getSize(), null);
            }

            // Health Bar
            g.setColor(Color.red);
            g.fillRect((int) (tiny.getPos().getWorldVar().x + tiny.getBounds().getXOffset()), (int) (tiny.getPos().getWorldVar().y - 5), 24, 5);

            g.setColor(Color.green);
            g.fillRect((int) (tiny.getPos().getWorldVar().x +tiny.getBounds().getXOffset()), (int) (tiny.getPos().getWorldVar().y - 5), (int) (24 * tiny.getHealthPercent()), 5);

        }
    }
}
