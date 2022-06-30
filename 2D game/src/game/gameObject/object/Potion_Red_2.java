package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Potion_Red_2 extends GameObject {

	public Potion_Red_2(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Red Potion pro";
		MP = 100;
		coin = 100;
		objectRender = new ObjectRender(pos, 9, 4,size );
	}

}
