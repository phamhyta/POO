package game.ui;

import game.game_object.Entity;
import game.math.Vector2f;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class FillBars {
    
    private BufferedImage[] bar;

    private Entity e;

    private Vector2f pos;
    private int size;
    private int length;

    private int energyLength;

    private int barWidthRatio;
    private int energyWidthRatio;

    private int barHeightRatio;
    private float percent;

    public FillBars(Entity e, BufferedImage[] sprite, Vector2f pos, int size, int length, float percent) {
        this.e = e;
        this.bar = sprite;
        this.pos = pos;
        this.size = size;
        this.length = length;
        this.percent= percent;

        this.energyLength = (int) ((bar[0].getWidth() + size) * (length * e.getHealthPercent()));
        this.barWidthRatio = (bar[0].getWidth() + size) * length / (bar[0].getWidth());
        this.energyWidthRatio = energyLength / (bar[0].getWidth());
        this.barHeightRatio = (bar[0].getHeight() + size) / bar[0].getHeight();
    }

    public void render(Graphics2D g, float percent) {
        int endsWidth = 0;
        int centerHeight = (int) (pos.y - barHeightRatio - bar[0].getHeight() / 2);

        this.energyLength = (int) ((bar[0].getWidth() + size) * (length * percent));
        this.energyWidthRatio = this.energyLength / (bar[0].getWidth());

        if(bar[2] != null) {
            endsWidth = bar[2].getWidth() + size;

            g.drawImage(bar[2], (int) (pos.x), (int) (pos.y), endsWidth, bar[2].getHeight() + size, null);
            g.drawImage(bar[2], (int) (pos.x + endsWidth * 2 + (bar[0].getWidth() + size) * length) - this.barWidthRatio, (int) (pos.y), -(endsWidth), bar[2].getHeight() + size, null);
            centerHeight += bar[2].getHeight() / 2 + (bar[2].getHeight() - bar[0].getHeight()) / 2;
        }

        g.drawImage(bar[0], (int) (pos.x + endsWidth - this.barWidthRatio), centerHeight, (bar[0].getWidth() + size) * length, bar[0].getHeight() + size, null);
        if(this.energyLength > 0){
            g.drawImage(bar[1], (int) (pos.x + endsWidth - this.energyWidthRatio), centerHeight, this.energyLength, (int) (bar[0].getHeight() + size), null);
            }

    }



}