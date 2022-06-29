package game.states;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import game.graphics.Sprite;
import game.graphics.SpriteSheet;
import game.util.KeyHandler;
import game.util.MouseHandler;
import java.awt.*;

public class GameIntruction extends GameState {
    private int count;
    private Sprite rock;
    private Sprite Musroom;
    private Sprite smallTree;
    private Sprite soil;
    private int playerState;
    private int currentCount;
    private boolean isAttacking;
    private int attackingState;
    private boolean Up;
    private boolean Down;
    private boolean Left;
    private boolean ms1;
    private boolean ms2;
    private boolean Right;
    private int playerScreenX;
    private int playerScreenY;
    private int a;
    private int b;
    private int direction;
    private Sprite playerSpirite[][];
    private String txt[];
    private Sprite Monster[];
    private int monsterHeath;
    private Rectangle attack;
    private Rectangle forMs1;
    private Rectangle forMs2;
    private Rectangle player;
    public GameIntruction(GameStateManager gsm) {
        super(gsm);
        this.currentCount = 0;
        this.count = 0;
        this.monsterHeath = 90;
        this.attackingState = 0;
        this.playerScreenX = 48*2;
        this.playerScreenY = 360 + 48;
        this.isAttacking = false;
        this.a = this.playerScreenX;
        this.b = this.playerScreenY;
        this.ms1 = false;
        this.ms2 = false;
        this.Up = false;
        this.Down = false;
        this.Left = false;
        this.Right = true;
        this.txt = new String[10];
        this.Monster = new Sprite[10];
        this.direction = 2;
        this.playerState = 0;
        this.playerSpirite = new Sprite[8][8]; 
        this.setUp();
    }

    @Override
    public void update(double time) {
        
    }

