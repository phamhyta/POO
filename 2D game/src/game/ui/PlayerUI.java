package game.ui;

import game.gameObject.Player;
import game.graphics.SpriteSheet;
import game.util.KeyHandler;
import game.util.MouseHandler;
import game.math.Vector2f;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class PlayerUI {

    private FillBars healthbar;
    private FillBars manaBar;
    private InventoryUI inve;

    Player p;

    public PlayerUI(Player p) {
        this.p = p;

        SpriteSheet bars = new SpriteSheet("res/ui/fillbars.png");
        BufferedImage[] hpBarSprite = {
                bars.getSubimage(12, 2, 7, 16),
                bars.getSubimage(39, 0, 7, 14), // red health bar
                bars.getSubimage(0, 0, 12, 20) };

        Vector2f pos = new Vector2f(16, 16);
        this.healthbar = new FillBars(p, hpBarSprite, pos, 16, 16, p.getHealthPercent());

        BufferedImage[] manaBarSprite = {
                bars.getSubimage(12, 2, 7, 16),
                bars.getSubimage(39, 17, 7, 14), // red health bar
                bars.getSubimage(0, 0, 12, 20) };

        pos = new Vector2f(16, 50);
        this.manaBar = new FillBars(p, manaBarSprite, pos, 10, 16, p.getManapercent());
        this.inve = new InventoryUI(p);

    }

    public void update(double time) {
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        key.inv.tick();
        key.attack.tick();
        if (key.inv.clicked == true) {
            inve.shop = 1;
        }
        if (key.attack.clicked == true) {
            inve.shop = 0;
        }
        key.invDn.tick();
        key.invUp.tick();
        key.invLeft.tick();
        key.invRight.tick();
        key.invEnter.tick();
        if (key.invUp.clicked) {
            inve.act = 1;
        }
        if (key.invDn.clicked) {
            inve.act = 2;
        }
        if (key.invLeft.clicked) {
            inve.act = 3;
        }
        if (key.invRight.clicked) {
            inve.act = 4;
        }
        if (key.invEnter.clicked) {
            inve.act = 5;
        }
    }

    public void render(Graphics2D g) {
        healthbar.render(g, p.getHealthPercent());
        manaBar.render(g, p.getManapercent());
        inve.render(g);
        inve.drawInfo(g);
    }

}