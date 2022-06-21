package game.render;


<<<<<<< HEAD
<<<<<<< HEAD
import game.gameObject.monster.TinyBox;
=======
import game.gameObject.enemy.TinyBox;
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
import game.gameObject.enemy.TinyBox;
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
import game.graphics.SpriteSheet;
import game.util.Camera;

import java.awt.*;

public class TinyBoxRender extends EntityRender{
    private TinyBox tiny;
    public TinyBoxRender(Camera camera,TinyBox tiny, SpriteSheet spriteSheet) {
        super(camera,tiny, spriteSheet);
        this.tiny= tiny;

<<<<<<< HEAD
<<<<<<< HEAD
        ATTACK = 0;
=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        ATTACK_DOWN = 1;
        ATTACK_UP = 1;
        ATTACK_LEFT = 1;
        ATTACK_RIGHT = 1;
        SKILL_UP=1;
        SKILL_DOWN=1;
        SKILL_LEFT=1;
        SKILL_RIGHT=1;
<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        IDLE = 0;
        FALLEN = 1;
        UP = 1;
        DOWN = 1;
        LEFT = 1;
        RIGHT = 1;

        ani.setNumFrames(3, 0);
        ani.setNumFrames(5, 1);

        currentAnimation = IDLE;
<<<<<<< HEAD
<<<<<<< HEAD
    }

    public void update() {
        super.update();
=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6

        ani.setNumFrames(3, 0);
        ani.setNumFrames(5, 1);
        currentAnimation = IDLE;

<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
    }

    @Override
    public void render(Graphics2D g) {
        if(camera.getBounds().collides(tiny.getBounds())) {
<<<<<<< HEAD
<<<<<<< HEAD

            if(tiny.useRight && tiny.isLeft()) {
                g.drawImage(ani.getImage().image, (int) (tiny.getPos().getWorldVar().x) + tiny.getSize(), (int) (tiny.getPos().getWorldVar().y), -tiny.getSize(), tiny.getSize(), null);
=======
            if(tiny.useRight && tiny.isLeft()) {
                g.drawImage(ani.getImage().image, (int) (tiny.getPos().getWorldVar().x) + tiny.getSize(), (int) (tiny.getPos().getWorldVar().y ), -tiny.getSize(), tiny.getSize(), null);
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
            if(tiny.useRight && tiny.isLeft()) {
                g.drawImage(ani.getImage().image, (int) (tiny.getPos().getWorldVar().x) + tiny.getSize(), (int) (tiny.getPos().getWorldVar().y ), -tiny.getSize(), tiny.getSize(), null);
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
            } else {
                g.drawImage(ani.getImage().image, (int) (tiny.getPos().getWorldVar().x), (int) (tiny.getPos().getWorldVar().y), tiny.getSize(), tiny.getSize(), null);
            }

            // Health Bar
            g.setColor(Color.red);
<<<<<<< HEAD
<<<<<<< HEAD
            g.fillRect((int) (tiny.getPos().getWorldVar().x + tiny.getBounds().getXOffset()), (int) (tiny.getPos().getWorldVar().y - 5), 24, 5);

            g.setColor(Color.green);
            g.fillRect((int) (tiny.getPos().getWorldVar().x +tiny.getBounds().getXOffset()), (int) (tiny.getPos().getWorldVar().y - 5), (int) (24 * tiny.getHealthPercent()), 5);
=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
            g.fillRect((int) (tiny.getPos().getWorldVar().x + 20), (int) (tiny.getPos().getWorldVar().y ), 24, 5);

            g.setColor(Color.green);
            g.fillRect((int) (tiny.getPos().getWorldVar().x + 20), (int) (tiny.getPos().getWorldVar().y ), (int) (24 * tiny.getHealthPercent()), 5);
<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6

        }
    }
}
