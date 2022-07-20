package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Food_10 extends GameObject {

	public Food_10(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Tôm chiên";
		HP = 50;
        coin = 50;
		objectRender = new ObjectRender(pos, 15, 4,size );
	}
}

