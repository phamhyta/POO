package game.gameObject.skill;

import game.gameObject.Player;
import game.gameObject.enemy.Enemy;

public class EnemySkill extends Skill{
    private Player player;

    public EnemySkill(Enemy enemy, int size, Player player) {
        super(enemy,size);
        this.player=player;
        r_attack=500;
        maxSpeed = 2;
        type =SKILL_BOSS;
    }

    public void update() {

        if(!die){
            this.chase(player);
            move();
            this.pos.x += dx;
            this.pos.y += dy;
            if(pos.x > defaultVector.x + r_attack || pos.x < defaultVector.x - r_attack||
                    pos.y >defaultVector.y + r_attack || pos.y < defaultVector.y - r_attack){
                die = true;
            }
            if(this.getBounds().collides(player.getBounds())){
                die = true;
                player.setHealth( player.getHealth()- damageCaculate( player), 5f*getDirection(), currentDirection == UP || currentDirection == DOWN);
                if(player.getHealth() <= 0) player.setDeath(true);
            }
            if(tc.collisionTile(dx, 0) || tc.collisionTile(0, dy)) die = true;
        }
    }

    private void chase(Player player) {
        if (!player.getDeath()) {
            autoDirecting(this.pos, player.getPos());
        } else {
            stopDirecting();
        }
    }

}
