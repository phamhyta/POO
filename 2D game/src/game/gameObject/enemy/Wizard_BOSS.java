package game.gameObject.enemy;

import game.data.GameControl;
import game.gameObject.EnemySkill;
import game.gameObject.Player;
import game.gameObject.Skill;
import game.gameObject.object.Items.*;
import game.graphics.Animation;
import game.math.BoundingBox;
import game.math.Vector2f;

public class Wizard_BOSS extends Enemy {
    private int cooldown = 1000;
    private long startSkillTime = System.nanoTime();
    public Wizard_BOSS (Vector2f origin, int size) {
        super(origin, size);
        xOffset = size / 4;
        yOffset = size / 2;
        bounds.setWidth(size/2);
        bounds.setHeight(size/2);
        bounds.setXOffset(xOffset);
        bounds.setYOffset(yOffset);

        maxHealth= 200;
        health= 200;
        EXP =30;
        damage = 30;
        acc = 1f;
        deacc = 2f;
        maxSpeed = 0;
        r_sense = 1000;
        r_attackrange = 10;
        coin =10;
        dropRate= 0.5F;

        skillManaConsume=0;
        mana = 1000;
        skillSpeed = 2000;
        hasIdle = true;
        useRight = true;
        right = true;

    }
    public void addForce(float a, boolean vertical) {
//        if(!vertical) {dx -= a;}
//        else {dy -= a;}
    }
    public void update(Player player, double time, Vector2f defaultPosition) {
        super.update(player, time, defaultPosition);

        if(player.isInCircle(this.getPos(), r_sense)&& canSkill) {
            skilltime = System.nanoTime();
        }
        skilling = isSkilling(time);

        if (!skilling)
            skillStartTime = System.nanoTime();
        if ( time / 1000000 - skillStartTime / 1000000 > skillDuration / 2) {
            skill.add(new EnemySkill(this, 48,player));
            skillStartTime = System.nanoTime();
        }


        for (int i = 0; i < skill.size(); i++) {
            if (skill.get(i).getDeath()) {
                skill.remove(i);
            } else
                skill.get(i).update();
        }
    }
    public void drop() {
        int rand = (int) (Math.random() * 100 /dropRate);
        if (rand < 50 && rand >=0) {
            GameControl.setGameObject(new Potion_Red_3(new Vector2f(this.getPos().x - 50, this.getPos().y+5), 32));
        } else if (rand < 80 && rand >= 50) {
            GameControl.setGameObject(new Potion_Blue_3(new Vector2f(this.getPos().x + 25, this.getPos().y-5), 32));
        } else if (rand >= 80 && rand <= 95) {
            GameControl.setGameObject(new Shield_3(new Vector2f(this.getPos().x - 40, this.getPos().y+10), 32));
        }
        else {
            GameControl.setGameObject(new Sword_9(new Vector2f(this.getPos().x , this.getPos().y), 32));
        }
    }
}
