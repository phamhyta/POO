package game.gameObject;

import game.data.GameControl;
import game.math.Vector2f;
import game.render.SkillRender;

public class Skill extends Entity{
    protected int direction;
    protected Entity entity;
    protected SkillRender skillRender;
    protected int r_attack;
    protected Vector2f defaultVector;

    public Skill(Entity entity, int size) {
        super(new Vector2f(entity.getPos()), size);
        this.entity = entity;
        this.direction = entity.currentDirection;
        skillRender = new SkillRender(this);

        damage = entity.getDamage()*2;

        defaultVector = new Vector2f(entity.getPos());
        r_attack =300;
        maxSpeed = 8;
        acc = 2;
        deacc=3;
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

        if(tc.collisionTile(dx, 0) || tc.collisionTile(0, dy)) die = true;
    }
    public SkillRender getSkillRender() {return skillRender;}

}

