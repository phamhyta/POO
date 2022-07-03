package game.gameObject.skill;

import game.data.GameControl;
import game.gameObject.Entity;
import game.math.Vector2f;
import game.render.SkillRender;

public class Skill extends Entity {
    public static final int SKILL_PLAYER =0;
    public static final int SKILL_BOSS =1;
    protected int direction;
    protected Entity entity;
    protected SkillRender skillRender;
    protected int r_attack;
    protected Vector2f defaultVector;
    protected int type ;

    public Skill(Entity entity, int size) {
        super(new Vector2f(entity.getPos()), size);
        this.entity = entity;
        this.direction = entity.getCurrentDirection();
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
    public int getType() {return type;}

}

