package game.ui;
import game.GamePanel;

import game.util.KeyHandler;
import game.util.MouseHandler;
import game.gameObject.Entity;
import game.math.Vector2f;
import game.gameObject.object.GameObject;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import game.gameObject.Player;
import java.util.ArrayList;
import java.awt.*;
public class InventoryUI {
    private Graphics2D g2;
    private GamePanel gp;
    private MouseHandler mouse;
    private KeyHandler key;
    private BufferedImage[] bar;
    private int commandNum=0;
    private int function = 0;
    public int shop = 0;
    public int act = 0;
    private int slotCol = 0;
    private int slotRow = 0;
    // private Entity e;
    private Player p;
    public ArrayList<GameObject> inventory; 
    // private Vector2f pos;
    // private int size;
    // private int length;

    private int energyLength;

    // private int barWidthRatio;
    // private int energyWidthRatio;

    // private int barHeightRatio;
    // private float percent;
    public InventoryUI(Player p, BufferedImage[] sprite, Vector2f pos, int size, int length, float percent) {
        this.p = p;
        this.bar = sprite;
        // this.pos = pos;
        // this.size = size;
        // this.length = length;
        // this.percent= percent;
        this.inventory = p.inventory;
        // this.energyLength = (int) ((bar[0].getWidth() + size) * (length * p.getHealthPercent()));
        // this.barWidthRatio = (bar[0].getWidth() + size) * length / (bar[0].getWidth());
        // this.energyWidthRatio = energyLength / (bar[0].getWidth());
        // this.barHeightRatio = (bar[0].getHeight() + size) / bar[0].getHeight();
    }
    public void drawSubWindow(Graphics2D g2, int x, int y, int width, int height){
        Color c = new Color(0,0,0);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35 ,35);
        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5,width-10,height-10,25,25);
    }
    public void render(Graphics2D g2) {
        if(shop != 0){
            int x = 850;
            int y= 400;
            int width = 48*8;
            int height = 52*5;

            // Slot
            final int slotXstart = x+20;
            final int slotYstart = y+20;
            int slotX = slotXstart;
            int slotY = slotYstart;
            // Cursur
            int cursurX = slotXstart + 60*slotCol;
            int cursurY = slotYstart + 60*slotRow;
            int cursurWight = 40;
            int cursurHeight = 40;
            // update
            if (act == 1) {
                System.out.println("up");
                slotRow--;
                if (slotRow < 0) slotCol = 3;
                act = 0;
            }
            if (act == 2) {
                System.out.println("Down");
                slotRow ++;
                if(slotRow > 3) slotRow = 0;
                act = 0;
            }
            if (act == 3) {
                System.out.println("left");
                slotCol--;
                if (slotCol < 0) slotCol = 6;
                act = 0;
            }
            if (act == 4) {
                System.out.println("Right");
                slotCol++;
                if (slotCol > 5) slotCol = 0;
                act = 0;
            }
            //===================================
            drawSubWindow(g2, x, y, width, height);
            Color c = new Color(255, 255, 255);
            g2.setColor(c);
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(cursurX, cursurY, cursurWight, cursurHeight, 4, 4);
            // Draw Items
            //System.out.println(inventory.get(0));
            for(int i = 0; i < inventory.size(); i++){
                g2.drawImage(inventory.get(i).getObjectRender().getimage(), slotX, slotY, null);
                //Vector2f pos, int row, int col, int size
                    slotX += 60;
                    if(i == 5 || i == 11 || i == 16){
                        slotX = slotXstart;
                        slotY += 60;
                    }
            }
        }
    }
    public void input(MouseHandler mouse, KeyHandler key) {
        key.invDn.tick();
        key.invUp.tick();
        key.invLeft.tick();
        key.invRight.tick();
        key.invEnter.tick();
        if(shop == 1) {
            if (act == 1) {
                System.out.println("up");
                if (function == 1) {
                    slotRow--;
                    if (slotRow < 0) slotRow = 8;
                } else {
                    commandNum--;
                    if (commandNum < 0) {
                        commandNum = 2;
                    }
                }
            }
            if (act == 2) {
                System.out.println("Down");
                if (function == 1) {
                    slotRow++;
                    if (slotRow > 8) slotRow = 0;
                } else {
                    commandNum++;
                    if (commandNum > 2) {
                        commandNum = 0;
                    }
                }
            }
            if (act == 3) {
                System.out.println("left");
                slotCol--;
                if (slotCol < 0) slotCol = 10;
            }
            if (act == 4) {
                System.out.println("Right");
                slotCol++;
                if (slotCol > 10) slotCol = 0;
            }
        }

    }

    public void update(double time) {
    }
}
