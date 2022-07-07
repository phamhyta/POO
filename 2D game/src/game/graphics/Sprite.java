package game.graphics;

import java.awt.image.BufferedImage;

public class Sprite {
    public BufferedImage image;

    private int w;
    private int h;

    public Sprite(BufferedImage image) {
        this.image = image;
        this.w = image.getWidth();
        this.h = image.getHeight();
    }

    public int getWidth() { return w; }
    public int getHeight() { return h; }

    public Sprite getSubimage(int x, int y, int w, int h) {
        return new Sprite(image.getSubimage(x, y, w, h));
    }


}
