package game.states;


import game.data.AddItems;
import game.game_object.Player;
import game.game_object.object.GameObject;
import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.util.KeyHandler;
import game.util.MouseHandler;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

import static game.states.GameStateManager.fontf;

public class ShopState extends GameState{
    private int commandNum=0;
    private int function = 0;
    private int shop = 0;
    private int buy = 0;
    private int back = 0;
    private int slotCol = 0;
    private int slotRow = 0;
    private ArrayList<GameObject> items;
    private SpriteSheet spriteSheet1;
    private SpriteSheet spriteSheet2;
    private SpriteSheet spriteSheet3;
    private Image image;
    private Player player;
    private int x = 200;
    private int y= 100;
    private int size = 32;
    private int width = size*11;
    private int height = size*13;
    private AddItems additems;
    private int bought = 0;
    
        // Slot
    private final int slotXstart = x+20;
    private final int slotYstart = y+20;
    private int slotX ;
    private int slotY ;
        // Cursur
    private int cursurWight = size;
    private int cursurHeight = size;

    public ShopState(GameStateManager gsm, Player player) {
        super(gsm);
        this.player=player;
        items = new ArrayList<>();
        additems = new AddItems(items);
        spriteSheet1 = new SpriteSheet("res/ui/buttons.png");
        spriteSheet2 = new SpriteSheet("res/ui/slots.png");
        spriteSheet3 = new SpriteSheet("res/ui/Dialogues.png");
    }

    public void drawIntro(Graphics2D g2){
        int xBuy = x+width;
        int yBuy = y+2*height/3;
        image = spriteSheet3.getSubimage(0*size,3*size/2+1,3*size,size*7/4);
        g2.drawImage(image,x,y, size*16,size*28/3, null);
        Color c = new Color(0, 0, 0);
        g2.setColor(c);
        g2.setFont(new Font("NewellsHand", Font.PLAIN, size));  
        g2.drawString("Tôi là sinh viên cơ khí Bách Khoa", x+size*2/3, y+48*2);
        g2.drawString("và không bỏ ngang sang IT", x+size*2/3, y+48*3);
        g2.drawString("Bạn cần tôi giúp gì nào ?", x+size*2/3, y+48*4+10);
        drawSubWindow(g2,xBuy, yBuy,200,height/3);
        g2.drawString("Buy", xBuy+64, yBuy+48);
        if(commandNum == 0) {
            g2.drawString(">",xBuy+32,yBuy+48);
        }
        g2.drawString("Leave", xBuy+64, yBuy+48*2);
        if(commandNum == 1) {
            g2.drawString(">",xBuy+32,yBuy+48*2);
        }
    }

    public void buy(GameObject go){
        player.setTargetMaterial(go);
        player.setCoin(player.getCoin() - go.getCoin());
    }

    public void drawAttributes(Graphics2D g2, int slotX, int slotY){
        int i = slotX+slotY*10;
        if(i < items.size() && i>=0){
            g2.setFont(new Font("NewellsHand", Font.PLAIN, size*2/3));
            items.get(i);
            g2.drawString(items.get(i).getName(), x+width*3/2+size/2, y+3*size/2);
            int cnt=1;
            if(items.get(i).getHP() != 0){
                g2.drawString("+" + String.valueOf(items.get(i).getHP()) + " HP", x+width*3/2+size/2, y+3*size/2 + cnt*size);
                cnt++;
            }
            if(items.get(i).getMP() != 0){
                g2.drawString("+" + String.valueOf(items.get(i).getMP()) + " MP", x+width*3/2+size/2, y+3*size/2 + cnt*size);
                cnt++;
            }
            if(items.get(i).getAttackValue() != 0){
                g2.drawString("+" + String.valueOf(items.get(i).getAttackValue()) + " attack", x+width*3/2+size/2, y+3*size/2 + cnt*size);
                cnt++;
            }
            if(items.get(i).getDefense() != 0){
                g2.drawString("+" + String.valueOf(items.get(i).getDefense()) + " defense", x+width*3/2+size/2, y+3*size/2 + cnt*size);
                cnt++;
            }
            if(items.get(i).getSpeed() != 0){
                g2.drawString("+" + String.valueOf(items.get(i).getSpeed()) + " Speed", x+width*3/2+size/2, y+3*size/2 + cnt*size);
                cnt++;
            }
            if(items.get(i).getCoin() != 0){
                g2.drawString("Gia: " + String.valueOf(items.get(i).getCoin()) + " Coins", x+width*3/2+size/2, y+3*size/2 + cnt*size);
                cnt++;
            }  
        }
            
    }

