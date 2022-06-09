package game.gameObject;

import game.graphics.Animation;
import game.graphics.Sprite;
import game.graphics.SpriteSheet;
import game.math.AABB;
import game.util.TileCollision;
import game.math.Vector2f;

import java.awt.Graphics2D;


public abstract class Entity extends GameObject{

    protected int UP =3;
    protected int DOWN=2;
    protected int RIGHT=0;
    protected int LEFT=1;
    protected int FALLEN=4;
    protected int ATTACK = 5;
    protected int IDLE = 6;


    protected int currentAnimation;
    protected int currentDirection = RIGHT;


    protected Animation ani;
    protected int hitsize;

    protected boolean up = false;
    protected boolean down = false;
    protected boolean right = false;
    protected boolean left = false;
    protected boolean attack = false;
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

    protected int maxHealth = 100;
    protected int health = 100;
    protected float healthpercent = 1;
    protected int defense = 10;
    protected int damage = 25;

    protected int EXP;

    protected AABB hitBounds;


    public Entity (SpriteSheet spriteSheet, Vector2f origin, int size){
        super(spriteSheet, origin, size);
        this.hitsize = size;

        hitBounds = new AABB(origin,size,size);
        hitBounds.setXOffset(size/2);

        ani = new Animation();
        setAnimation(RIGHT, spriteSheet.getSpriteArray(RIGHT),10 );

        tc = new TileCollision(this);
    }

    public void setFallen(boolean b){ fallen = b; }

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
    public boolean getDeath() { return die; }
    public int getHealth() { return health; }
    public float getHealthPercent() { return healthpercent; }
    public int getDefense() { return defense; }
    public AABB getHitBounds() { return hitBounds; }
    public int getEXP(){ return EXP;}
    public void setEXP(int EXP){ this.EXP= EXP;}

    public int getDirection() {
        if(currentDirection == UP || currentDirection == LEFT) {
            return 1;
        }
        return -1;
    }
    public Animation getAnimation() { return ani; }

    public void setAnimation(int i, Sprite[] frames, int delay){
        currentAnimation = i;
        ani.setFrames(i,frames);
        ani.setDelay(delay);
    }

    public void animate() {

        if(attacking) {
            if(currentAnimation < 5) {
                setAnimation(currentAnimation + ATTACK, spriteSheet.getSpriteArray(currentAnimation + ATTACK), attackDuration / 100);
            }
        } else if (up) {
            if ((currentAnimation != UP || ani.getDelay() == -1)) {
                setAnimation(UP, spriteSheet.getSpriteArray(UP), 5);
            }
        } else if (down) {
            if ((currentAnimation != DOWN || ani.getDelay() == -1)) {
                setAnimation(DOWN, spriteSheet.getSpriteArray(DOWN), 5);
            }
        } else if (left) {
            if ((currentAnimation != LEFT || ani.getDelay() == -1)) {
                setAnimation(LEFT, spriteSheet.getSpriteArray(LEFT), 5);
            }
        } else if (right) {
            if ((currentAnimation != RIGHT || ani.getDelay() == -1)) {
                setAnimation(RIGHT, spriteSheet.getSpriteArray(RIGHT), 5);
            }
        } else if (fallen) {
            if (currentAnimation != FALLEN || ani.getDelay() == -1) {
                setAnimation(FALLEN, spriteSheet.getSpriteArray(FALLEN), 15);
            }
        }
        else {
            if(!attacking && currentAnimation > 4) {
                setAnimation(currentAnimation - ATTACK, spriteSheet.getSpriteArray(currentAnimation - ATTACK), -1);
            } else if(!attacking) {
                if(hasIdle && currentAnimation != IDLE) {
                    setAnimation(IDLE, spriteSheet.getSpriteArray(IDLE), 10);
                } else if(!hasIdle) {
                    setAnimation(currentAnimation, spriteSheet.getSpriteArray(currentAnimation), -1);
                }
            }
        }
    }
    public void animate1() {

        if(attacking) {
            if(currentAnimation < 5) {
                setAnimation(currentAnimation + ATTACK, spriteSheet.getSpriteArray(currentAnimation + ATTACK), attackDuration / 100);
            }
        } else if (up) {
            if ((currentAnimation != UP || ani.getDelay() == -1)) {
                setAnimation(UP, spriteSheet.getSpriteArray(UP), 5);
            }
        } else if (down) {
            if ((currentAnimation != DOWN || ani.getDelay() == -1)) {
                setAnimation(DOWN, spriteSheet.getSpriteArray(DOWN), 5);
            }
        } else if (left) {
            if ((currentAnimation != LEFT || ani.getDelay() == -1)) {
                setAnimation(LEFT, spriteSheet.getSpriteArray(LEFT), 5);
            }
        } else if (right) {
            if ((currentAnimation != RIGHT || ani.getDelay() == -1)) {
                setAnimation(RIGHT, spriteSheet.getSpriteArray(RIGHT), 5);
            }
        } else if (fallen) {
            if (currentAnimation != FALLEN || ani.getDelay() == -1) {
                setAnimation(FALLEN, spriteSheet.getSpriteArray(FALLEN), 15);
            }
        }
        else {
            if(!attacking && currentAnimation > 4) {
                setAnimation(currentAnimation - ATTACK, spriteSheet.getSpriteArray(currentAnimation - ATTACK), -1);
            } else if(!attacking) {
                    setAnimation(currentAnimation, spriteSheet.getSpriteArray(currentAnimation), -1);
                }
            }
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

        if((attacktime / 1000000) > ((time / 1000000) - attackSpeed)) {
            canAttack = false;
        } else {
            canAttack = true;
        }

        if((attacktime / 1000000) + attackDuration > (time / 1000000)) {
            return true;
        }

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
            if(dy < -maxSpeed) {
                dy = -maxSpeed;
            }
        } else {
            if(dy < 0) {
                dy += deacc;
                if(dy > 0) {
                    dy = 0;
                }
            }
        }

        if(down) {
            currentDirection = DOWN;
            dy += acc;
            if(dy > maxSpeed) {
                dy = maxSpeed;
            }
        } else {
            if(dy > 0) {
                dy -= deacc;
                if(dy < 0) {
                    dy = 0;
                }
            }
        }

        if(left) {
            currentDirection = LEFT;
            dx -= acc;
            if(dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else {
            if(dx < 0) {
                dx += deacc;
                if(dx > 0) {
                    dx = 0;
                }
            }
        }

        if(right) {
            currentDirection = RIGHT;
            dx += acc;
            if(dx > maxSpeed) {
                dx = maxSpeed;
            }
        } else {
            if(dx > 0) {
                dx -= deacc;
                if(dx < 0) {
                    dx = 0;
                }
            }
        }
    }

    public void update(double time) {
        if(isInvincible) {
            if((invincibletime / 1000000) + invincible < (time / 1000000) ) {
                isInvincible = false;
            }
        }
        animate();
        setHitBoxDirection();
        ani.update();
    }

    @Override
    public abstract void render(Graphics2D g);
}





