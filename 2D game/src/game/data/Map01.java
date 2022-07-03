package game.data;

import game.gameObject.object.Items.Door;
import game.gameObject.object.Arrow;
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
        int i = 0;
        SpriteSheet minimonsterSheet = new SpriteSheet("res/entity/minimonsters.png", 16, 16);
        gc.origin[i] = new Vector2f(500.0F, 500.0F);
        setTinyBox(i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 0, 128, 32), 16, 16), 64);
        i++;

        gc.origin[i] = new Vector2f(600.0F, 600.0F);
        setTinyBox(i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 1, 128, 32), 16, 16), 64);
        i++;
        gc.origin[i] = new Vector2f(550.0F, 550.0F);
        setTinyBox(i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 2, 128, 32), 16, 16), 64);
        i++;
        gc.origin[i] = new Vector2f(570.0F, 590.0F);
        setTinyBox(i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 3, 128, 32), 16, 16), 64);
        i++;

        SpriteSheet tinyMoonSheet = new SpriteSheet("res/entity/littlegirl.png", 48, 48);
        gc.origin[i] = new Vector2f(1070.0F, 1070.0F);
        setTinyMoon(i, gc.origin[i], tinyMoonSheet, 64);
        i++;
        gc.origin[i] = new Vector2f(1000.0F, 1000.0F);
        setTinyMoon(i, gc.origin[i], tinyMoonSheet, 64);
        i++;
        gc.origin[i] = new Vector2f(1500.0F, 1500.0F);
        setTinyMoon(i, gc.origin[i], tinyMoonSheet, 64);
        i++;
        gc.origin[i] = new Vector2f(700.0F, 1000.0F);
        setTinyMoon(i, gc.origin[i], tinyMoonSheet, 64);
        i++;
    }

    public void setMaterialPosition() {
    }

    public void resetEnemy(int i) {
        SpriteSheet minimonsterSheet = new SpriteSheet("res/entity/minimonsters.png", 16, 16);
        if (i == 0) {
            setTinyBox(i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 0, 128, 32), 16, 16), 64);
        } else if (i == 1) {
            setTinyBox(i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 1, 128, 32), 16, 16), 64);
        } else if (i == 2) {
            setTinyBox(i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 2, 128, 32), 16, 16), 64);
        } else if (i == 3) {
            setTinyBox(i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 3, 128, 32), 16, 16), 64);
        } else {
            setTinyMoon(i, gc.origin[i], new SpriteSheet("res/entity/littlegirl.png", 48, 48), 64);
        }
    }

    public void setNPC() {
        int i = 0;
        SpriteSheet npcSheet = new SpriteSheet("res/entity/littlegirl.png", 48, 48);
        setNPC(i,new Vector2f(1500, 300), npcSheet, 64);
        i++;
    }
}