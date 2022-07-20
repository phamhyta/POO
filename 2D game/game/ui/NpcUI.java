package game.ui;

import game.GamePanel;

import game.game_object.npc.NPC;
import game.graphics.Font;
import game.util.KeyHandler;
import game.util.MouseHandler;
import static game.states.GameStateManager.fontf;
import java.awt.Graphics2D;

import java.awt.*;

public class NpcUI {

    private NPC npc;
    public NpcUI(NPC npc) {
        this.npc = npc;
    }

    public void input(MouseHandler mouse, KeyHandler key) {

    }
    
    public void render(Graphics2D g) {
        int width = 1000;
        int height = 300;
        int ScreenX =(int) npc.getPos().x+48;
        int ScreenY =(int) npc.getPos().y-200;
        Color c = new Color(0,0,0,200);
        g.setColor(c);
        g.fillRoundRect((int) npc.getPos().x,(int) npc.getPos().y-height,width,height,35 ,35);
        c = new Color(255, 255, 255,230);
        g.setColor(c);
        g.setStroke(new BasicStroke(5));
        g.drawRoundRect((int) npc.getPos().x+5,(int) npc.getPos().y+5-height,width-10,height-10,25,25);
        if(npc.talk()!=null){
            g.setColor(new Color(255,255,255));
            g.setFont(fontf.getFont("MeatMadness"));
            g.setFont(g.getFont().deriveFont(45F));   
            for(String line: npc.talk().split("\n")){
                g.drawString(line, ScreenX, ScreenY);
                ScreenY+=48;
        }
        }
    }

    public void update(double time) {

    }
}
