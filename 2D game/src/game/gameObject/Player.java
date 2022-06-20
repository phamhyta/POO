package game.gameObject;

import game.GamePanel;
import game.gameObject.enemy.Enemy;
import game.gameObject.object.GameObject;
import game.graphics.Animation;
import game.states.GameStateManager;
import game.states.PlayState;
import game.util.KeyHandler;
import game.util.MouseHandler;
import game.math.Vector2f;

import java.util.ArrayList;

public class Player extends Entity {
    private ArrayList<Enemy> enemy;
    private ArrayList<GameObject> inventory;

    private int skillCounter =0;
    private int nextLevelEXP = 50;

    public Player(Vector2f orgin, int size) {
        super(orgin, size);
        setDefaultValue();
        enemy = new ArrayList<>();
        inventory = new ArrayList<>();
        skill= new ArrayList<>();

    }
    private void setDefaultValue(){
        damage = 25;
        maxMana=100;
        mana = 100;
        maxHealth= 300;
        health = 200;
        acc = 2f;
        maxSpeed= 4f;
        deacc = 0.3f;
        bounds.setWidth(40);
        bounds.setHeight(30);
        bounds.setXOffset(10);
        bounds.setYOffset(30);

        health = 200;
        maxHealth = 200;
        name = "player";
    }

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
            damage = damage +10;
            GameStateManager.sound.playSingleMusic(8);
        }
    }

    public void update(double time){
        super.update(time);
        System.out.println(EXP);
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
//        move();
//        pos.x += dx;
//        pos.y += dy;
        checkLevelUp();

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

        }else {
            up = false;
            down = false;
            right = false;
            left = false;
        }

    }

}
