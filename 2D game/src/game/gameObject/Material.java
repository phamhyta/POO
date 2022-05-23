package game.gameObject;


import game.math.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Material extends GameObject{
    protected int HP;
    protected int MP;
    protected int speed;
    protected int attackValue;
    protected int defense;

    protected BufferedImage image;

    public int type; //0 is player, 1 is npc, 2 is monster
    public static final int type_player=0;
    public static final int type_npc=1;
    public static final int type_monster=2;
    public static final int type_sword=3;
    public static final int type_axe=4;
    public static final int type_shield =5;
    public static final int type_consumable=6;
    public static final int type_pickupOnly=7;
    public static final int type_nextMap=8;


    public Material(Vector2f origin, int size) {
        super(origin,size);
    }
    public void use (Player player){}
    public void update(){};
    public abstract void render(Graphics2D g);

}
