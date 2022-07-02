package game.states;

import game.GamePanel;
import game.util.KeyHandler;
import game.util.MouseHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static game.states.GameStateManager.fontf;


public class TitleState extends GameState{
    private int commandNum=0;
    BufferedImage image;
    int count = 0;

    public TitleState(GameStateManager gsm) {
        super(gsm);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/ui/pngTree.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(double time) {

    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        key.down.tick();
        key.up.tick();
        key.enter.tick();
        if(key.up.clicked) {
            commandNum --;
            if(commandNum <0) {
                commandNum = 2;
            }
        }
        if(key.down.clicked) {
            commandNum ++;
            if(commandNum >2) {
                commandNum = 0;
            }
        }
        if(key.enter.clicked) {
            if(commandNum == 0) {
                gsm.pop(GameStateManager.TITLE);
                gsm.add(GameStateManager.INTRO);
            }
            if(commandNum== 1) {
                gsm.pop(GameStateManager.TITLE);
                gsm.add(GameStateManager.INSTRUCTION);
            }
            if(commandNum== 2) {
                System.exit(0);
            }
        }
    }
    void setUp(){

    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, 0,0, GamePanel.width, GamePanel.height, null);
        this.count++;
        System.out.println(count);
        // title name
        g.setFont(fontf.getFont("Motion").deriveFont(Font.TRUETYPE_FONT,96F));
        String text = "POO GAME ADVENTURE";

        int x = getXforCenteredText(text,g);
        int y = 64*2;

        //draw Shadow
        g.setColor(Color.white);
        g.drawString(text,x+5,y+5);
        //draw main color
        g.setColor(Color.black);
        g.drawString(text, x, y);
        
        //MENU
        g.setFont(fontf.getFont("MeatMadness").deriveFont(Font.BOLD,40F));

        text= "NEW GAME";
        x= getXforCenteredText(text,g);
        y+= 64*5;
        g.drawString(text, x, y);
        if(commandNum == 0) {
            g.drawString(">",x-32,y);
        }

        text= "INSTRUCTION";
        x= getXforCenteredText(text,g);
        y+= 64;
        g.drawString(text, x, y);
        if(commandNum == 1) {
            g.drawString(">",x -32,y);
        }

        text= "QUIT GAME";
        x= getXforCenteredText(text,g);
        y+= 64;
        g.drawString(text, x, y);
        if(commandNum == 2) {
            g.drawString(">",x-32,y);
        }
    }
    public int getXforCenteredText(String text, Graphics2D g) {
        int length= (int)g.getFontMetrics().getStringBounds(text,g).getWidth();
        int x= GamePanel.width/2 -length/2;
        return x;
    }
}
