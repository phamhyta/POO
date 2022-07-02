package game.gameObject.object;

import game.math.Vector2f;
import game.render.ObjectRender;

public class Door extends GameObject{
    public Door (Vector2f origin, int size) {
        super(origin, size);
        type = type_nextMap;
        name = "Door";
        objectRender = new ObjectRender(pos, 3, 3,size );
    }
}
