package game.states;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import game.graphics.Sprite;
import game.graphics.SpriteSheet;
import game.util.KeyHandler;
import game.util.MouseHandler;

import static game.states.GameStateManager.fontf;


public class IntroState extends GameState
{
    private int count;
    private BufferedImage listOfImages1[];
    private String listString [];
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
        this.listString = new String[10];
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
            gsm.add(GameStateManager.PLAY);
        }
    
    }
    @Override
    public void render(Graphics2D g) {
        this.count++;
        System.out.println(count);
        //Mo dau
        renderFirstInro(g);
        renderTxt(0, 4, g, listString[0],0,720 - 48*2);
        renderTxt(4,12, g, listString[1],0,720 - 48*2);
        renderTxt(12, 20, g, listString[2],0,720 - 48*2);
        renderTxt(20,24,g,listString[3],0,720 - 48*2);
        renderTxt(24, 32, g, listString[4], 0, 720-48*2);
        //Monsters
        renderImage1(48, 56, g, this.listOfMonsters,this.listOfLittleGirl);
        renderImage(32, 56, g, this.listOfMonsters);
        renderImage2(56, 64, g,this.listOfPlayer);
        //Player
        renderTxt1(28,56,g,"Monsters",1280/2-48*3,180,60F);
        renderTxt(40,48,g,listString[5],0,720-48*2);
        renderTxt(48,56,g,listString[6],0,720-48*2);
        renderTxt1(56,64,g,listString[7],1280/2-48*3,180,60F);
        renderTxt(56, 64, g, listString[8],0,720-48*2);
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
        this.listString[0] = new String("Chuyen ke rang");
        this.listString[1] = new String("Thua khai thien lap dia, than von vo sinh vo tu,\n bat diet bat vong va co tich vinh hang...");
        this.listString[2] = new String("Thua hong hoang mo mit, than hoa giai toan than,\n sinh ra nhat nguyet tinh tu, chu than va sinh linh van vat...");
        this.listString[3] = new String("Tu day cung la luc xua hien cac the luc phan loan,\n pha hoai the goi van vat");
        this.listString[4] = new String("Dung dau the luc nay la ....\n mot nhan vat vo cung cao cuong xuat hien tu Truc Lam Tu");
        this.listString[5] = new String("Giang ho don rang lao da nghich luyen Dich Can Kinh \nNhung... khong thanh phat ma da nhap vao ma dao");
        this.listString[6] = new String("Lao chieu du vo so cao thu,\n trong do co Little Girl de gia nhap the luc nham thao tung van vat");
        this.listString[7] = new String("Va ban la");
        this.listString[8] = new String("Chao mung ban da den day de cung chung tay chong lai the luc phan loan");
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
    
    public void renderTxt(int timeBegin,int timeEnd,Graphics2D g,String txt,int x,int y){
        if(this.count>timeBegin*60 && this.count<=timeEnd*60){
            double time1 = (timeEnd-timeBegin)*60/2;
            double timeTran = (double) 255/(time1);
            this.tran =this.tran+ timeTran*this.check;
            if( tran>=255||tran<=0){
                this.check *=-1;
            }
            g.setColor(new Color(255,255,255,(int) tran));
            g.setFont(g.getFont().deriveFont(30F));
            for(String line: txt.split("\n")){
                g.drawString(line, x, y);
                y+=48;
        }
    }    
}
public void renderTxt1(int timeBegin,int timeEnd,Graphics2D g,String txt,int x,int y,float size){
    if(this.count>timeBegin*60 && this.count<=timeEnd*60){
        double time1 = (timeEnd-timeBegin)*60/2;
        double timeTran = (double) 255/(time1);
        this.tran1 =this.tran1+ timeTran*this.check1;
        if( tran1>=255||tran1<=0){
            this.check1 *=-1;
        }
        g.setFont(g.getFont().deriveFont(size));
        g.setColor(new Color(255,255,255,(int) tran1));
        g.drawString(txt,x,y);
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

