package game.states;

import game.GamePanel;
import game.math.Vector2f;
import game.ui.Button;
import game.util.KeyHandler;
import game.util.MouseHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

import static game.states.GameStateManager.fontf;
import static game.states.GameStateManager.g;


public class PauseState extends GameState {
    private Button btn1, btn2;
    private int selection =0;
    private BufferedImage imgButton;
    private Font font;
    public PauseState(GameStateManager gsm) {
        super(gsm);
        imgButton= GameStateManager.ui.getSubimage(2490,250,1500,450);

        g.setColor(Color.WHITE);
        g.setFont(fontf.getFont("Motion").deriveFont(Font.BOLD,20F));

        btn1 = new Button("COUNTINUE", imgButton, g.getFont(), new Vector2f(GamePanel.width / 2, GamePanel.height / 2 - 48), 32, 16);
        btn1.addEvent(e -> selection = 0);

        btn2 = new Button("EXIST", imgButton, g.getFont(),   new Vector2f(GamePanel.width / 2, GamePanel.height / 2 + 48), 32, 16);
        btn2.addEvent(e -> selection = 1);
    }


    @Override
    public void update(double time) {}

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        btn1.input(mouse, key);
        btn2.input(mouse, key);
        if(mouse.getButton() == 1  &&  btn1.getHovering() ) {
            gsm.pop(GameStateManager.PAUSE);
            gsm.add(GameStateManager.PLAY);
        }

        else if(mouse.getButton() == 1  &&  btn2.getHovering()) {
            System.exit(0);
        }

    }

    @Override
    public void render(Graphics2D g) {
        g.fillRoundRect(64*2,64*2,500,500,10,10);
        btn1.render(g);
        btn2.render(g);
    }
}
