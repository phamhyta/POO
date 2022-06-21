package game.render;

import game.gameObject.Entity;
import game.graphics.Animation;
import game.graphics.Sprite;
import game.graphics.SpriteSheet;
import game.util.Camera;

import java.awt.*;

public class EntityRender {
    protected Entity entity;
    public Animation ani;
    protected Camera camera;

    protected int UP = 7;
    protected int DOWN = 6;
    protected int RIGHT = 4;
    protected int LEFT = 5;
    protected int FALLEN = 8;
    protected int IDLE = 0;
    protected int ATTACK_RIGHT = 9;
    protected int ATTACK_LEFT = 10;
    protected int ATTACK_DOWN = 11;
    protected int ATTACK_UP = 12;
    protected int SKILL_UP = 2;
    protected int SKILL_DOWN = 0;
    protected int SKILL_LEFT = 1;
    protected int SKILL_RIGHT = 3;

    protected int currentAnimation;

    protected SpriteSheet spriteSheet;

    public EntityRender(Camera camera, Entity entity, SpriteSheet spriteSheet) {
        this.entity = entity;
        this.spriteSheet = spriteSheet;
        this.camera = camera;
        ani = new Animation();
        setAnimation(1, spriteSheet.getSpriteArray(1), 10);
    }

    public void setAnimation(int i, Sprite[] frames, int delay) {
        currentAnimation = i;
        ani.setFrames(i, frames);
        ani.setDelay(delay);
    }

    public void setAnimation(int i, int delay) {
        if ((currentAnimation != i || ani.getDelay() == -1)) {
            setAnimation(i, spriteSheet.getSpriteArray(i), delay);
        }
    }

    public void animate() {
        if (entity.isAttacking()) {
            if (currentAnimation == UP)
                setAnimation(ATTACK_UP, spriteSheet.getSpriteArray(ATTACK_UP), entity.getAttackDuration() / 100);
            if (currentAnimation == DOWN)
                setAnimation(ATTACK_DOWN, spriteSheet.getSpriteArray(ATTACK_DOWN), entity.getAttackDuration() / 100);
            if (currentAnimation == LEFT)
                setAnimation(ATTACK_LEFT, spriteSheet.getSpriteArray(ATTACK_LEFT), entity.getAttackDuration() / 100);
            if (currentAnimation == RIGHT)
                setAnimation(ATTACK_RIGHT, spriteSheet.getSpriteArray(ATTACK_RIGHT), entity.getAttackDuration() / 100);
        } else if (entity.isSkilling()) {
            if (currentAnimation == UP)
                setAnimation(SKILL_UP, spriteSheet.getSpriteArray(SKILL_UP), 20);
            if (currentAnimation == DOWN)
                setAnimation(SKILL_DOWN, spriteSheet.getSpriteArray(SKILL_DOWN), 20);
            if (currentAnimation == LEFT)
                setAnimation(SKILL_LEFT, spriteSheet.getSpriteArray(SKILL_LEFT), 20);
            if (currentAnimation == RIGHT)
                setAnimation(SKILL_RIGHT, spriteSheet.getSpriteArray(SKILL_RIGHT), 20);
        } else if (entity.isUp()) {
            setAnimation(UP, 5);
        } else if (entity.isDown()) {
            setAnimation(DOWN, 5);
        } else if (entity.isLeft()) {
            setAnimation(LEFT, 5);
        } else if (entity.isRight()) {
            setAnimation(RIGHT, 5);
        } else if (entity.isFallen()) {
            setAnimation(FALLEN, 15);
        } else {
            if (!entity.isAttacking()) {
                if (currentAnimation == ATTACK_UP)
                    setAnimation(UP, spriteSheet.getSpriteArray(UP), -1);
                if (currentAnimation == ATTACK_DOWN)
                    setAnimation(DOWN, spriteSheet.getSpriteArray(DOWN), -1);
                if (currentAnimation == ATTACK_LEFT)
                    setAnimation(LEFT, spriteSheet.getSpriteArray(LEFT), -1);
                if (currentAnimation == ATTACK_RIGHT)
                    setAnimation(RIGHT, spriteSheet.getSpriteArray(RIGHT), -1);
                if (currentAnimation == SKILL_UP)
                    setAnimation(UP, spriteSheet.getSpriteArray(UP), -1);
                if (currentAnimation == SKILL_DOWN)
                    setAnimation(DOWN, spriteSheet.getSpriteArray(DOWN), -1);
                if (currentAnimation == SKILL_LEFT)
                    setAnimation(LEFT, spriteSheet.getSpriteArray(LEFT), -1);
                if (currentAnimation == SKILL_RIGHT)
                    setAnimation(RIGHT, spriteSheet.getSpriteArray(RIGHT), -1);

                if (entity.isHasIdle() && currentAnimation != IDLE) {
                    setAnimation(IDLE, spriteSheet.getSpriteArray(IDLE), 10);
                } else if (!entity.isHasIdle()) {
                    setAnimation(currentAnimation, spriteSheet.getSpriteArray(currentAnimation), -1);
                }
            }
        }
    }

    public void update() {
        animate();
        ani.update();
        if (ani.hasPlayedOnce()) {
            currentAnimation = RIGHT;
        }
    }

    public void render(Graphics2D g) {
        if (camera.getBounds().collides(entity.getBounds())) {
            g.drawImage(ani.getImage().image, (int) (entity.getPos().getWorldVar().x),
                    (int) (entity.getPos().getWorldVar().y), entity.getSize(), entity.getSize(), null);
        }
        for (int i = 0; i < entity.getSkill().size(); i++) {
            if (entity.getSkill().get(i) != null)
                entity.getSkill().get(i).getSkillRender().render(g);
        }
    }

}