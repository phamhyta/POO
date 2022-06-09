
package game.data;

import game.gameObject.monster.TinyBox;
import game.gameObject.monster.TinyMon;
import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.render.TinyBoxRender;
import game.render.TinyMonRender;

public abstract class MapAsset {
    protected GameControl gc;
    public MapAsset(GameControl gc) {
        this.gc = gc;
        this.setMonsterPosition();
        this.setMaterialPosition();
        this.setNPC();
    }

    protected abstract void setMonsterPosition();

    public abstract void setMaterialPosition();

    public abstract void resetEnemy(int i);

    public void setTinyBox(int i, Vector2f vt, SpriteSheet spriteSheet,int size){
        TinyBox tiny = new TinyBox(this.gc.cam, new Vector2f(gc.origin[i]), size);
        gc.enemy[i] = tiny;
        gc.enemyRender[i] = new TinyBoxRender(tiny,spriteSheet);
    }
    public void setTinyMoon(int i, Vector2f vt, SpriteSheet spriteSheet,int size){
        TinyMon tiny = new TinyMon(this.gc.cam, new Vector2f(gc.origin[i]), size);
        gc.enemy[i] = tiny;
        gc.enemyRender[i] = new TinyMonRender(tiny,spriteSheet);
    }

    public abstract void setNPC();
}
