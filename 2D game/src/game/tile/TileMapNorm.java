package game.tile;

import game.graphics.SpriteSheet;
import game.tile.blocks.Block;
import game.tile.blocks.NormBlock;
import game.math.AABB;
import game.math.Vector2f;

import java.awt.*;

public class TileMapNorm extends TileMap {

    public Block[] blocks;

    private int tileWidth;
    private int tileHeight;

    private int height;

    public TileMapNorm(String data, SpriteSheet spriteSheet, int width, int height, int tileWidth, int tileHeight, int tileColumns) {
        blocks = new Block[width * height];

        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        this.height = height;

        String[] block = data.split(",");

        for(int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+",""));
            if(temp != 0) {
                blocks[i] = new NormBlock(spriteSheet.getSprite((int) ((temp - 1) % tileColumns), (int) ((temp - 1) / tileColumns) ), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);
            }
        }
    }

    public void render(Graphics2D g, AABB cam) {
        int x = (int) ((cam.getPos().x) / tileWidth);
        int y = (int) ((cam.getPos().y) / tileHeight);

        for(int i = x; i < x + (cam.getWidth() / tileWidth); i++) {
            for(int j = y; j < y + (cam.getHeight() / tileHeight); j++) {
                if(i + (j * height) > -1 && i + (j * height) < blocks.length && blocks[i + (j * height)] != null) {
                    blocks[i + (j * height)].render(g);
                }
            }
        }
    }

}
