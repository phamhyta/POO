package game.render;

import game.gameObject.npc.NPC;
import game.graphics.SpriteSheet;
import game.util.Camera;
import java.awt.*;

public class NPCRender extends EntityRender {
    private NPC npc;


    public NPCRender(NPC npc, SpriteSheet spriteSheet) {
        super(npc, spriteSheet);
        this.npc = npc;
        ATTACK_DOWN = 1;
        ATTACK_UP = 1;
        ATTACK_LEFT = 1;
        ATTACK_RIGHT = 1;
        SKILL_UP=1;
        SKILL_DOWN=1;
        SKILL_LEFT=1;
        SKILL_RIGHT=1;
        IDLE = 0;
        FALLEN = 1;
        UP = 1;
        DOWN = 1;
        LEFT = 1;
        RIGHT = 1;
    }


    public void update() {
        super.update();
    }

    public void render(Graphics2D g) {
        super.render(g);
        g.setColor(Color.green);
        g.drawString("Shop",(int) (npc.getPos().getWorldVar().x + npc.getBounds().getXOffset())-25, (int) (npc.getPos().getWorldVar().y));
    }

}

