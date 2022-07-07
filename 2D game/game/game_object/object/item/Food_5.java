package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Food_5 extends GameObject {

	public Food_5(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Dâu";
		MP = 50;
        coin = 50;
		objectRender = new ObjectRender(pos, 14, 4,size );
	}
}

