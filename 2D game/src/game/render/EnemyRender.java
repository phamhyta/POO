package game.render;

import game.gameObject.Entity;
import game.gameObject.monster.Enemy;
import game.graphics.SpriteSheet;

import java.awt.*;

public class EnemyRender extends EntityRender{
    protected Enemy enemy;

    public EnemyRender(Enemy enemy, SpriteSheet spriteSheet) {
        super(enemy, spriteSheet);
        this.enemy = enemy;
    }

    public void update(){
        super.update();
    }

    public void render(Graphics2D g) {
        if(enemy.cam.getBounds().collides(enemy.getBounds())) {
            g.drawImage(ani.getImage().image, (int) (enemy.getPos().getWorldVar().x) + enemy.getSize(), (int) (enemy.getPos().getWorldVar().y), -enemy.getSize(), enemy.getSize(), null);
            // Health Bar UI
            g.setColor(Color.red);
            g.fillRect((int) (enemy.getPos().getWorldVar().x + enemy.getBounds().getXOffset()), (int) (enemy.getPos().getWorldVar().y - 5), 24, 5);

            g.setColor(Color.green);
            g.fillRect((int) (enemy.getPos().getWorldVar().x +enemy.getBounds().getXOffset()), (int) (enemy.getPos().getWorldVar().y - 5), (int) (24 * enemy.getHealthPercent()), 5);

        }
    }
}
