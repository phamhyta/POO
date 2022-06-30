package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Food_1 extends GameObject {

	public Food_1(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Táo";
		MP = 50;
        coin = 50;
		objectRender = new ObjectRender(pos, 14, 0,size );
	}

}

