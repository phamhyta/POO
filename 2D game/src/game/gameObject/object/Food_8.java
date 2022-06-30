package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Food_8 extends GameObject {

	public Food_8(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Đùi bò";
		HP = 50;
        coin = 50;
		objectRender = new ObjectRender(pos, 15, 2,size );
	}
}

