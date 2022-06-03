package game.gameObject.monster;
import game.data.GameControl;
import game.gameObject.Entity;
import game.gameObject.Player;
import game.gameObject.object.OBJ_Coin_Bronze;
import game.gameObject.object.OBJ_Door;
import game.gameObject.object.OBJ_ManaCrystal;
import game.gameObject.object.OBJ_Potion_Red;
import game.graphics.Animation;
import game.math.AABB;
import game.util.Camera;
import game.math.Vector2f;

public class Enemy extends Entity {

    protected AABB sense;
    protected int r_sense;
    protected AABB attackrange;
    protected int r_attackrange;
    protected int r_enemyArea;
    public Camera cam;
    protected int xOffset;
    protected int yOffset;

    public boolean useRight = false;

    public Enemy(Camera cam, Vector2f origin, int size) {
        super(origin, size);
        this.cam = cam;

        damage = 10;
        acc = 1f;
        deacc = 2f;
        maxSpeed = 2f;
        r_sense = 350;
        r_attackrange = 32;
        r_enemyArea= 500;

        bounds.setWidth(42);
        bounds.setHeight(20);
        bounds.setXOffset(12);
        bounds.setYOffset(40);

        sense = new AABB(new Vector2f(origin.x + size / 2 - r_sense / 2, origin.y + size / 2 - r_sense / 2), r_sense);
        attackrange = new AABB(new Vector2f(origin.x + bounds.getXOffset() + bounds.getWidth() / 2 - r_attackrange / 2,
                origin.y + bounds.getYOffset() + bounds.getHeight() / 2 - r_attackrange / 2), r_attackrange);
    }


    public void reset(){
        health = maxHealth;
        healthpercent = health / maxHealth;
    }

    public void drop() {
        GameControl.materialGame.add(new OBJ_Coin_Bronze((new Vector2f(this.getPos().x,this.getPos().y)),32, this.coin));
        GameControl.materialGame.add(new OBJ_ManaCrystal(new Vector2f(this.getPos().x-50,this.getPos().y),32));
        GameControl.materialGame.add(new OBJ_Potion_Red(new Vector2f(this.getPos().x-20,this.getPos().y),32));
        int rand = (int) (Math.random()*75);
        if(rand<15){
            GameControl.materialGame.add(new OBJ_Door(new Vector2f(this.getPos().x,this.getPos().y),32));
            }
        else if(rand<50 && rand >= 15){
            GameControl.materialGame.add(new OBJ_ManaCrystal(new Vector2f(this.getPos().x+25,this.getPos().y),32));}
        else if(rand>=50 && rand <=75) {
            GameControl.materialGame.add(new OBJ_Potion_Red(new Vector2f(this.getPos().x-50,this.getPos().y),32));
            GameControl.materialGame.add(new OBJ_ManaCrystal(new Vector2f(this.getPos().x+25,this.getPos().y),32));
        }
//        if(75<rand && rand <=100) {new OBJ_Item}
    }
    private void autoDirecting(Vector2f posA, Vector2f posB){
        if (posA.y > posB.y + 1) {
            up = true;
        } else {
            up = false;
        }
        if (posA.y < posB.y - 1) {
            down = true;
        } else {
            down = false;
        }

        if (posA.x > posB.x + 1) {
            left = true;
        } else {
            left = false;
        }
        if (posA.x < posB.x - 1) {
            right = true;
        } else {
            right = false;
        }
    }
    private void stopDirecting(){
        up = false;
        down = false;
        left = false;
        right = false;
    }

    private void chase(Player player) {
        AABB playerBounds = player.getBounds();
        if (sense.colCircleBox(playerBounds) && !attackrange.colCircleBox(player.getBounds())) {
            autoDirecting(this.pos, player.getPos());
        } else {
            stopDirecting();
        }
    }

    public void moveBack(Vector2f center) {
        if (this.pos.x!=center.x || this.pos.y!= center.y) {
            autoDirecting(pos,center);
        }
        else {
            stopDirecting();
        }
    }

    public void moveInCircle(Vector2f center,double r, Player player) {
        if(this.isInCirclePath(center,r) && sense.colCircleBox(player.getBounds())
                && !player.isInCircle(center,r)){
            dx=0;
            dy=0;
            stopDirecting();
        }
        else {
            if (this.isInCircle(center, r)) {
                if (sense.colCircleBox(player.getBounds())) {
                    this.chase(player);
                } else {
                    reset();
                    this.moveBack(center);
                }
            } else {
                this.moveBack(center);
            }
            move();
        }

    }

    public void update(Player player, double time, Vector2f defaultPosition) {
        if (cam.getBounds().collides(this.bounds)) {
            super.update(time);
            moveInCircle(defaultPosition,r_enemyArea,player);

            if(teleported) {
                teleported = false;

                bounds.setWidth(size / 2);
                bounds.setHeight(size / 2 - yOffset);
                bounds.setXOffset(size / 2 - xOffset);
                bounds.setYOffset(size / 2 + yOffset);

                hitBounds = new AABB(pos, size, size);
                hitBounds.setXOffset(size / 2);

                sense = new AABB(new Vector2f(pos.x + size / 2 - r_sense / 2, pos.y + size / 2 - r_sense / 2), r_sense);
                attackrange = new AABB(new Vector2f(pos.x + bounds.getXOffset() + bounds.getWidth() / 2 - r_attackrange / 2 , pos.y + bounds.getYOffset() + bounds.getHeight() / 2 - r_attackrange / 2 ), r_attackrange);
            }

            if (attackrange.colCircleBox(player.getBounds()) && !isInvincible) {
                attack = true;
                player.setHealth(player.getHealth() - damage, 5f * getDirection(), currentDirection == UP || currentDirection == DOWN);
            } else {
                attack = false;
            }

            if (!fallen) {
                if (!tc.collisionTile(dx, 0)) {
                    sense.getPos().x += dx;
                    attackrange.getPos().x += dx;
                    pos.x += dx;
                }
                if (!tc.collisionTile(0, dy)) {
                    sense.getPos().y += dy;
                    attackrange.getPos().y += dy;
                    pos.y += dy;
                }
            } else {
                if (Animation.hasPlayedOnce()) {
                    die = true;
                }
            }
        }
    }



}