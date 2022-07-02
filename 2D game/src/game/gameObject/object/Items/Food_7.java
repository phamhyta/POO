package game.gameObject.object.Items;

import game.gameObject.Player;
import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Food_7 extends GameObject {

	public Food_7(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Thịt bò";
		HP = 50;
        coin = 50;
		objectRender = new ObjectRender(pos, 15, 1,size );
	}
}

