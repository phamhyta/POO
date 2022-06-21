package game.ui;

import game.GamePanel;

import game.gameObject.npc.NPC;
import game.util.KeyHandler;
import game.util.MouseHandler;

import java.awt.Graphics2D;

import java.awt.*;

public class NpcUI {

    private NPC npc;
    private Graphics2D g2;
    private GamePanel gp;
    private KeyHandler key;

    public NpcUI(NPC npc) {
        this.npc = npc;

    }

    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0,0,0);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35 ,35);
    }

    public void input(MouseHandler mouse, KeyHandler key) {
    }

    public void render(Graphics2D g) {
        Color c = new Color(0,0,0);
        g2.setColor(c);
        g2.fillRoundRect(100,100,100,100,35 ,35);
        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(100+5, 100+5,100-10,100-10,25,25);
    }

    public void update(double time) {
    }
}
