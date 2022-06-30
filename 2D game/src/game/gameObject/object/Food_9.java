package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Food_9 extends GameObject {

	public Food_9(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Thịt ";
		HP = 50;
        coin = 50;
		objectRender = new ObjectRender(pos, 15, 3,size );
	}

	public void use(Player player) {
		
	}


}