    public void setUp(){
        this.txt[0] = new String("Su dung A, S, D, W de di chuyen\ntoi vung chi dinh");
        this.txt[1] = new String("Tiep theo tan cong cay \nde hoan thanh khoa huan luyen");
        this.txt[2] = new String("Chuc mung ban da hoan thanh khoa huan luyen\n Bam Enter de bat dau cuoc hanh trinh cua ban");
        SpriteSheet input = new SpriteSheet("res/tile/nature.png", 12*8, 12*8);
        this.soil = input.getSprite(2, 2,32,32);
        this.rock = input.getSprite(2, 1, 32, 32);
        this.smallTree = input.getSprite(1, 1,32,32);
        this.Musroom = input.getSprite(3, 1, 32, 32);
        input = new SpriteSheet("res/entity/linkFormatted_new.png", 32, 32);
        this.playerSpirite = input.getSpriteArray2();
        this.player = new Rectangle(this.playerScreenX+32,this.playerScreenY+32,32,32);
        this.forMs1 = new Rectangle(6*32*2 ,360,48,48);
        this.forMs2 = new Rectangle(1280-48*3,this.playerScreenY,96,96);
        this.attack = new Rectangle(0,0,50,50);
        input = new SpriteSheet("res/entity/minimonsters.png",16,16);
        this.Monster = input.getSpriteArray(9);
    }
    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        this.Right = false;
        this.Left = false;
        this.Down = false;
        this.Up = false;
        key.enter.tick();
        key.up.tick();
        key.down.tick();
        key.left.tick();
        key.right.tick();
        key.attack.tick();
        if(key.enter.clicked){
            gsm.pop(GameStateManager.INSTRUCTION);
            gsm.add(GameStateManager.INTRO);
        }
        if(key.up.down){
            this.Up = true;
            this.direction = 0;
        }
        if(key.down.down){
            this.Down = true;
            this.direction = 2;
            
        }
        if(key.right.down){
            this.Right = true;
            this.direction = 3;
        }
        if(key.left.down){
            this.Left = true; 
            this.direction = 1;
        }
        if(key.attack.clicked){
            this.isAttacking = true;
            this.currentCount = count;
        }
    }
    public void mapRender(Graphics2D g){
        // Soil
        for(int i = 0; i <= 13;i++){
            for(int j = 0; j <=3;j++){
                g.drawImage(this.soil.image, 0+i*32*3, 360+(j-1)*32*3, 32*3,32*3,null);
            }
        }
        //Rock
        for(int i = -1; i<=20;i++){
            g.drawImage(this.rock.image, i*20*3, 360-32*3-48, 32*3,32*3,null);
        }
        //Musrom
        g.drawImage(this.Musroom.image,6*32*3 ,360+32*3 , 32*3,32*3,null);
        g.drawImage(this.Musroom.image,6*32*5 ,360+32*5 , 32*3,32*3,null);
        g.drawImage(this.Musroom.image,6*32 ,360+32*4 , 32*3,32*3,null);
        g.drawImage(this.Musroom.image,6*32*5 ,360 , 32*3,32*3,null);
        //Tree
    }
    public void playerRender(Graphics2D g){
        if(this.count%10==0&&(Up==true||Down==true||Left==true||Right==true)){
            this.playerState++;
            if(this.playerState>7){
                this.playerState = 0;
            }
        }
        if(this.direction==2){
            if(!this.isAttacking){
                g.drawImage(this.playerSpirite[6][this.playerState].image, this.playerScreenX, this.playerScreenY, 96,96,null);
            }
            else{
            this.attack.x = playerScreenX;
            this.attack.y = playerScreenY+50;
                g.drawImage(this.playerSpirite[11][this.attackingState].image, this.playerScreenX, this.playerScreenY,96,96, null);
                if(this.count%7==0){
                    this.attackingState++;
                    this.attackingState%=8;
                }
                if(this.currentCount+30==this.count){
                    this.isAttacking = false;
                    this.attackingState=0;
                }
            }
        }
        else if(this.direction==0){
            if(!this.isAttacking){
            g.drawImage(this.playerSpirite[7][this.playerState].image, this.playerScreenX, this.playerScreenY, 96,96,null);
        }
        else{
            this.attack.x = playerScreenX;
            this.attack.y = playerScreenY-50;
            g.drawImage(this.playerSpirite[12][this.attackingState].image, this.playerScreenX, this.playerScreenY,96,96, null);
            if(this.count%7==0){
                this.attackingState++;
                this.attackingState%=8;
            }
            if(this.currentCount+30==this.count){
                this.isAttacking = false;
                this.attackingState=0;
            }
            
        }
    }
        else if(this.direction==1){
            if(!this.isAttacking){
            g.drawImage(this.playerSpirite[5][this.playerState].image, this.playerScreenX, this.playerScreenY, 96,96,null);
        }
        else{
            this.attack.x = playerScreenX-50;
            this.attack.y = playerScreenY;
            g.drawImage(this.playerSpirite[10][this.attackingState].image, this.playerScreenX, this.playerScreenY,96,96, null);
            if(this.count%7==0){
                this.attackingState++;
                this.attackingState%=8;
            }
            if(this.currentCount+30==this.count){
                this.isAttacking = false;
                this.attackingState=0;
            }
        }
    }
        else if(this.direction==3){
            if(!this.isAttacking){
            g.drawImage(this.playerSpirite[4][this.playerState].image, this.playerScreenX, this.playerScreenY, 96,96,null);
        }
        else{
            this.attack.x = playerScreenX+50;
            this.attack.y = playerScreenY;
            g.drawImage(this.playerSpirite[9][this.attackingState].image, this.playerScreenX, this.playerScreenY,96,96, null);
            if(this.count%7==0){
                this.attackingState++;
                this.attackingState%=8;
            }
            if(this.currentCount+30==this.count){
                this.isAttacking = false;
                this.attackingState=0;
            }
        }
    }

    }
    public boolean checkColiision(){
        if(this.a<0||this.a>1280){
            return false;
        }
        if(this.b>720-48*3||this.b<360-32*3){
            return false;
        }
        return true;
    }
    @Override
    public void render(Graphics2D g) {
        count++;
        this.player.x = this.playerScreenX+32;
        this.player.y = this.playerScreenY+32;
        this.mapRender(g);
        move();
        this.renderMs1(g);
        this.renderMs2(g);
        this.playerRender(g);
        for(int i = -1; i<=20;i++){
            g.drawImage(this.smallTree.image, i*20*3, 360+3*32*3-48, 32*3,32*3,null);
        }
        this.buttonRender(g);
        if(this.ms1==true&&this.ms2== true){
            this.renderTxt(g,0,48*2+30,txt[2]);
        }
        
    }
    
    public void buttonRender(Graphics2D g) {
        g.setFont(GameStateManager.fontf.getFont("MeatMadness"));
        g.setColor(Color.WHITE);
        g.setFont(g.getFont().deriveFont(80F));
        // g.drawString("A",640,48*4);
        // g.drawString("S",640+48*2,48*4);
        // g.drawString("D",640+48*4,48*4);
        // g.drawString("W",640+40+48,48*2+30);
        // g.drawString("Space",640+48*6,48*4);
        // if(this.Down){
        //     g.setColor(Color.YELLOW);
        //     g.drawString("S",640+48*2,48*4);
        // }
        // if(this.Left){
        //     g.setColor(Color.YELLOW);
        //     g.drawString("A",640,48*4);
        // }
        // if(this.Right){
        //     g.setColor(Color.YELLOW);
        //     g.drawString("D",640+48*4,48*4);
        // }
        // if(this.Up){
        //     g.setColor(Color.YELLOW);
        //     g.drawString("W",640+40+48,48*2+30);
        // }
        // if(this.isAttacking){
        //     g.setColor(Color.YELLOW);
        //     g.drawString("Space",640+48*6,48*4);
        // }
        
}
    public void move(){
        if(this.checkColiision()){
            if(this.Down){
                this.b +=3;
                if(checkColiision()){
                    this.playerScreenY +=3;
                }
                else{
                    this.b-=3;
                }
            }
            if(this.Left){
                this.a -=3;
                if(checkColiision()){
                    this.playerScreenX -=3;
                }
                else{
                    this.a+=3;
                }
            }
            if(this.Right){
                this.a +=3;
                if(checkColiision()){
                    this.playerScreenX +=3;
                }
                else{
                    this.a-=3;
                }
            }
            if(this.Up){
                this.b -=3;
                if(checkColiision()){
                    this.playerScreenY -=3;
                }
                else{
                    this.b+=3;
                }
            }
        }
    }
    public void renderTxt(Graphics2D g,int x,int y,String txt){
        g.setColor(Color.WHITE);
        g.setFont(g.getFont().deriveFont(40F));
        for(String line: txt.split("\n")){
            g.drawString(line, x, y);
            y+=48;
    }
    }
    public void renderMs1(Graphics2D g){
        if(this.ms1==false){
            this.renderTxt(g,0,48*2+30,txt[0]);
            g.setStroke(new BasicStroke(5));
            g.draw(this.forMs1);
            if(this.forMs1.intersects(this.player)){
                this.ms1 = true;
            }
        }
    }
    public void renderMs2(Graphics2D g){
        if(this.ms2 == false&&this.ms1 == true){
            this.renderTxt(g,0,48*2+30,txt[1]);
            int k = this.playerState%4;
            g.drawImage(this.Monster[k].image,this.forMs2.x,this.forMs2.y,70,70,null);
            if(this.isAttacking==true){
                if(this.attack.intersects(this.forMs2)){
                    this.monsterHeath--;
                }
            }
            if(monsterHeath<0){
                this.ms2 = true;
            }
    }
}
}
