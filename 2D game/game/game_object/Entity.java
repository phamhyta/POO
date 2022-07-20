package game.game_object;

import game.math.a_star.PathFind;
import game.game_object.skill.Skill;
import game.math.BoundingBox;
import game.util.TileCollision;
import game.math.Vector2f;

import java.util.ArrayList;

public class Entity {

    protected int currentDirection = 0;
    protected int hitsize;

    protected BoundingBox hitBounds;
    protected BoundingBox bounds;
    protected Vector2f pos;
    protected int size;

    protected final int UP =3;
    protected final int DOWN=2;
    protected final int RIGHT=0;
    protected final int LEFT=1;

    protected boolean up = false;
    protected boolean down = false;
    protected boolean right = false;
    protected boolean left = false;
    protected boolean fallen = false;

    protected boolean hasIdle = false;
    public boolean xCol = false;
    public boolean yCol= false;
    protected int invincible = 800;
    protected double invincibletime;
    public boolean isInvincible = false;
    protected boolean die = false;

    protected int attackSpeed = 1050; // in milliseconds
    protected int attackDuration = 650; // in milliseconds
    protected double attacktime;
    protected boolean canAttack = true;
    protected boolean attacking = false;

    protected int skillSpeed = 500; // in milliseconds
    protected int skillDuration = 500; // in milliseconds
    protected long skillStartTime;
    protected double skilltime;
    protected boolean canSkill = true;
    protected boolean skilling = false;


    protected int maxHealth= 100 ;
    protected int health=100 ;
    protected float healthpercent = 1;
    protected int defense = 10;
    protected int damage= 10;

    protected int maxMana=1000;
    protected int mana = 1000;
    protected float manapercent = 1;

    protected int EXP;

    protected float dx;
    protected float dy;
    protected float maxSpeed = 4f;
    protected float acc = 2f;
    protected float deacc = 0.3f;
    protected float force = 25f;

    protected int coin = 1000;
    protected boolean teleported = false;
    protected TileCollision tc;
    protected String name = "" ;
    protected int attackManaConsume = 2;
    protected int skillManaConsume = 10;
    protected ArrayList<Skill> skill;
    protected PathFind pathFind;

    public Entity (Vector2f origin, int size){
        this.bounds = new BoundingBox(origin, size, size);
        this.pos = origin;
        this.size = size;
        this.hitsize = size;
        hitBounds = new BoundingBox(origin,size,size);
        hitBounds.setXOffset(size/2);
        tc = new TileCollision(this);
        skill= new ArrayList<>();
        pathFind = new PathFind();
    }
    public void setPos(Vector2f pos) {
        this.pos = pos;
        this.bounds = new BoundingBox(pos, size, size);
        teleported = true;
    }
    public void addForce(float a, boolean vertical) {
        if(!vertical) {dx -= a;}
            else {dy -= a;}
    }
    public void setHealth(int i, float f, boolean dir) {
        if(!isInvincible) {
            health = i;
            isInvincible = true;
            invincibletime = System.nanoTime();
            if(health <= 0) {
                die = true;
            }
            addForce(f, dir);
            healthpercent = (float) health / (float) maxHealth;
        }
    }
    public int damageCaculate(Entity entity){
        if(damage - entity.getDefense() <= 0) return 1;
        return damage - entity.getDefense();
    }

    public int getDirection() {
        if(currentDirection == UP || currentDirection == LEFT)  return 1;
        return -1;
    }

    private void setHitBoxDirection() {
        if (up && !attacking) {
            hitBounds.setXOffset((size - hitBounds.getWidth()) / 2);
            hitBounds.setYOffset(-hitBounds.getHeight() / 2 + hitBounds.getXOffset());
        } else if (down && !attacking) {
            hitBounds.setXOffset((size - hitBounds.getWidth()) / 2);
            hitBounds.setYOffset(hitBounds.getHeight() / 2 + hitBounds.getXOffset());
        } else if (left && !attacking) {
            hitBounds.setYOffset((size - hitBounds.getHeight()) / 2);
            hitBounds.setXOffset(-hitBounds.getWidth() / 2 + hitBounds.getYOffset());
        } else if (right && !attacking) {
            hitBounds.setYOffset((size - hitBounds.getHeight()) / 2);
            hitBounds.setXOffset(hitBounds.getWidth() / 2 + hitBounds.getYOffset());
        }
    }

    protected boolean isAttacking(double time) {
        canAttack = !((attacktime / 1000000) > ((time / 1000000) - attackSpeed)) && (this.mana - attackManaConsume) > 0;
        return (attacktime / 1000000) + attackDuration > (time / 1000000) && (this.mana - attackManaConsume) >= 0;
    }

    protected boolean isSkilling(double time) {
        canSkill = !((skilltime / 1000000) > ((time / 1000000) - skillSpeed)) && (this.mana - skillManaConsume) > 0;
        return (skilltime / 1000000) + skillDuration > (time / 1000000) && (this.mana - skillManaConsume) >= 0;
    }

