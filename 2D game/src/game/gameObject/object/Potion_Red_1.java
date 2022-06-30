package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Potion_Red_1 extends GameObject {

	public Potion_Red_1(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Red Potion";
		HP = 50;
		coin = 50;
		objectRender = new ObjectRender(pos, 9, 0,size );
	}

}
