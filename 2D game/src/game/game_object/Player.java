package game.game_object;

import game.GamePanel;
import game.game_object.enemy.Enemy;
import game.game_object.object.GameObject;
import game.game_object.skill.SkilPlayer;
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
    private int attackBase ;

    private int attackEquip ;
    private int defenseBase ;
    private int defenseEquip ;
    private int HP_Base;
    private int HP_Equip;
    private int MP_Base;
    private int MP_Equip;
    private float speedBase;
    private float speedEquip;
    private int level =1;

    public Player(Vector2f orgin, int size) {
        super(orgin, size);
        setDefaultValue();
        enemy = new ArrayList<>();
        inventory = new ArrayList<>();
    }

    private void caculateAttribute(){
        maxHealth = HP_Base + HP_Equip;
        maxMana = MP_Base + MP_Equip;
        defense = defenseBase + defenseEquip;
        damage = attackBase + attackEquip;
        maxSpeed = speedBase + speedEquip;
    }

    private void setDefaultValue() {
        attackBase = 25;
        MP_Base = 100;
        mana = 100;
        HP_Base = 200;
        health = 200;
        defenseBase = 10;
        acc = 2f;
        speedBase = 3f;
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
            HP_Base = (int) (HP_Base * 1.5);
            MP_Base = (int)(MP_Base * 1.5);
            nextLevelEXP *= 2;
            level++;
            attackBase += 10;
            defenseBase += 2;
            caculateAttribute();
            health = maxHealth;
            mana = maxMana;
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
        caculateAttribute();
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
    public void setAttackEquip(int attackEquip) {this.attackEquip = attackEquip;}
    public void setDefenseEquip(int defenseEquip) {this.defenseEquip = defenseEquip;}
    public void setHP_Equip(int HP_Equip) {this.HP_Equip = HP_Equip;}
    public void setMP_Equip(int MP_Equip) {this.MP_Equip = MP_Equip;}
    public void setSpeedEquip(float speedEquip) {this.speedEquip = speedEquip;}
    public int getDefenseEquip() {return defenseEquip;}
    public int getHP_Equip() {return HP_Equip;}
    public int getMP_Equip() {return MP_Equip;}
    public float getSpeedEquip() {return speedEquip;}
    public int getLevel(){ return level;}
}
