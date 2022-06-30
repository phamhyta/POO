package game.render;

import game.graphics.SpriteSheet;
import game.math.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ObjectRender {
    private BufferedImage image;
    private int size;
    private Vector2f pos;
    private SpriteSheet spriteSheet;

    public ObjectRender(Vector2f pos, int row, int col, int size){
        spriteSheet = new SpriteSheet("res/ui/items.png");
        image =  spriteSheet.getSubimage(col*32,row*32,32,32);
        this.size= size;
        this.pos=pos;
    }

    public BufferedImage getImage(){
        return image;
    }

    public void render(Graphics2D g){
        g.drawImage(image,(int)pos.getWorldVar().x,(int)pos.getWorldVar().y,size,size, null);
    }
    public BufferedImage getimage(){
        return image;
    }
}

