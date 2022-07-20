
package game.data;

import game.game_object.enemy.TinyBox;
import game.game_object.enemy.TinyMon;
import game.game_object.enemy.Wizard_BOSS;
import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.render.NPCRender;
import game.render.TinyBoxRender;
import game.render.TinyMonRender;
import game.render.WizardRender;
import game.game_object.npc.NPC;

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

    public void setTinyBox(int i, Vector2f vt, SpriteSheet spriteSheet, int size) {
        TinyBox tiny = new TinyBox(new Vector2f(vt), size);
        gc.enemy[i] = tiny;
        gc.entityRender[i] = new TinyBoxRender(tiny, spriteSheet);
    }
    public void setWizard(int i, Vector2f vt, SpriteSheet spriteSheet, int size) {
        Wizard_BOSS wiz = new Wizard_BOSS(new Vector2f(vt), size);
        gc.enemy[i] = wiz;
        gc.entityRender[i] = new WizardRender(wiz, spriteSheet);
    }

    public void setTinyMoon(int i, Vector2f vt, SpriteSheet spriteSheet, int size) {
        TinyMon tiny = new TinyMon(new Vector2f(vt), size);
        gc.enemy[i] = tiny;
        gc.entityRender[i] = new TinyMonRender(tiny, spriteSheet);
    }

    public void setNPC(int i, Vector2f vt, SpriteSheet spriteSheet, int size,String name) {
        NPC npc = new NPC(vt, size,name);
        gc.npc[i] = npc;
        gc.npcRender[i] = new NPCRender(npc, spriteSheet);
    }
    
    public void setNPC() {
    }
}
