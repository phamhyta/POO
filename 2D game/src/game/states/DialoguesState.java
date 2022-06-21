package game.states;

import game.util.KeyHandler;
import game.util.MouseHandler;

import java.awt.*;

public class DialoguesState extends GameState{
    public DialoguesState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void update(double time) {

    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {

    }

    @Override
    public void render(Graphics2D g) {
        Color c = new Color(0,0,0);
        g.setColor(c);
        g.fillRoundRect(100,100,500,100,35 ,35);
        c = new Color(255, 255, 255);
        g.setColor(c);
        g.setStroke(new BasicStroke(5));
        g.drawRoundRect(100+5, 100+5,500-10,100-10,25,25);
        c = new Color(220, 20, 60);
        g.setColor(c);
        g.drawString("Nhan P de noi chuyen", 150, 160);
    }
}
