package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Sword_9 extends GameObject {

	public Sword_9(Vector2f origin, int size) {
		super(origin, size);
		type= type_sword;
		name = "Sai Đao";
		attackValue = 450;
        coin = 450;
		objectRender = new ObjectRender(pos, 5, 8,size );
	}
}