    public void drawSubWindow(Graphics2D g2, int x, int y, int width, int height){
        g2.fillRoundRect(x,y,width,height,35 ,35);
        Color c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5,width-10,height-10,25,25);
        g2.setFont(new Font("NewellsHand", Font.PLAIN, 32));
    }
    public void drawShop(Graphics2D g2, int x, int y, int row, int col ){
        image = spriteSheet2.getSubimage(3*size+8,0*size,size+8,size+8);
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                g2.drawImage(image,slotXstart+j*size*3/2, slotYstart+i*size*3/2, size*3/2,size*3/2, null);
            }
        }
        Color c = new Color(218,165,32);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+size/2, y+size/2,col*size*3/2+size*1/4,row*size*3/2+size*1/4,25,25);
        g2.setFont(new Font("NewellsHand", Font.PLAIN, 32));
    }
    @Override
    public void update(double time) {
        System.out.println("Shop");
        shop = 1;
    }
    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        key.down.tick();
        key.up.tick();
        key.left.tick();
        key.right.tick();
        key.enter.tick();
        key.buy.tick();
        key.back.tick();
        if(shop == 1){
            if(key.up.clicked){
                if (function == 1){
                    slotRow--;
                    if(slotY == 0 && slotRow < 0) slotRow = 0;
                    else {
                        if (slotRow < 0) slotRow = slotY-1;
                    }
                } else {
                    commandNum--;
                    if (commandNum < 0) {
                        commandNum = 1;
                    }
                }
            }
            if (key.down.clicked) {
                if (function == 1) {
                    slotRow++;
                    if (slotRow > slotY-1) slotRow = 0;
                } else {
                    commandNum++;
                    if (commandNum > 1) {
                        commandNum = 0;
                    }
                }
            }
            if (key.left.clicked) {
                slotCol--;
                if (slotCol < 0) {
                    slotCol = slotX-1;
                    slotRow--;
                    if (slotRow < 0) slotRow = slotY-1;
                }
            }
            if (key.right.clicked) {
                slotCol++;
                if (slotCol > slotX-1) {
                    slotCol = 0;
                    slotRow++;
                    if (slotRow > slotY-1) slotRow = 0;
                }
            }

            if (key.enter.clicked) {
                if (commandNum == 1 && function == 0) {
                    gsm.pop(GameStateManager.SHOP);
                    gsm.add(GameStateManager.PLAY);
                } else {
                    if (function == 0) function = 1;
                    else function = 0;
                }
            }
            if(key.buy.clicked){
                buy = 1;
            }
            if(key.back.clicked){
                back = 1;
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        if(shop == 1) {
            if(function == 0 ){
                drawIntro(g);
            }
            if(function == 1 && commandNum==0){
                int cursurX = slotXstart + size*slotCol*3/2;
                int cursurY = slotYstart + size*slotRow*3/2;
                drawShop(g, x, y, 8, 10);
                
                image = spriteSheet1.getSubimage(0*size, size-1,4*size-6,size-8);
                g.drawImage(image, x+5*size, y-size*3/2, 6*size, size*3/2, null);
                Color c = new Color(0,0,0);
                g.setColor(c);
                g.drawString("Shop", x+5*size + 2*size, y- size/2);
                c = new Color(255, 255, 255);
                g.setColor(c);
                g.setStroke(new BasicStroke(3));
                g.drawRoundRect(cursurX, cursurY, cursurWight*3/2, cursurHeight*3/2, 10, 10);

                // drawitems
                slotX=0;
                slotY=0;
                if(function == 1 && commandNum == 0) {
                    for(int i=0; i< items.size(); i++){
                        g.drawImage(items.get(i).getObjectRender().getImage(),slotXstart+slotX*size*3/2,slotYstart+slotY*size*3/2,48,48,null);
                        slotX ++;
                        if(slotX > 9){
                            slotY ++;
                            slotX=0;
                        }
                    }
                }
                slotX=10;

                // Mo ta
                c = new Color(255,165,0);
                g.setColor(c);
                drawSubWindow(g, x+width*3/2 - size/4, y + size/2,width+size, height);
                c = new Color(0,0,0);
                g.setColor(c);
                g.setFont(new Font("NewellsHand", Font.PLAIN, size));
                g.drawString("ENTER để thoát", x+width*3/2+32, y+height-32);
                g.drawString("B để mua", x+width*3/2+32, y+height-64);
                g.setColor(Color.YELLOW);
                drawSubWindow(g, x+size/2, y+height, 400, 80);
                g.setColor(Color.BLACK);
                g.drawString("Your coins: " + player.getCoin(),x+size, y+height+size*3/2);

                drawAttributes(g, slotCol, slotRow);
                
                if(buy >= 1){
                    if(player.getInventory().size() > 24) {
                        g.setColor(Color.YELLOW);
                        drawSubWindow(g, x+3*size/2, y+height/2, 650, 80);
                        g.setColor(Color.BLACK);
                        g.drawString("Your inventory is full! Backspace to back",x+2*size, y+height/2+size*3/2);
                        if(back==1){
                            buy = 0;
                            back = 0;
                        }
                    }else{
                        if(player.getCoin() < items.get(slotCol+slotRow*10).getCoin()){
                            g.setColor(Color.YELLOW);
                            drawSubWindow(g, x+3*size/2, y+height/2, 650, 80);
                            g.setColor(Color.BLACK);
                            g.drawString("Your coin is not enough! Backspace to back",x+2*size, y+height/2+size*3/2);
                            if(back==1){
                                buy = 0;
                                back = 0;
                            }
                        }else{
                            if(buy==1){
                                buy(items.get(slotCol + slotRow*10));
                            }
                            buy++;
                            if(buy<30){
                                g.setColor(Color.yellow);
                                drawSubWindow(g, x+3*size/2, y+height/2, 600, 80);
                                g.setColor(Color.BLACK);
                                g.drawString("Thanks for buying!",x+2*size, y+height/2+size*3/2);
                            }else buy = 0;
                        }
                    }
                }
            }
        }
    }
}
