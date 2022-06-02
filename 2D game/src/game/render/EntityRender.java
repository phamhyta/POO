package game.render;

import game.gameObject.Entity;
import game.graphics.Animation;
import game.graphics.Sprite;
import game.graphics.SpriteSheet;

import java.awt.*;

public abstract class EntityRender {
    protected Entity entity;
    protected Animation ani;

    protected int UP =3;
    protected int DOWN=2;
    protected int RIGHT=0;
    protected int LEFT=1;
    protected int FALLEN=4;
    protected int ATTACK = 5;
    protected int IDLE = 6;

    protected int currentAnimation;
    protected int currentDirection = RIGHT;

    protected SpriteSheet spriteSheet;

    public EntityRender(Entity entity, SpriteSheet spriteSheet){
        this.entity = entity;
        this.spriteSheet = spriteSheet;

        ani = new Animation();
        setAnimation(RIGHT, spriteSheet.getSpriteArray(RIGHT),10 );

    }

    public void setAnimation(int i, Sprite[] frames, int delay){
        currentAnimation = i;
        ani.setFrames(i,frames);
        ani.setDelay(delay);
    }

    public void animate() {

        if(entity.isAttacking()) {
            if(currentAnimation < 5) {
                setAnimation(currentAnimation + ATTACK, spriteSheet.getSpriteArray(currentAnimation + ATTACK), entity.getAttackDuration() / 100);
            }
        } else if (entity.isUp()) {
            if ((currentAnimation != UP || ani.getDelay() == -1)) {
                setAnimation(UP, spriteSheet.getSpriteArray(UP), 5);
            }
        } else if (entity.isDown()) {
            if ((currentAnimation != DOWN || ani.getDelay() == -1)) {
                setAnimation(DOWN, spriteSheet.getSpriteArray(DOWN), 5);
            }
        } else if (entity.isLeft()) {
            if ((currentAnimation != LEFT || ani.getDelay() == -1)) {
                setAnimation(LEFT, spriteSheet.getSpriteArray(LEFT), 5);
            }
        } else if (entity.isRight()) {
            if ((currentAnimation != RIGHT || ani.getDelay() == -1)) {
                setAnimation(RIGHT, spriteSheet.getSpriteArray(RIGHT), 5);
            }
        } else if (entity.isFallen()) {
            if (currentAnimation != FALLEN || ani.getDelay() == -1) {
                setAnimation(FALLEN, spriteSheet.getSpriteArray(FALLEN), 15);
            }
        }
        else {
            if(!entity.isAttacking() && currentAnimation > 4) {
                setAnimation(currentAnimation - ATTACK, spriteSheet.getSpriteArray(currentAnimation - ATTACK), -1);
            } else if(!entity.isAttacking()) {
                if(entity.isHasIdle() && currentAnimation != IDLE) {
                    setAnimation(IDLE, spriteSheet.getSpriteArray(IDLE), 10);
                } else if(!entity.isHasIdle()) {
                    setAnimation(currentAnimation, spriteSheet.getSpriteArray(currentAnimation), -1);
                }
            }
        }
    }
    public void update(){
        animate();
        ani.update();
    }

    public abstract void render(Graphics2D g);

}
