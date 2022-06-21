package game.gameObject;

import game.graphics.SpriteSheet;
import game.math.BoundingBox;
import game.math.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    protected SpriteSheet spriteSheet;
    protected BoundingBox bounds;
    protected Vector2f pos;
    protected int size;

<<<<<<< HEAD
<<<<<<< HEAD
    protected int coin =0;

    protected boolean teleported = false;
	protected String name = "";
=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
    protected int coin = 0;

    protected boolean teleported = false;
    protected String name = "";
<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6

    protected int HP;
    protected int MP;
    protected int speed;
    protected int attackValue;
    protected int defense;

    protected BufferedImage image;

    public int type;
<<<<<<< HEAD
<<<<<<< HEAD
    public static final int type_player=0;
    public static final int type_npc=1;
    public static final int type_monster=2;
    public static final int type_sword=3;
    public static final int type_axe=4;
    public static final int type_shield =5;
    public static final int type_consumable=6;
    public static final int type_pickupOnly=7;
    public static final int type_nextMap=8;

    public GameObject(Vector2f origin,int size) {
=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
    public static final int type_player = 0;
    public static final int type_npc = 1;
    public static final int type_monster = 2;
    public static final int type_sword = 3;
    public static final int type_axe = 4;
    public static final int type_shield = 5;
    public static final int type_consumable = 6;
    public static final int type_pickupOnly = 7;
    public static final int type_nextMap = 8;

    public GameObject(Vector2f origin, int size) {
<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        this.bounds = new BoundingBox(origin, size, size);
        this.pos = origin;
        this.size = size;
    }

    public void setPos(Vector2f pos) {
        this.pos = pos;
        this.bounds = new BoundingBox(pos, size, size);
        teleported = true;
    }

<<<<<<< HEAD
<<<<<<< HEAD
	public void setName(String name) { this.name = name; }
    public void setSize(int i) { size = i; }
    public int getCoin() {return coin;}
    public void setCoin(int coin) {this.coin = coin;}

    public BoundingBox getBounds() { return bounds; }
    public Vector2f getPos() { return pos; }
    public int getSize() { return size; }

    public void use (Player player){}
    public void update(){};
    public abstract void render(Graphics2D g);

=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int i) {
        size = i;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public BoundingBox getBounds() {
        return bounds;
    }

    public Vector2f getPos() {
        return pos;
    }

    public int getSize() {
        return size;
    }

    public void use(Player player) {
    }

    public void update() {
    };

    public abstract void render(Graphics2D g);
<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
}