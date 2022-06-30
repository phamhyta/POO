package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Armor_4 extends GameObject {

	public Armor_4(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;
		name = "Bạch Giáp";
		defense = 200;
        coin = 200;
		objectRender = new ObjectRender(pos, 7, 5,size );
	}
}

