package game.states;

import game.graphics.SpriteSheet;
import game.util.KeyHandler;
import game.util.MouseHandler;

import java.awt.*;

public class DialoguesState extends GameState{
    private SpriteSheet spriteSheet;
    private Image image;
    public DialoguesState(GameStateManager gsm) {
        super(gsm);
        spriteSheet = new SpriteSheet("res/ui/Dialogues.png");
    }

    @Override
    public void update(double time) {

    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {

    }

    @Override
    public void render(Graphics2D g) {
        image = spriteSheet.getSubimage(0,49,3*32,32*7/4);
        g.drawImage(image,180,90, 350,204, null);
        g.setFont(new Font("NewellsHand", Font.PLAIN, 32));
        Color c = new Color(0,0,0);
        g.setColor(c);
        g.drawString("Nhan P de noi chuyen", 200, 170);
    }
}
