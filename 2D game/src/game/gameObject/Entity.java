package game.gameObject;

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
    protected boolean isInvincible = false;
    protected boolean die = false;

    protected int attackSpeed = 1050; // in milliseconds
    protected int attackDuration = 650; // in milliseconds
    protected double attacktime;
    protected boolean canAttack = true;
    protected boolean attacking = false;

    protected int skillSpeed = 2500; // in milliseconds
    protected int skillDuration = 1500; // in milliseconds
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

    public Entity (Vector2f origin, int size){
        this.bounds = new BoundingBox(origin, size, size);
        this.pos = origin;
        this.size = size;
        this.hitsize = size;
        hitBounds = new BoundingBox(origin,size,size);
        hitBounds.setXOffset(size/2);

        tc = new TileCollision(this);
        skill= new ArrayList<>();
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
        if((attacktime / 1000000) > ((time / 1000000) - attackSpeed) || (this.mana - attackManaConsume) <= 0) {canAttack = false;}
            else canAttack = true;
        if((attacktime / 1000000) + attackDuration > (time / 1000000) && (this.mana - attackManaConsume) >= 0) {
            return true;
        }
        return false;
    }

    protected boolean isSkilling(double time) {
        if((skilltime / 1000000) > ((time / 1000000) - skillSpeed) || (this.mana - skillManaConsume) <= 0) {canSkill = false;}
        else canSkill = true;
        if((skilltime / 1000000) + skillDuration > (time / 1000000) && (this.mana - skillManaConsume) >= 0) {return true;}
        return false;
    }

    public boolean isInCircle (Vector2f center, double r) {
        if (this.bounds.distance(center) < r) {return true;}
        return false;
    }
    public boolean isInCirclePath (Vector2f center, double r) {
        if (this.bounds.distance(center)  > (r-size) && this.bounds.distance(center)  < (r+ size)) {return true;}
        return false;
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
    public ArrayList<Skill> getSkill() {return skill;}
}





