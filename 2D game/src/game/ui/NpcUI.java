package game.ui;

import game.GamePanel;

import game.gameObject.NPC;
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

    public void drawDialogues(){

        int x = 10*48;
        int y= 10*48;
        int width = 48*3;
        int height = 48*4;
        int count=0;
        drawSubWindow(x,y,width,height);

        x+= 48;
        y+=48;
        g2.drawString("Buy", x, y );
        if(count==0){
            g2.drawString(">",x-24,y);
        }
        y+=48;
        g2.drawString("Slave", x, y );
        if(count==1){
            g2.drawString(">",x-24,y);
        }
        y+=48;
        g2.drawString("Leave", x, y );
        if(count==2){
            g2.drawString(">",x-24,y);
        }
    }

    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0,0,0);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35 ,35);
    }

    public void input(MouseHandler mouse, KeyHandler key) {
    }

    public void render(Graphics2D g) {

    }

    public void update(double time) {
    }
}
