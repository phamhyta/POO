package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Sword_4 extends GameObject {

	public Sword_4(Vector2f origin, int size) {
		super(origin, size);
		type= type_sword;
		name = "Phong kiếm";
		attackValue = 200;
        coin = 200;
		objectRender = new ObjectRender(pos, 5, 3,size );
	}
}
