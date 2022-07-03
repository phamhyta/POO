package game.states;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import game.graphics.Sprite;
import game.graphics.SpriteSheet;
import game.render.txtAndImageRender;
import game.util.KeyHandler;
import game.util.MouseHandler;

import static game.states.GameStateManager.fontf;


public class IntroState extends GameState
{
    private int count;
    private BufferedImage listOfImages1[];
    private txtAndImageRender listTxt[];
    private double tran;
    private double tran1;
    private double picTran;
    private double picTran1;
    private double check;
    private double check1;
    private int stateOfImage;
    private int stateOfImage1;
    private SpriteSheet littleGirl;
    private SpriteSheet player;
    private double secPerPic = 20*60/ 50.0;
    private SpriteSheet monsters;
    private Sprite listOfMonsters[][];
    private Sprite listOfLittleGirl [];
    private Sprite listOfPlayer[];
    private int process;
    public IntroState(GameStateManager gsm) {
        super(gsm);
        this.check = 1;
        this.check1 = 1;
        this.process = 0;
        this.picTran1 = 255;
        this.count = 0;
        this.tran = 0;
        this.tran1 = 0;
        this.picTran = 255;
        this.stateOfImage = 0;
        this.stateOfImage1 = 1;
        this.listOfImages1 = new BufferedImage[57];
        this.listOfMonsters = new Sprite[20][20];
        this.listOfLittleGirl = new Sprite[10];
        this.listTxt = new txtAndImageRender[10];
        this.listOfPlayer = new Sprite[10];
        setUp();
        GameStateManager.g.setFont(fontf.getFont("MaruMonica").deriveFont(Font.TRUETYPE_FONT,96F));
    }

