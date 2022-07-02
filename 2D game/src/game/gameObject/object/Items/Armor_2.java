package game.gameObject.object.Items;

import game.gameObject.Player;
import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Armor_2 extends GameObject {

	public Armor_2(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;
		name = "Thiết Giáp";
		defense = 100;
        coin = 100;
		objectRender = new ObjectRender(pos, 7, 7,size );
	}
}

