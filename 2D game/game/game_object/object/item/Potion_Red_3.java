package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Potion_Red_3 extends GameObject {

	public Potion_Red_3(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Red Potion Pro vip";
		MP = 150;
		coin = 150;
		objectRender = new ObjectRender(pos, 9, 8,size );
	}

}