    @Override
    public void update(double time) {
    }
    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        key.escape.tick();
        if(key.escape.clicked){
            gsm.pop(GameStateManager.INTRO);
            gsm.add(GameStateManager.NEWGAME);
        }
    
    }
    @Override
    public void render(Graphics2D g) {
        this.count++;
        System.out.println(count);
        //Mo dau
        renderFirstInro(g);
        listTxt[0].renderTxt(g, 0, 4, 0, 720-48*2, this.count);
        listTxt[1].renderTxt(g, 4, 12, 0, 720-48*2, this.count);
        listTxt[2].renderTxt(g,12, 20,0,720 - 48*2,this.count);
        listTxt[3].renderTxt(g,20, 24,0,720 - 48*2,this.count);
        listTxt[4].renderTxt(g,24, 32,0,720 - 48*2,this.count);
        //Monsters
        renderImage1(48, 56, g, this.listOfMonsters,this.listOfLittleGirl);
        renderImage(32, 56, g, this.listOfMonsters);
        renderImage2(56, 64, g,this.listOfPlayer);
        //Player
        listTxt[9].renderTxt(g,28, 56,1280/2-48*2,180,this.count,60F);
        listTxt[5].renderTxt(g,40, 48,0,720 - 48*2,this.count);
        listTxt[6].renderTxt(g,48, 58,0,720 - 48*2,this.count);
        listTxt[7].renderTxt(g,56, 64,1280/2-48*2,180,this.count,60F);
        listTxt[8].renderTxt(g,56, 64,0,720 - 48*2,this.count);
        if(this.count>=65*60){
            gsm.pop(GameStateManager.INTRO);
            gsm.add(GameStateManager.PLAY);
        }
    }
    public BufferedImage scaledImage(BufferedImage original,int width,int height){
        BufferedImage scaledImage = new BufferedImage(width,height,original.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original, 0, 0, width, height,null);
        g2.dispose();
        return scaledImage;
    }
    public void renderImage(int timeBegin,int timeEnd,Graphics2D g,Sprite listSprite[][]){
        if(this.count>timeBegin*60&&this.count<=timeEnd*60){
            if(count%20==0){
                this.stateOfImage++;
                if(this.stateOfImage==3){
                    this.stateOfImage=0;
                }
            }
            g.drawImage(listSprite[6][this.stateOfImage].image,640-48*3-48*2+24 , 180+48*2,48*3,48*3,null);
            g.drawImage(listSprite[4][this.stateOfImage].image,640-48*3+24, 180+48*2,48*3,48*3,null);
            g.drawImage(listSprite[2][this.stateOfImage].image,640 , 180+48*2,48*2,48*3,null);   
            g.drawImage(listSprite[0][this.stateOfImage].image,640+48*2-24 , 180+48*2,48*3,48*3,null);
            if((timeEnd-4)*60 <count&&count <= (timeEnd)*60){
                double k2 = 255.0/240.0;
                this.picTran += k2;
                g.setColor(( new Color(0,0,0,(int) this.picTran)));
                g.fillRect(0, 0, 1280, 720);
            }
            if(count<=(timeBegin+4)*60){
                
                double k2 =  255.0/240.0;
                this.picTran -= k2;
                g.setColor(( new Color(0,0,0,(int) this.picTran)));
                g.fillRect(0, 0, 1280, 720);
            }
    }
    }
    public void setUp(){
        this.monsters = new SpriteSheet("res/entity/minimonsters.png", 16, 16);
        this.littleGirl = new SpriteSheet("res/entity/littlegirl.png", 48, 48);
        this.player = new SpriteSheet("res/entity/linkFormatted_new.png");
        this.listOfMonsters = this.monsters.getSpriteArray2();
        this.listOfLittleGirl = this.littleGirl.getSpriteArray(2);
        this.listOfPlayer = this.player.getSpriteArray(6);
        this.listTxt[0] = new txtAndImageRender("Chuyen ke rang");
        this.listTxt[1] = new txtAndImageRender("Thua khai thien lap dia, than von vo sinh vo tu,\n bat diet bat vong va co tich vinh hang...");
        this.listTxt[2] = new txtAndImageRender("Thua hong hoang mo mit, than hoa giai toan than,\n sinh ra nhat nguyet tinh tu, chu than va sinh linh van vat...");
        this.listTxt[3] = new txtAndImageRender("Tu day cung la luc xua hien cac the luc phan loan,\n pha hoai the goi van vat");
        this.listTxt[4] = new txtAndImageRender("Dung dau the luc nay la ....\n mot nhan vat vo cung cao cuong xuat hien tu Truc Lam Tu");
        this.listTxt[5] = new txtAndImageRender("Giang ho don rang lao da nghich luyen Dich Can Kinh \nNhung... khong thanh phat ma da nhap vao ma dao");
        this.listTxt[6] = new txtAndImageRender("Lao chieu du vo so cao thu,\n trong do co Little Girl de gia nhap the luc nham thao tung van vat");
        this.listTxt[7] = new txtAndImageRender("Va ban la");
        this.listTxt[8] = new txtAndImageRender("Chao mung ban da den day de cung chung tay chong lai the luc phan loan");
        this.listTxt[9] = new txtAndImageRender("Monster");
        // Load pic 1
        for(int i = 1;i<=56;i++){
                loadImage(i);
                this.listOfImages1[i] = this.scaledImage(this.listOfImages1[i], 1280, 720);
                this.process = i;
        }
        
        
    }

    public void loadImage(int i){
        try{
            this.listOfImages1[i] = ImageIO.read(getClass().getResourceAsStream("/res/pic/Pic("+i+").png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void renderFirstInro(Graphics2D g){
        double index = (double) count / secPerPic;
        if(count <= 20*60){
            g.drawImage(this.listOfImages1[(int) index], 0, 0,null );
        }
        if(16*60 <count&&count <= 20*60){
            double k = 255.0/240.0;
            this.picTran += k;
            g.setColor(( new Color(0,0,0,(int) this.picTran)));
            g.fillRect(0, 0, 1280, 720);
        }
        if(count<=4*60){
            double k =  255.0/240.0;
            this.picTran -= k;
            g.setColor(( new Color(0,0,0,(int) this.picTran)));
            g.fillRect(0, 0, 1280, 720);
        }
        
    }
public void renderImage1(int timeBegin,int timeEnd,Graphics2D g,Sprite listSprite[][],Sprite [] littleGirl){
    if(this.count>timeBegin*60&&this.count<=timeEnd*60){
        if(count%20==0){
            this.stateOfImage1++;
            if(this.stateOfImage1==4){
                this.stateOfImage1=0;
            }
        }
        g.drawImage(littleGirl[this.stateOfImage].image,640-72 , 180,48*3,48*3,null);
        g.drawImage(listSprite[8][this.stateOfImage].image,640-48*3-48*2 , 180+48*5,48*3,48*3,null);
        g.drawImage(listSprite[9][this.stateOfImage].image,640-48*3+24+12, 180+48*5,48*3,48*3,null);
        g.drawImage(listSprite[10][this.stateOfImage].image,640+12 , 180+48*5,48*3,48*3,null);   
        g.drawImage(listSprite[11][this.stateOfImage].image,640+48*2 , 180+48*5,48*3,48*3,null);
        if((timeEnd-4)*60 <count&&count <= (timeEnd)*60){
            double k2 = 255.0/240.0;
            this.picTran1 += k2;
            g.setColor(( new Color(0,0,0,(int) this.picTran1)));
            g.fillRect(0, 0, 1280, 720);
        }
        if(count<=(timeBegin+4)*60){
            double k2 =  255.0/240.0;
            this.picTran1 -= k2;
            g.setColor(( new Color(0,0,0,(int) this.picTran1)));
            g.fillRect(0, 0, 1280, 720);
        }
}
}
public void renderImage2(int timeBegin,int timeEnd,Graphics2D g,Sprite listSprite[]){
    if(this.count>timeBegin*60&&this.count<=timeEnd*60){
        if(count%20==0){
            this.stateOfImage++;
            if(this.stateOfImage==7){
                this.stateOfImage=0;
            }
        }
        g.drawImage(listSprite[this.stateOfImage].image,640-72-48 , 180,48*5,48*5,null);
        if((timeEnd-4)*60 <count&&count <= (timeEnd)*60){
            double k2 = 255.0/240.0;
            this.picTran += k2;
            g.setColor(( new Color(0,0,0,(int) this.picTran)));
            g.fillRect(0, 0, 1280, 720);
        }
        if(count<=(timeBegin+4)*60){
            double k2 =  255.0/240.0;
            this.picTran -= k2;
            g.setColor(( new Color(0,0,0,(int) this.picTran)));
            g.fillRect(0, 0, 1280, 720);
        }
}
}
}

