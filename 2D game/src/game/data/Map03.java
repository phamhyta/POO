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
        int i = 1;
        SpriteSheet wizardSheet = new SpriteSheet("res/entity/boss_wizard/Idle.png", 110, 110);
        gc.origin[i] = new Vector2f(500, 500);
        setWizard( i, gc.origin[i], wizardSheet, 156);
        i++;


        SpriteSheet minimonsterSheet = new SpriteSheet("res/entity/minimonsters.png", 16, 16);
        gc.origin[i] = new Vector2f(2000, 750);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 0, 128, 32), 16, 16), 64);
        i++;

        gc.origin[i] = new Vector2f(2250, 750);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 1, 128, 32), 16, 16), 64);
        i++;
        gc.origin[i] = new Vector2f(1200, 1000);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 2, 128, 32), 16, 16), 64);
        i++;
        gc.origin[i] = new Vector2f(1000, 500);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 3, 128, 32), 16, 16), 64);
        i++;

        SpriteSheet tinyMoonSheet = new SpriteSheet("res/entity/littlegirl.png", 48, 48);
        gc.origin[i] = new Vector2f(1400, 1200);
        setTinyMoon( i, gc.origin[i], tinyMoonSheet, 64);
        i++;
        gc.origin[i] = new Vector2f(2500, 1350);
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
        gc.origin[i] = new Vector2f(2500, 1900);
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
