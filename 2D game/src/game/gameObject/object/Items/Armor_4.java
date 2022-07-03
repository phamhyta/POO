package game.gameObject.object.items;

import game.gameObject.Player;
import game.gameObject.object.GameObject;
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

