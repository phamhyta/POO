package game.gameObject;
import game.data.AssetSetter;
import game.gameObject.object.OBJ_Coin_Bronze;
import game.gameObject.object.OBJ_Door;
import game.gameObject.object.OBJ_ManaCrystal;
import game.gameObject.object.OBJ_Potion_Red;
import game.graphics.SpriteSheet;
import game.math.AABB;
import game.util.Camera;
import game.math.Vector2f;

import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy extends Entity {

    protected AABB sense;
    protected int r_sense;
    protected AABB attackrange;
    protected int r_attackrange;
    protected int r_enemyArea;
    protected Camera cam;
    protected int xOffset;
    protected int yOffset;

    public boolean useRight = false;

    public Enemy(Camera cam, SpriteSheet spriteSheet, Vector2f origin, int size) {
        super(spriteSheet, origin, size);
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
        AssetSetter.materialGame.add(new OBJ_Coin_Bronze((new Vector2f(this.getPos().x,this.getPos().y)),32, this.coin));
        AssetSetter.materialGame.add(new OBJ_ManaCrystal(new Vector2f(this.getPos().x-50,this.getPos().y),32));
        AssetSetter.materialGame.add(new OBJ_Potion_Red(new Vector2f(this.getPos().x-20,this.getPos().y),32));
        int rand = (int) (Math.random()*75);
        if(rand<15){
            AssetSetter.materialGame.add(new OBJ_Door(new Vector2f(this.getPos().x,this.getPos().y),32));
            }
        else if(rand<50 && rand >= 15){
            AssetSetter.materialGame.add(new OBJ_ManaCrystal(new Vector2f(this.getPos().x+25,this.getPos().y),32));}
        else if(rand>=50 && rand <=75) {
            AssetSetter.materialGame.add(new OBJ_Potion_Red(new Vector2f(this.getPos().x-50,this.getPos().y),32));
            AssetSetter.materialGame.add(new OBJ_ManaCrystal(new Vector2f(this.getPos().x+25,this.getPos().y),32));
        }
//        if(75<rand && rand <=100) {new OBJ_Item}
    }
    private void chase(Player player) {
        AABB playerBounds = player.getBounds();
        if (sense.colCircleBox(playerBounds) && !attackrange.colCircleBox(playerBounds)) {
            if (pos.y > player.pos.y + 1) {
                up = true;
            } else {
                up = false;
            }
            if (pos.y < player.pos.y - 1) {
                down = true;
            } else {
                down = false;
            }

            if (pos.x > player.pos.x + 1) {
                left = true;
            } else {
                left = false;
            }
            if (pos.x < player.pos.x - 1) {
                right = true;
            } else {
                right = false;
            }
        } else {
            up = false;
            down = false;
            left = false;
            right = false;
        }
    }



    public void moveBack(Vector2f center) {
        if (this.pos.x!=center.x || this.pos.y!= center.y) {
            if (pos.y > center.y + 1) {
                up = true;
            } else {
                up = false;
            }
            if (pos.y < center.y - 1) {
                down = true;
            } else {
                down = false;
            }

            if (pos.x > center.x + 1) {
                left = true;
            } else {
                left = false;
            }
            if (pos.x < center.x - 1) {
                right = true;
            } else {
                right = false;
            }
        }
        else {
            up = false;
            down = false;
            right = false;
            left = false;
        }
    }

    public void moveInCircle(Vector2f center,double r, Player player) {
        if(this.isInCirclePath(center,r) && sense.colCircleBox(player.getBounds())
                && !player.isInCircle(center,r)){
            dx=0;
            dy=0;
            up = false;
            down = false;
            right = false;
            left = false;
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
                if (ani.hasPlayedOnce()) {
                    die = true;
                }
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        if (cam.getBounds().collides(this.bounds)) {

            g.drawImage(ani.getImage().image, (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
            // Health Bar UI
            g.setColor(Color.red);
            g.fillRect((int) (pos.getWorldVar().x + bounds.getXOffset()) +10, (int) (pos.getWorldVar().y - 5), 24, 5);

            g.setColor(Color.green);
            g.fillRect((int) (pos.getWorldVar().x + bounds.getXOffset()) +10, (int) (pos.getWorldVar().y - 5), (int) (24 * healthpercent), 5);

        }

    }
}