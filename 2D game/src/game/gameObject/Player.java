package game.gameObject;

import game.GamePanel;
import game.gameObject.enemy.Enemy;
import game.gameObject.object.GameObject;
import game.gameObject.skill.SkilPlayer;
import game.graphics.Animation;
import game.states.GameStateManager;
import game.states.PlayState;
import game.util.KeyHandler;
import game.util.MouseHandler;
import game.math.Vector2f;
import java.util.ArrayList;

public class Player extends Entity {
    public static int coin = 0;
    private ArrayList<Enemy> enemy;
    public ArrayList<GameObject> inventory;
    private int nextLevelEXP = 50;

    public Player(Vector2f orgin, int size) {
        super(orgin, size);
        setDefaultValue();
        enemy = new ArrayList<>();
        inventory = new ArrayList<>();
    }

    private void setDefaultValue() {
        damage = 25;
        maxMana = 100;
        mana = 100;
        health = 200;
        maxHealth = 200;
        defense = 10;
        acc = 2f;
        maxSpeed = 4f;
        deacc = 0.3f;
        bounds.setWidth(32);
        bounds.setHeight(16);
        bounds.setXOffset(16);
        bounds.setYOffset(20);
        name = "player";
    }

    public void setTargetEnemy(Enemy enemy) {
        this.enemy.add(enemy);
    }

    public void setTargetMaterial(GameObject go) {
        this.inventory.add(go);
    }

    public void removeMaterial(GameObject go) {
        this.inventory.remove(go);
    }

    public void resetPosition() {
        pos.x = (GamePanel.width / 2) + 100;
        PlayState.map.x = 0;
        GameStateManager.cam.getPos().x = 0;

        pos.y = (GamePanel.height / 2) + 150;
        GameStateManager.cam.getPos().y = 0;
        PlayState.map.y = 0;
    }

    private void checkLevelUp() {
        if (this.EXP >= nextLevelEXP) {
            maxHealth = (int) (maxHealth * 1.5);
            health = maxHealth;
            maxMana = maxMana * 2;
            mana = maxMana;
            nextLevelEXP *= 2;
            damage = damage + 10;
            defense += 2;
            GameStateManager.sound.playSingleMusic(8);
        }
    }

    public void update(double time) {
        super.update(time);
        attacking = isAttacking(time);
        skilling = isSkilling(time);
        if (!skilling)
            skillStartTime = System.nanoTime();
        if (skilling && time / 1000000 - skillStartTime / 1000000 > skillDuration / 2) {
            skill.add(new SkilPlayer(this, 48));
            this.mana -= skillManaConsume;
            skillStartTime = System.nanoTime();
        }
        for (int i = 0; i < skill.size(); i++) {
            if (skill.get(i).getDeath()) {
                skill.remove(i);
            } else
                skill.get(i).update();
        }

        for (int i = 0; i < enemy.size(); i++) {
            if (attacking && hitBounds.collides(enemy.get(i).getBounds())) {
                if (!enemy.get(i).isInvincible) {
                    mana = mana - attackManaConsume;
                }
                enemy.get(i).setHealth(enemy.get(i).getHealth() - damageCaculate(enemy.get(i)), force * getDirection(),
                        currentDirection == UP || currentDirection == DOWN);
                enemy.remove(i);
            }
        }

        if (!fallen) {
            move();
            if (!tc.collisionTile(dx, 0)) {
                pos.x += dx;
                xCol = false;
            } else {
                xCol = true;
            }

            if (!tc.collisionTile(0, dy)) {
                pos.y += dy;
                yCol = false;
            } else {
                yCol = true;
            }
        } else {
            xCol = false;
            yCol = false;
            if (Animation.hasPlayedOnce()) {
                resetPosition();
                dx = 0;
                dy = 0;
                fallen = false;
            }
        }
        checkLevelUp();
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        if (!fallen) {
            if (skilling) {
                up = false;
                down = false;
                right = false;
                left = false;
            } else {
                up = key.up.down;
                down = key.down.down;
                left = key.left.down;
                right = key.right.down;
                // SKILL
                if (key.skill.down && canSkill) {
                    skilltime = System.nanoTime();
                }
                if (key.attack.down && canAttack) {
                    attacktime = System.nanoTime();
                }
                if (key.shift.down) {
                    maxSpeed = 8;
                    GameStateManager.cam.setMaxSpeed(7);
                } else {
                    maxSpeed = 4;
                    GameStateManager.cam.setMaxSpeed(4);
                }

                if (up && down) {
                    up = false;
                    down = false;
                }

                if (right && left) {
                    right = false;
                    left = false;
                }
            }

        } else {
            up = false;
            down = false;
            right = false;
            left = false;
        }
    }

}
