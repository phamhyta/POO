package game.data;
import game.ai.MapSolid;
import game.game_object.object.item.Door;
import game.game_object.object.Arrow;
import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.tile.TileManager;


public class MapIntruc extends MapAsset {

    MapIntruc(GameControl gc){

        super(gc);
        gc.tm = new TileManager("res/tile/winter.xml", gc.cam);
        gc.mapSolid = new MapSolid(gc.tm);
        gc.gameObject.add(new Door(new Vector2f(1000,600),48));
}
    @Override
    protected void setMonsterPosition() {
        // TODO Auto-generated method stub
        
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
        
