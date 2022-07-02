package game.gameObject.object.Items;

import game.gameObject.Player;
import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Armor_5 extends GameObject {

	public Armor_5(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;
		name = "Thủ Vệ Giáp";
		defense = 250;
        coin = 250;
		objectRender = new ObjectRender(pos, 7, 4,size );
	}

}

