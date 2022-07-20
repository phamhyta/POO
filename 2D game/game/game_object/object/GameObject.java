package game.game_object.object;

import game.game_object.Player;
import game.math.BoundingBox;
import game.math.Vector2f;
import game.render.ObjectRender;

import java.awt.*;

public class GameObject {

    protected BoundingBox bounds;

    protected ObjectRender objectRender;
    protected Vector2f pos;
    protected int size;
    protected int coin = 0;
    protected String name = "";

    protected int HP = 0;
    protected int MP = 0;
    protected int speed = 0;
    protected int attackValue = 0;
    protected int defense = 0;

    public int type;

    public static final int type_sword = 0;
    public static final int type_direction = 1;
    public static final int type_shield = 2;
    public static final int type_consumable = 3;
    public static final int type_pickupOnly = 4;
    public static final int type_nextMap = 5;
    public static final int type_Arrow = 6;


    public GameObject(Vector2f origin, int size) {
        this.bounds = new BoundingBox(origin, size, size);
        this.pos = origin;
        this.size = size;
    }

    public GameObject() {
    }

    public BoundingBox getBounds() { return bounds; }
    public Vector2f getPos() { return pos; }
    public int getSize() { return size; }

    public void use (Player player){
        if(type == type_consumable){
            if( HP != 0 ){
                if(player.getHealth() + this.HP < player.getMaxHealth()) {
                    player.setHealth(player.getHealth() + this.HP);
                }
                else{
                    player.setHealth(player.getMaxHealth());
                }
            }
            if( MP != 0 ){
                if(player.getMana() + this.MP < player.getMaxMana()) {
                    player.setCurrentMana(player.getMana() + this.MP);
                }
                else{
                    player.setCurrentMana(player.getMaxMana());
                }
            }
        }
        if(type == type_shield){
            if(HP != 0){player.setHP_Equip(HP);}
            if(MP != 0){player.setMP_Equip(MP);}
            if( defense != 0 ){player.setDefenseEquip(defense);}
            if( speed != 0 ){player.setSpeedEquip(speed);}
        }
        if(type == type_sword){
            if( attackValue != 0 ){player.setAttackEquip(attackValue);}
        }
        player.updateHealthManaPercent();
    }
    public void setHP(int hP) {
        HP = hP;
    }
    public int getHP() {
        return HP;
    }
    public void setMP(int mP) {
        MP = mP;
    }
    public int getMP() {
        return MP;
    }
    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }
    public int getAttackValue() {
        return attackValue;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getDefense() {
        return defense;
    }
    public int getCoin() {
        return coin;
    }
    public void setCoin(int coin) {
        this.coin = coin;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }
    public ObjectRender getObjectRender() {
        return objectRender;
    }
}