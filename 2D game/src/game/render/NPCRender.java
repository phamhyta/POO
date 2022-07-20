package game.render;

import game.game_object.npc.NPC;
import game.graphics.SpriteSheet;

import java.awt.*;

public class NPCRender extends EntityRender {
    private NPC npc;
    public NPCRender(NPC npc, SpriteSheet spriteSheet) {
        super(npc, spriteSheet);
        this.npc = npc;
    }
    
    public void update() {
        super.update();
    }

    public void render(Graphics2D g) {
        super.render(g);
        // g.setFont(new Font("NewellsHand", Font.PLAIN, 32));
        // g.setColor(Color.green);
        // g.drawString("Shop",(int) (npc.getPos().getWorldVar().x + npc.getBounds().getXOffset())-25, (int) (npc.getPos().getWorldVar().y));
    }


}

