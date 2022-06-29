package game.states;

import game.gameObject.GameObject;
import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.util.KeyHandler;
import game.util.MouseHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

import static game.states.GameStateManager.fontf;

public class ShopState extends GameState{
    private int commandNum=0;
    private int function = 0;
    private int shop = 0;
    private int slotCol = 0;
    private int slotRow = 0;
    private ArrayList<GameObject> items;
    public ShopState(GameStateManager gsm) {
        super(gsm);
    }
    public void drawDialogues(Graphics2D g2){

        int x = 200;
        int y= 100;
        int width = 48*12;
        int height = 48*10;

        // Slot
        final int slotXstart = x+20;
        final int slotYstart = y+20;
        int slotX = slotXstart;
        int slotY = slotYstart;
        // Cursur
        int cursurX = slotXstart + 48*slotCol;
        int cursurY = slotYstart + 48*slotRow;
        int cursurWight = 48;
        int cursurHeight = 48;
        // Buy
        if(function == 1 && commandNum == 0) {
            // Kho
            drawSubWindow(g2, x, y, width, height);
            Color c = new Color(255, 255, 255);
            g2.setColor(c);
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(cursurX, cursurY, cursurWight, cursurHeight, 10, 10);
            // Mo ta
            drawSubWindow(g2, x+width, y,2*width/3, height);
            g2.drawString("MO TA TRANG BI", x+width +32, y+64);
            g2.drawString("ENTER de thoat", x+width+32, y+height-32);
            g2.drawString("B de mua", x+width+32, y+height-64);
            // Draw Items
            items = new ArrayList<>();
        }
        // Sell
        if(function == 1 && commandNum == 1){
            drawSubWindow(g2, x, y, width, height);
            Color c = new Color(255, 255, 255);
            g2.setColor(c);
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(cursurX, cursurY, cursurWight, cursurHeight, 10, 10);
            // Mo ta
            drawSubWindow(g2, x+width, y,2*width/3, height);
            g2.drawString("MO TA TRANG BI", x+width +32, y+64);
            g2.drawString("ENTER de thoat", x+width+32, y+height-32);
            g2.drawString("S de Ban", x+width+32, y+height-64);
        }
        // buyBox
        int xBuy = x+width;
        int yBuy = y+2*height/3;
        if(function == 0 ){
            drawSubWindow(g2, x, y, width+200, height-200);
            Color c = new Color(220, 20, 60);
            g2.setColor(c);
            g2.drawString("Toi la sinh vien co khi Bach Khoa", x+48, y+48);
            g2.drawString("va khong bo ngang sang IT", x+48, y+48*2);
            g2.drawString("Ban can toi giup gi nao ?", x+48, y+48*3+10);
            drawSubWindow(g2,xBuy, yBuy,200,height/3);

            g2.drawString("Buy", xBuy+64, yBuy+48);
            if(commandNum == 0) {
                g2.drawString(">",xBuy+32,yBuy+48);
            }
            g2.drawString("Sell", xBuy+64, yBuy+48*2);
            if(commandNum == 1) {
                g2.drawString(">",xBuy +32,yBuy+48*2);
            }
            g2.drawString("Leave", xBuy+64, yBuy+48*3);
            if(commandNum == 2) {
                g2.drawString(">",xBuy+32,yBuy+48*3);
            }
        }

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

    @Override
    public void update(double time) {
        System.out.println("Dialogues");
        shop = 1;
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        key.down.tick();
        key.up.tick();
        key.left.tick();
        key.right.tick();
        key.enter.tick();
        if(shop == 1) {
            if (key.up.clicked) {
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
            if (key.down.clicked) {
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
            if (key.left.clicked) {
                slotCol--;
                if (slotCol < 0) slotCol = 10;
            }
            if (key.right.clicked) {
                slotCol++;
                if (slotCol > 10) slotCol = 0;
            }

            if (key.enter.clicked) {
                if (commandNum == 2 && function == 0) {
                    gsm.pop(GameStateManager.SHOP);
                    gsm.add(GameStateManager.PLAY);
                } else {
                    if (function == 0) function = 1;
                    else function = 0;
                }
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        if(shop == 1) {
            drawDialogues(g);
        }
    }
}
