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
        r_sense = 1000;
        r_attackrange = 10;
        coin =10;
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

}
