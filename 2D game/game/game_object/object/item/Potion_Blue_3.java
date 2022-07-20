package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Potion_Blue_3 extends GameObject {

	public Potion_Blue_3(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Blue Potion Pro vip";
		MP = 150;
		coin = 150;
		objectRender = new ObjectRender(pos, 9, 9,size );
	}

}