    public boolean isInCircle (Vector2f center, double r) {
        return this.bounds.distance(center) < r;
    }
    public boolean isInCirclePath (Vector2f center, double r) {
        return this.bounds.distance(center) > (r - size) && this.bounds.distance(center) < (r + size);
    }
    public void move() {
        if(up) {
            currentDirection = UP;
            dy -= acc;
            if(dy < -maxSpeed) {dy = -maxSpeed;}
        } else {
            if(dy < 0) {
                dy += deacc;
                if(dy > 0) {dy = 0;}
            }
        }
        if(down) {
            currentDirection = DOWN;
            dy += acc;
            if(dy > maxSpeed) {dy = maxSpeed;}
        } else {
            if(dy > 0) {
                dy -= deacc;
                if(dy < 0) {dy = 0;}
            }
        }
        if(left) {
            currentDirection = LEFT;
            dx -= acc;
            if(dx < -maxSpeed) {dx = -maxSpeed;}
        } else {
            if(dx < 0) {
                dx += deacc;
                if(dx > 0) {dx = 0;}
            }
        }
        if(right) {
            currentDirection = RIGHT;
            dx += acc;
            if(dx > maxSpeed) {dx = maxSpeed;}
        } else {
            if(dx > 0) {
                dx -= deacc;
                if(dx < 0) {dx = 0;}
            }
        }
    }

    protected void moveInPath(Entity entity){
        pathFind.update();
        pathFind.setNodes((int)(pos.x +bounds.getYOffset()) /64,(int)(this.pos.y +bounds.getYOffset()) /64,
                (int)(entity.pos.x + entity.getBounds().getXOffset())/64,(int)(entity.pos.y+entity.getBounds().getYOffset() )/64);
        if(pathFind.search()){
            if(!pathFind.getPathList().isEmpty() || !pathFind.getPathList().get(0).equals( pathFind.getGoalNode())){
                int col = pathFind.getPathList().get(0).getCol();
                int row = pathFind.getPathList().get(0).getRow();
                pathFind.getPathList().remove(0);
                Vector2f vt = new Vector2f(col * 64,row * 64 );
                autoDirecting(this.pos,vt);
            }
        }else{
                autoDirecting(this.pos, entity.getPos());
        }

    }

    protected void moveInPath(Vector2f origin){
        pathFind.update();
        pathFind.setNodes((int)(pos.x +bounds.getYOffset()) /64,(int)(this.pos.y +bounds.getYOffset()) /64,
                (int)(origin.x /64),(int)(origin.y /64));
        if(pathFind.search()){
            if(!pathFind.getPathList().isEmpty()|| !pathFind.getPathList().get(0).equals( pathFind.getGoalNode())){
                int col = pathFind.getPathList().get(0).getCol();
                int row = pathFind.getPathList().get(0).getRow();
                pathFind.getPathList().remove(0);
                Vector2f vt = new Vector2f(col * 64,row * 64 );
                autoDirecting(this.pos,vt);
            }
        }else{
            stopDirecting();
        }
    }


    protected void autoDirecting(Vector2f posA, Vector2f posB){
        up = posA.y > posB.y + 5 ;
        down = posA.y < posB.y - 5;
        left = posA.x > posB.x + 5;
        right = posA.x < posB.x - 5;
    }

    protected void stopDirecting(){
        up = false;
        down = false;
        left = false;
        right = false;
    }


    public void update(double time) {
        if(isInvincible) {
            if((invincibletime / 1000000) + invincible < (time / 1000000) ) {
                isInvincible = false;
            }
        }
        setHitBoxDirection();
        updateHealthManaPercent();
    }
    public void updateHealthManaPercent(){
        manapercent = (float) mana/maxMana;
        healthpercent= (float) health/maxHealth;
    }

    public void setFallen(boolean b){ fallen = b; }
    public boolean getDeath() { return die; }
    public void setDeath(boolean death){this.die = death;}
    public int getHealth() { return health; }
    public void setHealth(int health){ this.health = health;}
    public float getHealthPercent() { return healthpercent; }
    public int getDefense() { return defense; }
    public BoundingBox getHitBounds() { return hitBounds; }
    public BoundingBox getBounds(){ return bounds;}
    public int getEXP(){ return EXP;}
    public void setEXP(int EXP){ this.EXP= EXP;}
    public boolean isUp() {return up;}
    public boolean isDown() {return down;}
    public boolean isRight() {return right;}
    public boolean isLeft() {return left;}
    public boolean isFallen() {return fallen;}
    public boolean isAttacking() {return attacking;}
    public boolean isSkilling() {return skilling;}
    public boolean isHasIdle() {return hasIdle;}
    public void setName(String name) { this.name = name; }
    public void setSize(int i) { size = i; }
    public void setMaxSpeed(float f) { maxSpeed = f; }
    public void setAcc(float f) { acc = f; }
    public void setDeacc(float f) { deacc = f; }
    public int getCoin() {return coin;}
    public void setCoin(int coin) {this.coin = coin;}
    public float getDeacc() { return deacc; }
    public float getAcc() { return acc; }
    public float getMaxSpeed() { return maxSpeed; }
    public float getDx() { return dx; }
    public float getDy() { return dy; }
    public Vector2f getPos() { return pos; }
    public int getSize() { return size; }
    public int getAttackDuration() {
        return attackDuration;
    }
    public int getMaxMana() {return maxMana;}
    public void setMaxMana(int maxMana) {this.maxMana = maxMana;}
    public int getMana() {return mana;}
    public void setCurrentMana(int mana) {this.mana = mana;}
    public float getManapercent() {return manapercent;}
    public int getMaxHealth() {return maxHealth;}
    public int getDamage() { return damage;}
    public void setDamage(int damage) {this.damage=damage;}
    public void setDefense(int defense) {this.defense=defense;}
    public ArrayList<Skill> getSkill() {return skill;}
    public int getSkillDuration() {return skillDuration;}
    public int getCurrentDirection() {return currentDirection;}
    public void setBox(int zone){
        this.bounds.setBox(pos, zone, zone);
    }
}





