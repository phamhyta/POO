package game.gameObject;

import game.graphics.SpriteSheet;
import game.math.BoundingBox;
import game.util.TileCollision;
import game.math.Vector2f;

import java.awt.Graphics2D;


public abstract class GameObject {

    protected SpriteSheet spriteSheet;
    protected BoundingBox bounds;
    protected Vector2f pos;
    protected int size;

    // used for moving objects like boxes and such
    protected float dx;
    protected float dy;

    protected float maxSpeed = 4f;
    protected float acc = 2f;
    protected float deacc = 0.3f;
    protected float force = 25f;

    protected int coin =0;

    protected boolean teleported = false;
	protected TileCollision tc;
	protected String name = "";

    public GameObject(SpriteSheet spriteSheet, Vector2f origin, int size) {
        this(origin,size);
        this.spriteSheet = spriteSheet;
    }
    public GameObject(Vector2f origin,int size) {
        this.bounds = new BoundingBox(origin, size, size);
        this.pos = origin;
        this.size = size;
    }

    public void setPos(Vector2f pos) {
        this.pos = pos;
        this.bounds = new BoundingBox(pos, size, size);
        teleported = true;
    }

	public void setName(String name) { this.name = name; }

    public void setSize(int i) { size = i; }
    public void setMaxSpeed(float f) { maxSpeed = f; }
    public void setAcc(float f) { acc = f; }
    public void setDeacc(float f) { deacc = f; }
    public int getCoin() {return coin;}
    public void setCoin(int coin) {this.coin = coin;}

    public float getDeacc() { return deacc; }
    public float getAcc() { return acc; }
    public float getMaxSpeed() { return maxSpeed; }
    public float getDx() { return dx; }
    public float getDy() { return dy; }
    public BoundingBox getBounds() { return bounds; }
    public Vector2f getPos() { return pos; }
    public int getSize() { return size; }

    public void addForce(float a, boolean vertical) {
        if(!vertical) {
            dx -= a; 
        } else {
            dy -= a;
        }
    }

    public void update() {

    }

    public void render(Graphics2D g) {

    }

}