package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Sword_8 extends GameObject {

	public Sword_8(Vector2f origin, int size) {
		super(origin, size);
		type= type_sword;
		name = "Đại Đao";
		attackValue = 400;
        coin = 400;
		objectRender = new ObjectRender(pos, 5, 7,size );
	}
}
