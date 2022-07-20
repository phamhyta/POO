package game.game_object.enemy;

import game.data.GameControl;
import game.game_object.Entity;
import game.game_object.Player;
import game.game_object.object.item.Potion_Blue_1;
import game.game_object.object.item.Shield_2;
import game.game_object.object.item.Coin;
import game.game_object.object.item.Potion_Red_1;
import game.graphics.Animation;
import game.math.BoundingBox;
import game.math.Vector2f;

public class Enemy extends Entity {

    protected BoundingBox sense;
    protected int r_sense;
    protected BoundingBox attackrange;
    protected int r_attackrange;
    protected int r_enemyArea;
    protected int xOffset;
    protected int yOffset;

    protected float dropRate;
    public boolean useRight = false;

    public Enemy(Vector2f origin, int size) {
        super(origin, size);
        damage = 10;
        acc = 1f;
        deacc = 2f;
        maxSpeed = 2f;
        r_sense = 350;
        r_attackrange = 32;
        r_enemyArea = 500;
        bounds.setWidth(20);
        bounds.setHeight(20);
        bounds.setXOffset(20);
        bounds.setYOffset(20);

        sense = new BoundingBox(new Vector2f(origin.x + size / 2 - r_sense / 2, origin.y + size / 2 - r_sense / 2),
                r_sense);
        attackrange = new BoundingBox(
                new Vector2f(origin.x + bounds.getXOffset() + bounds.getWidth() / 2 - r_attackrange / 2,
                        origin.y + bounds.getYOffset() + bounds.getHeight() / 2 - r_attackrange / 2),
                r_attackrange);
    }

    public void drop() {

    }

    private void chase(Player player) {
        BoundingBox playerBounds = player.getBounds();
        if (sense.colCircleBox(playerBounds) && !attackrange.colCircleBox(player.getBounds())) {
            moveInPath(player);
        } else {
            stopDirecting();
        }
    }

    public void moveBack(Vector2f center) {
        if (this.pos.x != center.x || this.pos.y != center.y) {
            moveInPath(center);
        } else {
            stopDirecting();
        }
    }

    public void moveInCircle(Vector2f center, double r, Player player) {
        if (this.isInCirclePath(center, r) && sense.colCircleBox(player.getBounds())
                && !player.isInCircle(center, r)) {
            dx = 0;
            dy = 0;
            stopDirecting();
        } else {
            if (this.isInCircle(center, r) && sense.colCircleBox(player.getBounds())) {this.chase(player);}
            else {this.moveBack(center);}
            move();
        }
    }

    public void update(Player player, double time, Vector2f defaultPosition) {
        super.update(time);
        sense = new BoundingBox(new Vector2f(pos.x + size / 2 - r_sense / 2, pos.y + size / 2 - r_sense / 2), r_sense);
        moveInCircle(defaultPosition, r_enemyArea, player);

        if (teleported) {
            teleported = false;

            bounds.setWidth(size / 2);
            bounds.setHeight(size / 2 - yOffset);
            bounds.setXOffset(size / 2 - xOffset);
            bounds.setYOffset(size / 2 + yOffset);
            hitBounds = new BoundingBox(pos, size, size);
            hitBounds.setXOffset(size / 2);

            sense = new BoundingBox(new Vector2f(pos.x + size / 2 - r_sense / 2, pos.y + size / 2 - r_sense / 2),
                    r_sense);
            attackrange = new BoundingBox(
                    new Vector2f(pos.x + bounds.getXOffset() + bounds.getWidth() / 2 - r_attackrange / 2,
                            pos.y + bounds.getYOffset() + bounds.getHeight() / 2 - r_attackrange / 2),
                    r_attackrange);
        }

        if (attackrange.colCircleBox(player.getBounds()) && !isInvincible) {
            attacking = true;
            player.setHealth(player.getHealth() - damageCaculate(player), 5f * getDirection(),
                    currentDirection == UP || currentDirection == DOWN);
        } else {
            attacking = false;
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