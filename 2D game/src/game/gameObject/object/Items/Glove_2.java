package game.gameObject.object.items;

import game.gameObject.Player;
import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Glove_2 extends GameObject {

	public Glove_2(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;
		name = "Găng Tay Sắt";
		defense = 100;
        coin = 100;
		objectRender = new ObjectRender(pos, 8, 1,size );
	}
}

