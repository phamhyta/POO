package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Armor_3 extends GameObject {

	public Armor_3(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;
		name = "Mộc Giáp";
		defense = 150;
        coin = 150;
		objectRender = new ObjectRender(pos, 7, 6,size );
	}
}

