package game.states;


import game.gameObject.Player;
import game.gameObject.object.GameObject;
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
    private int buy = 0;
    private int slotCol = 0;
    private int slotRow = 0;
    private ArrayList<GameObject> items;
    private SpriteSheet spriteSheet;
    private Image image;
    private GameObject go[][];
    private Player player;
    private int x = 200;
    private int y= 100;
    private int size = 32;
    private int width = size*11;
    private int height = size*13;
    
        // Slot
    private final int slotXstart = x+20;
    private final int slotYstart = y+20;
    private int slotX ;
    private int slotY ;
        // Cursur
    private int cursurWight = size;
    private int cursurHeight = size;

    public ShopState(GameStateManager gsm) {
        super(gsm);
    }

    public void drawDialogues(Graphics2D g2){
        int cursurX = slotXstart + size*slotCol*3/2;
        int cursurY = slotYstart + size*slotRow*3/2;
        slotX = 0;
        slotY = 0;
        // Buy
        if(function == 1 && commandNum == 0) {
            // Kho
            // drawSubWindow(g2, x, y, width, height);
            drawShop(g2, x, y, 8, 10);
            spriteSheet = new SpriteSheet("res/ui/buttons.png");
            image = spriteSheet.getSubimage(0*size, size-1,4*size-6,size-8);
            g2.drawImage(image, x+5*size, y-size*3/2, 6*size, size*3/2, null);
            Color c = new Color(0,0,0);
            g2.setColor(c);
            g2.drawString("Shop", x+5*size + 2*size, y- size/2);
            c = new Color(255, 255, 255);

            items = new ArrayList<>();
            go = new GameObject[20][20];
            g2.setColor(c);
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(cursurX, cursurY, cursurWight*3/2, cursurHeight*3/2, 10, 10);

            // Mo ta
            c = new Color(255,165,0);
            g2.setColor(c);
            drawSubWindow(g2, x+width*3/2 - size/4, y + size/2,width+size, height);
            c = new Color(0,0,0);
            g2.setColor(c);
            g2.setFont(new Font("NewellsHand", Font.PLAIN, size));
            g2.drawString("ENTER để thoát", x+width*3/2+32, y+height-32);
            g2.drawString("B để mua", x+width*3/2+32, y+height-64);
            // Draw Items
            setShop(g2);
            
            if(buy == 1){
                buy(player,go[slotCol][slotRow]);
                buy = 0;
            }
        }
        // Sell
        // if(function == 1 && commandNum == 1){
        //     slotX1=0;
        //     slotY1=0;
        //     drawSubWindow(g2, x, y, width, height);
        //     Color c = new Color(255, 255, 255);
        //     g2.setColor(c);
        //     g2.setStroke(new BasicStroke(3));
        //     g2.drawRoundRect(cursurX, cursurY, cursurWight, cursurHeight, 10, 10);
        //     // Mo ta
        //     drawSubWindow(g2, x+width, y,2*width/3, height);
        //     g2.setFont(new Font("NewellsHand", Font.PLAIN, size));
        //     g2.drawString("MÔ TẢ TRANG BỊ", x+width +32, y+64);
        //     g2.drawString("ENTER để thoát", x+width+32, y+height-32);
        //     g2.drawString("S để bán", x+width+32, y+height-64);
        // }
        // buyBox
        int xBuy = x+width;
        int yBuy = y+2*height/3;
        if(function == 0 ){

            //drawSubWindow(g2, x, y, width+200, height-200);
            spriteSheet = new SpriteSheet("res/ui/Dialogues.png");
            image = spriteSheet.getSubimage(0*size,3*size/2+1,3*size,size*7/4);
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
            // g2.drawString("Sell", xBuy+64, yBuy+48*2);
            // if(commandNum == 1) {
            //     g2.drawString(">",xBuy +32,yBuy+48*2);
            // }
            g2.drawString("Leave", xBuy+64, yBuy+48*2);
            if(commandNum == 1) {
                g2.drawString(">",xBuy+32,yBuy+48*2);
            }
        }

    }

    public void setShop(Graphics2D g2){
        g2.setFont(new Font("NewellsHand", Font.PLAIN, size*2/3));
            spriteSheet = new SpriteSheet("res/ui/shop.png");
            //HP,MP
                setItems(g2, slotX, slotY, "Bình máu", 100,0,0,0,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Bình năng lượng",0,100,0,0,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Bình máu pro",150,0,0,0,0, 150);
                slotX++;
                setItems(g2, slotX, slotY, "Bình năng lượng pro",150,0,0,0,0,150);
                slotX++;
                setItems(g2, slotX, slotY, "Bình máu được sơn kim tuyến",200,0,0,0,0, 200);
                slotX++;
                setItems(g2, slotX, slotY, "Bình năng lượng được sơn kim tuyến",200,0,0,0,0,200);
                slotX++;
                setItems(g2, slotX, slotY, "Huyết thư",300,0,0,0,0,300);
                slotX++;
                setItems(g2, slotX, slotY, "Nộ thư",300,0,0,0,0,300);
                slotX++;
                setItems(g2, slotX, slotY, "Huyết ngọc",0,300,0,0,0,300);
                slotX++;
                setItems(g2, slotX, slotY, "Nộ ngọc",0,300,0,0,0,300);
                slotX++;
            slotX=0;
            slotY++;

            //Kiem
                setItems(g2, slotX, slotY, "Kiếm gỗ" , 0,0,10,0,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Kiếm bạc",0,0,20,0,0,150);
                slotX++;
                setItems(g2, slotX, slotY, "Kiếm thạch bích",0,0,30,0,0, 200);
                slotX++;
                setItems(g2, slotX, slotY, "Phong kiếm",0,0,40,0,0,250);
                slotX++;
                setItems(g2, slotX, slotY, "Đại thủ kiếm",0,0,50,0,0, 300);
                slotX++;
                setItems(g2, slotX, slotY, "Cổ cung kiếm",0,0,60,0,0,350);
                slotX++;
                setItems(g2, slotX, slotY, "Thanh kiếm",0,0,70,0,0,400);
                slotX++;
                setItems(g2, slotX, slotY, "Đại trung kiếm",0,0,80,0,0,450);
                slotX++;
                setItems(g2, slotX, slotY, "Sai dao",0,0,90,0,0,500);
                slotX++;
                setItems(g2, slotX, slotY, "Song tàng kiếm",0,0,100,0,0,550);
                slotX++;
            slotX=0;
            slotY++;
            //Giap
                setItems(g2, slotX, slotY, "Áo vải" , 0,0,0,10,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Giáp thép",0,0,0,20,0,150);
                slotX++;
                setItems(g2, slotX, slotY, "Mộc giáp",0,0,0,30,0, 200);
                slotX++;
                setItems(g2, slotX, slotY, "Kim giáp",0,0,0,40,0,250);
                slotX++;
                setItems(g2, slotX, slotY, "Giáp bạc",0,0,0,50,0, 300);
                slotX++;
                setItems(g2, slotX, slotY, "Quần hoa",0,0,0,10,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Quần sịn",0,0,0,20,0,150);
                slotX++;
                setItems(g2, slotX, slotY, "Quần bò",0,0,0,30,0,200);
                slotX++;
                setItems(g2, slotX, slotY, "Thắt lựng vàng",0,0,0,40,0,250);
                slotX++;
                setItems(g2, slotX, slotY, "Áo choàng bóng ",0,0,0,50,0,300);
                slotX++;
            slotX=0;
            slotY++;
            // giày, trang sức
                setItems(g2, slotX, slotY, "Găng tay" , 0,0,0,10,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Găng tay bạc",0,0,0,20,0,150);
                slotX++;
                setItems(g2, slotX, slotY, "Giày",0,0,0,10,10, 200);
                slotX++;
                setItems(g2, slotX, slotY, "Giày bạc",0,0,0,20,20,250);
                slotX++;
                setItems(g2, slotX, slotY, "Nhẫn vàng",0,0,0,0,0, 300);
                slotX++;
                setItems(g2, slotX, slotY, "Nhẫn kim cương",0,0,0,0,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "dây chuyền vàng",0,0,0,0,0,150);
                slotX++;
                setItems(g2, slotX, slotY, "Tràng hạt",0,0,0,0,0,200);
                slotX++;
                setItems(g2, slotX, slotY, "Nanh hùm",0,0,0,0,0,250);
                slotX++;
                setItems(g2, slotX, slotY, "Balo",0,0,0,0,0,300);
                slotX++;
            slotX=0;
            slotY++;
            // Khiên, cung
                setItems(g2, slotX, slotY, "khiên gỗ" , 0,0,0,100,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Khiên thép",0,0,0,200,0,150);
                slotX++;
                setItems(g2, slotX, slotY, "khiên thất truyền",0,0,0,300,0, 200);
                slotX++;
                setItems(g2, slotX, slotY, "Cung gỗ",0,0,100,0,0,150);
                slotX++;
                setItems(g2, slotX, slotY, "Nỏ sét",0,0,150,0,0, 200);
                slotX++;
                setItems(g2, slotX, slotY, "Ná cao su",0,0,200,0,0,250);
                slotX++;
                setItems(g2, slotX, slotY, "Boomerang",0,0,250,0,0,300);
                slotX++;
                setItems(g2, slotX, slotY, "Quyền trượng pháp sư",0,0,300,0,0,350);
                slotX++;
                setItems(g2, slotX, slotY, "Nanh lợn",0,0,0,0,0,250);
                slotX++;
                setItems(g2, slotX, slotY, "lông phượng",0,0,0,0,0,500);
                slotX++;
            slotX=0;
            slotY++;
            // thức ăn
                setItems(g2, slotX, slotY, "Táo" , 0,0,0,0,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Chuối",0,0,0,0,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Lê",0,0,0,0,0, 100);
                slotX++;
                setItems(g2, slotX, slotY, "Chanh",0,0,0,0,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Dâu",0,0,0,0,0, 100);
                slotX++;
                setItems(g2, slotX, slotY, "Đùi gà",0,0,0,0,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Thịt bò",0,0,0,0,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Đùi lợn",0,0,0,0,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Thịt hụn khói",0,0,0,0,0,100);
                slotX++;
                setItems(g2, slotX, slotY, "Tôm chiên xù",0,0,0,0,0,100);
                slotX++;
            slotY++;
    }

    public void buy(Player player, GameObject go){
        player.setTargetMaterial(go);
    }

    public void setItems(Graphics2D g2,int i, int j,String name, int healthBonus,int mana, int attack, int defense, int speed, int coin){
        go[i][j] = new GameObject();
        items.add(go[i][j]);
        go[i][j].setImage(spriteSheet.getSubimage(i*size, j*size,size,size));
        go[i][j].setName(name);
        go[i][j].setHP(healthBonus);
        go[i][j].setMP(mana);
        go[i][j].setAttackValue(attack);
        go[i][j].setDefense(defense);
        go[i][j].setSpeed(speed);
        go[i][j].setCoin(coin);
        g2.drawImage(go[i][j].getImage(),slotXstart+i*size*3/2, slotYstart+j*size*3/2, size*3/2,size*3/2, null);
        if(i==slotCol && j==slotRow){
            g2.drawString(go[i][j].getName(), x+width*3/2+size/2, y+3*size/2);
            g2.drawString("+" + String.valueOf(go[i][j].getHP()) + " HP", x+width*3/2+size/2, y+3*size/2 + size);
            g2.drawString("+" + String.valueOf(go[i][j].getMP()) + " MP", x+width*3/2+size/2, y+3*size/2 + 2*size);
            g2.drawString("+" + String.valueOf(go[i][j].getAttackValue()) + " attack", x+width*3/2+size/2, y+3*size/2 + 3*size);
            g2.drawString("+" + String.valueOf(go[i][j].getDefense()) + " defense", x+width*3/2+size/2, y+3*size/2 + 4*size);
            g2.drawString("+" + String.valueOf(go[i][j].getSpeed()) + " Speed", x+width*3/2+size/2, y+3*size/2 + 5*size);
            g2.drawString("Gia: " +String.valueOf(go[i][j].getCoin()) + " Coins", x+width*3/2+size/2, y+3*size/2 + 6*size);
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
        spriteSheet = new SpriteSheet("res/ui/slots.png");
        image = spriteSheet.getSubimage(3*size+8,0*size,size+8,size+8);
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
        key.buy.tick();
        if(shop == 1) {
            if (key.up.clicked) {
                if (function == 1) {
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
                if (slotCol < 0) slotCol = slotX-1;
            }
            if (key.right.clicked) {
                slotCol++;
                if (slotCol > slotX-1) slotCol = 0;
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
        }
    }

    @Override
    public void render(Graphics2D g) {
        if(shop == 1) {
            drawDialogues(g);
        }
    }
}
