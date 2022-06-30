package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Armor_10 extends GameObject {

	public Armor_10(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;
		name = "Áo choàng bóng tối";
		defense = 250;
        coin = 250;
		objectRender = new ObjectRender(pos, 7, 14,size );
	}
}

