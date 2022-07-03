package game.gameObject.object.items;

import game.gameObject.Player;
import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Sword_6 extends GameObject {

	public Sword_6(Vector2f origin, int size) {
		super(origin, size);
		type= type_sword;
		name = "Cổ kiếm";
		attackValue = 300;
        coin = 300;
		objectRender = new ObjectRender(pos, 5, 5,size );
	}
}
