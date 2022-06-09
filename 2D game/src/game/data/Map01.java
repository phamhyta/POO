package game.data;


import game.gameObject.monster.TinyBox;
import game.gameObject.monster.TinyMon;
import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.tile.TileManager;

public class Map01 extends MapAsset {
    public Map01(GameControl gc) {
        super(gc);
        gc.tm = new TileManager("res/tile/tilemap.xml", gc.cam);
    }

    public void setMonsterPosition() {
        int i = 0;
        SpriteSheet minimonsterSheet = new SpriteSheet("res/entity/minimonsters.png", 16, 16);
        this.gc.origin[i] = new Vector2f(500.0F, 500.0F);
        this.gc.enemy[i] = new TinyBox(this.gc.cam, new SpriteSheet(minimonsterSheet.getSprite(0, 0, 128, 32), 16, 16), new Vector2f(this.gc.origin[i]), 64);
        i ++;
        this.gc.origin[i] = new Vector2f(600.0F, 600.0F);
        this.gc.enemy[i] = new TinyBox(this.gc.cam, new SpriteSheet(minimonsterSheet.getSprite(0, 1, 128, 32), 16, 16), new Vector2f(this.gc.origin[i]), 64);
        ++i;
        this.gc.origin[i] = new Vector2f(550.0F, 550.0F);
        this.gc.enemy[i] = new TinyBox(this.gc.cam, new SpriteSheet(minimonsterSheet.getSprite(0, 2, 128, 32), 16, 16), new Vector2f(this.gc.origin[i]), 64);
        ++i;
        this.gc.origin[i] = new Vector2f(570.0F, 590.0F);
        this.gc.enemy[i] = new TinyBox(this.gc.cam, new SpriteSheet(minimonsterSheet.getSprite(0, 3, 128, 32), 16, 16), new Vector2f(this.gc.origin[i]), 64);
        ++i;
        this.gc.origin[i] = new Vector2f(1070.0F, 1070.0F);
        this.gc.enemy[i] = new TinyMon(this.gc.cam, new SpriteSheet("res/entity/littlegirl.png", 48, 48), new Vector2f(this.gc.origin[i]), 64);
        ++i;
        this.gc.origin[i] = new Vector2f(1000.0F, 1000.0F);
        this.gc.enemy[i] = new TinyMon(this.gc.cam, new SpriteSheet("res/entity/littlegirl.png", 48, 48), new Vector2f(this.gc.origin[i]), 64);
        ++i;
        this.gc.origin[i] = new Vector2f(1500.0F, 1500.0F);
        this.gc.enemy[i] = new TinyMon(this.gc.cam, new SpriteSheet("res/entity/littlegirl.png", 48, 48), new Vector2f(this.gc.origin[i]), 64);
        ++i;
        this.gc.origin[i] = new Vector2f(700.0F, 1000.0F);
        this.gc.enemy[i] = new TinyMon(this.gc.cam, new SpriteSheet("res/entity/littlegirl.png", 48, 48), new Vector2f(this.gc.origin[i]), 64);
    }

    public void setMaterialPosition() {
    }

    public void resetEnemy(int i) {
        SpriteSheet minimonsterSheet = new SpriteSheet("res/entity/minimonsters.png", 16, 16);
        if (i < 2) {
            this.gc.enemy[i] = new TinyBox(this.gc.cam, new SpriteSheet(minimonsterSheet.getSprite(0, 0, 128, 32), 16, 16), new Vector2f(this.gc.origin[i]), 64);
        } else if (i < 4) {
            this.gc.enemy[i] = new TinyBox(this.gc.cam, new SpriteSheet(minimonsterSheet.getSprite(0, 1, 128, 32), 16, 16), new Vector2f(this.gc.origin[i]), 64);
        } else {
            this.gc.enemy[i] = new TinyMon(this.gc.cam, new SpriteSheet("res/entity/littlegirl.png", 48, 48), new Vector2f(this.gc.origin[i]), 64);
        }

    }

    public void setNPC() {
    }
}
