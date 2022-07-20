package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Sword_3 extends GameObject {

	public Sword_3(Vector2f origin, int size) {
		super(origin, size);
		type= type_sword;
		name = "Bích Kiếm";
		attackValue = 150;
        coin =150;
		objectRender = new ObjectRender(pos, 5, 2,size );
	}
}
