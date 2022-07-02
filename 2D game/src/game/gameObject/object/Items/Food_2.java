package game.gameObject.object.Items;

import game.gameObject.Player;
import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Food_2 extends GameObject {

	public Food_2(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Chuối";
		MP = 50;
        coin = 50;
		objectRender = new ObjectRender(pos, 14, 1,size );
	}

}

