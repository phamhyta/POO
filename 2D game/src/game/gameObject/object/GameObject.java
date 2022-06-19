package game.gameObject.object;

import game.gameObject.Player;
import game.math.BoundingBox;
import game.math.Vector2f;

public class GameObject {

    protected BoundingBox bounds;

    protected ObjectRender objectRender;
    protected Vector2f pos;
    protected int size;
    protected int coin =0;
	protected String name = "";

    protected int HP;
    protected int MP;
    protected int speed;
    protected int attackValue;
    protected int defense;

    public int type;

    public static final int type_sword=0;
    public static final int type_axe=1;
    public static final int type_shield =2;
    public static final int type_consumable=3;
    public static final int type_pickupOnly=4;
    public static final int type_nextMap=5;

    public GameObject(Vector2f origin,int size) {
        this.bounds = new BoundingBox(origin, size, size);
        this.pos = origin;
        this.size = size;
    }

    public int getCoin() {return coin;}
    public void setCoin(int coin) {this.coin = coin;}
    public ObjectRender getObjectRender() {return objectRender;}

    public BoundingBox getBounds() { return bounds; }
    public Vector2f getPos() { return pos; }
    public int getSize() { return size; }

    public void use (Player player){}
    public void update(){};

}