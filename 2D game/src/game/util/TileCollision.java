package game.util;

import game.game_object.Entity;
import game.tile.TileMapObj;
import game.tile.blocks.Block;
import game.tile.blocks.HoleBlock;

public class TileCollision {

    private Entity e;

    public TileCollision(Entity e) {
        this.e = e;
    }

    public boolean collisionTile(float ax, float ay) {
        for (int c = 0; c < 4; c++) {
            int xt = (int) ((e.getPos().x + ax) + (c % 2) * e.getBounds().getWidth() + e.getBounds().getXOffset()) / 64;
            int yt = (int) ((e.getPos().y + ay) + (c / 2) * e.getBounds().getHeight() + e.getBounds().getYOffset()) / 64;

            if (TileMapObj.event_blocks[xt + (yt * TileMapObj.height)] instanceof Block) {
                Block block = TileMapObj.event_blocks[xt + (yt * TileMapObj.height)];
                if (block instanceof HoleBlock) {
                    return collisionHole(ax, ay, xt, yt, block);
                }
                return block.update(e.getBounds());
            }
        }
        return false;
    }

    private boolean collisionHole(float ax, float ay, float xt, float yt, Block block) {
        int nextXt = (int) ((((e.getPos().x + ax) + e.getBounds().getXOffset()) / 64) + e.getBounds().getWidth() / 64);
        int nextYt = (int) ((((e.getPos().y + ay) + e.getBounds().getYOffset()) / 64) + e.getBounds().getHeight() / 64);

        if (block.isInside(e.getBounds())) {
            e.setFallen(true);
            return false;
        } else if ((nextXt == yt + 1) || (nextXt == xt + 1) || (nextYt == yt - 1) || (nextXt == xt - 1)) {
            if (TileMapObj.event_blocks[nextXt + (nextYt * TileMapObj.height)] instanceof HoleBlock) {
                if (e.getBounds().getPos().x > block.getPos().x) {
                    e.setFallen(true);
                }
                return false;
            }
        }
        e.setFallen(false);
        return false;
    }
}
