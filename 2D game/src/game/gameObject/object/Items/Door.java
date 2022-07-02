package game.gameObject.object.Items;

import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;

public class Door extends GameObject{
    public Door (Vector2f origin, int size) {
        super(origin, size);
        type = type_nextMap;
        name = "Door";
        objectRender = new ObjectRender(pos, 2, 6,size );
    }
}
