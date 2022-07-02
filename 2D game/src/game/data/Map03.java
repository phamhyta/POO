package game.data;

import game.gameObject.enemy.TinyMon;
import game.gameObject.object.Door;
import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.tile.TileManager;

public class Map03 extends MapAsset {

    public Map03(GameControl gc) {
        super(gc);
        gc.tm = new TileManager("res/tile/nature.xml", gc.cam);
        gc.gameObject.add(new Door(new Vector2f(1500,2000),128));
    }

    public void setMonsterPosition() {
        int i = 0;
        SpriteSheet minimonsterSheet = new SpriteSheet("res/entity/minimonsters.png", 16, 16);
        gc.origin[i] = new Vector2f(500.0F, 500.0F);
        setTinyBox(i,gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 0, 128, 32), 16, 16),64);
        i ++;

        gc.origin[i] = new Vector2f(600.0F, 600.0F);
        setTinyBox(i,gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 1, 128, 32), 16, 16),64);
        i ++;
        gc.origin[i] = new Vector2f(550.0F, 550.0F);
        setTinyBox(i,gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 2, 128, 32), 16, 16),64);
        i ++;
        gc.origin[i] = new Vector2f(570.0F, 590.0F);
        setTinyBox(i,gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 3, 128, 32), 16, 16),64);
        i ++;

        SpriteSheet tinyMoonSheet = new SpriteSheet("res/entity/littlegirl.png", 48, 48);
        gc.origin[i] = new Vector2f(1070.0F, 1070.0F);
        setTinyMoon( i,gc.origin[i], tinyMoonSheet,  64);
        i++;
        gc.origin[i] = new Vector2f(1000.0F, 1000.0F);
        setTinyMoon( i,gc.origin[i], tinyMoonSheet,  64);
        i++;
        gc.origin[i] = new Vector2f(1500.0F, 1500.0F);
        setTinyMoon( i,gc.origin[i], tinyMoonSheet,  64);
        i++;
        gc.origin[i] = new Vector2f(700.0F, 1000.0F);
        setTinyMoon( i,gc.origin[i], tinyMoonSheet,  64);
        i++;
    }

    public void setMaterialPosition() {
    }


    public void resetEnemy(int i) {
        SpriteSheet minimonsterSheet = new SpriteSheet("res/entity/minimonsters.png", 16, 16);
        if (i == 0) {
            setTinyBox(i,gc.origin[i],new SpriteSheet(minimonsterSheet.getSprite(0, 0, 128, 32), 16, 16),64 );
        } else if (i == 1) {
            setTinyBox(i,gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 1, 128, 32), 16, 16),64);
        } else if (i == 2) {
            setTinyBox(i,gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 2, 128, 32), 16, 16),64);
        } else if (i == 3) {
            setTinyBox(i,gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 3, 128, 32), 16, 16),64);
        } else {
            setTinyMoon(i,gc.origin[i], new SpriteSheet("res/entity/littlegirl.png", 48, 48),  64);
        }
    }

    public void setNPC() {
        int i=0;
        SpriteSheet npcSheet = new SpriteSheet("res/entity/littlegirl.png", 48, 48);
        gc.origin[i] = new Vector2f(200.0F, 200.0F);
        setNPC(i,gc.origin[i], npcSheet,  64);
        i++;
    }
}
