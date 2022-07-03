package game.gameObject.object.items;

import game.gameObject.Player;
import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Sword_1 extends GameObject {

	public Sword_1(Vector2f origin, int size) {
		super(origin, size);
		type= type_sword;
		name = "Kiếm gỗ";
		attackValue = 50;
		coin = 50;
		objectRender = new ObjectRender(pos, 5, 0,size );
	}
}