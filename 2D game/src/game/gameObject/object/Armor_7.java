package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Armor_7 extends GameObject {

	public Armor_7(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;
		name = "Quần Short";
		defense = 100;
        coin = 100;
		objectRender = new ObjectRender(pos, 7, 11,size );
	}

}

