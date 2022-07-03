package game.game_object.object;

import game.math.Vector2f;
import game.render.ObjectRender;

public class Arrow extends GameObject {
    public Arrow (Vector2f origin, int size) {
        super(origin, size);
        name = "Arrow";
        objectRender = new ObjectRender(pos, 2, 0,size );
    }
}
