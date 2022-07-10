package game.states;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import game.graphics.SpriteSheet;
import game.render.TxtAndImageRender;
import game.util.KeyHandler;
import game.util.MouseHandler;

public class IntroState extends GameState
{
    private int count;
    private BufferedImage listOfImages1[];
    private TxtAndImageRender listTxt[];
    private TxtAndImageRender intro;
    private TxtAndImageRender Little;
    private TxtAndImageRender Monster[];
    private TxtAndImageRender Player;
    public IntroState(GameStateManager gsm) {
        super(gsm);
        this.Monster = new TxtAndImageRender[20];
        this.count = 0;
        this.listOfImages1 = new BufferedImage[57];
        this.listTxt = new TxtAndImageRender[20];
        setUp();
    }

    @Override
    public void update(double time) {

    }
    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        key.escape.tick();
        key.enter.tick();
        if(key.escape.clicked){
            gsm.pop(GameStateManager.INTRO);
            gsm.add(GameStateManager.NEWGAME);
        }
        if(key.enter.clicked){
            gsm.pop(GameStateManager.INTRO);
            gsm.add(GameStateManager.INSTRUCTION);
        }
    }
    @Override
    public void render(Graphics2D g) {
        this.count++;
        //Mo dau
        this.intro.renderFirstInro(g, count);
        listTxt[0].renderTxt(g, 0, 4, 0, 720-48*2, this.count);
        listTxt[1].renderTxt(g, 4, 12, 0, 720-48*2, this.count);
        listTxt[2].renderTxt(g,12, 20,0,720 - 48*2,this.count);
        listTxt[3].renderTxt(g,20, 24,0,720 - 48*2,this.count);
        listTxt[4].renderTxt(g,24, 32,0,720 - 48*2,this.count);
        //Monsters
        this.Monster[0].RenderImage(g, 32, 56, 640+48*2-24 , 180+48*2,48*3,48*3, count);
        this.Monster[2].RenderImage(g, 32, 56, 640 , 180+48*2,48*2,48*3, count);
        this.Monster[4].RenderImage(g, 32, 56, 640-48*3+24, 180+48*2,48*3,48*3, count);
        this.Monster[6].RenderImage(g, 32, 56, 640-48*3-48*2+24 , 180+48*2,48*3,48*3, count);
        this.Monster[8].RenderImage(g, 48, 56, 640+48*2-24 , 180+48*5,48*3,48*3, count);
        this.Monster[9].RenderImage(g, 48, 56, 640 , 180+48*5,48*2,48*3, count);
        this.Monster[10].RenderImage(g, 48, 56, 640-48*3+24, 180+48*5,48*3,48*3, count);
        this.Monster[11].RenderImage(g, 48, 56, 640-48*3-48*2+24 , 180+48*5,48*3,48*3, count);
        //Little
        this.Little.RenderImage(g, 48, 56, 640-72 , 180, 48*3, 48*3, count);
        // Player
        this.Player.RenderImage(g, 56, 100, 640-72-24 , 180, 48*5, 48*5, count);
        //Txt
        listTxt[9].renderTxt(g,28, 56,1280/2-48*2,180,this.count,60F);
        listTxt[5].renderTxt(g,40, 48,0,720 - 48*2,this.count);
        listTxt[6].renderTxt(g,48, 56,0,720 - 48*2,this.count);
        listTxt[7].renderTxt(g,56, 100,1280/2-48*2,180,this.count,60F);
        listTxt[8].renderTxt(g,56, 100,0,720 - 48*2,this.count);
        listTxt[10].renderTxt(g, 56, 100, 0, 720-48, this.count);
    }
    public BufferedImage scaledImage(BufferedImage original,int width,int height){
        BufferedImage scaledImage = new BufferedImage(width,height,original.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original, 0, 0, width, height,null);
        g2.dispose();
        return scaledImage;
    }
    
    public void setUp(){
        this.listTxt[0] = new TxtAndImageRender("Chuyen ke rang");
        this.listTxt[1] = new TxtAndImageRender("Thua khai thien lap dia, than von vo sinh vo tu,\nbat diet bat vong va co tich vinh hang...");
        this.listTxt[2] = new TxtAndImageRender("Thua hong hoang mo mit, than hoa giai toan than,\nsinh ra nhat nguyet tinh tu, chu than va sinh linh van vat...");
        this.listTxt[3] = new TxtAndImageRender("Tu day cung la luc xua hien cac the luc phan loan,\npha hoai the goi van vat");
        this.listTxt[4] = new TxtAndImageRender("Dung dau the luc nay la ....\nmot nhan vat vo cung cao cuong xuat hien tu Truc Lam Tu");
        this.listTxt[5] = new TxtAndImageRender("Giang ho don rang lao da nghich luyen Dich Can Kinh \nNhung... khong thanh phat ma da nhap vao ma dao");
        this.listTxt[6] = new TxtAndImageRender("Lao chieu du vo so cao thu,\ntrong do co Little Girl de gia nhap the luc nham thao tung van vat");
        this.listTxt[7] = new TxtAndImageRender("Va ban la");
        this.listTxt[8] = new TxtAndImageRender("Chao mung ban da den day de cung chung tay chong lai the luc phan loan");
        this.listTxt[9] = new TxtAndImageRender("Monster");
        this.listTxt[10] = new TxtAndImageRender("Nhan Enter de bat dau vao khoa huan luyen");
        this.Monster[0] = new TxtAndImageRender((new SpriteSheet("res/entity/minimonsters.png",16,16)).getSpriteArray(0));
        this.Monster[2] = new TxtAndImageRender((new SpriteSheet("res/entity/minimonsters.png",16,16)).getSpriteArray(2));
        this.Monster[4] = new TxtAndImageRender((new SpriteSheet("res/entity/minimonsters.png",16,16)).getSpriteArray(4));
        this.Monster[6] = new TxtAndImageRender((new SpriteSheet("res/entity/minimonsters.png",16,16)).getSpriteArray(6));
        this.Monster[8] = new TxtAndImageRender((new SpriteSheet("res/entity/minimonsters.png",16,16)).getSpriteArray(8));
        this.Monster[9] = new TxtAndImageRender((new SpriteSheet("res/entity/minimonsters.png",16,16)).getSpriteArray(9));
        this.Monster[10] = new TxtAndImageRender((new SpriteSheet("res/entity/minimonsters.png",16,16)).getSpriteArray(10));
        this.Monster[11] = new TxtAndImageRender((new SpriteSheet("res/entity/minimonsters.png",16,16)).getSpriteArray(11));
        this.Little = new TxtAndImageRender((new SpriteSheet("res/entity/littlegirl.png", 48, 48)).getSpriteArray(2));
        this.Player = new TxtAndImageRender((new SpriteSheet("res/entity/linkFormatted_new.png", 32, 32)).getSpriteArray(6));
        // Load pic 1)
        for(int i = 1;i<=56;i++){
            try{
                this.listOfImages1[i] = ImageIO.read(getClass().getResourceAsStream("/res/pic/Pic("+i+").png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
            this.listOfImages1[i] = this.scaledImage(this.listOfImages1[i], 1280, 720);
        }
        this.intro = new TxtAndImageRender(this.listOfImages1);
    }

}
