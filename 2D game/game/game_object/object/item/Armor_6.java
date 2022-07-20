package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Armor_6 extends GameObject {

	public Armor_6(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;
		name = "Quần hoa";
		defense = 50;
        coin = 50;
		objectRender = new ObjectRender(pos, 7, 12,size );
	}
}

