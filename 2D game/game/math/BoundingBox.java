package game.math;

import game.game_object.Entity;

public class BoundingBox {
    private Vector2f pos;
    private float xOffset =0;
    private float yOffset =0;
    private float w;
    private float h;
    private float r;
    private int size;
    private Entity e;

    //BOX
    public BoundingBox(Vector2f pos, int w, int h){
        this.pos=pos;
        this.w=w;
        this.h=h;
        size = Math.max(w,h);
    }
    //CIRCLE
    public BoundingBox(Vector2f pos, int r){
        this.pos= pos;
        this.r =r;
        size =r;
    }
    public Vector2f getPos(){ return pos;}
    public float getRadius(){ return r;}
    public float getWidth(){ return w;}
    public float getHeight(){ return h;}

    public void setBox(Vector2f pos, int w, int h){
        this.pos = pos;
        this.w=w;
        this.h=h;
        size = Math.max(w,h);
    }
    public void setCircle(Vector2f pos, int r, Entity e){
        this.pos= pos;
        this.r =r;
        this.e =e;
        size =r;
    }
    public void setWidth(float f){ w=f ;}
    public void setHeight(float f) { h = f; }

    public void setXOffset(float f) { xOffset = f; }
    public void setYOffset(float f) { yOffset = f; }
    public float getXOffset() { return xOffset; }
    public float getYOffset() { return yOffset; }
    public void setPos(Vector2f pos) {this.pos = pos;}


    public float distance(Vector2f other) {
        float dx = pos.x - other.x;
        float dy = pos.y - other.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public boolean collides(BoundingBox bBox){
        float ax= ((pos.getWorldVar().x + (xOffset))+ (this.w/2));
        float ay= ((pos.getWorldVar().y + (yOffset))+ (this.h/2));
        float bx= ((bBox.getPos().getWorldVar().x + (bBox.xOffset))+ (bBox.getWidth()/2));
        float by= ((bBox.getPos().getWorldVar().y + (bBox.yOffset))+ (bBox.getHeight()/2));

        if (Math.abs(ax - bx) < (this.w / 2) + (bBox.getWidth() / 2)) {
            if (Math.abs(ay - by) < (this.h / 2) + (bBox.getHeight() / 2)) {
                return true;
            }
        }
        return false;
    }

    public boolean colCircleBox(BoundingBox aBox) {
        float dx= Math.max(aBox.getPos().getWorldVar().x + aBox.getXOffset(),Math.min(pos.getWorldVar().x +(r/2),aBox.getPos().getWorldVar().x +aBox.getXOffset()+ aBox.getWidth()));
        float dy= Math.max(aBox.getPos().getWorldVar().y + aBox.getYOffset(),Math.min(pos.getWorldVar().y +(r/2),aBox.getPos().getWorldVar().y +aBox.getYOffset()+ aBox.getHeight()));

        dx= pos.getWorldVar().x+(r/2) -dx;
        dy= pos.getWorldVar().y+(r/2) -dy;

        if(Math.sqrt(dx*dx+dy*dy)< r/2){
            return true;
        }
        return false;
    }

    public boolean inside(int xp, int yp) {
        if(xp == -1 || yp == - 1) return false;

        int wTemp = (int) this.w;
        int hTemp = (int) this.h;
        int x = (int) this.pos.x;
        int y = (int) this.pos.y;

        if(xp < x || yp < y) {
            return false;
        }

        wTemp += x;
        hTemp += y;
        return ((wTemp < x || wTemp > xp) && (hTemp < y || hTemp > yp));
    }
}
