package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Potion_Blue_1 extends GameObject {

	public Potion_Blue_1(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Blue Potion";
		MP = 50;
		coin = 50;
		objectRender = new ObjectRender(pos, 9, 1,size );
	}

}
