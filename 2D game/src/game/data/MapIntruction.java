package game.data;
import game.ai.MapSolid;
import game.game_object.object.item.Door;
import game.game_object.object.Arrow;
import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.tile.TileManager;


public class MapIntruction extends MapAsset {

    MapIntruction(GameControl gc){

        super(gc);
        gc.tm = new TileManager("res/tile/winter.xml", gc.cam);
        gc.mapSolid = new MapSolid(gc.tm);
        // gc.gameObject.add(new Door(new Vector2f(1000,600),48));
}
    @Override
    protected void setMonsterPosition() {
        int i = 1;
        SpriteSheet minimonsterSheet = new SpriteSheet("res/entity/minimonsters.png", 16, 16);
        gc.origin[i] = new Vector2f(1000, 600);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 0, 128, 32), 16, 16), 48);
    }

    @Override
    public void setMaterialPosition() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resetEnemy(int i) {
        // TODO Auto-generated method stub
        
    }
}
        
