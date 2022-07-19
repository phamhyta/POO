package game.data;

import game.game_object.object.item.Arrow;
import game.game_object.object.item.Door;
import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.tile.TileManager;

public class Map01 extends MapAsset {

    public Map01(GameControl gc) {
        super(gc);
        gc.tm = new TileManager("res/tile/beach.xml", gc.cam);
        gc.gameObject.add(new Door(new Vector2f(2240, 1408), 128)); // 35 va 22
        gc.gameObject.add(new Arrow(new Vector2f(2240, 1728), 128)); // 35 va 27
    }

    public void setMonsterPosition() {
        int i = 1;
        SpriteSheet minimonsterSheet = new SpriteSheet("res/entity/minimonsters.png", 16, 16);
        gc.origin[i] = new Vector2f(2000, 500);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 0, 128, 32), 16, 16), 64);
        i++;

        gc.origin[i] = new Vector2f(2250, 750);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 1, 128, 32), 16, 16), 64);
        i++;
        gc.origin[i] = new Vector2f(1200, 1000);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 2, 128, 32), 16, 16), 64);
        i++;
        gc.origin[i] = new Vector2f(1000, 1500);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 3, 128, 32), 16, 16), 64);
        i++;

        SpriteSheet tinyMoonSheet = new SpriteSheet("res/entity/mon1_sprite.png", 50, 50);
        gc.origin[i] = new Vector2f(1400, 1200);
        setTinyMoon( i, gc.origin[i], tinyMoonSheet, 64);
        i++;
        gc.origin[i] = new Vector2f(2250, 1350);
        setTinyMoon( i, gc.origin[i], tinyMoonSheet, 64);
        i++;
        gc.origin[i] = new Vector2f(750, 2400);
        setTinyMoon( i, gc.origin[i], tinyMoonSheet, 64);
        i++;
        gc.origin[i] = new Vector2f(1000, 2000);
        setTinyMoon( i, gc.origin[i], tinyMoonSheet, 64);
        i++;



        gc.origin[i] = new Vector2f(1700, 1350);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 0, 128, 32), 16, 16), 64);
        i++;

        gc.origin[i] = new Vector2f(2250, 1400);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 1, 128, 32), 16, 16), 64);
        i++;
        gc.origin[i] = new Vector2f(1500, 1700);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 2, 128, 32), 16, 16), 64);
        i++;
        gc.origin[i] = new Vector2f(1000, 1500);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 3, 128, 32), 16, 16), 64);
        i++;


        gc.origin[i] = new Vector2f(1400, 1200);
        setTinyMoon( i, gc.origin[i], tinyMoonSheet, 64);
        i++;
        gc.origin[i] = new Vector2f(2250, 1900);
        setTinyMoon( i, gc.origin[i], tinyMoonSheet, 64);
        i++;
        gc.origin[i] = new Vector2f(1600, 1800);
        setTinyMoon( i, gc.origin[i], tinyMoonSheet, 64);
        i++;
        gc.origin[i] = new Vector2f(1900, 1400);
        setTinyMoon( i, gc.origin[i], tinyMoonSheet, 64);
        i++;
    }

    public void setMaterialPosition() {
    }

    public void resetEnemy(int i) {
        SpriteSheet minimonsterSheet = new SpriteSheet("res/entity/minimonsters.png", 16, 16);
        if (i == 0) {
            setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 0, 128, 32), 16, 16), 64);
        } else if (i == 1) {
            setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 1, 128, 32), 16, 16), 64);
        } else if (i == 2) {
            setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 2, 128, 32), 16, 16), 64);
        } else if (i == 3) {
            setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 3, 128, 32), 16, 16), 64);
        } else {
            setTinyMoon( i, gc.origin[i], new SpriteSheet("res/entity/littlegirl.png", 48, 48), 64);
        }
    }

    public void setNPC() {
        int i=0;
        SpriteSheet npcSheet = new SpriteSheet("res/entity/littlegirl.png", 48, 48);
        setNPC( i,new Vector2f(2000, 2000), npcSheet,  64,"Shop");
        i++;
    }
}