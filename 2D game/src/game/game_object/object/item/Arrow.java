package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;

public class Arrow extends GameObject {
    public Arrow (Vector2f origin, int size) {
        super(origin, size);
        type = type_Arrow;
        name = "Arrow";
        objectRender = new ObjectRender(pos, 2, 0,size );
    }
}
