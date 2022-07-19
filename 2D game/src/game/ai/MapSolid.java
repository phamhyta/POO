package game.ai;

import game.tile.TileManager;
import game.tile.TileMapObj;
import game.tile.blocks.HoleBlock;
import game.tile.blocks.ObjBlock;

public class MapSolid {
    private TileManager tileManager;

    public MapSolid(TileManager tileManager) {
        this.tileManager = tileManager;
        for (int i = 0; i < TileMapObj.event_blocks.length; i++) {
            if (TileMapObj.event_blocks[i] instanceof ObjBlock || TileMapObj.event_blocks[i] instanceof HoleBlock) {
                PathFind.node[i % 50][i / 50].solid = true;
            }
        }
    }

}