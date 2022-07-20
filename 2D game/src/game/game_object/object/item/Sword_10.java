package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Sword_10 extends GameObject {

	public Sword_10(Vector2f origin, int size) {
		super(origin, size);
		type= type_sword;
		name = "Song Tuyệt Kiếm";
		attackValue = 500;
        coin = 500;
		objectRender = new ObjectRender(pos, 5, 9,size );
	}
}
