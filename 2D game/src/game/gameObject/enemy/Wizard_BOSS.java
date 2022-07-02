package game.gameObject.enemy;

import game.gameObject.EnemySkill;
import game.gameObject.Player;
import game.gameObject.Skill;
import game.graphics.Animation;
import game.math.BoundingBox;
import game.math.Vector2f;

public class Wizard_BOSS extends Enemy {
    private int cooldown = 1000;
    private long startSkillTime = System.nanoTime();
    public Wizard_BOSS (Vector2f origin, int size) {
        super(origin, size);
        xOffset = size / 4;
        yOffset = size / 4;
        maxHealth= 200;
        health= 200;
        EXP =30;
        damage = 30;
        acc = 1f;
        deacc = 2f;
        maxSpeed = 0;
        r_sense = 100000;
        r_attackrange = 32;
        coin =10;


        hasIdle = true;
        useRight = true;
        right = true;

    }
    public void addForce(float a, boolean vertical) {
//        if(!vertical) {dx -= a;}
//        else {dy -= a;}
    }
    public void update(Player player, double time, Vector2f defaultPosition) {
        super.update(time);



        if(teleported) {
            teleported = false;

            bounds.setWidth(size / 2);
            bounds.setHeight(size / 2 - yOffset);
            bounds.setXOffset(size / 2 - xOffset);
            bounds.setYOffset(size / 2 + yOffset);
            hitBounds = new BoundingBox(pos, size, size);
            hitBounds.setXOffset(size / 2);

            sense = new BoundingBox(new Vector2f(pos.x + size / 2 - r_sense / 2, pos.y + size / 2 - r_sense / 2), r_sense);
            attackrange = new BoundingBox(new Vector2f(pos.x + bounds.getXOffset() + bounds.getWidth() / 2 - r_attackrange / 2 , pos.y + bounds.getYOffset() + bounds.getHeight() / 2 - r_attackrange / 2 ), r_attackrange);
        }

        if (attackrange.colCircleBox(player.getBounds()) && !isInvincible) {
            attacking = true;
            player.setHealth(player.getHealth()-damageCaculate(player), force/5 * getDirection(), currentDirection == UP || currentDirection == DOWN);
        } else {
            attacking = false;
        }

        if(attacking){
            if (this.isAttacking(time)) {
                enemySkill.add(new EnemySkill(this,48));
                startSkillTime=0;
            }
            for (int i = 0; i < enemySkill.size(); i++) {
                if (enemySkill.get(i).getDeath()) {
                    enemySkill.remove(i);
                } else enemySkill.get(i).update(player);
            }
        }



        if (!fallen) {
            if (!tc.collisionTile(dx, 0)) {
                sense.getPos().x += dx;
                attackrange.getPos().x += dx;
                pos.x += dx;
            }
            if (!tc.collisionTile(0, dy)) {
                sense.getPos().y += dy;
                attackrange.getPos().y += dy;
                pos.y += dy;
            }
        } else {
            if (Animation.hasPlayedOnce()) {
                die = true;
            }
        }
    }

}
