package game.states;

import game.GamePanel;
import game.math.Vector2f;
import game.ui.Button;
import game.util.KeyHandler;
import game.util.MouseHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static game.states.GameStateManager.fontf;

public class TitleState extends GameState{
    private int selection =0;
    private int commandNum=0;
    BufferedImage image;
    private BufferedImage imgButton;
    private Button btn1, btn2, btn3;
    private boolean clicked = false;

    public TitleState(GameStateManager gsm) {
        super(gsm);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/ui/pngTree.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        imgButton= GameStateManager.ui.getSubimage(2490,250,1500,450);
        btn1 = new Button("Play State", new Vector2f(64*8 +8, 64*6 + 20), 32, 24, imgButton, new Vector2f(64*8, 64*6), 290, 75);
        btn1.addEvent(e -> selection = 0);

        btn2 = new Button("INSTRUCTION", new Vector2f(64*8 -10, 64*7+32 + 20), 32, 24, imgButton, new Vector2f(64*8-10, 64*7+32), 310, 75);
        btn2.addEvent(e -> selection = 1);

        btn3 = new Button("EXIST", new Vector2f(64*9, 64*9 ), 32, 24, imgButton, new Vector2f(64*8+32, 64 *9-12), 230, 72);
        btn3.addEvent(e -> selection = 2);

    }

    @Override
    public void update(double time) {

    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        btn1.input(mouse, key);
        btn2.input(mouse, key);
        btn3.input(mouse, key);

        if(mouse.getButton() == 1 && !clicked &&  btn1.getHovering() ) {
            gsm.pop(GameStateManager.TITLE);
            gsm.add(GameStateManager.INTRO);
        }

        else if(mouse.getButton() == 1 && !clicked &&  btn2.getHovering()) {
            gsm.pop(GameStateManager.TITLE);
            gsm.add(GameStateManager.INSTRUCTION);
        }
        else if(mouse.getButton() == 1 && !clicked &&  btn3.getHovering()){
            System.exit(0);
        }

        else if(mouse.getButton() == -1) {
            clicked = false;
        }
    }


    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, 0,0, GamePanel.width, GamePanel.height, null);
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
        //Button
        btn1.render(g);
        btn2.render(g);
        btn3.render(g);
    }
    public int getXforCenteredText(String text, Graphics2D g) {
        int length= (int)g.getFontMetrics().getStringBounds(text,g).getWidth();
        int x= GamePanel.width/2 -length/2;
        return x;
    }
}
