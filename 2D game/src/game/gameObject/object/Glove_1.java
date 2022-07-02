package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Glove_1 extends GameObject {

	public Glove_1(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;
		name = "Găng Tay";
		defense = 50;
        coin = 50;
		objectRender = new ObjectRender(pos, 8, 0,size );
	}
}

