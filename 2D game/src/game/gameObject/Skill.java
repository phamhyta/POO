package game.gameObject;

<<<<<<< HEAD
=======
import game.data.GameControl;
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
import game.math.Vector2f;

public class Skill extends Entity{
    private int direction;

<<<<<<< HEAD
    private int ManaConsume =50;

    public Skill(Vector2f origin, int size, int direction) {
        super(origin, size);
        this.direction = direction;
        checkCurrentDirection();
        damage = 50;
        health= 100;
        maxSpeed = 5;
        acc = 2;
        deacc=5;
=======
    private Entity entity;
    private SkillRender skillRender;

    public Skill(Entity entity, int size) {
        super(new Vector2f(entity.getPos()), size);
        this.entity = entity;
        this.direction = entity.currentDirection;
        skillRender = new SkillRender(this);
        checkCurrentDirection();
        damage = entity.getDamage()*2;
        health= 100;
        maxSpeed = 5;
        acc = 2;
        deacc=1;
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
    }

    private void checkCurrentDirection() {
        if(direction == UP) up =true;
        if(direction == DOWN) down =true;
        if(direction == LEFT) left =true;
        if(direction == RIGHT) right =true;
    }

<<<<<<< HEAD

    public void checkAlive(Entity entity){
        if(this.bounds.collides(entity.getBounds())){
            die = true;
            entity.setHealth(entity.getHealth() - damage);
        }
    }

=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
    public void update() {
        if(!die){
            move();
            this.pos.x += dx;
            this.pos.y += dy;
            health = health -1;
<<<<<<< HEAD
            System.out.println(health);
        }
        if(health <= 0) {die = true;}
        else die = false;
        System.out.println(die);
    }

    public int getManaConsume() {return ManaConsume;}
}
=======
        }
        if(health <= 0) {die = true;}

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

>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
