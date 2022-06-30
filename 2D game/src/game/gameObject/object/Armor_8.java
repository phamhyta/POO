package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Armor_8 extends GameObject {

	public Armor_8(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;
		name = "Quần Dài";
		defense = 150;
        coin = 150;
		objectRender = new ObjectRender(pos, 7, 10,size );
	}
}

