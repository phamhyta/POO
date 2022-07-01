package game.gameObject.object.Items;

import game.gameObject.Player;
import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Food_4 extends GameObject {

	public Food_4(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Cam";
		MP = 50;
        coin = 50;
		objectRender = new ObjectRender(pos, 14, 3,size );
	}
}

