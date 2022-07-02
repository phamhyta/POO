package game.util;

import game.GamePanel;
import game.gameObject.Entity;
import game.math.BoundingBox;
import game.math.Vector2f;
import game.states.PlayState;

import java.awt.Graphics;

public class Camera {

    private BoundingBox collisionCam;

    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    private float dx;
    private float dy;
    private float maxSpeed = 8f;
    private float acc = 3f;
    private float deacc = 0.3f;

    private int widthLimit;
    private int heightLimit;

    private int tileSize = 64;

    private Entity e;

    public Camera(BoundingBox collisionCam) {
        this.collisionCam = collisionCam;
    }

    public void setLimit(int widthLimit, int heightLimit) {
        this.widthLimit = widthLimit;
        this.heightLimit = heightLimit;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public Vector2f getPos() {
        return collisionCam.getPos();
    }
    public BoundingBox getBounds() {
        return collisionCam;
    }

    public void update() {
        move();
        if(e != null) {
            if (!e.xCol) {
                if ((e.getPos().getWorldVar().x + dy) < Vector2f.getWorldVarX(widthLimit - collisionCam.getWidth() / 2) + tileSize
                        && (e.getPos().getWorldVar().x + dy) > Vector2f.getWorldVarX(GamePanel.width / 2 - tileSize * 2)) {
                    PlayState.map.x += dx;
                    collisionCam.getPos().x += dx;
                }
            }
            if (!e.yCol) {
                if ((e.getPos().getWorldVar().y + dy) < Vector2f.getWorldVarY(heightLimit - collisionCam.getHeight() / 2) + tileSize
                        && (e.getPos().getWorldVar().y + dy) > Vector2f.getWorldVarY(GamePanel.height / 2 - tileSize * 2)) {
                    PlayState.map.y += dy;
                    collisionCam.getPos().y += dy;
                }
            }
        } else {
            if(collisionCam.getPos().x + dx > 0
                    && collisionCam.getPos().getWorldVar().x + dx < Vector2f.getWorldVarX(widthLimit - collisionCam.getWidth()) - tileSize) {
                PlayState.map.x += dx;
                collisionCam.getPos().x += dx;
            }

            if(collisionCam.getPos().y + dy > 0
                    && collisionCam.getPos().getWorldVar().y + dy < Vector2f.getWorldVarY(heightLimit - collisionCam.getHeight()) - tileSize) {
                PlayState.map.y += dy;
                collisionCam.getPos().y += dy;
            }
        }
    }

    private void move() {
        if (up) {
            dy -= acc;
            if (dy < -maxSpeed) {
                dy = -maxSpeed;
            }
        } else {
            if (dy < 0) {
                dy += deacc;
                if (dy > 0) {
                    dy = 0;
                }
            }
        }
        if (down) {
            dy += acc;
            if (dy > maxSpeed) {
                dy = maxSpeed;
            }
        } else {
            if (dy > 0) {
                dy -= deacc;
                if (dy < 0) {
                    dy = 0;
                }
            }
        }
        if (left) {
            dx -= acc;
            if (dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else {
            if (dx < 0) {
                dx += deacc;
                if (dx > 0) {
                    dx = 0;
                }
            }
        }
        if (right) {
            dx += acc;
            if (dx > maxSpeed) {
                dx = maxSpeed;
            }
        } else {
            if (dx > 0) {
                dx -= deacc;
                if (dx < 0) {
                    dx = 0;
                }
            }
        }
    }

    public void target(Entity e) {
        this.e = e;
        if(e != null) {
            acc = e.getAcc();
            deacc = e.getDeacc();
            maxSpeed = e.getMaxSpeed();
        } else {
            acc = 3;
            deacc = 0.3f;
            maxSpeed = 8;
        }
    }

    public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed; }

    public void input(MouseHandler mouse, KeyHandler key) {

        if (e == null) {
            if (key.up.down) {
                up = true;
            } else {
                up = false;
            }
            if (key.down.down) {
                down = true;
            } else {
                down = false;
            }
            if (key.left.down) {
                left = true;
            } else {
                left = false;
            }
            if (key.right.down) {
                right = true;
            } else {
                right = false;
            }
        } else {
            if (!e.yCol) {
                if (collisionCam.getPos().y + collisionCam.getHeight() / 2 + dy -120 > e.getPos().y + e.getSize() / 2 + e.getDy() + 2) {
                    up = true;
                    down = false;
                } else if (collisionCam.getPos().y + collisionCam.getHeight() / 2 + dy +20 < e.getPos().y + e.getSize() / 2 + e.getDy() - 2) {
                    down = true;
                    up = false;
                } else {
                    dy = 0;
                    up = false;
                    down = false;
                }
            }

            if (!e.xCol) {
                if (collisionCam.getPos().x + collisionCam.getWidth() / 2  + dx -120> e.getPos().x + e.getSize() / 2 + e.getDx() + 2) {
                    left = true;
                    right = false;
                } else if (collisionCam.getPos().x + collisionCam.getWidth() / 2 + dx +25 < e.getPos().x + e.getSize() / 2 + e.getDx() - 2) {
                    right = true;
                    left = false;
                } else {
                    dx = 0;
                    right = false;
                    left = false;
                }
            }
        }
    }

}