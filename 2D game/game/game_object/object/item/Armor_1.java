package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Armor_1 extends GameObject {

	public Armor_1(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;
		name = "Áo vải";
		defense = 50;
        coin = 50;
		objectRender = new ObjectRender(pos, 7, 9,size );
	}
}

