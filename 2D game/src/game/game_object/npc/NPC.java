package game.game_object.npc;

import game.game_object.Entity;
import game.graphics.SpriteSheet;
import game.math.BoundingBox;
import game.math.Vector2f;
import game.render.TxtAndImageRender;
import game.states.GameStateManager;
import game.util.KeyHandler;
import game.util.MouseHandler;

import java.awt.*;

public class NPC extends Entity{
    protected BoundingBox sense;
    protected int r_sense;
    protected int xOffset;
    protected int yOffset;
    protected String conversation[];
    protected Graphics2D g2;
    protected String name;
    protected boolean talking;
    protected int currenConversation;
    public NPC(Vector2f origin, int size,String name){
        super(origin, size);
        xOffset = size / 4;
        yOffset = size / 4;
        r_sense = 30;
        this.currenConversation = -1;
        canAttack = false;
        this.talking = false;
        attacking = false;
        bounds.setWidth(42);
        bounds.setHeight(20);
        bounds.setXOffset(16);
        bounds.setYOffset(40);
        this.name = name;
        this.conversation = new String [20];
        sense = new BoundingBox(new Vector2f(origin.x + size / 2 - r_sense / 2, origin.y + size / 2 - r_sense / 2), r_sense);
    }
    public void update(double time){}
    public void input(MouseHandler mouse, KeyHandler key) {
        key.enter.tick();
            if(key.enter.clicked){
                this.talking = true;
                this.currenConversation++;
            }
    }
    public String getName(){
        return this.name;
    }
    public void setTalk(int i, String name){
        this.conversation[i] = name;
    }

    public String talk(){
        return this.conversation[currenConversation];
    }
    public boolean isTalking(){
        return this.talking;
    }
    public int getCurrentConversation(){
        return this.currenConversation;
    }
    public void setTalk(boolean talk){
        this.talking = talk;
    }
}
