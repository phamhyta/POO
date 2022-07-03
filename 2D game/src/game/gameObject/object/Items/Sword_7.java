package game.gameObject.object.items;

import game.gameObject.Player;
import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Sword_7 extends GameObject {

	public Sword_7(Vector2f origin, int size) {
		super(origin, size);
		type= type_sword;
		name = "Thanh kiếm";
		attackValue = 350;
        coin = 350;
		objectRender = new ObjectRender(pos, 5, 6,size );
	}
}
