package game.gameObject;

import game.data.GameControl;
import game.math.Vector2f;
import game.render.SkillRender;

public class Skill extends Entity{
    private int direction;
    private Entity entity;
    private SkillRender skillRender;
    private int r_attack;
    private Vector2f defaultVector;

    public Skill(Entity entity, int size) {
        super(new Vector2f(entity.getPos()), size);
        this.entity = entity;
        this.direction = entity.currentDirection;
        skillRender = new SkillRender(this);
        checkCurrentDirection();
        damage = entity.getDamage()*2;

        defaultVector = new Vector2f(entity.getPos());
        r_attack =300;
        maxSpeed = 8;
        acc = 2;
        deacc=3;
    }

    private void checkCurrentDirection() {
        if(direction == UP) up =true;
        if(direction == DOWN) down =true;
        if(direction == LEFT) left =true;
        if(direction == RIGHT) right =true;
    }

    public void update() {
        if(!die){
            move();
            this.pos.x += dx;
            this.pos.y += dy;
        }
        if(pos.x > defaultVector.x + r_attack || pos.x < defaultVector.x - r_attack||
            pos.y >defaultVector.y + r_attack || pos.y < defaultVector.y - r_attack){
            die = true;
        }

        for(int i=0; i< GameControl.enemy.length; i++){
            if(GameControl.enemy[i] != null){
                if(this.getBounds().collides(GameControl.enemy[i].getBounds())){
                    die = true;
                    GameControl.enemy[i].setHealth( GameControl.enemy[i].getHealth()- damageCaculate( GameControl.enemy[i]), force*getDirection(), currentDirection == UP || currentDirection == DOWN);
                    if(GameControl.enemy[i].getHealth() <= 0) GameControl.enemy[i].setDeath(true);
                }
            }
        }
        if(tc.collisionTile(dx, 0) || tc.collisionTile(0, dy)) die = true;
    }
    public SkillRender getSkillRender() {return skillRender;}

}

