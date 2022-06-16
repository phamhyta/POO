package game.gameObject;

import game.math.Vector2f;

public class Skill extends Entity{
    private int direction;

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
    }

    private void checkCurrentDirection() {
        if(direction == UP) up =true;
        if(direction == DOWN) down =true;
        if(direction == LEFT) left =true;
        if(direction == RIGHT) right =true;
    }


    public void checkAlive(Entity entity){
        if(this.bounds.collides(entity.getBounds())){
            die = true;
            entity.setHealth(entity.getHealth() - damage);
        }
    }

    public void update() {
        if(!die){
            move();
            this.pos.x += dx;
            this.pos.y += dy;
            health = health -1;
            System.out.println(health);
        }
        if(health <= 0) {die = true;}
        else die = false;
        System.out.println(die);
    }

    public int getManaConsume() {return ManaConsume;}
}
