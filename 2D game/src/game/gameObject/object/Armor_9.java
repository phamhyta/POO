package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Armor_9 extends GameObject {

	public Armor_9(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;
		name = "Thắt lưng vàng";
		defense = 200;
        coin = 200;
		objectRender = new ObjectRender(pos, 7, 15,size );
	}
}

