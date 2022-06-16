package game.gameObject;

import game.GamePanel;
import game.gameObject.monster.Enemy;
import game.graphics.Animation;
import game.states.GameStateManager;
import game.states.PlayState;
import game.util.KeyHandler;
import game.util.MouseHandler;
import game.math.Vector2f;

import java.awt.*;
import java.util.ArrayList;

public class Player extends Entity {
    private ArrayList<Enemy> enemy;
    private ArrayList<GameObject> inventory;

    private int maxMana=50;
    private int mana = 5;
    private float manapercent = 1;
    private int nextLevelEXP = 50;
    private boolean skillOn= false;

    public Player(Vector2f orgin, int size) {
        super(orgin, size);
        setDefaultValue();
        enemy = new ArrayList<>();
        inventory = new ArrayList<>();
    }
    private void setDefaultValue(){
        acc = 2f;
        maxSpeed= 4f;
        deacc = 0.3f;
        bounds.setWidth(40);
        bounds.setHeight(30);
        bounds.setXOffset(10);
        bounds.setYOffset(30);
        hitBounds.setWidth(37);
        hitBounds.setHeight(37);

        health = 200;
        maxHealth = 200;
        name = "player";
    }

    public int getMaxMana() {return maxMana;}
    public void setMaxMana(int maxMana) {this.maxMana = maxMana;}
    public int getMana() {return mana;}
    public void setCurrentMana(int mana) {this.mana = mana;}
    public float getManapercent() {return manapercent;}
    public void setManapercent(float manapercent) {this.manapercent = manapercent;}
    public int getMaxHealth() {return maxHealth;}
    public void setCurrentHealth(int health){this.health = health;}

    public void setTargetEnemy(Enemy enemy) {
        this.enemy.add(enemy);
    }

    public void setTargetMaterial(GameObject go) {
        this.inventory.add(go);
    }
    public void removeMaterial(GameObject go){
        this.inventory.remove(go);
    }

    private void resetPosition(){
        System.out.println("Reseting Player... ");
        pos.x = GamePanel.width/2-32;
        PlayState.map.x=0;
        GameStateManager.cam.getPos().x =0;

        pos.y = GamePanel.height/2-32;
        GameStateManager.cam.getPos().y =0;
        PlayState.map.y=0;
    }
    private void checkLevelUp(){
        if(this.EXP >= nextLevelEXP){
            maxHealth *=2;
            health = maxHealth;
            maxMana = maxMana*2;
            mana= maxMana;
            nextLevelEXP *=2;
        }
    }
    private void updateHealthManaPercent(){
        manapercent = (float) mana/maxMana;
        healthpercent= (float) health/maxHealth;
    }
    public void update(double time){
        super.update(time);

        attacking = isAttacking(time);
        for(int i=0; i< enemy.size(); i++ ){
            if(attacking && hitBounds.collides(enemy.get(i).getBounds()) ){
                if(!enemy.get(i).isInvincible) {
//                  USE MANA ???
                    mana = mana -1;
                    // use in skill, we will update later
                }
                enemy.get(i).setHealth(enemy.get(i).getHealth()- damage, force*getDirection(), currentDirection == UP || currentDirection == DOWN);
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
        updateHealthManaPercent();
        if(skill){
            if(skillOn){
                if(skillAttack == null){
                    skillAttack = new Skill(new Vector2f(this.pos.x, this.pos.y),32, currentDirection);
                }
                else{
                    skillAttack.update();
                    System.out.println(pos.x);
                    System.out.println(pos.y);
                    System.out.println(skillAttack.getPos().x);
                    System.out.println(skillAttack.getPos().y);
                    if(skillAttack.getDeath()){
                        skillOn= false;
                        skillAttack = null;
                    }
                }
            }
        }

    }

    public void input(MouseHandler mouse,KeyHandler key ){
        if(!fallen){
            up =key.up.down;
            down =key.down.down;
            left=key.left.down;
            right=key.right.down;
            //SKILL
            key.skill.tick();
            if(key.skill.clicked && canAttack){
                skill = true;
                skillOn = true;
            }
            if(key.attack.down && canAttack){
                attack = true;
                attacktime = System.nanoTime();
            }
            else{
                if(!attacking){
                    attack = false;
                }
            }
            if(key.shift.down) {
                maxSpeed = 8;
                GameStateManager.cam.setMaxSpeed(7);
            } else {
                maxSpeed = 4;
                GameStateManager.cam.setMaxSpeed(4);
            }

            if(up && down) {
                up = false;
                down = false;
            }

            if(right && left) {
                right = false;
                left = false;
            }
        }else {
            up = false;
            down = false;
            right = false;
            left = false;
        }

    }

}
