package game.gameObject;

import game.GamePanel;
<<<<<<< HEAD
<<<<<<< HEAD
import game.gameObject.monster.Enemy;
=======
import game.gameObject.enemy.Enemy;
import game.gameObject.object.GameObject;
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
import game.gameObject.enemy.Enemy;
import game.gameObject.object.GameObject;
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
import game.graphics.Animation;
import game.states.GameStateManager;
import game.states.PlayState;
import game.util.KeyHandler;
import game.util.MouseHandler;
import game.math.Vector2f;

<<<<<<< HEAD
<<<<<<< HEAD
import java.awt.*;
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
import java.util.ArrayList;

public class Player extends Entity {
    private ArrayList<Enemy> enemy;
    private ArrayList<GameObject> inventory;

<<<<<<< HEAD
<<<<<<< HEAD
    private int maxMana=50;
    private int mana = 5;
    private float manapercent = 1;
    private int nextLevelEXP = 50;
    private boolean skillOn= false;
=======
    private int skillCounter =0;
    private int nextLevelEXP = 50;
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
    private int skillCounter =0;
    private int nextLevelEXP = 50;
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6

    public Player(Vector2f orgin, int size) {
        super(orgin, size);
        setDefaultValue();
        enemy = new ArrayList<>();
        inventory = new ArrayList<>();
<<<<<<< HEAD
<<<<<<< HEAD
    }
    private void setDefaultValue(){
=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        skill= new ArrayList<>();

    }
    private void setDefaultValue(){
        damage = 25;
        maxMana=100;
        mana = 100;
        health = 200;
        maxHealth = 200;
        defense=10;

<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        acc = 2f;
        maxSpeed= 4f;
        deacc = 0.3f;
        bounds.setWidth(40);
        bounds.setHeight(30);
        bounds.setXOffset(10);
        bounds.setYOffset(30);
<<<<<<< HEAD
<<<<<<< HEAD
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

=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        name = "player";
    }

    public void setTargetEnemy(Enemy enemy) {
        this.enemy.add(enemy);
    }
<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
    public void setTargetMaterial(GameObject go) {
        this.inventory.add(go);
    }
    public void removeMaterial(GameObject go){
        this.inventory.remove(go);
    }

    private void resetPosition(){
<<<<<<< HEAD
<<<<<<< HEAD
        System.out.println("Reseting Player... ");
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        pos.x = GamePanel.width/2-32;
        PlayState.map.x=0;
        GameStateManager.cam.getPos().x =0;

        pos.y = GamePanel.height/2-32;
        GameStateManager.cam.getPos().y =0;
        PlayState.map.y=0;
    }
    private void checkLevelUp(){
        if(this.EXP >= nextLevelEXP){
<<<<<<< HEAD
<<<<<<< HEAD
            maxHealth *=2;
=======
            maxHealth = (int)(maxHealth*1.5);
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
            maxHealth = (int)(maxHealth*1.5);
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
            health = maxHealth;
            maxMana = maxMana*2;
            mana= maxMana;
            nextLevelEXP *=2;
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
            damage = damage +10;
            defense +=2;
            GameStateManager.sound.playSingleMusic(8);
        }
    }

    public void update(double time){
        super.update(time);
        attacking = isAttacking(time);
        skilling = isSkilling(time);

        if(skilling){ skillCounter++;}
        if(skilling && skillCounter ==90){
            skill.add(new Skill(this, 32));
            this.mana -= skillManaConsume;
            skillCounter =0;
        }
        for(int i=0; i< skill.size(); i++){
            if(skill.get(i).getDeath()) {
                skill.remove(i);
            }
            else skill.get(i).update();
        }

        for(int i=0; i< enemy.size(); i++ ){
            if(attacking && hitBounds.collides(enemy.get(i).getBounds()) ){
                if(!enemy.get(i).isInvincible) {
                    mana = mana - attackManaConsume;
                }
                enemy.get(i).setHealth(enemy.get(i).getHealth()- damageCaculate(enemy.get(i)), force*getDirection(), currentDirection == UP || currentDirection == DOWN);
<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
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
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
    }

    public void input(MouseHandler mouse,KeyHandler key ){
        if(!fallen ){
            if(skilling){
                up = false;
                down = false;
                right = false;
                left = false;
            }
            else{
                up =key.up.down;
                down =key.down.down;
                left=key.left.down;
                right=key.right.down;
                //SKILL
                if(key.skill.down && canSkill){
                    skilltime = System.nanoTime();
                }
                if(key.attack.down && canAttack){
                    attacktime = System.nanoTime();
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
            }

<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        }else {
            up = false;
            down = false;
            right = false;
            left = false;
        }
<<<<<<< HEAD
<<<<<<< HEAD

    }

=======
    }
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
    }
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
}
