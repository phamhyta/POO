
package game.data;

import game.gameObject.enemy.TinyBox;
import game.gameObject.enemy.TinyMon;
import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.render.TinyBoxRender;
import game.render.TinyMonRender;
import game.util.Camera;

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

    public void setTinyBox(Camera camera,int i, Vector2f vt, SpriteSheet spriteSheet, int size){
        TinyBox tiny = new TinyBox( new Vector2f(gc.origin[i]), size);
        gc.enemy[i] = tiny;
        gc.entityRender[i] = new TinyBoxRender(camera,tiny,spriteSheet);
    }
    public void setTinyMoon(Camera camera,int i, Vector2f vt, SpriteSheet spriteSheet,int size){
        TinyMon tiny = new TinyMon(new Vector2f(gc.origin[i]), size);
        gc.enemy[i] = tiny;
        gc.entityRender[i] = new TinyMonRender(camera,tiny,spriteSheet);
    }

    public abstract void setNPC();
}
