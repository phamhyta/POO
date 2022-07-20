package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Food_3 extends GameObject {

	public Food_3(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Lê";
		MP = 50;
        coin = 50;
		objectRender = new ObjectRender(pos, 14, 2,size );
	}
}

